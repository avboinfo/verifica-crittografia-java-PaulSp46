import java.util.*;

class Main{
    public static void main(String[] args) {
        final String[] menu = {"Cripta il file", "Decripta il file", "Stampa il file (solo se decriptato)"};
        Scanner keyInput = new Scanner(System.in);
        int choice = Utility.scegli(menu, keyInput);
    }
}