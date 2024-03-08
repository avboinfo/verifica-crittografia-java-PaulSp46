import java.util.Scanner;

public class Utility {

    public static int scegli(String[] m, Scanner keyInput){
        int scelta = 0;
        //if (m.length == 0) throw new Exception("Errore, vettore di scelte vuoto!");
        
        System.out.println("Menu: ");
        for (int i = 0; i < m.length; i++) {
            System.out.println("[" + (i+1) + "] " + m[i]);
        }
        do{
            System.out.print("Inserisci un numero (1-" + m.length + "): ");
            scelta = keyInput.nextInt();
            keyInput.nextLine();
        }while(scelta <=0 || scelta > m.length);

        return scelta;
    }
}