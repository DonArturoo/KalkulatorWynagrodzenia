package com.example.kalkulatorwynagrodzenia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Wynagrodzenie extends AppCompatActivity {

    TextView netto;
    TextView brutto;
    String net;
    String bru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wynagrodzenie);

        netto = findViewById(R.id.wynagnetto);
        brutto = findViewById(R.id.wynagbrutto);

        if(getIntent().getIntExtra("netto", 0) > 0){
            net = netto.getText().toString() + " " + getIntent().getIntExtra("netto", 0);
            bru = brutto.getText().toString() + " " + wynagnetto(getIntent().getIntExtra("netto", 0));
        }else{
            net = netto.getText().toString() + " " + wynagbrutto(getIntent().getIntExtra("brutto", 0));
            bru = brutto.getText().toString() + " " + getIntent().getIntExtra("brutto", 0);
        }
        netto.setText(net);
        brutto.setText(bru);
    }
    private String wynagbrutto(int i){
        int cal = i;
        double koszt = cal * 0.2;
        int podatkowa = cal - wartosc(koszt);
        double pit = podatkowa * 0.18;
        int zarobek = cal - wartosc(pit);
        String zysk = String.valueOf(zarobek);
        return zysk;
    }

    private String wynagnetto(int i){
        int zysk = i;
        int zarobek = wartosc((zysk*100)/85.6);
        String cal = String.valueOf(zarobek);
        return cal;
    }

    private int wartosc(double d){
        int a = (int)d;
        d-=a;
        if(d>=0.5){
            a+=1;
        }
    return a;
    }
}
