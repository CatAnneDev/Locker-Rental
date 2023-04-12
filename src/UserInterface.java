import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;  


public class UserInterface{
	//Thematic colors
	Color MainBackground = new Color(206, 206, 206);
	Color TrumanAccent = new Color(80, 8, 120);
	Color DarkerButtonColor = new Color(179, 179, 179);
			
			
	//Main Screen Componets
	JFrame MainFrame=new JFrame("Locker Rental");//creating instance of JFrame  
	Image icon = Toolkit.getDefaultToolkit().getImage("assets/Images/icon.png");  
	
	//Home screen Panel
	JPanel HomeScreen =  new JPanel();
	AppManager manager;
	
	
	public UserInterface(AppManager m) throws IOException {
		
		setUpMainFrame();
		setUpHomeScreen();
		manager = m;
		
		
		MainFrame.add(HomeScreen, BorderLayout.CENTER);
		MainFrame.setVisible(true);
		
		
	}
	
	private void setUpMainFrame() {
		MainFrame.setIconImage(icon);
		MainFrame.setLayout(new BorderLayout());
		MainFrame.setSize(900,700);//900 width and 700 height  
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	}
	
	private void setUpHomeScreen() throws IOException {
		
		//Making the first visible Screen
		HomeScreen.setLayout(new BorderLayout());
		HomeScreen.setBackground(MainBackground);
		
		
		
		
		//Making the Upper Card
		JPanel TitlePane = new JPanel();
		HomeScreen.setLayout(new BorderLayout());
		//getting the logo
		BufferedImage LockerLogo = ImageIO.read(new File("assets/Images/image3.png"));
		JLabel Logo = new JLabel(new ImageIcon(LockerLogo.getScaledInstance(360, 125, Image.SCALE_SMOOTH)));
		TitlePane.add(Logo, BorderLayout.WEST);
		
		
		
		
		
		//Set up side card
		JPanel RentalOptions = new JPanel();
		RentalOptions.setLayout(new BoxLayout(RentalOptions, BoxLayout.Y_AXIS));
		RentalOptions.setPreferredSize(new Dimension(200, 100));
		
		JButton AddButton = new JButton("Add a new Rental");
		AddButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		AddButton.setMaximumSize(new Dimension(175,50));
		AddButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
					System.out.println("Add Button");
				    openAddFrame();
			} 
		} );
		
		JButton ViewButton = new JButton("View Rentals");
		ViewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		ViewButton.setMaximumSize(new Dimension(175,50));
		ViewButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
					System.out.println("View Button");
					openViewFrame();
			} 
		} );
		
		JButton RemoveButton  = new JButton("Remove a Rental");
		RemoveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		RemoveButton.setMaximumSize(new Dimension(175,50));
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
		
		
		
		
		HomeScreen.add(TitlePane, BorderLayout.NORTH);
		HomeScreen.add(RentalOptions, BorderLayout.EAST);
	}
	
	private void openAddFrame() {
		JFrame AddFrame = new JFrame("Add a Rental");
		AddFrame.setIconImage(icon);
		AddFrame.setLayout(new BorderLayout());
		AddFrame.setSize(550,450);//550 width and 450 height    
		
		
		//Add Fields
		JPanel AddForm = new JPanel();
		AddForm.setLayout(new GridLayout(0,2,35,35));
		AddForm.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
		
		JLabel NameLabel = new JLabel("Name: ");
		JTextField NameArea = new JTextField("Enter Name here.");
		
		JLabel EmailLabel = new JLabel("Email: ");
		JTextField EmailArea = new JTextField("Enter Email here.");
		
		JLabel PhoneLabel = new JLabel("Phone: ");
		JTextField PhoneArea = new JTextField("Enter Phone here.");
		
		JLabel DateLabel = new JLabel("Date: ");
		JTextField DateArea = new JTextField(java.time.LocalDate.now().toString());
		
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
		
		
		//Addform Components
		AddForm.add(NameLabel);
		AddForm.add(NameArea);
		
		AddForm.add(EmailLabel);
		AddForm.add(EmailArea);
		
		AddForm.add(PhoneLabel);
		AddForm.add(PhoneArea);
		
		AddForm.add(DateLabel);
		AddForm.add(DateArea);
		
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
						term = "fall";
					}
					if (SpringButton.isSelected() == true) {
						term = "spring";
					}
					
					if (name.equals("Enter Name here.") || email.equals( "Enter Email here.") || phone.equals( "Enter Phone here.")) {
						JOptionPane.showMessageDialog(AddFrame, "Please Enter Record Information.", "Input Warning", JOptionPane.ERROR_MESSAGE);
					}
					else {
						Renter newRenter = new Renter(name, email, phone, term, manager);
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
		AddFrame.setVisible(true);
	}

	
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
		
		//Info section
		JPanel InfoForm = new JPanel();
		InfoForm.setLayout(new GridLayout(0,2,5,5));
		InfoForm.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
		InfoForm.add(new JLabel(""));
		JButton MoreInfoButton = new JButton("More Info");
		MoreInfoButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
					try {
						Renter temp = model.getRenterAt(renters.getSelectedRow());
						Rental rental = temp.getRental();
						Locker locker = rental.getLocker();

						JOptionPane.showMessageDialog(ViewFrame, 
								"Name:   " + temp.getRenterName() + "\n"
								+ "Email:   " + temp.getRenterEmail() + "\n"
								+ "Phone:   " + temp.getPhoneNumber() + "\n"
								+ "CheckOut Date:   " + rental.getDate() + "\n"
								+ "Rental term:   " + rental.getTerm() + "\n"
								+ "Locker Number:   " + locker.getLockerNumber() + "\n"
								+ "Locker Pin:   " + locker.getLockerPin().getPin() + "\n"
								, "Record Information  ", JOptionPane.INFORMATION_MESSAGE);
					
					}
					catch (Exception e1) {
						JOptionPane.showMessageDialog(ViewFrame, "Please select a record", "Selection Warning", JOptionPane.ERROR_MESSAGE);
					}
					
						
						
					
					

					
			} 
		} );

		InfoForm.add(MoreInfoButton);


		
		
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
		ViewFrame.setVisible(true);
		
		
	
	}
	
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
						
						boolean flag = manager.removeRenter(temp);
						if (flag == true) {
							JOptionPane.showMessageDialog(RemoveFrame, "Record removed", "Success!", JOptionPane.INFORMATION_MESSAGE);
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
		RemoveFrame.setVisible(true);
		
		
	
	}
	

}

