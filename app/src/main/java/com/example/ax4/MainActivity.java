package com.example.ax4;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private ToggleButton t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPrefs = getSharedPreferences("com.waybyy.infratics", MODE_PRIVATE);


        t1 = (ToggleButton)findViewById(R.id.toggle1);
        t2 = (ToggleButton)findViewById(R.id.toggle2);


        t1.setChecked(sharedPrefs.getBoolean("NameOfThingToSave", true));
        t2.setChecked(sharedPrefs.getBoolean("NameOfThingToSave2", true));

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t1.isChecked())
                {
                    //on
                    SharedPreferences.Editor editor = getSharedPreferences("com.waybyy.infratics", MODE_PRIVATE).edit();
                    editor.putBoolean("NameOfThingToSave", true);
                    editor.commit();

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("val1");
                    myRef.setValue(1);
                }else {

                    SharedPreferences.Editor editor = getSharedPreferences("com.waybyy.infratics", MODE_PRIVATE).edit();
                    editor.putBoolean("NameOfThingToSave", false);
                    editor.commit();

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("val1");
                    myRef.setValue(0);
                }
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t2.isChecked())
                {
                    //on
                    SharedPreferences.Editor editor = getSharedPreferences("com.waybyy.infratics", MODE_PRIVATE).edit();
                    editor.putBoolean("NameOfThingToSave2", true);
                    editor.commit();

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("val2");
                    myRef.setValue(1);
                }else {

                    SharedPreferences.Editor editor = getSharedPreferences("com.waybyy.infratics", MODE_PRIVATE).edit();
                    editor.putBoolean("NameOfThingToSave2", false);
                    editor.commit();

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("val2");
                    myRef.setValue(0);
                }
            }
        });

    }
}
