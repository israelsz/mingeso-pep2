package com.example.demo;

public class Corredor {

    String rut;
    String nombre;
    String checkPointPartida; //HH:MM:SS
    String checkPoint1; //HH:MM:SS
    String checkPoint2; //HH:MM:SS
    String checkPointLlegada;

    //Constructor
    public Corredor(String rut, String nombre, String checkPointPartida, String checkPoint1, String checkPoint2, String checkPointLlegada) {
        this.rut = rut;
        this.nombre = nombre;
        this.checkPointPartida = checkPointPartida;
        this.checkPoint1 = checkPoint1;
        this.checkPoint2 = checkPoint2;
        this.checkPointLlegada = checkPointLlegada;
    }

    //Getters and setters
    public String getRut() {
        return rut;
    }


    public String getNombre() {
        return nombre;
    }


    public String getCheckPointPartida() {
        return checkPointPartida;
    }


    public String getCheckPointLlegada() {
        return checkPointLlegada;
    }

    public void setCheckPointLlegada(String checkPointLlegada) {
        this.checkPointLlegada = checkPointLlegada;
    }

}
