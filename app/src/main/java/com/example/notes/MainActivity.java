package com.example.notes;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context = this;
    private FloatingActionButton fab;
    EditText note, description;
    DbHelper dbhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbhelper  = new DbHelper(MainActivity.this);
//        note = findViewById(R.id.editText);
//        description = findViewById(R.id.editText2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                LayoutInflater inflater = getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.inflate_activity, null);
                final EditText Inflate_Title = alertLayout.findViewById(R.id.Inflate_Title);
                final EditText Inflate_Description = alertLayout.findViewById(R.id.Inflate_Description);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setView(alertLayout);

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("New Note");
                // this is set the view from XML inside AlertDialog
                alert.setView(alertLayout);
                // disallow cancel of AlertDialog on click of back button and outside touch
                alert.setCancelable(false);
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Notes notes = new Notes();
                        notes.setNote(Inflate_Title.getText().toString());
                        notes.setDescription(Inflate_Description.getText().toString());
                        dbhelper.insertNote(notes);
                        Toast.makeText(context, "Note Save", Toast.LENGTH_SHORT).show();
                        DbHelper db = new DbHelper(MainActivity.this);
                        ListView listView = findViewById(R.id.listview);
                        ArrayList<String> notes = db.getNotes();
                        CustomAdapter adapter = new CustomAdapter(MainActivity.this,notes);
                        listView.setAdapter(adapter);
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();

            }
        });
//        DbHelper db = new DbHelper(this);
//        String[] users = new String[]{"user 1", "user 2", "user 3"};
//
//        ListView listView = findViewById(R.id.listview);
//        ArrayList<String> notes = db.getNotes();
//        CustomAdapter adapter = new CustomAdapter(MainActivity.this,notes);
//
//        listView.setAdapter(adapter);
    }
}
