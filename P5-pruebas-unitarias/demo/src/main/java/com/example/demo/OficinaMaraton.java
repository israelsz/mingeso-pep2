package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class OficinaMaraton {
    ArrayList<Corredor> corredores;

    public OficinaMaraton(ArrayList<Corredor> corredores) {
        this.corredores = corredores;
    }

    public String calcularCorredorPrimerPuestoMaraton() throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm:ss");
        //Se convierte el tiempo en string a horas
        Corredor mejorTiempo = corredores.get(0);
        for (int i = 0; i < corredores.size(); i++) {
            //Se consiguen los tiempos de los corredores a comparar
            if(!corredores.get(i).getCheckPointLlegada().equals("NULL")){
                Date mejorTiempoActual = formatoFecha.parse(mejorTiempo.getCheckPointLlegada());
                Date tiempoComparar = formatoFecha.parse(corredores.get(i).getCheckPointLlegada());
                long comparacion = mejorTiempoActual.getTime() - tiempoComparar.getTime();
                if (comparacion > 0) {
                    mejorTiempo = corredores.get(i);
                }
            }
        }
        if(mejorTiempo.getCheckPointLlegada().equals("NULL")){
            return ("Nadie llego a la meta");
        }
        return ("Mejor corredor: " + mejorTiempo.getNombre() + " rut: " + mejorTiempo.getRut());
    }

    // Se asume que eso calcula el tiempo promedio que tomaron en finalizar la carrera para todos los corredores que
    // efectivamente corrieron.
    public String calcularTiempoPromedioCorredores() throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm:ss");
        long total = 0;
        long cantidadCorredores = 0;
        for (int i = 0; i < corredores.size(); i++){
            if(!corredores.get(i).getCheckPointLlegada().equals("NULL")){
                total = total +  formatoFecha.parse(corredores.get(i).getCheckPointLlegada()).getTime();
                cantidadCorredores = cantidadCorredores + 1;
            }
        }
        if(cantidadCorredores == 0){
            return("No hubo corredores");
        }
        Date tiempo = new Date(total/cantidadCorredores);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(tiempo);

        return("Tiempo promedio: " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
    }

    // Se hace la suposición, si tiene un valor distinto a null en el checkpoint de partida pero null en la de llegada
    // significa que es un corredor que no llego a la meta, pero si corrio
    public double calcularPorcentajeCorredoresQueLlegaronMeta(){
        double cantCorredoresMeta = 0.0;
        double cantCorredoresTotal = 0.0;
        for (int i = 0; i < corredores.size(); i++){
            //Si tiene un valor distinto de null en el punto de partida significa que si corrio
            if(!corredores.get(i).getCheckPointPartida().equals("NULL")){
                cantCorredoresTotal = cantCorredoresTotal + 1;
            }
            //Si tiene un valor distinto de null en el checkpoint de llegada significa que logro llegar
            if(!corredores.get(i).getCheckPointLlegada().equals("NULL")){
                cantCorredoresMeta = cantCorredoresMeta + 1;
            }
        }
        //Se calcula y retorna el porcentaje en decimal
        return cantCorredoresMeta/cantCorredoresTotal;
    }

    //Se asume que un corredor no corrio si tiene null en su punto de checkpoint de partida
    public double calcularPorcentajeCorredoresInscritosQueNoCorrieron(){
        double cantCorredoresNoCorredores = 0.0;
        double cantCorredoresTotal = 0.0;
        for (int i = 0; i < corredores.size(); i++){
            //Si se trata de un corredor inscrito que no corrio
            if(corredores.get(i).getCheckPointPartida().equals("NULL")){
                cantCorredoresNoCorredores = cantCorredoresNoCorredores + 1;
            }
            cantCorredoresTotal = cantCorredoresTotal + 1;
        }
        return cantCorredoresNoCorredores/cantCorredoresTotal;
    }
}