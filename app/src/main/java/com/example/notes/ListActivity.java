package com.example.notes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ListView listView = findViewById(R.id.lv_books);

        String[] users = new String[]{"user 1", "user 2", "user 3"};

        DbHelper helper = new DbHelper(ListActivity.this);
        ArrayList<String> notes = helper.getNotes();

        //data
//        ArrayAdapter arrayAdapter = new ArrayAdapter(
//                ListActivity.this,
//                R.layout.row_single,
//                users);

        CustomAdapter adapter = new CustomAdapter(ListActivity.this,notes);

        listView.setAdapter(adapter);




    }

}
