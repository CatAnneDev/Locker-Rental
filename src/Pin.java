

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import javax.swing.JOptionPane;

public class Pin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3161078618907619929L;


	// Locker id #
	int id;

	// Path to pin file
	String filePath = "..\\assets\\Pins\\encrypted_pins.json";
	//String filePath = "..\\assets\\Pins\\dummy_pins.json";
	//String filePath = "assets/Pins/dummy_pins.json";
	
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
	public String getPin() {
		try {
			// Load the pins
			Map<Integer, String[]> pin_map = (Map<Integer, String[]>) loadPins();

			// Get index of currently selected pin
			int index = Integer.parseInt(pin_map.get(this.id)[0]);

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
		return "";
	}

	/**
	 * Gets the previously selected pin
	 * @return Previous pin
	 */
	@SuppressWarnings("unchecked")
	public String getPreviousPin() {
		try {
			// Load the pins
			Map<Integer, String[]> pin_map = (Map<Integer, String[]>) loadPins();

			// Get current pin index
			int current_index = Integer.parseInt(pin_map.get(this.id)[0]);

			// If the current index is greater than one
			if (current_index > 1) {
				// Return the previous pin
				return pin_map.get(this.id)[current_index - 1];
			}
			
			// Otherwise, the index is 1
			// Return the last pin in the list
			return pin_map.get(this.id)[5];
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

		// Return fail value
		return "";
	}


	/**
	 * Increments to the next pin in available pin list
	 */
	@SuppressWarnings("unchecked")
	public void setNextPin() {
		try {
			// Load the pins
			Map<Integer, String[]> pin_map = (Map<Integer, String[]>) loadPins();

			// If the current pin is the last in the list
			if (Integer.parseInt(pin_map.get(this.id)[0]) == 5) {
				// Loop back to beginning of the list
				pin_map.get(this.id)[0] = "1";
			}
			// Otherwise
			else {
				// Increment current pin to the next in the list
				String[] pin_list = pin_map.get(this.id);
				int numb = Integer.parseInt(pin_list[0]);
				numb++;

				pin_map.get(this.id)[0] = Integer.toString(numb);
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
	 * Saves pin map object to the pin file
	 * @param pins Map containing pins
	 */
	private void storePins(Map<Integer, String[]> pins) throws FileNotFoundException, IOException{
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