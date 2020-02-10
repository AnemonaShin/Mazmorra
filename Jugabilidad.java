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
  public static void GAMEOVER(){
    Jugabilidad.BorrarPantalla();
    System.out.println(">--------- GAME OVER ---------<");
  }
  public static ArrayList Enemigos(){
    Random R = new Random();
    int MR = 0;
    boolean Enemigos = true;
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
    int ElectionN = 0;
    String ElectionT = "";
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
        System.out.println("--------------["+(ElectionT =   Read.nextLine())+"]--------------");
        if (ElectionT.length()==1){
          ElectionN = Integer.parseInt(ElectionT);
          switch(ElectionN){
            case 1:
              System.out.println("----- ¡Atacas al enemigo! -----");
              System.out.println("---- ¡Le quitas 1 de vida! ----");
              try {
                Thread.sleep(2000);
              }  catch(Exception e){

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
            default:
              System.out.println("-------------------------------");
              System.out.println("----- Opcion Inexistente ------");
              System.out.println("-------------------------------");
              try {
                Thread.sleep(3000);
              } catch(Exception e){

              } 
            break;
            }
          } 
          else {
            System.out.println("-------------------------------");
            System.out.println("------ Un numero a la vez -----");
            System.out.println("-------------------------------");
            try {
                Thread.sleep(3000);
              } catch(Exception e){

              } 
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
      }
    }
  }

  public static boolean RatioDeEncuentroBatalla(){
    boolean Acierto = true;
    boolean Verify = true;
    Random R = new Random();
    int RR = 0;
    while (Verify == true){
      RR = R.nextInt(15);
      if (RR < 5){ // Acierta Batalla
        Acierto = true;
        Verify = false;
      }
      else if(RR > 5){ // Evade Batalla
        Acierto = false;
        Verify = false;
      }
    }
    return Acierto;
  }

  public static void AciertoBatalla(){
    boolean Acierto = Jugabilidad.RatioDeEncuentroBatalla();
    if (Acierto == true){
      System.out.println("----- ¡Batalla Inminente! -----");
      Jugabilidad.Batalla();
    } else if(Acierto == false){

    }
  }
  
  public static ArrayList Jugador(String Nombre){
    Scanner Read = new Scanner(System.in);
    ArrayList DatosJ = new ArrayList();
    ArrayList Stats = new ArrayList();
    DatosJ.add(Nombre);
    String Job = "";
    int STR = 0;
    int VIT = 0;
    int LUCK = 0;
    System.out.println("Bienvenido "+Nombre+"...");
    System.out.println("Te encuentras encerrado en una habitacion sin salida.");
    System.out.println("Solo tienes un par de cosas a tu alrededor...");
    try {
      Thread.sleep(2000);
      System.out.println("");
      System.out.print("[(1)]Un Zapato,");
      System.out.print(" [(2)]Un Guante,");
      System.out.print(" [(3)]Un Libro");
      System.out.print(" y [(4)]Una Piedra");
    } catch(Exception e){

    }
    System.out.println("");
    System.out.println("Debes elegir uno...");
    System.out.println("");
    System.out.print("¿Cual eliges? > ");
    try {
      int Op = Read.nextInt();
      switch (Op){
      case 1: //Runner
        Job = "Runner";
        System.out.println("Recoges el Zapato");
        DatosJ.add(Job);
      break;
      case 2: //Fighter
        Job = "Fighter";
        System.out.println("Recoges el Guante");
        DatosJ.add(Job);
      break;
      case 3: //Mage
        Job = "Mage";
        System.out.println("Recoges el Libro");
        DatosJ.add(Job);
      break;
      case 4: //Druid
        Job = "Druid";
        System.out.println("Recoges la Piedra");
        DatosJ.add(Job);
      break;
      default: //Nonsense
        Job = "Nonsense";
        System.out.println("Preparate para la nada...");
        DatosJ.add(Job);
      break;
      }
      
      switch(Job){
        case "Runner":
        System.out.println("Has elegido un camino lleno de escapes...");
        STR = 1;
        VIT = 3;
        LUCK = 5;
        // Inicio calculo de estadisticas principales.
        Stats = Jugabilidad.Estadisticas(STR, VIT, LUCK);
        System.out.println("Tus estadisticas son...");
        System.out.println("");
        System.out.print("Vida : "+Stats.get(0));
        System.out.print(" Fuerza : "+Stats.get(1));
        System.out.print(" Suerte : "+Stats.get(2));
        System.out.println("");
        System.out.print("¿Deseas informacion sobre tus estadisticas? > ");
        String OP = Read.next();
        if (OP.equals("Si")||OP.equals("si")||OP.equals("sI")||OP.equals("SI")){
          Jugabilidad.DSTATS();
        } else if(OP.equals("No")||OP.equals("no")||OP.equals("nO")||OP.equals("NO")){
          System.out.println("Muy bien... prosigamos.");
        } else {
          System.out.println("");
        }
        break;
      }

    } catch(Exception E){ // Cualquier error implica GAME OVER
      System.out.println("Aveces... los seres humanos requieren tiempo para que sus decisiones sean correctas...");
      Jugabilidad.GAMEOVER();
    }
    
    return DatosJ;
  }

  public static ArrayList Estadisticas(int STR,int VIT,int LUCK){
    ArrayList Stats = new ArrayList();
    int Vida = 10+(10/VIT+(VIT));
    int Fuerza = 1+STR;
    int Suerte = (LUCK*10)/5;
    Stats.add(Vida); //Vida
    Stats.add(Fuerza); //Fuerza
    Stats.add(Suerte); //Suerte
    return Stats;
  }

  public static void DSTATS(){
    System.out.println("");
    System.out.println("Muy bien...");
    // Fuerza
    System.out.println("Fuerza");
    System.out.println("La fuerza te ayudara a destruir a tus enemigos.");
    System.out.println("Realizar ciertas acciones y a su ves sortear obstaculos que requieran fuerza...");
    System.out.println("");
    // Vida 
    System.out.println("Vida");
    System.out.println("Basicamente esto es tu vida.");
    System.out.println("Determina la cantidad de golpes que puedes resistir antes de morir.");
    System.out.println("");
    // Suerte
    System.out.println("Suerte");
    System.out.println("Esta es la estadistica más importante para el juego.");
    System.out.println("(Almenos en esta ALFA)");
    System.out.println("Determina la probabilidad de acertar y a su ves,la probabilidad de escapar de una batalla.");
    System.out.println("Basicamente lo mas crucial.");
    System.out.println("");
    System.out.println("Esto es todo lo que debes saber...");
  }
}