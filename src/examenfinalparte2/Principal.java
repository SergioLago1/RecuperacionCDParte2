package examenfinalparte2;

import java.util.Scanner;

/**
 * Se mira si un número es primo o no y se mostrarán los números primos de el
 * número de cifras que se introduzca.
 *
 * @author slagogonzalez
 */
public class Principal {

    public static boolean esPrimo = false;

    public static void main(String arg[]) {
        int dig;
        int ndig;
        do {
            dig = introducirDigito();
            if (dig <= 0) {
                System.out.println("Ingrese como parámetro, un numero de digito correcto (mayor que 0): ");
            }
        } while (dig <= 0);//Para que introduzca un número mayor que 0
        for (int numComparar = 1; numComparar <= 99999; numComparar++) {
            ndig = contarDivisionEntera(numComparar);//Número de cifras del número introducido 

            //Si el dígito y su número de cifras es igual 
            if (ndig == dig) {
                if (numComparar < 4) {
                    esPrimo = true;
                } else if (numComparar % 2 == 0) {//Si el número que compara es divisible entre 2 no es primo
                    esPrimo = false;
                } else {
                    int countDivisores = 0;
                    int i1 = 1;
                    int limite = (numComparar - 1) / 2;
                    if (limite % 2 == 0) {
                        limite--;
                    }

                    esPrimo = calculaNumDivisores(i1, limite, numComparar, countDivisores);
                }

                if (esPrimo == true) {
                    System.out.println(numComparar);
                }
            }
        }
    }

    /**
     * Pide un número entero por pantalla
     *
     * @return El número entero introducido
     */
    public static int introducirDigito() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un dígito:");
        return teclado.nextInt();
    }

    /**
     * Calcula el número de divisores del número
     *
     * @param i1 Divisor
     * @param limite Límite de divisores
     * @param numComparar Número del que se van a contar los divisores
     * @param countDivisores Contador de divisores
     * @return Si numComparar es primo o no
     */

    private static boolean calculaNumDivisores(int i1, int limite, int numComparar, int countDivisores) {
        boolean esPrimo = false;
        while (i1 <= limite) {
            if (numComparar % i1 == 0) {
                countDivisores++;
            }
            i1 += 2;
            if (countDivisores == 2) {
                i1 = limite + 1;
            }
        }

        if (countDivisores == 1) {
            esPrimo = true;
        }

        return esPrimo;
    }

    /**
     * Cuenta el número de divisiones enteras que se pueden realizar sobre el
     * número pasado.
     *
     * @param numComparar Número dividendo
     * @return El número de divisiones enteras
     */
    private static int contarDivisionEntera(int numComparar) {
        int aux = numComparar;
        int contador = 0;
        while (aux != 0) {
            aux = aux / 10;
            contador++;
        }
        return contador;
    }

}
