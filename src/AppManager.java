import java.io.*;
import java.util.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class AppManager {
	public ArrayList<Locker> Lockers;
	private ArrayList<Renter> Renters;
	private int rentalNumberCount;
	
		
	public AppManager(AppManager app){
		this.Lockers = app.Lockers;
		this.Renters = app.Renters;
		this.rentalNumberCount = app.rentalNumberCount;
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
	
	public void addRenter(Renter r) {
		Renters.add(r);
	}
	
	public Locker checkOutLocker() {
		for (Locker l : Lockers) {
			if(l.rental_status == false) {
				l.setRentalStatus(true);
				return l;
			}
		}
		
		System.out.println("No Open Lockers");
		return null;
	}
	
	
	private boolean writeToFile() throws IOException {
		File file = new File("assets/AppData/objects.txt");
		FileOutputStream f = new FileOutputStream(file);
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		//if the file is not empty
		if( !(file.length()==0) ) {
			o.writeObject(this);
		}
		
		
		o.close();
		f.close();
		return true;
	}
	

}
