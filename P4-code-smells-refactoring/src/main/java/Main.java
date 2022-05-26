public class Main {
    public static void main(String[] args) {

        Algoritmo eratotenes = new Algoritmo();
        AlgoritmoRefactored erastotenesRefactored = new AlgoritmoRefactored();

        int numero = 35;

        int[] resultado = eratotenes.num_p(numero);


        int[] resultado2 = erastotenesRefactored.retornarNumerosPrimosErastotenes(numero);

        System.out.println("Resultados:\n Original\tRefactored");
        for(int i = 0; i < resultado2.length; i++){
            System.out.println(resultado[i] + "\t\t\t" +resultado2[i]);
        }
    }
}
