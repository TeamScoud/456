package com.example.appoinment_final;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {



    /*EditText t1,t2,t3,t4,t5;
    Button button3;
    DatabaseReference readRef;
    Student std;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main2);


       /*
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        button3 = findViewById(R.id.button3);
        std = new Student();


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                readRef = FirebaseDatabase.getInstance().getReference().child("Student");
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            t1.setText(dataSnapshot.child("date").getValue().toString());
                            t2.setText(dataSnapshot.child("id").getValue().toString());
                            //spinner.setText(dataSnapshot.child("mode").getValue().toString());
                            t3.setText(dataSnapshot.child("mode").getValue().toString());

                            //t4.setText(dataSnapshot.child("name").getValue().toString());
                            t5.setText(dataSnapshot.child("subject").getValue().toString());



                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to display",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }



        });*/
    }
}
