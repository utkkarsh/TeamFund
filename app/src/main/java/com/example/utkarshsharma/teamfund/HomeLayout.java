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

public class HomeLayout extends Fragment {
    @Nullable
    CardView balance;
    private String edate;
    private String pdate;
    Api api;
    private RecyclerView recyclerView,partyViewer;
    private EmployeeAdapter empAdapter;
    private PartyAdapter partyAdapter;
    public List<Employee> empList;
    private List<Party> partyList;
    final String apikey="Test01";
    final String project="NBrown";
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout, container, false);

        //Step 1: Set RecyclerView for no of details
        recyclerView = (RecyclerView) view.findViewById(R.id.employee_view);
        partyViewer= (RecyclerView) view.findViewById(R.id.party_view);
        //Step 2: Create ArrayList
        empList = new ArrayList<>();
        partyList=new ArrayList<>();
        //Step 3: Create Adapter Instance

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        prepareEmployee(api);

        RecyclerView.LayoutManager pLayoutManager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) pLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        partyViewer.setLayoutManager(pLayoutManager);
        getAllPartyDetail(api);



        return view;

    }


    private void prepareEmployee(Api api) {

      /*  empList.add(new Employee("Utkarsh Sharma", "687458","9857545855"));
        empList.add(new Employee("Him","5844785","4785566478"));
        empList.add(new Employee("Utkarsh Sharma", "687458","9857545855"));
        empList.add(new Employee("Him","5844785","4785566478"));
        empList.add(new Employee("Utkarsh Sharma", "687458","9857545855"));
        empList.add(new Employee("Him","5844785","4785566478"));
        empList.add(new Employee("Utkarsh Sharma", "687458","9857545855"));
        empList.add(new Employee("Him","5844785","4785566478"));
        empList.add(new Employee("Utkarsh Sharma", "687458","9857545855"));
        empList.add(new Employee("Him","5844785","4785566478"));
        adapter.notifyDataSetChanged();
    */

        Call<CallEmployee> call = api.getEmployee(apikey,project);
        call.enqueue(new Callback<CallEmployee>() {
            @Override
            public void onResponse(Call<CallEmployee> call, Response<CallEmployee> response) {
                Log.d("onSuccess",response.toString());
                String edate=response.body().getEdate();
                List<Employee> emplist = response.body().getResults();
                empAdapter=new EmployeeAdapter(getContext(),emplist);
                recyclerView.setAdapter(empAdapter);
                Log.d("Edate",edate);
            }

            @Override
            public void onFailure(Call<CallEmployee> call, Throwable t) {
                Log.d("onFailure",t.toString());
            }
        });
    }

    private void getAllPartyDetail(Api api)
    {/*
        partyList.add(new Party("Pizza","10-10-2018","₹ 788"));
        partyList.add(new Party("Halwa","10-10-2018","₹ 7880"));
        partyList.add(new Party("Burger","10-10-2018","₹ 1788"));
        partyList.add(new Party("Pizza","10-10-2018","₹ 788"));
        partyList.add(new Party("Halwa","10-10-2018","₹ 7880"));
        partyList.add(new Party("Burger","10-10-2018","₹ 1788"));
        partyList.add(new Party("Pizza","10-10-2018","₹ 788"));
        partyList.add(new Party("Halwa","10-10-2018","₹ 7880"));
        partyList.add(new Party("Burger","10-10-2018","₹ 1788"));
    */
        Call<CallParty> call2 = api.getParties(apikey,project);
        call2.enqueue(new Callback<CallParty>() {
            @Override
            public void onResponse(Call<CallParty> call, Response<CallParty> response) {
                Log.d("onSuccess",response.toString());
                String pdate=response.body().getpdate();
                List<Party> plist = response.body().getResults();
                partyAdapter=new PartyAdapter(getContext(),plist);
                partyViewer.setAdapter(partyAdapter);
                Log.d("Pdate",pdate);
            }

            @Override
            public void onFailure(Call<CallParty> call, Throwable t) {
                Log.d("onFailure",t.toString());
            }
        });

    }

}