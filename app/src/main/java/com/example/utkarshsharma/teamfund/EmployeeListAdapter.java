package com.example.utkarshsharma.teamfund;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.MyViewHolder> {

    private Context mContext;
    private List<Employee> employeeList;
    private String[] monarray={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, team,dob;
        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.person_name);
            team = (TextView) view.findViewById(R.id.person_team);
            dob = (TextView) view.findViewById(R.id.person_dob);
        }
    }


    public EmployeeListAdapter(Context mContext, List<Employee> employeeList) {
        this.mContext = mContext;
        this.employeeList = employeeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.emp_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        String dateob;

        Employee employee = employeeList.get(position);
        holder.name.setText(employee.getEname());
        holder.team.setText(employee.geteEproj());
        dateob=String.valueOf(employee.getEmpdob())+" "+monarray[employee.getEmpmob()-1];
        holder.dob.setText(dateob);

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
