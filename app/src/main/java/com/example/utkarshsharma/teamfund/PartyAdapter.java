package com.example.utkarshsharma.teamfund;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
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


public class PartyAdapter extends RecyclerView.Adapter<PartyAdapter.MyViewHolder> {

    private Context mContext;
    private List<Party> partyList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, date,price;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.party_name);
            date = (TextView) view.findViewById(R.id.party_date);
            price = (TextView) view.findViewById(R.id.party_price);
        }
    }


    public PartyAdapter(Context mContext, List<Party> partyList) {
        this.mContext = mContext;
        this.partyList = partyList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.party_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Party party = partyList.get(position);
        holder.name.setText(party.pname);
        holder.date.setText(party.pdate);
        holder.price.setText(party.price);

    }


    @Override
    public int getItemCount() {
        return partyList.size();
    }
}
