package com.example.utkarshsharma.teamfund;

import com.google.gson.annotations.SerializedName;

public class Party {

    @SerializedName("pid")
    private int partyId;
    @SerializedName("pname")
    private String partyName;
    @SerializedName("date")
    private String partyDate;
    @SerializedName("price")
    private String partyPrice;

    public Party(   String name,String date,String price)
    {
        partyDate=date;
        partyPrice=price;
        partyName=name;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(String partyDate) {
        this.partyDate = partyDate;
    }

    public String getPartyPrice() {
        return partyPrice;
    }

    public void setPartyPrice(String partyPrice) {
        this.partyPrice = partyPrice;
    }

    }
