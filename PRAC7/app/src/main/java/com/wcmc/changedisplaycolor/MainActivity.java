package com.wcmc.changedisplaycolor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1 = findViewById(R.id.Layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.blue:
                l1.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case R.id.green:
                l1.setBackgroundColor(getResources().getColor(R.color.green));
                break;

            case R.id.yellow:
                l1.setBackgroundColor(getResources().getColor(R.color.yello));
                break;

            case R.id.red:
                l1.setBackgroundColor(getResources().getColor(R.color.red));
                break;

            case R.id.orange:
                l1.setBackgroundColor(getResources().getColor(R.color.orange));
                break;

            case R.id.lightgreen:
                l1.setBackgroundColor(getResources().getColor(R.color.lightgreen));
                break;
        }
        return true;
    }
}
