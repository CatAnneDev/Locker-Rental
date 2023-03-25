import java.util.Date;

public class Rental {
	private int rental_num;
	private Date checkout_date;
	private String[] semesters;
	private Renter renter;
	
	public Rental (int r_num, Date d, String[] s, Renter r)
	{
		rental_num = r_num;
		checkout_date = d;
		semesters = s;
		renter = r;
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

	public void setSemesters (String[] s)
	{
		semesters = s;
	}

	public String[] getSemesters ()
	{
		return semesters;
	}

	public void setRenter (Renter r)
	{
		renter = r;
	}

	public Renter getRenter ()
	{
		return renter;
	}
}
