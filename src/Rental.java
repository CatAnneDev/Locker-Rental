import java.util.Date;
import java.lang.String;

public class Rental {
	private int rental_num;
	private Date checkout_date;
	private String semester;
	private Renter renter;
	
	public Rental (int r_num, Date d, String s, Renter renter)
	{
		rental_num = r_num;
		checkout_date = d;
		semester = s;
		renter = renter;
	}

	public void setRentalNumber (int r_num)
	{
		rental_num = r_num;
	}

	public int getRentalNumber ()
	{
		return rental_num;
	}

	public void setDate (Date d)
	{
		checkout_date = d;
	}

	public Date getMonth ()
	{
		return checkout_date;
	}

	public void setSemester (String s)
	{
		semester = s;
	}

	public int getSemester ()
	{
		return semester;
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
