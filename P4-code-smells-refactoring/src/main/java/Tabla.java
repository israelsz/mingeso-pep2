public class Tabla {
    // Atributos
    private boolean[] tabla;
    private int i,j,numeroSiguiente,cuenta;

    //Constructor
    public Tabla(int numeroSiguiente) {
        this.numeroSiguiente = numeroSiguiente;
        cuenta = 0;
        tabla = new boolean[numeroSiguiente];
        for (i=0; i<numeroSiguiente; i++)
            tabla[i] = true;
        tabla[0] = tabla[1] = false;
    }

    public void tacharMultiplosDeDos(){
        for (i = 2; i<Math.sqrt(numeroSiguiente)+1; i++) {
            if (tabla[i]) {
                for (j=2*i; j<numeroSiguiente; j+=i)
                    tabla[j] = false;
            }
        }
    }

    public void contarPrimosRestantes(){
        for (i=0; i<numeroSiguiente; i++){
            if (tabla[i])
                cuenta++;
        }
    }

    public int[] retornarPrimosEncontrados(){
        int[] numeros_primos = new int[cuenta];
        for (i=0, j=0; i<numeroSiguiente; i++){
            if (tabla[i])
                numeros_primos[j++] = i;
        }
        return numeros_primos;
    }
}
