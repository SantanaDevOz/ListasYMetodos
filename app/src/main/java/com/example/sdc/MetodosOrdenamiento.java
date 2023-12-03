package com.example.sdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MetodosOrdenamiento extends AppCompatActivity {
    Button Btn_MetodoBurbuja,Btn_MetodoQS,Btn_Inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodos_ordenamiento);
        Btn_MetodoBurbuja = findViewById(R.id.Btn_MetodoBurbuja);
        Btn_MetodoQS = findViewById(R.id.Btn_MetodoQS);
        Btn_Inicio = findViewById(R.id.Btn_Inicio);

        Btn_MetodoBurbuja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MetodosOrdenamiento.this,Burbuja.class));
                        finish();
                    }
                },1000);
            }
        });

        Btn_MetodoQS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MetodosOrdenamiento.this, QS.class));
                        finish();
                    }
                },1000);
            }
        });

        Btn_Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MetodosOrdenamiento.this,MainActivity.class));
                        finish();
                    }
                },1000);
            }
        });
    }
}