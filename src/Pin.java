
import java.util.HashMap;
import java.util.Map;

public class Pin {
	
	Map<Integer, Integer[]> pins;
	
	
	public Pin() {
		// Generate temporary dummy pins
		pins = new HashMap<>();

		// Store dummy pins in "lockers" 27, 28, and 29
		Integer[] value = new Integer[] { 1111, 2222, 3333, 4444 };
		pins.put(27, value);
		pins.put(28, value);
		pins.put(29, value);
	}
	

	public int getNextPin(int current_pin, int locker_id) {

		
		// Load list of available pins for the specific locker
		Integer[] available_pins = pins.get(locker_id);
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
	}
	
	//private Map<Integer, Integer[]> loadPins();
	
	//private void storePins();

	public static void main(String[] args) {
		Pin pin_test = new Pin();

		// Testing that next pin is selected
		int next_pin = pin_test.getNextPin(1111, 28);

		// Should print "2222"
		System.out.println(next_pin);
	}
}