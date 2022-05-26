public class Algoritmo {
    public int[] num_p (int n){
        int i,j,k; // Dead Code, la k no se ocupa
        int n_list, p_datos; //Dead code, estas dos vatiables no se ocupan
        if (n >= 2) {
            //Declaraciones
            int d = n + 1;
            boolean[] tabla = new boolean[d];
            for (i=0; i<d; i++)
                tabla[i] = true;
            tabla[0] = tabla[1] = false;
            for (i = 2; i<Math.sqrt(d)+1; i++) {
                if (tabla[i]) {
                    for (j=2*i; j<d; j+=i)
                        tabla[j] = false;
                }
            }
            int cuenta = 0;
            for (i=0; i<d; i++){
                if (tabla[i])
                    cuenta++;
            }
            int[] n_prim = new int[cuenta];
            for (i=0, j=0; i<d; i++){
                if (tabla[i])
                    n_prim[j++] = i;
            }
            return n_prim;
        } else {
            return new int[0];
        }
    }
}

// Code Smells detectados:
// ----- Bloaters -----
// -> Long method (el metodo tiene más de 10 lineas) -> Crear más metodos, evita codigo spaghetti
//     - Presente en el metodo num_p
// -> Primitive obsesion (muchas primitvas) -> Crear objeto que sea representativo
//     - Hay muchas primitivas que podrían expresarse como un objeto, en este caso la Tabla

// ----- Dispensables -----
// -> Comments (el nombre del método no es significativo, no se entiende que hace)
// -> Dead Code (hay variables que no se ocupan)
//       - En las lineas 3 y 4 hay codigo que no cumple ninguna funcionalidad.

// Total de 23 lineas con code smells
// 25 minutos para arreglar los code-smells = 0.42 hrs
// Se considera una linea escrita cada 6 minutos = 1 linea cada 0-1 hrs
// 33 lineas de la clase * 0.1 = 3.3 hrs de creación de este algoritmo
//Entonces Deuda tecnica = (0.42/3.3)*100 = 12.73 %
//Esto significa que arreglar los codesmells de este código toma el 12.73% de su creación, o sea 25 minutos de 3.3 horas
// Este porcentaje es muy alto, lo adecuado es mantenerlo menor al 5%. Luego se vuelve muy dificil de mantener
// a medida que el programa crece.

