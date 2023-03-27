import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

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
	
	public UserInterface() throws IOException {
		
		setUpMainFrame();
		setUpHomeScreen();
		
		
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
		JLabel Logo = new JLabel(new ImageIcon(LockerLogo.getScaledInstance(356, 99, Image.SCALE_SMOOTH)));
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
		AddFrame.setSize(550,450);//900 width and 700 height    
		
		
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
					System.out.println("Submit Button");
			} 
		} );
		SubmitForm.add(SubmitButton);
		
		
		
		
		AddFrame.add(SubmitForm, BorderLayout.SOUTH);
		AddFrame.add(AddFrameTitle, BorderLayout.NORTH);
		AddFrame.add(AddForm, BorderLayout.CENTER);
		AddFrame.setVisible(true);
	}

	
	private void openViewFrame() {
		
	}
	


}