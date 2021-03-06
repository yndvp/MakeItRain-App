package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private Button makeItRain;
    private Button showInfo;
    private TextView moneyValue;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeItRain = findViewById(R.id.buttonMakeItRain);
        moneyValue = findViewById(R.id.moneyValue);

//        moneyValue.setText(R.string.test);

        // Attaching event listener
//          makeItRain.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View view) {
//                  Log.d("MainActivity", "onClick: Make it rain");
//              }
//          });
        // Attaching event listener: Lambda expression
//        makeItRain.setOnClickListener(view -> Log.d("MainActivity", "onClick: Make it rain"));
    }

    public void showMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

        moneyCounter += 1000;
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
        Log.d("MIR", "onClick: Make it rain " + moneyCounter);

//        if(moneyCounter == 20000) {
//            moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
//        }

        switch (moneyCounter) {
            case 20000:
                moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,
                        R.color.purple_700));
                break;
            case 30000:
                // Another way to set color
                moneyValue.setTextColor(Color.MAGENTA);
                break;
            case 40000:
                moneyValue.setTextColor(Color.LTGRAY);
                break;
            default:
                moneyValue.setTextColor(Color.WHITE);
        }
    }

    public void showInfo(View view) {
        Toast.makeText(MainActivity.this, R.string.app_info, Toast.LENGTH_SHORT)
                .show();
        Snackbar.make(moneyValue, R.string.app_info, Snackbar.LENGTH_LONG)
                .setAction("More", view1 -> {
                    Log.d("Snack", "showInfo: Snackbar More");
                })
                .show();
    }
}