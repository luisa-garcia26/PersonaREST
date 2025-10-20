package com.mycompany.personarest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/personas")
public class PersonaResource {

    private static List<Persona> lista = new ArrayList<>();

    static {
        lista.add(new Persona("Juan", 30));
        lista.add(new Persona("Ana", 25));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getPersonas() {
        return lista;
    }

    @GET
    @Path("/salarioPromedio")
    @Produces(MediaType.APPLICATION_XML)
    public Promedio getSalarioPromedio() {
        double suma = 0;
        for (Persona p : lista) suma += p.getSalario();
        return new Promedio(suma / lista.size());
    }

    @GET
    @Path("/sumaSalarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Suma getSumaSalarios() {
        double suma = 0;
        for (Persona p : lista) suma += p.getSalario();
        return new Suma(suma);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Persona addPersona(Persona persona) {
        lista.add(persona);
        return persona;
    }

    public static class Promedio {
        private double promedio;
        public Promedio() {}
        public Promedio(double promedio) { this.promedio = promedio; }
        public double getPromedio() { return promedio; }
        public void setPromedio(double promedio) { this.promedio = promedio; }
    }

    public static class Suma {
        private double suma;
        public Suma() {}
        public Suma(double suma) { this.suma = suma; }
        public double getSuma() { return suma; }
        public void setSuma(double suma) { this.suma = suma; }
    }
}
