package com.example.rahul.inventory;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     DBHelper mDBHelper;
     RecyclerView mRecyclerView;
     ArrayList<Inventory> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        mDBHelper = new DBHelper(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rvNew);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new InventorAdapter(getApplicationContext(), mList));


        // Opens the add a product version of Editor Activity when button is clicked
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DataIntent = new Intent(MainActivity.this, DataCreation.class);
                startActivity(DataIntent);
            }
        });


    }
}
