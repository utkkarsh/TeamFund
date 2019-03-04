package com.example.utkarshsharma.teamfund;

import com.google.gson.annotations.SerializedName;

public class Party {
    @SerializedName("pname")
    String pname;
    @SerializedName("pid")
    String pid;
    @SerializedName("date")
    String pdate;
    @SerializedName("price")
    String price;

    public Party(String name, String id, String dt, String prc)
    {
        pname=name;
        pid=id;
        pdate=dt;
        price=prc;
    }


}
