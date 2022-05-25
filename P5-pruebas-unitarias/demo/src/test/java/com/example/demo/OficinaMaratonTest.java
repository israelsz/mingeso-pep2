package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.ArrayList;

@SpringBootTest
public class OficinaMaratonTest {

    //Metodo 1
    @Test
    void calcularCorredorPrimerPuestoEntradasNormales() throws ParseException {
        Corredor corredor1 = new Corredor("1","Juan","00:00:00","00:05:20","00:23:42","00:52:12");
        Corredor corredor2 = new Corredor("2","Albert","00:00:00","00:04:20","00:13:42","00:42:12");
        Corredor corredor3 = new Corredor("3","Alfred","00:00:00","00:06:20","00:17:42","00:40:07");
        Corredor corredor4 = new Corredor("4","Elvis","NULL","NULL","NULL","NULL");

        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);

        OficinaMaraton oficina1 = new OficinaMaraton(corredores);
        String prueba = oficina1.calcularCorredorPrimerPuestoMaraton();
        assertEquals("Mejor corredor: Alfred rut: 3",prueba);

    }

    @Test
    void calcularCorredorPrimerPuestoEntradasNulas() throws ParseException {
        Corredor corredor1 = new Corredor("1","Juan","NULL","NULL","NULL","NULL");
        Corredor corredor2 = new Corredor("2","Albert","NULL","NULL","NULL","NULL");
        Corredor corredor3 = new Corredor("3","Alfred","NULL","NULL","NULL","NULL");
        Corredor corredor4 = new Corredor("4","Elvis","NULL","NULL","NULL","NULL");

        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);

        OficinaMaraton oficina1 = new OficinaMaraton(corredores);
        String prueba = oficina1.calcularCorredorPrimerPuestoMaraton();
        assertEquals("Nadie llego a la meta",prueba);

    }

    //Metodo 2
    @Test
    void calcularTiempoPromedioCorredores() throws ParseException {
        Corredor corredor1 = new Corredor("1","Juan","00:00:00","00:05:20","00:23:42","00:52:12");
        Corredor corredor2 = new Corredor("2","Albert","00:00:00","00:04:20","00:13:42","00:42:12");
        Corredor corredor3 = new Corredor("3","Alfred","00:00:00","00:06:20","00:17:42","00:40:07");
        Corredor corredor4 = new Corredor("4","Elvis","NULL","NULL","NULL","NULL");

        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);

        OficinaMaraton oficina1 = new OficinaMaraton(corredores);
        String prueba = oficina1.calcularTiempoPromedioCorredores();
        assertEquals("Tiempo promedio: 0:44:50",prueba);
    }

    @Test
    void calcularTiempoPromedioCorredoresEntradasNulas() throws ParseException {
        Corredor corredor1 = new Corredor("1","Juan","NULL","NULL","NULL","NULL");
        Corredor corredor2 = new Corredor("2","Albert","NULL","NULL","NULL","NULL");
        Corredor corredor3 = new Corredor("3","Alfred","NULL","NULL","NULL","NULL");
        Corredor corredor4 = new Corredor("4","Elvis","NULL","NULL","NULL","NULL");

        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);

        OficinaMaraton oficina1 = new OficinaMaraton(corredores);
        String prueba = oficina1.calcularTiempoPromedioCorredores();
        assertEquals("No hubo corredores",prueba);
    }

    //Metodo 3

    @Test
    void calcularPorcentajeCorredoresQueLlegaronMeta() {
        Corredor corredor1 = new Corredor("1","Juan","00:00:00","00:05:20","00:23:42","00:52:12");
        Corredor corredor2 = new Corredor("2","Albert","00:00:00","00:04:20","00:13:42","00:42:12");
        Corredor corredor3 = new Corredor("3","Alfred","00:00:00","00:06:20","00:17:42","00:40:07");
        Corredor corredor4 = new Corredor("4","Elvis","00:00:00","NULL","NULL","NULL");

        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);

        OficinaMaraton oficina1 = new OficinaMaraton(corredores);
        double prueba = oficina1.calcularPorcentajeCorredoresQueLlegaronMeta();
        assertEquals(0.75,prueba);
    }

    @Test
    void calcularPorcentajeCorredoresQueLlegaronMetaConNoCorredor() {
        Corredor corredor1 = new Corredor("1","Juan","00:00:00","00:05:20","00:23:42","00:52:12");
        Corredor corredor2 = new Corredor("2","Albert","00:00:00","00:04:20","00:13:42","00:42:12");
        Corredor corredor3 = new Corredor("3","Alfred","00:00:00","00:06:20","00:17:42","00:40:07");
        Corredor corredor4 = new Corredor("4","Elvis","NULL","NULL","NULL","NULL");

        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);

        OficinaMaraton oficina1 = new OficinaMaraton(corredores);
        double prueba = oficina1.calcularPorcentajeCorredoresQueLlegaronMeta();
        assertEquals(1.0,prueba);
    }

    // Metodo 4

    @Test
    void calcularPorcentajeCorredoresInscritosQueNoCorrieronUnNoCorredor() {
        Corredor corredor1 = new Corredor("1","Juan","00:00:00","00:05:20","00:23:42","00:52:12");
        Corredor corredor2 = new Corredor("2","Albert","00:00:00","00:04:20","00:13:42","00:42:12");
        Corredor corredor3 = new Corredor("3","Alfred","00:00:00","00:06:20","00:17:42","00:40:07");
        Corredor corredor4 = new Corredor("4","Elvis","NULL","NULL","NULL","NULL");

        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);

        OficinaMaraton oficina1 = new OficinaMaraton(corredores);
        double prueba = oficina1.calcularPorcentajeCorredoresInscritosQueNoCorrieron();
        assertEquals(0.25,prueba);
    }

    @Test
    void calcularPorcentajeCorredoresInscritosQueNoCorrieronTodosCorrieron() {
        Corredor corredor1 = new Corredor("1","Juan","00:00:00","00:05:20","00:23:42","00:52:12");
        Corredor corredor2 = new Corredor("2","Albert","00:00:00","00:04:20","00:13:42","00:42:12");
        Corredor corredor3 = new Corredor("3","Alfred","00:00:00","00:06:20","00:17:42","00:40:07");
        Corredor corredor4 = new Corredor("4","Elvis","00:00:00","NULL","NULL","NULL");

        ArrayList<Corredor> corredores = new ArrayList<Corredor>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);

        OficinaMaraton oficina1 = new OficinaMaraton(corredores);
        double prueba = oficina1.calcularPorcentajeCorredoresInscritosQueNoCorrieron();
        assertEquals(0.0,prueba);
    }

}
