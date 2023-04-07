public class Locker
{
    public int locker_number;
    public boolean rental_status;
    Pin locker_pin;
    AppManager app;

    public Locker (int lockNum, AppManager a)
	  {
    	locker_number = lockNum;
    	rental_status = false;
    	locker_pin = new Pin();
    	app = a;
  
	  }


    public void setLockerNumber(int l_number)
    {
        locker_number = l_number;
    }
    public int getLockerNumber()
    {
        return locker_number;
    }

    public void setRentalStatus(boolean rent_stat)
    {
        rental_status = rent_stat;
    }

    public boolean getRentalStatus() {
        return rental_status;
    }

    public void setLockerPin(Pin pin)
    {
        locker_pin = pin;
    }

    public Pin getLockerPin() {
        return locker_pin;
    }
    
    @Override
    public String toString() {
        return this.locker_number + ": Rental Status: " + this.rental_status + " Pin: " + this.locker_pin.getPin();
    }
    
    
}