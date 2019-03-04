/*package com.example.utkarshsharma.teamfund;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    CardView balance;

    private RecyclerView recyclerView,partyViewer;
    private EmployeeAdapter adapter;
    private PartyAdapter partyAdapter;
    private List<Employee> empList;
    private List<Party> partyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Step 1: Set RecyclerView for no of details
        recyclerView = (RecyclerView) findViewById(R.id.employee_view);
        partyViewer= (RecyclerView) findViewById(R.id.party_view);
        //Step 2: Create ArrayList
        empList = new ArrayList<>();
        partyList=new ArrayList<>();
        //Step 3: Create Adapter Instance
        adapter = new EmployeeAdapter(this, empList);
        partyAdapter=new PartyAdapter(this,partyList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareEmployee();

        RecyclerView.LayoutManager pLayoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) pLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        partyViewer.setLayoutManager(pLayoutManager);
        partyViewer.setItemAnimator(new DefaultItemAnimator());
        partyViewer.setAdapter(partyAdapter);
        getAllPartyDetail();

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
    {
        partyList.add(new Party(2146,"Pizza","10-10-2018","₹ 788"));
        partyList.add(new Party(2147,"Halwa","10-10-2018","₹ 7880"));
        partyList.add(new Party(2148,"Burger","10-10-2018","₹ 1788"));
    }

}
*/