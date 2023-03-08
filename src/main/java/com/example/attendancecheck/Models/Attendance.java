package com.example.attendancecheck.Models;

import javafx.beans.property.*;

public class Attendance {
    private StringProperty ID;
    private StringProperty MSV;
    private StringProperty fullName;
    private IntegerProperty Status;
    private DoubleProperty AbsentsCount;

    public Attendance(){}
    public Attendance(String ID, String MSV, String fullName, int Status, double AbsentsCount ){
        this.ID = new SimpleStringProperty(this, "ID", ID);
        this.MSV = new SimpleStringProperty(this, "MSV", MSV);
        this.fullName = new SimpleStringProperty(this, "Full Name", fullName);
        this.Status = new SimpleIntegerProperty(this, "Status",Status);
        this.AbsentsCount = new SimpleDoubleProperty(this, "Absents Count", AbsentsCount);
    }


    public StringProperty IDProperty(){
        return this.ID;
    }
    public StringProperty MSVProperty(){
        return this.MSV;
    }

    public StringProperty fullNameProperty(){
        return this.fullName;
    }
    public IntegerProperty StatusProperty(){
        return this.Status;
    }

    public DoubleProperty AbsentsCountProperty(){
        return this.AbsentsCount;
    }
    public void setAbsentsCount(double count){

        this.AbsentsCount.set(AbsentsCount.getValue() + count);
    }
}
