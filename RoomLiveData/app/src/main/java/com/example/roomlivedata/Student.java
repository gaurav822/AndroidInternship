package com.example.roomlivedata;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "StudentData")
public class Student {

    @PrimaryKey @NonNull
    String RollNumber;

    @ColumnInfo(name = "StudentName")
    String Name;

    String MailID;
    String PhoneNumber;

    public String getRollNumber() {
        return RollNumber;
    }

    public void setRollNumber(String rollNumber) {
        RollNumber = rollNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMailID() {
        return MailID;
    }

    public void setMailID(String mailID) {
        MailID = mailID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
