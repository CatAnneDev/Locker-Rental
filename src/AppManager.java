import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class AppManager implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1742251814903682890L;
	public ArrayList<Locker> Lockers;
	public static ArrayList<Renter> Renters;
	private int rentalNumberCount;
	
		
	@SuppressWarnings("static-access")
	public AppManager(ArrayList<Locker> L,ArrayList<Renter> R,int rentalNum){
		this.Lockers = L;
		this.Renters = R;
		this.rentalNumberCount = rentalNum;
	}
	
	public AppManager(){
		
		Lockers = new ArrayList<Locker>();
		Renters = new ArrayList<Renter>();
		for(int i = 0; i <= 30; i++) {
			Locker temp = new Locker(i+27, this);
			Lockers.add(temp);
			//System.out.println(temp);
		}
		
		rentalNumberCount = 0;
		
		
		
	}
	
	public boolean removeRenter(Renter r) {
		try {
			returnLocker(r.getRental().getLocker());
			Renters.remove(r);
			return true;
		}
		catch(Exception e1){
			return false;
		}
	}
	
	public void addRenter(Renter r) {
		Renters.add(r);
	}
	
	
	public Locker checkOutLocker(int lnum) {
		for (Locker l : Lockers) {
			if(l.rental_status == false && l.getLockerNumber() == lnum) {
				l.setRentalStatus(true);
				return l;
			}
		}
		
		System.out.println("No Open Lockers");
		return null;
	}
	
	
	public void returnLocker(Locker l) {
		l.getLockerPin().setNextPin();
		l.setRentalStatus(false);
	}
	
	
	public boolean writeToFile() throws IOException {
		//File file = new File("..\\assets\\AppData\\objects.json");
		File file = new File("assets/AppData/objects.json");
		FileOutputStream f = new FileOutputStream(file);
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		
		o.writeObject(Lockers);
		o.writeObject(Renters);
		o.writeObject(rentalNumberCount);
		
		
		
		
		o.close();
		f.close();
		return true;
	}
	

}
