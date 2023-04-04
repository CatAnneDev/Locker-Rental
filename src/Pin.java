
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
		this.id = locker_id;
	}
	
	/**
	 * Gets respective pin from pin file
	 * @return The curret pin of the locker
	 */
	@SuppressWarnings("unchecked")
	public int getPin() {
		// Load the pins
		Map<Integer, Integer[]> pin_map = (Map<Integer, Integer[]>) loadPins();

		// Get index of currently selected pin
		int index = pin_map.get(this.id)[0];

		// Return pin
		return pin_map.get(this.id)[index];
	}

	public int getNextPin(int current_pin, int locker_id) {

		verifyUser();

		/* 
		// Load list of available pins for the specific locker
		Integer[] available_pins = temp_pins.get(locker_id);
		// Used to track index
		int current_index = 0;

		// While the current pin now found
		while (available_pins[current_index] != current_pin) {
			// Next pin
			current_index++;
		}

		// If the last pin is the current one
		if (current_index == 3) {
			// Loop back to beginning of list
			return available_pins[0];
		}
		// Otherwise
		else {
			// Return the next pin in the list
			return available_pins[current_index + 1];
		}
		*/

		return 0;
	}

	/**
	 * Verifies the user's ability to access the pins
	 * @return Boolean result of the verification
	 */
	public static boolean verifyUser() {
		boolean result = false;

		// Allow user to input password
		String entry = JOptionPane.showInputDialog(null, "Please enter the pin password");

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
	public void storePins(Map<Integer, Integer[]> pins) {
		try {
			// Create necessary file objects
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

			// Write the Map object and close
            objectOut.writeObject(pins);
            objectOut.close(); 
        }

		// Catches file not found exception
		catch (FileNotFoundException ex) {
			// Display error message
			JOptionPane.showMessageDialog(null, "The pin file was not found");
        }

		// Catches input/output exception
		catch (IOException ex) {
			// Display error message
			JOptionPane.showMessageDialog(null, "An error occurred when storing the pins");
		}
	}

	/**
	 * Loads pin map from pin file
	 * @return Pin map object
	 */
	public Object loadPins() {
		try {
			// Create necessary file objects
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
			// Read the object
            Object obj = objectIn.readObject();
 
			// Close and return
            objectIn.close();
            return obj;
 
        } 
		catch (Exception ex) {
			// Load unsuccessful, return null
            ex.printStackTrace();
            return null;
        }
	}
	




	// Temporary function to create the 1st map to be stored
	public Map<Integer, Integer[]> makeMap() {
		Map<Integer, Integer[]> map = new HashMap<>();
		Integer[] vals = new Integer[] {1, 1111, 2222, 3333, 4444};

		for (int i = 27; i < 59; i++) {
			map.put(i, vals);
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Pin pin_test = new Pin(27);

		Map<Integer, Integer[]> test = (Map<Integer, Integer[]>) pin_test.loadPins();

		System.out.println(pin_test.getPin());

	}
}