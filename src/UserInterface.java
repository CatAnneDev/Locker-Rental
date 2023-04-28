import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableRowSorter;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;



public class UserInterface{
	//Thematic colors
	Color MainBackground = new Color(206, 206, 206);
	Color TrumanAccent = new Color(80, 8, 120);
	Color DarkerButtonColor = new Color(179, 179, 179);


	//Main Screen Componets
	JFrame MainFrame=new JFrame("Locker Rental");//creating instance of JFrame
	//Image icon = Toolkit.getDefaultToolkit().getImage("..\\assets\\Images\\icon.png"); 
	Image icon = Toolkit.getDefaultToolkit().getImage("assets/Images/icon.png");

	//Home screen Panel
	JPanel HomeScreen =  new JPanel();
	AppManager manager;

	/**
	 * User interface constructor, sets up each relevant frame
	 */
	public UserInterface(AppManager m) throws IOException {

		setUpMainFrame();
		setUpHomeScreen();
		manager = m;


		MainFrame.add(HomeScreen, BorderLayout.CENTER);
		MainFrame.setLocationRelativeTo(null);
		MainFrame.setVisible(true);


	}

	/**
	 * Sets up the main frame display
	 */
	private void setUpMainFrame() {
		MainFrame.setIconImage(icon);
		MainFrame.setLayout(new BorderLayout());
		MainFrame.setSize(700,600);//900 width and 700 height  
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Sets up the home screen display
	 */
	private void setUpHomeScreen() throws IOException {

		//Making the first visible Screen
		HomeScreen.setLayout(new BorderLayout());
		//HomeScreen.setBackground(MainBackground);




		//Making the Upper Card
		JPanel TitlePane = new JPanel();
		HomeScreen.setLayout(new BorderLayout());
		//getting the logo
		//BufferedImage LockerLogo = ImageIO.read(new File("..\\assets\\Images\\image3.png"));
		BufferedImage LockerLogo = ImageIO.read(new File("assets/Images/image3.png"));
		JLabel Logo = new JLabel(new ImageIcon(LockerLogo.getScaledInstance(360, 125, Image.SCALE_SMOOTH)));
		TitlePane.add(Logo, BorderLayout.WEST);





		//Set up side card
		JPanel RentalOptions = new JPanel();
		RentalOptions.setLayout(new BoxLayout(RentalOptions, BoxLayout.Y_AXIS));
		RentalOptions.setPreferredSize(new Dimension(300, 100));

		JButton AddButton = new JButton("Add a New Rental");
		AddButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		AddButton.setMaximumSize(new Dimension(225,50));
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add Button");
				boolean lockerAvailable = false;
				for (Locker l : manager.Lockers) {
					if (l.rental_status == false) {
							
						lockerAvailable = true;
					}
				}
				if (lockerAvailable == false) {
					JOptionPane.showMessageDialog(HomeScreen, "No available lockers", "Full Locker Warning", JOptionPane.ERROR_MESSAGE);
						
				}
				else {
					openAddFrame();
				}
			}
		} );

		JButton ViewButton = new JButton("View/Edit Rentals");
		ViewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		ViewButton.setMaximumSize(new Dimension(225,50));
		ViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("View Button");
				openViewFrame();
			}
		} );

		JButton RemoveButton  = new JButton("Remove a Rental");
		RemoveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		RemoveButton.setMaximumSize(new Dimension(225,50));
		RemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Remove Button");
				openRemoveFrame();
			}
		} );

		//Add the componets and spacing
		RentalOptions.add(Box.createRigidArea(new Dimension(0, 75)));
		RentalOptions.add(AddButton);
		RentalOptions.add(Box.createRigidArea(new Dimension(0, 75)));
		RentalOptions.add(ViewButton);
		RentalOptions.add(Box.createRigidArea(new Dimension(0, 75)));
		RentalOptions.add(RemoveButton);

		//Set up side card
		JPanel HelpOptions = new JPanel();
		HelpOptions.setLayout(new BoxLayout(HelpOptions, BoxLayout.Y_AXIS));
		HelpOptions.setPreferredSize(new Dimension(300, 100));

		JButton PinButton = new JButton("How to Change Locker Pin");
		PinButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		PinButton.setMaximumSize(new Dimension(225,50));
		PinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pin Button");
				if (Desktop.isDesktopSupported()) {
					try {
						//File myFile = new File("..\\assets\\Documents\\PinChange.pdf");
						File myFile = new File("assets/Documents/PinChange.pdf");
						Desktop.getDesktop().open(myFile);
					} catch (IOException ex) {
						// no application registered for PDFs
					}
				}
			}
		} );

		JButton ManualButton = new JButton("Open Manual");
		ManualButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		ManualButton.setMaximumSize(new Dimension(225,50));
		ManualButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Manual Button");
				if (Desktop.isDesktopSupported()) {
					try {
						//File myFile = new File("..\\assets\\Documents\\Manuel.pdf");
						File myFile = new File("assets/Documents/Manual.pdf");
						Desktop.getDesktop().open(myFile);
					} catch (IOException ex) {
						// no application registered for PDFs
					}
				};
			}
		} );


		//Add the componets and spacing
		HelpOptions.add(Box.createRigidArea(new Dimension(0, 75)));
		HelpOptions.add(PinButton);
		HelpOptions.add(Box.createRigidArea(new Dimension(0, 75)));
		HelpOptions.add(ManualButton);
		RentalOptions.add(Box.createRigidArea(new Dimension(0, 75)));


		HomeScreen.add(TitlePane, BorderLayout.NORTH);
		HomeScreen.add(RentalOptions, BorderLayout.WEST);
		HomeScreen.add(HelpOptions, BorderLayout.EAST);
	}

	/**
	 * Opens the add rental frame for user entry
	 */
	private void openAddFrame() {
		JFrame AddFrame = new JFrame("Add a Rental");
		AddFrame.setIconImage(icon);
		AddFrame.setLayout(new BorderLayout());
		AddFrame.setSize(550,550);//550 width and 450 height


		//Add Fields
		JPanel AddForm = new JPanel();
		AddForm.setLayout(new GridLayout(0,2,35,35));
		AddForm.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));

		JLabel NameLabel = new JLabel("Name / Organization: ");
		JTextField NameArea = new JTextField("Enter Name/Org here.");

		// Add Focus Listener so field is made empty when clicked on
		NameArea.addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				if (NameArea.getText().equals("Enter Name/Org here.")) {
					NameArea.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				if (NameArea.getText().isEmpty())
				{
					NameArea.setText("Enter Name/Org here.");
				}
			}
		});


		JLabel EmailLabel = new JLabel("Email: ");
		JTextField EmailArea = new JTextField("Enter Email here.");

		// Add Focus Listener so field is made empty when clicked on
		EmailArea.addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				if (EmailArea.getText().equals("Enter Email here."))
				{
					EmailArea.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				if (EmailArea.getText().isEmpty())
				{
					EmailArea.setText("Enter Email here.");
				}
			}
		});

		JLabel PhoneLabel = new JLabel("Phone: ");
		JTextField PhoneArea = new JTextField("Enter Phone here.");

		// Add Focus Listener so field is made empty when clicked on
		PhoneArea.addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				if (PhoneArea.getText().equals("Enter Phone here."))
				{
					PhoneArea.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				if (PhoneArea.getText().isEmpty())
				{
					PhoneArea.setText("Enter Phone here.");
				}
			}
		});

		JLabel DateLabel = new JLabel("Date: ");
		JTextField DateArea = new JTextField(java.time.LocalDate.now().toString());

		JLabel LockerNumLabel = new JLabel("Locker Num: ");
		ArrayList<String> LockerNums= new ArrayList<String>();
		for (int i = 0; i < manager.Lockers.size(); i++) {
			Locker l = manager.Lockers.get(i);
			if(l.rental_status == false) {
				LockerNums.add(String.valueOf(l.getLockerNumber()));
			}
		}

		JComboBox LockerArea = new JComboBox(LockerNums.toArray());

		LockerArea.setSelectedItem(LockerNums.get(0));


		//Radio Button section
		JLabel TermLabel = new JLabel("Rental Term: ");
		JPanel RadioButtonPanel = new JPanel();

		JRadioButton SpringButton = new JRadioButton();
		JLabel SpringLabel = new JLabel("Spring");
		JRadioButton FallButton = new JRadioButton();
		JLabel FallLabel = new JLabel("    Fall");
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(FallButton);
		radioButtons.add(SpringButton);
		RadioButtonPanel.setLayout(new GridLayout(0,4,5,5));
		RadioButtonPanel.add(SpringLabel);
		RadioButtonPanel.add(SpringButton);
		RadioButtonPanel.add(FallLabel);
		RadioButtonPanel.add(FallButton);



		//Add form Components
		AddForm.add(NameLabel);
		AddForm.add(NameArea);

		AddForm.add(EmailLabel);
		AddForm.add(EmailArea);

		AddForm.add(PhoneLabel);
		AddForm.add(PhoneArea);

		AddForm.add(DateLabel);
		AddForm.add(DateArea);

		AddForm.add(LockerNumLabel);
		AddForm.add(LockerArea);

		AddForm.add(TermLabel);
		AddForm.add(RadioButtonPanel);



		//Title information
		JLabel AddFrameTitle = new JLabel("Add a Rental");
		AddFrameTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		AddFrameTitle.setBorder(BorderFactory.createEmptyBorder(20,5,5,5));
		AddFrameTitle.setHorizontalAlignment(JLabel.CENTER);
		AddFrameTitle.setVerticalAlignment(JLabel.CENTER);



		//Submit section
		JPanel SubmitForm = new JPanel();
		SubmitForm.setLayout(new GridLayout(0,2,5,5));
		SubmitForm.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
		SubmitForm.add(new JLabel(""));


		JButton SubmitButton = new JButton("Submit");

		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Submit Button");

				String name = NameArea.getText();
				String email = EmailArea.getText();
				String phone = PhoneArea.getText();
				String date = DateArea.getText();
				String term = "temp";

				if (FallButton.isSelected() == true) {
					term = "Fall";
				}
				if (SpringButton.isSelected() == true) {
					term = "Spring";
				}

				if (name.equals("Enter Name/Org here.") || email.equals( "Enter Email here.") || phone.equals( "Enter Phone here.")) {
					JOptionPane.showMessageDialog(AddFrame, "Please Enter Record Information.", "Input Warning", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Renter newRenter = new Renter(name, email, phone, term, manager, Integer.parseInt((String) LockerArea.getSelectedItem()));
					try {
						manager.writeToFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("Record Created!");
					JOptionPane.showMessageDialog(AddFrame, "Record added", "Success!", JOptionPane.INFORMATION_MESSAGE);
					AddFrame.setVisible(false);
				}

			}
		} );
		SubmitForm.add(SubmitButton);

		AddFrame.add(SubmitForm, BorderLayout.SOUTH);
		AddFrame.add(AddFrameTitle, BorderLayout.NORTH);
		AddFrame.add(AddForm, BorderLayout.CENTER);

		AddFrame.setLocationRelativeTo(null);
		AddFrame.setVisible(true);

		// set focus to submit button so that the default enter
		// name text is not empty when the add frame is opened
		SubmitButton.requestFocusInWindow();
	}

	/**
	 * Opens the view rental frame
	 */
	private void openViewFrame() {
		JFrame ViewFrame = new JFrame("View Rentals");
		ViewFrame.setIconImage(icon);
		ViewFrame.setLayout(new BorderLayout());
		ViewFrame.setSize(550,450);


		RenterTableModel model = new RenterTableModel(AppManager.Renters);
		JTable renters = new JTable(model);
		renters.setShowGrid(false);
		renters.setShowHorizontalLines(false);
		renters.setShowVerticalLines(false);
		renters.setRowMargin(0);
		renters.setIntercellSpacing(new Dimension(0, 0));
		renters.setFillsViewportHeight(true);
		TableRowSorter<RenterTableModel> sorter = new TableRowSorter<>(model);
		renters.setRowSorter(sorter);

		// default sort table based on Locker Number
		renters.getRowSorter().toggleSortOrder(2);

		//Info section
		JPanel InfoForm = new JPanel();
		InfoForm.setLayout(new GridLayout(0,2,5,5));
		InfoForm.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
		//InfoForm.add(new JLabel(""));
		JButton MoreInfoButton = new JButton("More Info");
		JButton EditInfoButton = new JButton("Edit Info");

		MoreInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Renter temp = model.getRenterAt(renters.convertRowIndexToModel(renters.getSelectedRow()));
					Rental rental = temp.getRental();
					Locker locker = rental.getLocker();


					JOptionPane.showMessageDialog(ViewFrame,
							"Name/Org:   " + temp.getRenterName() + "\n"
									+ "Email:   " + temp.getRenterEmail() + "\n"
									+ "Phone:   " + temp.getPhoneNumber() + "\n"
									+ "CheckOut Date:   " + rental.getDate() + "\n"
									+ "Rental term:   " + rental.getTerm() + "\n"
									+ "Locker Number:   " + locker.getLockerNumber() + "\n"
									+ "Locker Pin:   " + locker.getLockerPin().getPin() + "\n"
							, "Record Information  ", JOptionPane.INFORMATION_MESSAGE);

				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(ViewFrame, "Please select a record", "Selection Warning", JOptionPane.ERROR_MESSAGE);
				}

			}
		} );

		EditInfoButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Renter temp = model.getRenterAt(renters.getSelectedRow());
					Rental rental = temp.getRental();
					Locker locker = rental.getLocker();

					JPanel panel = new JPanel();

					panel.setLayout(new GridLayout(0, 2, 3, 5));


					JTextField NameArea = new JTextField(temp.getRenterName());
					panel.add(new JLabel("Name/Org:"));
					panel.add(NameArea);

					JTextField EmailArea = new JTextField(temp.getRenterEmail());
					panel.add(new JLabel("Email:"));
					panel.add(EmailArea);

					JTextField PhoneArea = new JTextField(temp.getPhoneNumber());
					panel.add(new JLabel("Phone:"));
					panel.add(PhoneArea);

					String[] semesters = {"Spring","Fall"};
					JComboBox SemesterArea = new JComboBox(semesters);

					SemesterArea.setSelectedItem(rental.getTerm());

					SemesterArea.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							rental.setTerm(SemesterArea.getSelectedItem().toString());
						}
					});

					panel.add(new JLabel("Term:"));
					panel.add(SemesterArea);

					int result = JOptionPane.showOptionDialog(ViewFrame, panel, "Edit Renter Information",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null,
							new String[]{"Update","Next Pin","Cancel"},"default");




					if (result == JOptionPane.OK_OPTION)
					{
						if (NameArea.getText().equals("") || EmailArea.getText().equals("")
								|| PhoneArea.getText().equals(""))
						{
							JOptionPane.showMessageDialog(ViewFrame, "Please Do Not Leave Record Information Blank.",
									"Input Warning", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							model.getRenterAt(renters.getSelectedRow()).setRenterName(NameArea.getText());
							model.getRenterAt(renters.getSelectedRow()).setRenterEmail(EmailArea.getText());
							model.getRenterAt(renters.getSelectedRow()).setRenterPhone(PhoneArea.getText());
							model.getRenterAt(renters.getSelectedRow()).setRental(rental);

							model.fireTableDataChanged();
							try {
								manager.writeToFile();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(ViewFrame, "Record Has Been Updated!",
									"Record Updated", JOptionPane.INFORMATION_MESSAGE);
						}

					}
					else if (result == JOptionPane.NO_OPTION)
					{
						model.getRenterAt(renters.getSelectedRow()).getRental().getLocker().getLockerPin().setNextPin();

						JOptionPane.showMessageDialog(ViewFrame,
								"Locker Pin has been Changed!\n"
										+ "Previous Pin: " + model.getRenterAt(renters.getSelectedRow()).getRental().
										getLocker().getLockerPin().getPreviousPin() + "\n" + "New Pin: " +
										model.getRenterAt(renters.getSelectedRow()).getRental().
												getLocker().getLockerPin().getPin() + "\n"
						);

					}

				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(ViewFrame, "Please select a record to edit",
							"Selection Warning", JOptionPane.ERROR_MESSAGE);
				}

			}
		} );

		InfoForm.add(MoreInfoButton);
		InfoForm.add(EditInfoButton);



		JPanel tableForm = new JPanel();
		tableForm.setLayout(new BorderLayout());
		tableForm.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
		tableForm.add(new JScrollPane(renters));
		tableForm.add(renters.getTableHeader(), BorderLayout.NORTH);
		tableForm.add(renters, BorderLayout.CENTER);

		//Title information
		JLabel ViewFrameTitle = new JLabel("Click a record for more information.");
		ViewFrameTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		ViewFrameTitle.setBorder(BorderFactory.createEmptyBorder(20,5,5,5));
		ViewFrameTitle.setHorizontalAlignment(JLabel.CENTER);
		ViewFrameTitle.setVerticalAlignment(JLabel.CENTER);

		ViewFrame.add(ViewFrameTitle,BorderLayout.NORTH );
		ViewFrame.add(InfoForm, BorderLayout.SOUTH);
		ViewFrame.add(tableForm, BorderLayout.CENTER);
		ViewFrame.setLocationRelativeTo(null);
		ViewFrame.setVisible(true);



	}

	/**
	 * Opens the remove rental frame
	 */
	private void openRemoveFrame() {
		JFrame RemoveFrame = new JFrame("Remove a Rental");
		RemoveFrame.setIconImage(icon);
		RemoveFrame.setLayout(new BorderLayout());
		RemoveFrame.setSize(550,450);


		RenterTableModel model = new RenterTableModel(AppManager.Renters);
		JTable renters = new JTable(model);
		renters.setShowGrid(false);
		renters.setShowHorizontalLines(false);
		renters.setShowVerticalLines(false);
		renters.setRowMargin(0);
		renters.setIntercellSpacing(new Dimension(0, 0));
		renters.setFillsViewportHeight(true);
		TableRowSorter<RenterTableModel> sorter = new TableRowSorter<>(model);
		renters.setRowSorter(sorter);

		// default sort table based on Locker Number
		renters.getRowSorter().toggleSortOrder(2);


		//Info section
		JPanel RemoveForm = new JPanel();
		RemoveForm.setLayout(new GridLayout(0,2,5,5));
		RemoveForm.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
		RemoveForm.add(new JLabel(""));
		JButton RemoveButton = new JButton("Remove");
		RemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Renter temp = model.getRenterAt(renters.getSelectedRow());

					int a=JOptionPane.showConfirmDialog(RemoveFrame,"This action will remove a record permanately. \n Are you sure?");
					if(a==JOptionPane.YES_OPTION) {

						int old_pin = temp.getRental().getLocker().locker_pin.getPin();
						boolean flag = manager.removeRenter(temp);
						try {
							manager.writeToFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						int new_pin = temp.getRental().getLocker().locker_pin.getPin();
						if (flag == true) {
							JOptionPane.showMessageDialog(RemoveFrame, "Record removed\n\nCHANGE LOCKER PIN NOW\nOld Pin: " + old_pin + "\nNew Pin: " + new_pin + "\nReference the 'Change Locker pdf' to change the pin",
									"Success!", JOptionPane.INFORMATION_MESSAGE);
							RemoveFrame.setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(RemoveFrame, "Record removal failed", "Removal Warning", JOptionPane.ERROR_MESSAGE);
						}
					}


				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(RemoveFrame, "Please select a record", "Selection Warning", JOptionPane.ERROR_MESSAGE);
				}
			}
		} );

		RemoveButton.setBackground(new Color(255,138, 138));
		RemoveForm.add(RemoveButton);





		JPanel tableForm = new JPanel();
		tableForm.setLayout(new BorderLayout());
		tableForm.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
		tableForm.add(new JScrollPane(renters));
		tableForm.add(renters.getTableHeader(), BorderLayout.NORTH);
		tableForm.add(renters, BorderLayout.CENTER);

		//Title information
		JLabel RemoveFrameTitle = new JLabel("Click a record, then click remove.");
		RemoveFrameTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		RemoveFrameTitle.setBorder(BorderFactory.createEmptyBorder(20,5,5,5));
		RemoveFrameTitle.setHorizontalAlignment(JLabel.CENTER);
		RemoveFrameTitle.setVerticalAlignment(JLabel.CENTER);

		RemoveFrame.add(RemoveFrameTitle,BorderLayout.NORTH );
		RemoveFrame.add(RemoveForm, BorderLayout.SOUTH);
		RemoveFrame.add(tableForm, BorderLayout.CENTER);
		RemoveFrame.setLocationRelativeTo(null);
		RemoveFrame.setVisible(true);



	}


}
