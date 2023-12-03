package com.example.sdc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QS extends AppCompatActivity {
    EditText Digitar2;
    TextView Imprimir;
    Button Btn_Ingresar,Btn_Inicio;

    Nodo inicio = null;
    Nodo ultimo = null;

    public class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int valor) {
            dato=valor;
            this.siguiente = null;
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qs);
        Digitar2 = findViewById(R.id.Digitar2);
        Btn_Ingresar = findViewById(R.id.Btn_Ingresar);
        Imprimir = findViewById(R.id.Imprimir);
        Btn_Inicio = findViewById(R.id.Btn_Inicio);

        Btn_Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresarValor();
                ordenarLista();
            }
        });

        Btn_Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(QS.this, MetodosOrdenamiento.class));
                        finish();
                    }
                },1000);
            }
        });
    }

    private void ingresarValor() {
        int valor = Integer.parseInt(Digitar2.getText().toString());
        Nodo nuevoNodo = new Nodo(valor);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
        }
        ultimo = nuevoNodo;
        Digitar2.setText("");
    }

    private void ordenarLista() {
        Nodo fin = ultimo;
        inicio = quicksort(inicio, fin);
        mostrarLista(inicio);
    }

    private Nodo partir(Nodo inicio, Nodo fin, Nodo[] nuevoInicio, Nodo[] nuevoFin) {
        Nodo pivote = fin;
        Nodo previo = null;
        Nodo current = inicio;
        Nodo tail = pivote;

        while (current != pivote) {
            if (current.dato < pivote.dato) {
                if (nuevoInicio[0] == null) {
                    nuevoInicio[0] = current;
                }
                previo = current;
                current = current.siguiente;
            } else {
                if (previo != null) {
                    previo.siguiente = current.siguiente;
                }
                Nodo temp = current.siguiente;
                current.siguiente = null;
                tail.siguiente = current;
                tail = current;
                current = temp;
            }
        }

        if (nuevoInicio[0] == null) {
            nuevoInicio[0] = pivote;
        }

        nuevoFin[0] = tail;

        return pivote;
    }

    private Nodo quicksort(Nodo inicio, Nodo fin) {
        if (inicio == null || inicio == fin) {
            return inicio;
        }

        Nodo[] nuevoInicio = { null };
        Nodo[] nuevoFin = { null };

        Nodo pivote = partir(inicio, fin, nuevoInicio, nuevoFin);

        if (nuevoInicio[0] != pivote) {
            Nodo temp = nuevoInicio[0];
            while (temp.siguiente != pivote) {
                temp = temp.siguiente;
            }
            temp.siguiente = null;

            nuevoInicio[0] = quicksort(nuevoInicio[0], temp);
            temp = nuevoInicio[0];
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = pivote;
        }

        pivote.siguiente = quicksort(pivote.siguiente, nuevoFin[0]);

        return nuevoInicio[0];
    }

    private void mostrarLista(Nodo inicio) {
        StringBuilder stringBuilder = new StringBuilder();
        Nodo temp = inicio;
        while (temp != null) {
            stringBuilder.append(temp.dato).append(" ");
            temp = temp.siguiente;
        }
        Imprimir.setText(stringBuilder.toString());
    }
}