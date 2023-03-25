import java.io.IOException;

public class DummyMain
{
	public static void main(String[] args) throws IOException
	{
		// classes: Renter, Locker, Rental, Pin, User Interface
		Renter x = new Renter("Karch","kta3235","217",null);

		System.out.println(x.getRenterEmail());
		
		UserInterface Ui = new UserInterface();

	}
}