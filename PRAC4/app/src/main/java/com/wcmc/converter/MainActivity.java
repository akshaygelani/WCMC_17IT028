package com.wcmc.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    ToggleButton toggleButton;
    Double a1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText2);
        toggleButton = findViewById(R.id.toggleButton2);
        button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter the Temperature", Toast.LENGTH_SHORT).show();
                }
                else if (toggleButton.isChecked()){
                    a1 = Double.parseDouble(String.valueOf(editText.getText()));
                    Double b1 = a1*(9/5)+32;
                    String r = String.valueOf(b1);
                    Toast.makeText(MainActivity.this, r+" F", Toast.LENGTH_SHORT).show();
                }
                else{
                    a1 = Double.parseDouble(String.valueOf(editText.getText()));
                    Double b1 = a1-32;
                    Double c1 = b1*5/9;
                    String r = String.valueOf(c1);
                    Toast.makeText(MainActivity.this, r+" C", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
