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

public class HomeLayout extends Fragment {
    @Nullable
    CardView balance;
    private String edate;
    private String pdate;
    Api api;
    private RecyclerView recyclerView,partyViewer;
    private EmployeeAdapter adapter;
    private PartyAdapter partyAdapter;
    private List<Employee> empList;
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
        adapter = new EmployeeAdapter(getContext(), empList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareEmployee();

        RecyclerView.LayoutManager pLayoutManager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) pLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        partyViewer.setLayoutManager(pLayoutManager);

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
        getAllPartyDetail();



        return view;

    }


    private void prepareEmployee() {

        empList.add(new Employee("Utkarsh Sharma", "687458","9857545855"));
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
    }

    private void getAllPartyDetail()
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

    }

}