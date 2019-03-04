package com.example.utkarshsharma.teamfund;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {

    private Context mContext;
    private List<Employee> employeeList;
    private String[] monarray={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView fname, lname,dob;
        public MyViewHolder(View view) {
            super(view);
            fname = (TextView) view.findViewById(R.id.fname);
            lname = (TextView) view.findViewById(R.id.lname);
            dob = (TextView) view.findViewById(R.id.dob);
        }
    }


    public EmployeeAdapter(Context mContext, List<Employee> employeeList) {
        this.mContext = mContext;
        this.employeeList = employeeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        String dateob;

        Employee employee = employeeList.get(position);
        holder.fname.setText(employee.getfname());
        holder.lname.setText(employee.getlname());
        dateob=String.valueOf(employee.getEmpdob())+" "+monarray[employee.getEmpmob()-1];
        holder.dob.setText(dateob);

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
