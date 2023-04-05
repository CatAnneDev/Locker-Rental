import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DummyMain
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		
		AppManager Manager = new AppManager(readFromFile());
		// classes: Renter, Locker, Rental, Pin, User Interface
		Renter x = new Renter("Karch","kta3235@truman.edu","6365942334","spring", Manager);
		Renter y = new Renter("Bert","brt4235@truman.edu","6368273849","fall", Manager);
		Renter z = new Renter("Carl","cmd3235@truman.edu","6363431245","spring", Manager);
		Renter w = new Renter("Daryl","dae3235@truman.edu","6363425433","spring", Manager);
		
		for (Renter r : Manager.Renters) {
			System.out.println(r.getRenterName());
		}

		System.out.println(x.getRenterEmail());
		for (Locker l : Manager.Lockers) {
			System.out.println(l);
		}
		
		UserInterface Ui = new UserInterface(Manager);

	}
	
	private static AppManager readFromFile() throws IOException, ClassNotFoundException {
		File file = new File("assets/AppData/objects.txt");
	
		
		//if the file is not empty
		if( !(file.length()==0) ) {
			FileInputStream f = new FileInputStream(file);
			ObjectInputStream o = new ObjectInputStream(f);
			AppManager app = (AppManager) o.readObject();
			o.close();
			f.close();
			return app;
		}
		
		AppManager app = new AppManager();

		return app;
	
	}
}