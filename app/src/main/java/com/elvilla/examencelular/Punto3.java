package com.elvilla.examencelular;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Punto3 extends AppCompatActivity {
    private TableLayout tabla;
    ArrayList<Celular> celulares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto3);

        tabla = (TableLayout)findViewById(R.id.tabla3);
        celulares = Datos.guardar();
        double preciobarato=2147483647;
        TableRow fila = new TableRow(this);
        TextView c1 = new TextView(this);
        TextView c2 = new TextView(this);
        TextView c3 = new TextView(this);
        TextView c4 = new TextView(this);
        TextView c5 = new TextView(this);
        TextView c6 = new TextView(this);
        for (int i = 0; i < celulares.size(); i++) {
            if(celulares.get(i).getMarca().equalsIgnoreCase("Huawei")){
                if (celulares.get(i).getSo().equalsIgnoreCase("Android")){
                    if (celulares.get(i).getColor().equalsIgnoreCase("Blanco")) {
                        if (celulares.get(i).getPrecio()<= preciobarato) {
                            preciobarato = celulares.get(i).getPrecio();
                            c1.setText("" + (i + 1));
                            c2.setText("" + preciobarato);
                            c3.setText("" + celulares.get(i).getRam());
                            c4.setText("" + celulares.get(i).getMarca());
                            c5.setText("" + celulares.get(i).getSo());
                            c6.setText("" + celulares.get(i).getColor());
                        }
                    }
                }
            }
        }
        fila.addView(c1);
        fila.addView(c2);
        fila.addView(c3);
        fila.addView(c4);
        fila.addView(c5);
        fila.addView(c6);
        tabla.addView(fila);
    }
}
