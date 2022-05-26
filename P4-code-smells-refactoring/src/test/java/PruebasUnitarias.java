import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PruebasUnitarias {
    //Se crea una instancia de cada clase para las pruebas
    Algoritmo erastotenesCodeSmell = new Algoritmo();
    AlgoritmoRefactored erastotenesRefactored = new AlgoritmoRefactored();

    @org.junit.jupiter.api.Test
    void casoNumeroMenorADos(){
        int numero = 1;

        int[] resultado1 = erastotenesCodeSmell.num_p(numero);
        int[] resultado2 = erastotenesRefactored.retornarNumerosPrimosErastotenes(numero);

        //Pasa la prueba si ambas arrays contienen los mismos elementos
        assertArrayEquals(resultado1,resultado2);
    }

    @org.junit.jupiter.api.Test
    void casoNumeroNegativo(){
        int numero = -87;

        int[] resultado1 = erastotenesCodeSmell.num_p(numero);
        int[] resultado2 = erastotenesRefactored.retornarNumerosPrimosErastotenes(numero);

        //Pasa la prueba si ambas arrays contienen los mismos elementos
        assertArrayEquals(resultado1,resultado2);
    }

    @org.junit.jupiter.api.Test
    void casoMayorADos(){
        int numero = 20;

        int[] resultado1 = erastotenesCodeSmell.num_p(numero);
        int[] resultado2 = erastotenesRefactored.retornarNumerosPrimosErastotenes(numero);

        //Pasa la prueba si ambas arrays contienen los mismos elementos
        assertArrayEquals(resultado1,resultado2);
    }

    @org.junit.jupiter.api.Test
    void casoNumeroGrande(){
        int numero = 350;

        int[] resultado1 = erastotenesCodeSmell.num_p(numero);
        int[] resultado2 = erastotenesRefactored.retornarNumerosPrimosErastotenes(numero);

        //Pasa la prueba si ambas arrays contienen los mismos elementos
        assertArrayEquals(resultado1,resultado2);
    }

}
