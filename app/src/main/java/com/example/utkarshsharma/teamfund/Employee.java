package com.example.utkarshsharma.teamfund;

import com.google.gson.annotations.SerializedName;

public class Employee {
    @SerializedName("emp_name")
    private String ename;
    @SerializedName("empid")
    private String empid;
    @SerializedName("emp_dob")
    private int empdob;
    @SerializedName("emp_mob")
    private int empmob;
    @SerializedName("emp_proj")
    private String empproj;
    @SerializedName("emp_cntct")
    private String empphone;

    public Employee(String name, String id,String phone) {
        ename = name;
        empid = id;
        empphone=phone;
    }


    public String getEname() {
        return ename;
    }
    public String geteEproj() {
        return empproj;
    }
    public String getfname()
    {   String[] splited = ename.split("\\s+");
        return splited[0];
    }

    public String getlname()
    {   String[] splited = ename.split("\\s+");
        return splited[1];
    }


    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public int getEmpdob() {
        return empdob;
    }

    public void setEmpdob(int empdob) {
        this.empdob = empdob;
    }

    public int getEmpmob() {
        return empmob;
    }

    public void setEmpmob(int empmob) {
        this.empmob = empmob;
    }

    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        this.empphone = empphone;
    }



}
