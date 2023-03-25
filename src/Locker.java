class Locker
{
    public int locker_number;
    public boolean rental_status;
    Pin locker_pin;

    public void Rental (int lock_num, boolean rent_stat, Pin pin)
    {
        locker_number = lock_num;
        rental_status = rent_stat;
        locker_pin = pin;
    }

    public void setLockerNumber(int l_number)
    {
        locker_number = lock_num;
    }
    public int geTLockerNumber()
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
}