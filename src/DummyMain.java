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
		Renter x = new Renter("Karch","kta3235","217","spring", Manager);

		System.out.println(x.getRenterEmail());
		for (Locker l : Manager.Lockers) {
			System.out.println(l);
		}
		
		UserInterface Ui = new UserInterface();

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