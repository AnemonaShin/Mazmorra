import java.util.ArrayList;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner Read = new Scanner(System.in);
    System.out.println("¡Bienvenido!");
    System.out.println("Este 'JUEGO' se encuentra actualmente en estado 'ALFA'");
    System.out.print("Porfavor... Ingrese su nombre. > ");
    String Nombre = Read.next();
    Jugabilidad.Jugador(Nombre);

    


    int[] Espacio = new int[4];
    boolean Control = true;
    int M = 0;
    int N = 0;
    String Respuesta = "";
    for (int x = 0;x<=3;x++){
      Espacio[x] = x;
    }
    try {
      while (Control == true){
      System.out.println("Piso : "+Espacio[M]);
      System.out.println("¿Avanzas?");
      Respuesta = Read.nextLine();
      switch(Respuesta){
        case "Si":
        if (M < 3){
          System.out.println("Avanzas");
          Jugabilidad.AciertoBatalla();
          M++;
        } else if(M == 3) {
          System.out.println("Ya no hay camino que recorrer.");
          System.out.println("¿Quieres devolverte?");
          Respuesta = Read.nextLine();
          if (Respuesta.equals("Si")){
            M = 0;
          } else if(Respuesta.equals("No")) {
            System.out.println("Como desees...");
            Control = false;
          } else {
            System.out.println("¿Aun no te decides?");
          }
        }
        break;
        case "No":
        System.out.println("Como desees...");
        Control = false;
        break;
        default:
          System.out.println("¿Aun no te decides?");
        break;
        }
      }
    } catch(Exception e){

    }
  }
}