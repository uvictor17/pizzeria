
package com.mycompany.pizzeria;

import java.util.Scanner;

public class Pizzeria {
    static String[] tamanio = {"Mini", "Mediana", "Extragrande", "Jumbo", "Mega"};
    static String[] especialidades = {"Jamon", "Champiñones", "Chorihuevo", "pollo","Res","Shenlong"};
    static int[] precioPizza = {80, 100, 90, 120, 125, 180};
    static String[] complementos = {"Sangria 2L", "Ensalada", "nuguets", "Snacks","palitos de cebolla", "spagueti"};
    static int[] precioComplementos = {35, 30, 20, 27, 45};
    static int[][] orden = new int[5][3];
    static int[] complementosSeleccionados = new int[complementos.length];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int opcion = 0;

        do {
            System.out.println("★★★★★★★ LA PIZZA DE DON CANGREJO ★★★★★★★");
            System.out.println("             BIENVENIDO     ");
            System.out.println("★★ MENU ★★");
            System.out.println("1. DESEO ORDENAR");
            System.out.println("2. REVISAR PEDIDO");
            System.out.println("3. SALIR ");
            System.out.println("★★★★★★★★★★★★★★★★★★★★★★★");
            System.out.println("¿QUE VA QUERER? ");
            opcion = in.nextInt();
             
            switch (opcion) {
                case 1:
                
                    ordenarPizza(in);
                    break;
                case 2:
                
                    imprimirOrden();
                
                    break;
                default:
                    break;
            }
        } while (opcion != 3);
    }

    public static void ordenarPizza(Scanner in) {
        for (int j = 0; j < 3; j++) {
            int tam = 0;
            int esp = 0;
            int cuantas = 0;

            do {
                System.out.println("\n★★★ ELIGE TAMAÑO DE PIZZA " + (j + 1) + " ★★★");
                for (int i = 0; i < tamanio.length; i++) {
                    System.out.println((i + 1) + ". " + tamanio[i]);
                }
                System.out.print("ELIGE UNA OPCION: ");
                tam = in.nextInt();

                if (tam <= 0 || tam > tamanio.length) {
                    System.out.println("OPCION INVALIDA");
                } else {
                    orden[j][0] = tam;
                }
            } while (tam <= 0 || tam > tamanio.length);

            do {
                System.out.println("\n★★★ ELIGE ESPECIALIDAD DE LA PIZZA " + (j + 1) + " ★★★");
                for (int i = 0; i < especialidades.length; i++) {
                    System.out.println((i + 1) + ". " + especialidades[i]);
                }
                System.out.print("ELIGE UNA OPCION: ");
                esp = in.nextInt();

                if (esp <= 0 || esp > especialidades.length) {
                    System.out.println("OPCION INVALIDA");
                } else {
                    orden[j][1] = esp;
                }
            } while (esp <= 0 || esp > especialidades.length);

            do {
                System.out.println("\n★★★ ¿CUÁNTAS DE LA PIZZA " + (j + 1) + "? (1 a 3) ★★★");
                cuantas = in.nextInt();

                if (cuantas <= 0 || cuantas > 3) {
                    System.out.println("VALOR INVALIDO");
                } else {
                    orden[j][2] = cuantas;
                }
            } while (cuantas <= 0 || cuantas > 3);

            
            agregarComplementos(in);
        }
    }

    public static void agregarComplementos(Scanner in) {
        System.out.println("\n★★★ ELIGE COMPLEMENTOS ★★★");
        int complemento;

        do {
            for (int i = 0; i < complementos.length; i++) {
                System.out.println((i + 1) + ". " + complementos[i]);
            }
            System.out.print("ELIGE UN COMPLEMENTO: ");
            complemento = in.nextInt();

            if (complemento != 2) {
                if (complemento <= 0 || complemento > complementos.length) {
                    System.out.println("OPCION INVALIDA");
                } else {
                    complementosSeleccionados[complemento - 1]++;
                }
            }
        } while (complemento != 0);
        
    }

    public static void imprimirOrden() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nDatos:");
               String nom,dir,num;
                System.out.println("¿A QUE NOMBRE VA ESTAR? ");
                nom=teclado.next();
                System.out.println("¿Direccion? ");
                dir=teclado.next();
                System.out.println("¿numero telefonico? ");
                num=teclado.next();
        System.out.println("★★★★★★★★★ ORDEN ★★★★★★★★★\n");
        int total = 0;
        
        for (int i = 0; i < orden.length; i++) {
            if (orden[i][0] != 0 && orden[i][1] != 0) {
                System.out.println(orden[i][2] + " PIZZAS " + tamanio[orden[i][0] - 1] + " DE " + especialidades[orden[i][1] - 1] + "\t $" + (precioPizza[orden[i][0] - 1] * orden[i][2]));
                total += (precioPizza[orden[i][0] - 1] * orden[i][2]);
            }
        }

        System.out.println("\nCOMPLEMENTOS:");
        for (int i = 0; i < complementos.length; i++) {
            if (complementosSeleccionados[i] > 0) {
                System.out.println(complementosSeleccionados[i] + " " + complementos[i] + "\t $" + (precioComplementos[i] * complementosSeleccionados[i]));
                total += (precioComplementos[i] * complementosSeleccionados[i]);
            }
        }
        
        System.out.println("\n TOTAL A PAGAR: $" + total);
        System.out.print("\n A NOMBRE DE:"+nom+"\n Dirrecion de la entrega:"+dir+"\n Num.Telefonico:"+num);
        System.out.println("\n ★★★★★★★★★ FIN ORDEN ★★★★★★★★★\n");
    }
}