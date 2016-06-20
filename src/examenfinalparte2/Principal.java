
 package examenfinalparte2;
 import java.util.Scanner;

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
        } while (dig <= 0); 
        for (int numComparar = 1; numComparar <= 99999; numComparar++) {
            ndig = contarDivisionEntera(numComparar); 
            
            
            if (ndig == dig) {
                if (numComparar < 4) {
                    esPrimo = true;
                } else if (numComparar % 2 == 0) { 
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
    
      public static int introducirDigito() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un dígito:");
        return teclado.nextInt();
    }


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