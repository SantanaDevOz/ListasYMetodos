package com.example.sdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ListaSimple extends AppCompatActivity
{
    EditText Digitar;
    TextView Imprimir;
    Button Btn_Ingresar,Btn_Inicio;

    public class Nodo {
        String texto;
        Nodo siguiente;

        public Nodo(String texto) {
            this.texto = texto;
            this.siguiente = null;
        }
    }


    public Nodo inicio=null;
    public Nodo ultimo=null;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_simple);

        Digitar = findViewById(R.id.Digitar);
        Imprimir = findViewById(R.id.Imprimir);
        Btn_Ingresar = findViewById(R.id.Btn_Ingresar);
        Btn_Inicio = findViewById(R.id.Btn_Inicio);

        Btn_Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = Digitar.getText().toString();
                Nodo nuevoNodo = new Nodo(texto);
                if (inicio==null)
                {
                    inicio = nuevoNodo;
                    ultimo = nuevoNodo;
                }
                else
                {
                    ultimo.siguiente = nuevoNodo;
                    ultimo = nuevoNodo;
                }
                Imprimir.setText("");
                actualizarSalida();
            }
        });

        Btn_Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ListaSimple.this,MainActivity.class));
                        finish();
                    }
                },1000);
            }
        });
    }

    private void actualizarSalida()
    {
        StringBuilder resultado = new StringBuilder();
        Nodo imp = inicio;
        while (imp!=null)
        {
            resultado.append(imp.texto+(" "));
            imp=imp.siguiente;
        }
        Imprimir = findViewById(R.id.Imprimir);
        Imprimir.setText(resultado.toString());
    }

}