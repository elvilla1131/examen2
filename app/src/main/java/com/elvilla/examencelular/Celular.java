package com.elvilla.examencelular;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Celular extends AppCompatActivity {
    private double precio;
    private int ram;
    private String marca;
    private String so;
    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celular);
    }

    public Celular(double precio, int ram, String marca, String so, String color) {
        this.precio = precio;
        this.ram = ram;
        this.marca = marca;
        this.so = so;
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void guardar(){
        Datos.guardar(this);
    }
}
