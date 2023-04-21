import java.io.Serializable;

public class Rental implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 697222621650877997L;
	private int rental_num;
	private String checkout_date;
	private String term;
	private Renter renter;
	private Locker locker;
	private AppManager app;
	
	public Rental (String t, Renter r, AppManager a, int lnum)
	{
		rental_num = 1;
		checkout_date = java.time.LocalDate.now().toString();
		term = t;
		renter = r;
		app = a;
		locker = a.checkOutLocker(lnum);
	}

	public void setRentalNumber (int r_num)
	{
		rental_num = r_num;
	}

	public int getRentalNumber ()
	{
		return rental_num;
	}

	public void setDate (String d)
	{
		checkout_date = d;
	}

	public String getDate ()
	{
		return checkout_date;
	}

	public void setTerm (String t)
	{
		term = t;
	}

	public String getTerm ()
	{
		return term;
	}

	public void setRenter (Renter r)
	{
		renter = r;
	}

	public Renter getRenter ()
	{
		return renter;
	}
	public Locker getLocker ()
	{
		return locker;
	}
	
}
