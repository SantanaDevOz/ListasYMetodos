package com.example.sdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ListaDobleLigada extends AppCompatActivity
{
    EditText Digitar;
    TextView Imprimir,Imprimir2;
    Button Btn_Ingresar,Btn_Inicio;

    public class Nodo {
        String texto;
        Nodo siguiente;
        Nodo anterior;

        public Nodo(String texto) {
            this.texto = texto;
            this.siguiente = null;
            this.anterior = null;
        }
    }
    public Nodo inicio=null;
    public Nodo ultimo=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_doble_ligada);
        Digitar = findViewById(R.id.Digitar);
        Imprimir = findViewById(R.id.Imprimir);
        Imprimir2 = findViewById(R.id.Imprimir2);
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
                    nuevoNodo.anterior=ultimo;
                    ultimo.siguiente=nuevoNodo;
                    ultimo=nuevoNodo;
                }
                Imprimir.setText("");
                actualizarSalida();
                Imprimir2.setText("");
                actualizarSalida2();
            }
        });

        Btn_Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ListaDobleLigada.this, MainActivity.class));
                        finish();
                    }
                },1000);
            }
        });
    }

    private void actualizarSalida()
    {
        StringBuilder resultado = new StringBuilder();
        Nodo imp=inicio;
        while (imp!=null)
        {
            resultado.append(imp.texto+(" "));
            imp=imp.siguiente;
        }
        Imprimir = findViewById(R.id.Imprimir);
        Imprimir.setText(resultado.toString());
    }

    private void actualizarSalida2()
    {
        StringBuilder resultado = new StringBuilder();
        Nodo imp=ultimo;
        while (imp!=null)
        {
            resultado.append(imp.texto+(", "));
            imp=imp.anterior;
        }
        Imprimir2 = findViewById(R.id.Imprimir2);
        Imprimir2.setText(resultado.toString());
    }
}