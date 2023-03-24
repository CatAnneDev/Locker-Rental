class Locker
{
    public int locker_number;
    public boolean rental_status;

    public void set_locker_number (int l_number)
    {
        locker_number = l_number;
    }
    public int get_locker_number ()
    {
        return locker_number;
    }

    public boolean get_rental_status() {
        return rental_status;
    }

}