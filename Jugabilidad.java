import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Jugabilidad{
  public static void BorrarPantalla(){
    String Borrar = "--->---->------->----->------->";
    for (int Cont = 0;Cont <= 20;Cont++){
      System.out.println(Borrar);
      try {
        Thread.sleep(50);
      } catch (Exception e){

      }
    }
  }
  public static ArrayList Enemigos(){
    Random R = new Random();
    int MR = 0;
    boolean Enemigos = true;
    String Nombre = "";
    ArrayList Datos = new ArrayList();
    //------------------------------------------
    ArrayList E1 = new ArrayList(); // Enemigo 1
    E1.add("Luna"); //Nombre
    E1.add(5); //Vida
    //------------------------------------------
    ArrayList E2 = new ArrayList(); // Enemigo 2
    E2.add("Sol"); //Nombre
    E2.add(5); //Vida
    //------------------------------------------
    ArrayList E3 = new ArrayList(); // Enemigo 3
    E3.add("Palta"); //Nombre 
    E3.add(5); //Vida
    //------------------------------------------
    while (Enemigos == true){ // Apoyo ante errores.
    MR = R.nextInt(4);
      switch(MR){ // Variable aleatoria que devuelve un enemigo.
        case 1: // Enemigo 1
          Enemigos = false;
          for (int D = 0; D <= 1; D++){
            Datos.add(D, E1.get(D));
          }
        break;
        case 2: // Enemigo 2
          Enemigos = false;
          for (int D = 0; D <= 1; D++){
            Datos.add(D, E2.get(D));
          }
        break;
        case 3: // Enemigo 3
          Enemigos = false;
          for (int D = 0; D <= 1; D++){
            Datos.add(D, E3.get(D));
          }
        break;
      }
    }
    return Datos;
  }
  
  public static void Batalla(){
    Scanner Read = new Scanner(System.in); 
    ArrayList Datos = Jugabilidad.Enemigos(); // Resibe datos de la Enemigos y los aloja en un ArrayList.
    int Election = 0;
    boolean Battle = true;
    boolean Verify = false;
    int Life = 0;
    while (Battle == true) {
    Jugabilidad.BorrarPantalla();
    System.out.println("-------------------------------");
    System.out.println("¡"+Datos.get(0)+" Enemigo Salvaje Aparece!");
    System.out.println("-------------------------------");
    System.out.println("----------Vida - ("+Datos.get(1)+")-----------");
    Life = (int) Datos.get(1);
    System.out.println("-------------------------------");
    System.out.println("---------¿Que hacer?-----------");
    System.out.println("-------------------------------");
    System.out.println("- ([1]Ataque) --- ([2]Accion) -");
    System.out.println("- ([3]Objeto) --- ([4]Escape) -");
    System.out.println("-------------------------------");
    
      try {
        System.out.print("-------------------------- > [");
        System.out.println("--------------["+(Election =   Read.nextInt())+"]--------------");
        switch(Election){
          case 1:
          System.out.println("----- ¡Atacas al enemigo! -----");
          System.out.println("---- ¡Le quitas 1 de vida! ----");
          try {
            Thread.sleep(2000);
          } catch(Exception e){

          }
          Life = Life - 1;
          Datos.set(1, Life);
          if (Life == 0){
            System.out.println("----- ¡Enemigo Derrotado! -----");
            Battle = false;
          }
          break;
          case 2: // Para futuras practicas.
          System.out.println("¡Aun no implementado!");
          try {
            Thread.sleep(3000);
          } catch(Exception e){

          }
          break;
          case 3: // Necesario aprender como crear inventario. (Plan hacer otra funcion)
          System.out.println("¡Aun no implementado!");
          try {
            Thread.sleep(3000);
          } catch(Exception e){

          } 
          break;
          case 4:
          System.out.println("-------------------------------");
          System.out.println("----- ¡Corres por tu vida! ----");
          System.out.println("-------------------------------");
          try {
            Thread.sleep(3000);
          } catch(Exception e){

          }
          Battle = false;
          break;
        }
      } 
      catch(Exception e){
        try {
          Thread.sleep(2000);
        } catch (Exception A){

        }
        System.out.println("-------------------------------");
        System.out.println("------ ¡No ingrese texto! -----");
        System.out.println("-------------------------------");
        Jugabilidad.BorrarPantalla();
        Read.nextLine();
      }
    }
  }
}