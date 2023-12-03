package com.example.sdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Burbuja extends AppCompatActivity {
    EditText Digitar2;
    TextView Imprimir2;
    Button Btn_Ingresar, Btn_Inicio;
    Nodo inicio;
    public class Nodo {
        int dato;
        Nodo siguiente;
        Nodo anterior;

        public Nodo(int valor) {
            dato=valor;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burbuja);

        Digitar2 = findViewById(R.id.Digitar2);
        Btn_Ingresar = findViewById(R.id.Btn_Ingresar);
        Imprimir2 = findViewById(R.id.Imprimir2);
        Btn_Inicio = findViewById(R.id.Btn_Inicio);
        inicio = null;

        Btn_Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valor = Integer.parseInt(Digitar2.getText().toString());
                agregarNodo(valor);
                burbuja();
                mostrarListas();
            }
        });

        Btn_Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(Burbuja.this, MetodosOrdenamiento.class));
                    }
                },1000);
            }
        });
    }

    private void agregarNodo(int x) {
        Nodo nuevoNodo = new Nodo(x);
        nuevoNodo.siguiente = inicio;
        inicio = nuevoNodo;
    }

    private void burbuja() {
        boolean intercambio;
        do {
            intercambio = false;
            Nodo actual = inicio;
            Nodo previo = null;

            while (actual != null && actual.siguiente != null) {
                if (actual.dato > actual.siguiente.dato) {
                    if (previo != null) {
                        previo.siguiente = actual.siguiente;
                        actual.siguiente = actual.siguiente.siguiente;
                        previo.siguiente.siguiente = actual;
                        intercambio = true;
                    } else {
                        inicio = actual.siguiente;
                        actual.siguiente = inicio.siguiente;
                        inicio.siguiente = actual;
                        intercambio = true;
                    }
                }
                previo = actual;
                actual = actual.siguiente;
            }
        } while (intercambio);
    }

    private void mostrarListas() {
        StringBuilder listaOrdenada = new StringBuilder();
        Nodo tempOrdenada = inicio;
        burbuja();
        while (tempOrdenada != null) {
            listaOrdenada.append(tempOrdenada.dato).append(" ");
            tempOrdenada = tempOrdenada.siguiente;
        }
        Imprimir2.setText(listaOrdenada.toString());
    }
}
