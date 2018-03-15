package com.example.owner.newestpractice;


import android.provider.ContactsContract;

public class Image {

    private boolean checker;
    private int numID;

    public Image(int num, boolean an){
        checker = an;
        numID = num;
    }

    public int getNumID(){

        return numID;


    }
    public boolean getChecker(){

        return checker;

    }

    public void setChecker(boolean in){


        checker = in;

    }
    public void setNumID(int in){

        numID = in;
    }
}
