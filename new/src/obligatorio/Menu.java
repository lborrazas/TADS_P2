package obligatorio;

import obligatorio.entities.enumerados.MedalType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu{

    public static void main (String args[]) throws Exception {
        Menu menu = new Menu();
        menu.run();
    }

    public void run() throws Exception{

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;//Guardaremos la opcion del usuario
        int opcion2;
        int opcion3;
        CargaDeDatos cdd = new CargaDeDatos();
        Consultas consultas = null;

        while (!salir) {

            System.out.println("0. Carga de datos");
            System.out.println("1. Top 10 de atletas que consiguieron la mayor cantidad de medallas en la historia de los juegos. Estos atletas podrían haber participado en múltiples ediciones de los juegos. ");
            System.out.println("2. Top 10 de regiones que consiguieron la mayor cantidad de medallas en la historia de los juegos.");
            System.out.println("3. top 10 de ediciones de los juegos olímpicos donde se tuvo mayor participación de atletas femeninos.");
            System.out.println("4.  5 competiciones donde se presentan la mayor cantidad de atletas de cierto sexo.");
            System.out.println("5.Indicar los 5 equipos mas efectivos entre un rango de años (especificadas al ejecutar el reporte).");
            System.out.println("6. Salir");

            try {

                System.out.println("Escribe la opcion deseada: ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 0:
                        System.out.println("Carga de datos...");

                        cdd.main();
                        consultas = new Consultas(cdd);
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
                        switch (opcion2) {
                            case 0:
                                System.out.println("Consideramos todas las medallas");
                                 // Athlete []  top10 = consultas.consulta1();
                                consultas.consulta1(MedalType.Na);
//                                for (int i = 0; i <top10.length; i++){
//                                    System.out.println(top10[i]);
//                                }
                                break;
                            case 1:
                                System.out.println("Consideramos las de oro");
                                consultas.consulta1(MedalType.Gold);
                                break;
                            case 2:
                                System.out.println("Consideramos las de plata");
                                consultas.consulta1(MedalType.Silver);
                                break;
                            case 3:
                                System.out.println("Consideramos las de bronce");
                                consultas.consulta1(MedalType.Bronze);
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
                        switch (opcion3) {
                            case 0:
                                System.out.println("Consideramos todas las medallas");
                                consultas.consulta2(MedalType.Na);
                                break;
                            case 1:
                                System.out.println("Consideramos las de oro");
                                consultas.consulta2(MedalType.Gold);
                                break;
                            case 2:
                                System.out.println("Consideramos las de plata");
                                consultas.consulta2(MedalType.Silver);
                                break;
                            case 3:
                                System.out.println("Consideramos las de bronce");
                                consultas.consulta2(MedalType.Bronze);
                                break;
                            default:
                                System.out.println("Error, ingrese una de las opciones");
                        }
                        break;
                    case 3:
                        System.out.println("top 10 de ediciones de los juegos olímpicos donde se tuvo mayor participación de atletas femeninos.");
                        System.out.println("Datos esperados del resultado: nombre edición, año, cantidad de atletas.");
                        break;
                    case 4:
                        System.out.println(" 5 competiciones donde se presentan la mayor cantidad de atletas de cierto sexo.");
                        System.out.println("Elija el sexo a condierar insertantano 1 si Femenino o 2 si Masculino");
                        int sexo = 0;
                        //sexo = sn.nextInt();
                        boolean salida = false;
                        while (!salida){
                        System.out.println("Ingrese 1 o 2 unicamente");
                        sexo = sn.nextInt();

                        if (sexo == 1) {
                              salida =true;
                            System.out.println("consulta de femenino");
                            } else {
                            salida = true;
                            System.out.println("consulta de masculino");
                    }
                    }
                        break;
                    case 5:
                        System.out.println("Indicar los 5 equipos mas efectivos entre un rango de años (especificadas al ejecutar el reporte).");
                        System.out.println("Con efectividad se refiere aquellos donde la relación entre competidores y medallas obtenidas obtiene los valores mas altos.");
                        System.out.println("Datos esperados del resultado: Nombre del equipo, cantidad de competidores, medallas obtenidas.");
                        break;
                    case 6:
                        System.out.println("Gracias por venir, vuelva pronto!");
                        salir = true;
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