package com.elvilla.examencelular;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Punto1 extends AppCompatActivity {
    private TableLayout tabla;
    ArrayList<Celular> celulares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto1);

        tabla = (TableLayout)findViewById(R.id.tabla1);
        celulares = Datos.guardar();
        for (int i = 0; i < celulares.size(); i++) {
            if(celulares.get(i).getMarca().equalsIgnoreCase("Samsung")){
                if (celulares.get(i).getSo().equalsIgnoreCase("Android")){
                    if (celulares.get(i).getColor().equalsIgnoreCase("Negro")){
                        TableRow fila = new TableRow(this);
                        TextView c1 = new TextView(this);
                        TextView c2 = new TextView(this);
                        TextView c3 = new TextView(this);

                        c1.setText("" + (i + 1));
                        c2.setText("" + celulares.get(i).getPrecio());
                        c3.setText("" + celulares.get(i).getRam());

                        fila.addView(c1);
                        fila.addView(c2);
                        fila.addView(c3);


                        tabla.addView(fila);
                    }
                }
            }



        }
    }
}
