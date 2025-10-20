package com.mycompany.personarest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {
    private String nombre;
    private int edad;
    private static final double SALARIO_MINIMO = 1500000;

    public Persona() {}

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public double getSalario() {
        return (edad * SALARIO_MINIMO) / 3;
    }
}
