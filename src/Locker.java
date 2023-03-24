class Locker
{
    public int locker_number;
    public boolean rental_status;

    public Rental (int lock_num, boolean rent_stat)
    {
        locker_number = lock_num;
        rental_status = rent_stat;
    }

    public void set_locker_number(int l_number)
    {
        locker_number = lock_num;
    }
    public int get_locker_number()
    {
        return locker_number;
    }

    public void set_rental_status(boolean rent_stat)
    {
        rental_status = rent_stat;
    }

    public boolean get_rental_status() {
        return rental_status;
    }

}