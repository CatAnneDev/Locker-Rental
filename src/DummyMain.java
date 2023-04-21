import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class DummyMain
{
	private static String password = "pass";

	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		
		AppManager Manager = readFromFile();
		// classes: Renter, Locker, Rental, Pin, User Interface
		//Renter x = new Renter("Karch","kta3235@truman.edu","6365942334","spring", Manager, 27);
		//Renter y = new Renter("Bert","brt4235@truman.edu","6368273849","fall", Manager,28);
		//Renter z = new Renter("Carl","cmd3235@truman.edu","6363431245","spring", Manager,29);
		//Renter w = new Renter("Daryl","dae3235@truman.edu","6363425433","spring", Manager,30);
		
		for (Renter r : Manager.Renters) {
			System.out.println(r.getRenterName());
		}

		// System.out.println(x.getRenterEmail());
		for (Locker l : Manager.Lockers) {
			System.out.println(l);
		}

		if (verifyUser()) {
			UserInterface Ui = new UserInterface(Manager);
		}
		else {
			JOptionPane.showMessageDialog(null, "Password Incorrect\nExiting",
										  "ERROR", JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Verifies the user's ability to access the pins
	 * @return Boolean result of the verification
	 */
	public static boolean verifyUser() {
		boolean result = false;

		JPasswordField pass_field = new JPasswordField(20);

		// Allow user to input password
		int entry = JOptionPane.showConfirmDialog(null, pass_field, "Please enter the pin password",
												  JOptionPane.OK_CANCEL_OPTION);

		if (entry < 0) {
			// User canceled, exit process
			return false;
		}
		else {
			String entered_password = new String(pass_field.getPassword());
			return entered_password.equals(password);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static AppManager readFromFile() throws IOException, ClassNotFoundException {
		File file = new File("assets/AppData/objects.json");
		//File file = new File("..assets\\AppData\\objects.json");
	
		
		//if the file is not empty
		if( !(file.length()==0) ) {
			FileInputStream f = new FileInputStream(file);
			ObjectInputStream o = new ObjectInputStream(f);
			ArrayList<Locker> lock = (ArrayList<Locker>) o.readObject();
			ArrayList<Renter> rent = (ArrayList<Renter>) o.readObject();
			int rentalNum = (Integer) o.readObject();
			AppManager app = new AppManager(lock,rent,rentalNum);
			o.close();
			f.close();
			return app;
		}
		
		AppManager app = new AppManager();

		return app;
	
	}
}
