public class AlgoritmoRefactored {

    public int[] retornarNumerosPrimosErastotenes (int numero){

        if (numero >= 2) {
            int numeroSiguiente = numero + 1;
            Tabla tabla = new Tabla(numeroSiguiente);
            tabla.tacharMultiplosDeDos();
            tabla.contarPrimosRestantes();
            return tabla.retornarPrimosEncontrados();
        } else {
            return new int[0];
        }
    }
}
