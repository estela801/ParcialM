package com.example.thesalon.datos;

public class Cita {
    private String servicio;
    private String fecha;
    private String hora;
    private String observacion;
    String key;

    public Cita() {
    }

    public Cita(String servicio, String fecha, String hora, String observacion){
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
        this.observacion = observacion;
    }

    public String getServicio(){ return servicio;}
    public void setServicio(String servicio){this.servicio = servicio;}

    public String getFecha(){ return fecha;}
    public void setFecha(String fecha){this.fecha = fecha;}

    public String getHora(){ return hora;}
    public void setHora(String hora){this.hora = hora;}

    public String getObservacion(){ return observacion;}
    public void setObservacion(String observacion){this.observacion = observacion;}

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }



}
