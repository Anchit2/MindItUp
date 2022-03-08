package com.example.minditup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Categories extends AppCompatActivity {

    RelativeLayout depressed;
    TextView deptext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getSupportActionBar().hide();

        depressed= findViewById(R.id.depressed);
        deptext= findViewById(R.id.deptext);
        depressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String detext = deptext.getText().toString();
                if(detext.equals("Overcoming Depression")){
                    startActivity(new Intent(Categories.this,DepressedActivity.class));
                    deptext.setText("Overcoming Depression.");
                }else{
                    startActivity(new Intent(Categories.this,MainActivity.class));
                }


            }
        });
    }
}