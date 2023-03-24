import java.lang.String;

public class Renter
{
    private String renterName;
    private String renterEmail;
    private String phoneNumber;

    private List<Rental> Rentals;

    public Renter(String name, String email, String number, List<Rental> rentals)
    {
        renterName = name;
        renterEmail = email;
        phoneNumber = number;
        Rentals = rentals;

    }

    public String getRenterName()
    {
        return renterName;
    }

    public String getRenterEmail()
    {
        return RenterEmail;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public List<Rental> getRentals()
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

    public void setRentals(List<Rental> Rentals)
    {
        this.Rentals = Rentals;
    }
}