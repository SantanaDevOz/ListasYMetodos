package com.example.sdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button Btn_ListaSimple,Btn_ListaDobleLigada,Btn_ListaCircular,Btn_MetodosOrdenamiento;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_ListaSimple = findViewById(R.id.Btn_ListaSimple);
        Btn_ListaDobleLigada = findViewById(R.id.Btn_ListaDobleLigada);
        Btn_ListaCircular = findViewById(R.id.Btn_ListaCircular);
        Btn_MetodosOrdenamiento = findViewById(R.id.Btn_MetodosOrdenamiento);

        Btn_ListaSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this,ListaSimple.class));
                        finish();
                    }
                },1000);
            }
        });

        Btn_ListaDobleLigada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this, ListaDobleLigada.class));
                        finish();
                    }
                },1000);
            }
        });

        Btn_ListaCircular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this, ListaCircular.class));
                        finish();
                    }
                },1000);
            }
        });

        Btn_MetodosOrdenamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this, MetodosOrdenamiento.class));
                        finish();
                    }
                },1000);
            }
        });

    }

}