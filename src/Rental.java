import java.util.Date;

public class Rental {
	private int rental_num;
	private Date checkout_date;
	private Renter renter;
	
	public Rental (Date d, int r_num, Renter renter)
	{
		checkout_date = d;
		rental_num = r_num;
		renter = renter;
	}

	public void setDate (Date d)
	{
		checkout_date = d;
	}

	public Date getMonth ()
	{
		return checkout_date;
	}

	public void setRentalNumber (int r_num)
	{
		rental_num = r_num;
	}

	public int getRentalNumber ()
	{
		return rental_num;
	}

	public void setRenter (Renter renter)
	{
		renter = renter;
	}

	public Renter getRenter ()
	{
		return renter;
	}
}
