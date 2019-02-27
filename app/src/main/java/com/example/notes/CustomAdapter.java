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

    public ArrayList<Notes> users;
    LayoutInflater inflater;
    Activity ctx;

    CustomAdapter(Activity ctx, ArrayList<Notes> users){
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
        TextView tv1 = view.findViewById(R.id.mytitle);
        TextView tv2 = view.findViewById(R.id.mydescription);
        Notes note = users.get(position);

        final String title = note.getNote();
        String desc = note.getDescription();

//        final Button btn = view.findViewById(R.id.mybtn);
//                btn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(ctx.getApplicationContext(),title, Toast.LENGTH_SHORT).show();
//                    }
//                });

        Notes note2 = users.get(position);
        tv1.setText(title);
        tv2.setText(desc);

//        btn.setText(note);
        return view;
    }
}
