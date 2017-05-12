package com.example.raas.programquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mnama;
    Button mmasuk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mnama= (EditText) findViewById(R.id.txtnama);
        mmasuk= (Button) findViewById(R.id.btnmsk);
        mmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Isi.class);
                i.putExtra("NAMA",mnama.getText().toString());
                startActivity(i);
            }
        });
    }
}
