package com.wcmc_17IT028;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1,num2;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=getLayoutInflater();
                View view= inflater.inflate(R.layout.custimview,(ViewGroup)findViewById(R.id.layout1));

                TextView textView=view.findViewById(R.id.toast);
                String sum=String.valueOf(Integer.parseInt(num1.getText().toString())+Integer.parseInt(num2.getText().toString()));
                textView.setText("Sum is : "+sum);

                Toast toast=new Toast(MainActivity.this);
                toast.setView(view);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
