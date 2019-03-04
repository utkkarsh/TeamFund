package com.example.utkarshsharma.teamfund;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CallParty {


    @SerializedName("pdate")
    private String pdate;
    @SerializedName("results")
    private List<Party> results;

    public List<Party> getResults() {
        Log.d("Results",results.toString());
        return results;
    }
    public String getpdate() {
        return pdate;
    }

}

