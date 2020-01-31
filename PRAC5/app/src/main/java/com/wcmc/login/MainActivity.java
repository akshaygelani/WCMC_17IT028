package com.wcmc.login;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name,Password;
    private TextView attampts,toast;
    private Button Login,cancle;
    private int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.etName);
        Password = findViewById(R.id.etPassword);
        Login = findViewById(R.id.btnlogin);
        attampts = findViewById(R.id.txtView);
        cancle = findViewById(R.id.btncancle);

        toast = (TextView)findViewById(R.id.toast);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
    private void validate(String userName, String userPassword){

        if((userName.equals("Admin")) && (userPassword.equals("root"))){
            toast.setText("Login Successfully");
            toast.setBackgroundColor(Color.GREEN);
            toast.setTextColor(Color.BLACK);
        }else {
            counter--;
            toast.setText("User Name or Password is incorrect");
            attampts.setText("Remaining attempts: "+String.valueOf(counter));
            toast.setBackgroundColor(Color.RED);
            toast.setTextColor(Color.WHITE);
            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
