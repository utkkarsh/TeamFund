package com.example.utkarshsharma.teamfund;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CallEmployee {


    @SerializedName("edate")
    private String edate;
    @SerializedName("results")
    private List<Employee> results;

    public List<Employee> getResults() {
        Log.d("Results",results.toString());
        return results;
    }
    public String getEdate() {
        return edate;
    }
    public void setResults(List<Employee> results) {
        this.results = results;
    }



}
