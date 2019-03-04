package com.example.utkarshsharma.teamfund;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://libeosapp.000webhostapp.com";


    @GET("getEmpl.php")
    Call<CallEmployee> getEmployee(@Query("apikey") String apiKey,@Query("proj") String project);

    @GET("getParty.php")
    Call<CallParty> getParties(@Query("apikey") String apiKey,@Query("proj") String project);

}