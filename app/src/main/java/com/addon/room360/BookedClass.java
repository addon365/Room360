package com.addon.room360;

/**
 * Created by chitti on 22-04-2018.
 */

public class BookedClass {

    public int roomNumber;
    public String ACNonAC;
    public int capacity;

    public BookedClass(int Roomno, String AC, int capacityy){
        this.roomNumber = Roomno;
        this.ACNonAC= AC;
        this.capacity=capacityy;
    }
}
