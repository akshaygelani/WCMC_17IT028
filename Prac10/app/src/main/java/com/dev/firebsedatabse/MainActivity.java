package com.dev.firebsedatabse;


import android.os.Bundle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText phone;
    private TextView settext;
    private  EditText takeemail2;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submit(View view) {
        email = findViewById(R.id.editText);
        phone = findViewById(R.id.editText3);
        DatabaseReference myRef = database.getReference("Details").child(email.getText().toString());
        myRef.setValue(phone.getText().toString());
    }

    public void showdetails(View view){

        settext= findViewById(R.id.textView3);
        takeemail2=findViewById(R.id.editText4);

        String abc=takeemail2.getText().toString();

        DatabaseReference myRef1 = database.getReference("Details").child(abc);

        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                settext.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("ERROR", "Failed to read value.", error.toException());
            }
        });
    }

}
