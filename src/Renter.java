import java.lang.String;
import java.util.ArrayList;

public class Renter
{
    private String renterName;
    private String renterEmail;
    private String phoneNumber;

    private Rental Rental;
    private AppManager app;
    public Renter(String name, String email, String number, String term, AppManager a, int lnum)
    {
        renterName = name;
        renterEmail = email;
        phoneNumber = number;
        Rental = new Rental(term, this, a, lnum); 
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

    public Rental getRental()
    {
        return Rental;
    }

    public void setRenterName(String renterName)
    {
        this.renterName = renterName;
    }

    public void setRenterEmail(String renterEmail)
    {
        this.renterEmail = renterEmail;
    }

    public void setRenterPhone(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setRental(Rental Rental)
    {
        this.Rental = Rental;
    }
    
    @Override
    public String toString() {
        return renterName + ":      " + Rental.getLocker().getLockerNumber();
    }
    
}