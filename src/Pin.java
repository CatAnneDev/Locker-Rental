

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Pin {
	
	// Locker id #
	int id;

	// Password for pin access
	String password = "pass";

	// Path to pin file
	String filePath = "..\\assets\\pins\\dummy_pins.json";
	
	/**
	 * Pin class constructor
	 * @param locker_id
	 */
	public Pin(int locker_id) {
		// Set locker id
		this.id = locker_id;
	}
	
	/**
	 * Gets respective pin from pin file
	 * @return The curret pin of the locker, or -1 if failure occurred
	 */
	@SuppressWarnings("unchecked")
	public int getPin() {
		try {
			// Load the pins
			Map<Integer, Integer[]> pin_map = (Map<Integer, Integer[]>) loadPins();

			// Get index of currently selected pin
			int index = pin_map.get(this.id)[0];

			// Return pin
			return pin_map.get(this.id)[index];
		}

		// Catches file not found exception
		catch (FileNotFoundException ex) {
			// Display error message
			JOptionPane.showMessageDialog(null, "The pin file was not found");
		}
		
		// Map class not found in java environment
		catch (ClassNotFoundException ex) {
			// Display error message
			JOptionPane.showMessageDialog(null, "A Java error occurred");
		}

		// Catches input/output exception
		catch (IOException ex) {
			// Display error message
			JOptionPane.showMessageDialog(null, "An error occurred when loading the pins");
		}

		// Return fail value
		return -1;
	}

	/**
	 * Increments to the next pin in available pin list
	 */
	@SuppressWarnings("unchecked")
	public void setNextPin() {
		try {
			// Load the pins
			Map<Integer, Integer[]> pin_map = (Map<Integer, Integer[]>) loadPins();

			// If the current pin is the last in the list
			if (pin_map.get(this.id)[0] == 4) {
				// Loop back to beginning of the list
				pin_map.get(this.id)[0] = 1;
			}
			// Otherwise
			else {
				// Increment current pin to the next in the list
				pin_map.get(this.id)[0] += 1;
			}

			// Store updated pin
			storePins(pin_map);
		}

		// Catches file not found exception
		catch (FileNotFoundException ex) {
			// Display error message
			JOptionPane.showMessageDialog(null, "The pin file was not found");
		}

		// Map class not found in java environment
		catch (ClassNotFoundException ex) {
			// Display error message
			JOptionPane.showMessageDialog(null, "A Java error occurred");
		}

		// Catches input/output exception
		catch (IOException ex) {
			// Display error message
			JOptionPane.showMessageDialog(null, "An error occurred when storing the pins");
		}
	}

	/**
	 * Verifies the user's ability to access the pins
	 * @return Boolean result of the verification
	 */
	public boolean verifyUser() {
		boolean result = false;

		// Allow user to input password
		String entry = JOptionPane.showInputDialog(null, "Please enter the pin password",
												   "Enter Password", JOptionPane.INFORMATION_MESSAGE);

		// If the user entry is equivalent to the password
		if (entry != null && entry.equals(password)) {
			// Give user access
			result = true;
		}

		return result;
	}

	/**
	 * Saves pin map object to the pin file
	 * @param pins Map containing pins
	 */
	private void storePins(Map<Integer, Integer[]> pins) throws FileNotFoundException, IOException{
		// Create necessary file objects
		FileOutputStream fileOut = new FileOutputStream(filePath);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

		// Write the Map object and close
		objectOut.writeObject(pins);
		objectOut.close(); 
	}

	/**
	 * Loads pin map from pin file
	 * @return Pin map object
	 */
	private Object loadPins() throws FileNotFoundException, ClassNotFoundException, IOException{
		// Create necessary file objects
		FileInputStream fileIn = new FileInputStream(filePath);
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);

		// Read the object
		Object obj = objectIn.readObject();

		// Close and return
		objectIn.close();
		return obj;
	}
}