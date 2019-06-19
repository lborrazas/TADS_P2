package obligatorio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu{

    public Menu() {
    }

    public void run() {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;//Guardaremos la opcion del usuario
        int opcion2;
        int opcion3;

        while (!salir) {

            System.out.println("0. Carga de datos");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");

            try {

                System.out.println("Escribe la opcion deseada: ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 0:
                        System.out.println("Carga de datos...");
                        CargaDeDatos cdd = new CargaDeDatos();
                        System.out.println("Carga terminada!");
                        break;
                    case 1:
                        System.out.println(" Top 10 de atletas que consiguieron la mayor cantidad de medallas en la historia de los juegos. Estos atletas podrían haber participado en múltiples ediciones de los juegos. ");
                        System.out.println("Datos esperados del resultado: nombre atleta, sexo atleta, cantidad de medallas, año min, año max.");
                        System.out.println("Ingrese 0 en caso de considerar todas las medallas");
                        System.out.println("Ingrese 1 en caso de considerar las medallas de oro");
                        System.out.println("Ingrese 2 en caso de considerar las medallas de plata");
                        System.out.println("Ingrese 3 en caso de considerar las medallas de bronce");
                        opcion2 = sn.nextInt();
                        switch (opcion2){
                            case 0:
                                System.out.println("Consideramos todas las medallas");
                                break;
                            case 1:
                                System.out.println("Consideramos las de oro");
                                break;
                            case 2:
                                System.out.println("Consideramos las de plata");
                                break;
                            case 3:
                                System.out.println("Consideramos las de bronce");
                                break;
                            default:
                                System.out.println("Error, ingrese una de las opciones");
                        }
                        break;
                    case 2:
                        System.out.println("Top 10 de regiones que consiguieron la mayor cantidad de medallas en la historia de los juegos. ");
                        System.out.println("Datos esperados del resultado: nombre de la región, cantidad de medallas.");
                        System.out.println("Ingrese 0 en caso de considerar todas las medallas");
                        System.out.println("Ingrese 1 en caso de considerar las medallas de oro");
                        System.out.println("Ingrese 2 en caso de considerar las medallas de plata");
                        System.out.println("Ingrese 3 en caso de considerar las medallas de bronce");
                        opcion3 = sn.nextInt();
                        switch (opcion3){
                            case 0:
                                System.out.println("Consideramos todas las medallas");
                                break;
                            case 1:
                                System.out.println("Consideramos las de oro");
                                break;
                            case 2:
                                System.out.println("Consideramos las de plata");
                                break;
                            case 3:
                                System.out.println("Consideramos las de bronce");
                                break;
                            default:
                                System.out.println("Error, ingrese una de las opciones");
                        }
                        break;
                    case 3:
                        System.out.println("top 10 de ediciones de los juegos olímpicos donde se tuvo mayor participación de\n" +
                                "atletas femeninos.");
                        System.out.println("Datos esperados del resultado: nombre edición, año, cantidad de atletas.");
                        break;
                    case 4:
                        System.out.println(" 5 competiciones donde se presentan la mayor cantidad de atletas de cierto sexo.");
                        System.out.println("Elija el sexo a condierar insertantanod 'M' o 'F'");
                        salir = true;
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.next();
            }
        }

    }

}