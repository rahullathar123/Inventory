package com.example.rahul.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by rahul on 2017-12-26.
 */

public class DataCreation extends AppCompatActivity {


    private EditText pName,PQuantity,pPrice,pRestock;
    private DBHelper mDBHelper;
    private Button saveButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);


        mDBHelper = new DBHelper(this);
        pName = (EditText) findViewById(R.id.PName);
        PQuantity =(EditText)findViewById(R.id.PQuantity);
        pPrice = (EditText)findViewById(R.id.PPrice);
        pRestock =(EditText)findViewById(R.id.RRestock);
        saveButton = (Button) findViewById(R.id.SaveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String name = String.valueOf(pName.getText());
                int quantity = Integer.parseInt(String.valueOf(PQuantity.getText()));
                int restock = Integer.valueOf(String.valueOf(pRestock.getText()));
                int price = Integer.valueOf(String.valueOf(pPrice.getText()));

               mDBHelper.insertNewData(name,quantity,restock,price);

                Intent intent = new Intent(DataCreation.this,MainActivity.class);
                startActivity(intent);

            }
        });













    }
}
