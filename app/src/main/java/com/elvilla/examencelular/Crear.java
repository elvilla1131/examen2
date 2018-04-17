package com.elvilla.examencelular;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Crear extends AppCompatActivity {
    private EditText cajaPrecio, cajaRam;
    private Spinner comboColor, comboMarca, comboSo;
    private Resources resources;
    private String[] strMarca, strColor, strSo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        resources=this.getResources();
        cajaPrecio = (EditText)findViewById(R.id.txtPrecio);
        cajaRam = (EditText)findViewById(R.id.txtRam);
        comboMarca = (Spinner)findViewById(R.id.cmbMarca);
        comboSo=(Spinner)findViewById(R.id.cmbSo);
        comboColor=(Spinner)findViewById(R.id.cmbColor);
        strMarca=resources.getStringArray(R.array.marcaCel);
        strSo=resources.getStringArray(R.array.sistemCel);
        strColor=resources.getStringArray(R.array.colorCel);
        ArrayAdapter<String> adapterMarca = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,strMarca);
        ArrayAdapter<String> adapterso = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,strSo);
        ArrayAdapter<String> adaptercolor = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,strColor);
        comboMarca.setAdapter(adapterMarca);
        comboSo.setAdapter(adapterso);
        comboColor.setAdapter(adaptercolor);
    }

    public void guardar(View view){
        double precio;
        int ram;
        String color, marca, so;

        if (validar()) {
            precio = Double.parseDouble(cajaPrecio.getText().toString());
            ram = Integer.parseInt(cajaRam.getText().toString());
            marca = comboMarca.getSelectedItem().toString();
            so = comboSo.getSelectedItem().toString();
            color = comboColor.getSelectedItem().toString();

            Celular c = new Celular(precio, ram, marca, so, color);
            c.guardar();
            Toast.makeText(this, resources.getString(R.string.mensajeExitoso), Toast.LENGTH_SHORT).show();
            cajaPrecio.setText("");
            cajaRam.setText("");
            comboColor.setSelection(0);
            comboMarca.setSelection(0);
            comboSo.setSelection(0);
            cajaPrecio.requestFocus();
        }
    }

    public boolean validar(){
        if(cajaPrecio.getText().toString().isEmpty()){
            cajaPrecio.setError(resources.getString(R.string.error));
            return false;
        }
        if(cajaRam.getText().toString().isEmpty()){
            cajaRam.setError(resources.getString(R.string.error1));
            return false;
        }
        if(cajaPrecio.getText().toString().equalsIgnoreCase("0")){
            cajaPrecio.setError(resources.getString(R.string.error2));
            return false;
        }
        if(cajaRam.getText().toString().equalsIgnoreCase("0")){
            cajaRam.setError(resources.getString(R.string.error3));
            return false;
        }
        return true;
    }

    public void borrar1(View v){ limpiar(); }

    public void limpiar(){
        cajaPrecio.setText("");
        cajaRam.setText("");
        comboColor.setSelection(0);
        comboMarca.setSelection(0);
        comboSo.setSelection(0);
        cajaPrecio.requestFocus();
    }


}
