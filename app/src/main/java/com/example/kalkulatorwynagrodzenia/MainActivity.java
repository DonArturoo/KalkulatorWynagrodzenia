package com.example.kalkulatorwynagrodzenia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText netto;
    TextView brutto;
    Button przelicz;
    ToggleButton toggleButton;
    int net=0;
    int brut=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        netto = findViewById(R.id.netto);
        brutto = findViewById(R.id.brutto);
        przelicz = findViewById(R.id.przelicz);
        toggleButton = findViewById(R.id.toggleButton);

        przelicz.setEnabled(false);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    netto.setEnabled(true);
                    brutto.setEnabled(false);
                    przelicz.setEnabled(true);
                    brut = 0;
                }
                else{
                    netto.setEnabled(false);
                    brutto.setEnabled(true);
                    przelicz.setEnabled(true);
                    net = 0;
                }
            }
        });



        przelicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Wynagrodzenie.class);
                if(netto.isEnabled()) {
                    net = Integer.parseInt(String.valueOf(netto.getText()));
                }else {
                    brut = Integer.parseInt(String.valueOf(brutto.getText()));
                }
                intent.putExtra("netto", net);
                intent.putExtra("brutto", brut);
                startActivity(intent);
            }
        });
    }
}
