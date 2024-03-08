import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) {
        boolean loop = true;
        final String[] menu = {"Cripta il file", "Decripta il file", "Stampa il file (solo se decriptato)", "Esci"};
        Scanner keyInput = new Scanner(System.in);
        int choice;
        File f = new File("static/data.txt");
        StringBuilder str = new StringBuilder();
        String criptedMessage = "";
        String decriptedMessage = "";

        
        while (loop) {

            choice = Utility.scegli(menu, keyInput);

            switch(choice){
                default:
                    System.out.println("scelta non contemplata");
                case 1:
                    try {
                        Scanner fileInput = new Scanner(f);
                        while (fileInput.hasNextLine()) {
                            String s = fileInput.nextLine();
                            str.append(s+"\n");
                        }
                        fileInput.close();

                        criptedMessage = str.toString();
                        criptedMessage = Encryption.crypt(criptedMessage);
                        FileWriter fileOut = new FileWriter(f);
                        fileOut.write(criptedMessage);
                        fileOut.close();
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        Scanner fileInput = new Scanner(f);

                        if (criptedMessage != "") {
                            FileWriter fileOut = new FileWriter(f);
                            fileOut.write(Encryption.decrypt(criptedMessage));
                            fileOut.close();
                        } else{
                            
                            while (fileInput.hasNextLine()) {
                                String s = fileInput.nextLine();
                                str.append(s);
                            }
                            fileInput.close();

                            decriptedMessage = str.toString();
                            decriptedMessage = Encryption.decrypt(decriptedMessage);
                            FileWriter fileOut = new FileWriter(f);
                            fileOut.write(decriptedMessage);
                            fileOut.close();
                        }
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Scanner fileInput = new Scanner(f);
                        while (fileInput.hasNextLine()) {
                            String s = fileInput.nextLine();
                            str.append(s+"\n");
                        }
                        System.out.println(str.toString());
                        fileInput.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    loop = false;
                    break;
            }   
        }
    }
}