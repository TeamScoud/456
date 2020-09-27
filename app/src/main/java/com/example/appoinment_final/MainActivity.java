package com.example.appoinment_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText e2,e5,e1;
    Spinner spinner,spinner2;
    DatePickerDialog picker;
    Button button,button2;
    DatabaseReference dbRef;
    DatabaseReference readRef;
    Student std;
    long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e2 = findViewById(R.id.e2);
        e5 = findViewById(R.id.e5);
        e1 = findViewById(R.id.e1);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        std = new Student();
        dbRef=FirebaseDatabase.getInstance().getReference().child("Student");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        dbRef=FirebaseDatabase.getInstance().getReference().child("Student").child(String.valueOf(maxid));
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.hasChild(String.valueOf(maxid+1))) {
                    dbRef = FirebaseDatabase.getInstance().getReference().child("Student").child(String.valueOf(maxid+1));
                    dbRef.removeValue();
                    Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_SHORT).show();

                }else
                    Toast.makeText(getApplicationContext(), "Data Not Deleted Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//

                //dbRef = FirebaseDatabase.getInstance().getReference().child("Student");
                if (TextUtils.isEmpty(e1.getText().toString()))

                    Toast.makeText(MainActivity.this, "Please Enter ID ", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(e5.getText().toString()))
                    Toast.makeText(MainActivity.this, "Please Enter Name ", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(spinner.getSelectedItem().toString()))
                    Toast.makeText(MainActivity.this, "Please Enter Subject ", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(e2.getText().toString()))
                    Toast.makeText(MainActivity.this, "Please Enter Date ", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(spinner2.getSelectedItem().toString()))
                    Toast.makeText(MainActivity.this, "Please Enter Date ", Toast.LENGTH_SHORT).show();

                else{

                    std.setID(e1.getText().toString().trim());
                    std.setName(e5.getText().toString().trim());
                    std.setSubject(spinner.getSelectedItem().toString().trim());
                    std.setDate(e2.getText().toString().trim());
                    std.setMode(spinner2.getSelectedItem().toString().trim());

                    dbRef.push().child(String.valueOf(maxid+1)).setValue(std);


                    //dbRef.push().setValue(std);
                    //dbRef.child("Std1").setValue(std);
                    Toast.makeText(getApplicationContext(),"Data Saved Successfully",Toast.LENGTH_SHORT).show();

                    //


                }

            }



        });







        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener(){

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){

                        e2.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }

                        }, year, month, day);

                picker.show();
            }
        });
    }




}
