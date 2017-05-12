package com.example.raas.programquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Isi extends AppCompatActivity {
    Button mmasuk,mkeluar;
    TextView mnama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi);
        mnama=(TextView) findViewById(R.id.nama);

        String namadarifront = getIntent().getStringExtra("NAMA");
       mnama.setText(namadarifront);

        mmasuk= (Button) findViewById(R.id.btn1);
        mmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Isi.this, Alikhlas.class);
                startActivity(i);
            }
        });

        mmasuk= (Button) findViewById(R.id.btn2);
        mmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Isi.this, Alfalaq.class);
                startActivity(i);
            }
        });

        mmasuk= (Button) findViewById(R.id.btn3);
        mmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Isi.this, Annas.class);
                startActivity(i);
            }
        });
        mkeluar= (Button) findViewById(R.id.btn4);
        mkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                //finish();buat cuman ke frame sebelumnya
                //System.exit(0);buat cuman ke frame sebelumnya

            }
        });



    }
}
