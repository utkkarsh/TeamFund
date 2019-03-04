package com.example.utkarshsharma.teamfund;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeamLayout extends Fragment {
    @Nullable
    private RecyclerView recyclerView;
    private EmployeeListAdapter empAdapter;
    private List<Employee> empList;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.team_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.team_list_card);
        empList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        prepareEmployee(api);
        return view;

    }
    private void prepareEmployee(Api api) {
        Call<CallEmployee> call = api.getEmployee("Test01","NBrown");
        call.enqueue(new Callback<CallEmployee>() {
            @Override
            public void onResponse(Call<CallEmployee> call, Response<CallEmployee> response) {
                Log.d("onSuccess",response.toString());
                String edate=response.body().getEdate();
                List<Employee> emplist = response.body().getResults();
                empAdapter=new EmployeeListAdapter(getContext(),emplist);
                recyclerView.setAdapter(empAdapter);
                Log.d("Edate",edate);
            }

            @Override
            public void onFailure(Call<CallEmployee> call, Throwable t) {
                Log.d("onFailure",t.toString());
            }
        });
    }


}