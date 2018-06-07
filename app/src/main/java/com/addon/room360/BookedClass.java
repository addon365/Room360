package com.addon.room360;

/**
 * Created by chitti on 22-04-2018.
 */

public class BookedClass {

    public int roomNumber, capacity;
    public String ACNonAC, bookingdate, Plancheckdate, Checkindate, checkoutdate, adultcount, kidscount;





    public BookedClass(int Roomno, String AC, int capacityy){
        this.roomNumber = Roomno;
        this.ACNonAC= AC;
        this.capacity=capacityy;
    }

    public BookedClass(String BookingDate, String Plancheckdate, String Checkindate, String checkoutdate, String Adultcount, String kidscount){
        this.adultcount=Adultcount;
        this.kidscount = kidscount;
        this.bookingdate = BookingDate;
        this.Plancheckdate = Plancheckdate;
        this.Checkindate = Checkindate;
        this.checkoutdate = checkoutdate;
    }
public int getRoomNumber(){
        return roomNumber;
}
public String getACNonAC(){
        return ACNonAC;
}

public int getCapacity(){
        return capacity;
}

    public String getAdultcount() {
        return adultcount;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public String getCheckindate() {
        return Checkindate;
    }

    public String getCheckoutdate() {
        return checkoutdate;
    }

    public String getKidscount() {
        return kidscount;
    }

    public String getPlancheckdate() {
        return Plancheckdate;
    }
}
