import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

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
		AddButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
					System.out.println("Add Button");
				    openAddFrame();
			} 
		} );
		
		JButton ViewButton = new JButton("View Rentals");
		ViewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		ViewButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
					System.out.println("View Button");
			} 
		} );
		
		JButton RemoveButton  = new JButton("Remove a Rental");
		RemoveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		RemoveButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
					System.out.println("Remove Button");
			} 
		} );
		
		//Add the componets and spacing
		RentalOptions.add(Box.createRigidArea(new Dimension(0, 50)));
		RentalOptions.add(AddButton);
		RentalOptions.add(Box.createRigidArea(new Dimension(0, 50)));
		RentalOptions.add(ViewButton);
		RentalOptions.add(Box.createRigidArea(new Dimension(0, 50)));
		RentalOptions.add(RemoveButton);
		
		
		
		
		HomeScreen.add(TitlePane, BorderLayout.NORTH);
		HomeScreen.add(RentalOptions, BorderLayout.EAST);
	}
	
	private void openAddFrame() {
		JFrame AddFrame = new JFrame("Add a Rental");
		AddFrame.setIconImage(icon);
		AddFrame.setLayout(new BorderLayout());
		AddFrame.setSize(450,350);//900 width and 700 height    
		AddFrame.setVisible(true);
	}


	


}