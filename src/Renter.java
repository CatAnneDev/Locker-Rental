import java.lang.String;
import java.util.ArrayList;

public class Renter
{
    private String renterName;
    private String renterEmail;
    private String phoneNumber;

    private ArrayList<Rental> Rentals;
    private AppManager app;

    public Renter(String name, String email, String number, String term, AppManager a)
    {
        renterName = name;
        renterEmail = email;
        phoneNumber = number;
        Rental newRental = new Rental(term, this, a); 
        app = a;
        a.addRenter(this);
    }

    public String getRenterName()
    {
        return renterName;
    }

    public String getRenterEmail()
    {
        return renterEmail;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public ArrayList<Rental> getRentals()
    {
        return Rentals;
    }

    public void setRenterName(String renterName)
    {
        this.renterName = renterName;
    }

    public void setRenterEmail(String renterName)
    {
        this.renterName = renterName;
    }

    public void setRenterPhone(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setRentals(ArrayList<Rental> Rentals)
    {
        this.Rentals = Rentals;
    }
}