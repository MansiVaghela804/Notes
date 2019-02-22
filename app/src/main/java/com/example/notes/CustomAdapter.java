package com.example.notes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    public ArrayList<String> users;
    LayoutInflater inflater;
    Activity ctx;

    CustomAdapter(Activity ctx, ArrayList<String> users){
        this.users = users;
        this.ctx = ctx;
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = ctx.getLayoutInflater().inflate(R.layout.row_single,null);
        TextView tv = view.findViewById(R.id.mytext);
        final Button btn = view.findViewById(R.id.mybtn);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ctx.getApplicationContext(),users.get(position),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        String note = users.get(position);
        tv.setText(note);
        btn.setText(note);
        return view;
    }
}
