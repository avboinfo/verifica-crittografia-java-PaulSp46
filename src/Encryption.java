public class Encryption {
    public static String crypt(String data) {
        int c = 0;
        String key = "KHgyJgpOKLòj";
        StringBuilder cesarOut = new StringBuilder();
        char[] charList = data.toCharArray();

        for(int i=0; i<charList.length; i++){
            cesarOut.append((char)(charList[i]+10));
        }

        data = cesarOut.toString();
        
        StringBuilder xorOut = new StringBuilder(data.length());
        for (char singleChar : data.toCharArray()){
            char keyChar = key.charAt(c%key.length());
            int result = (int)singleChar^(int)keyChar;
            xorOut.append((char)result);
        }
        return xorOut.toString();
    }

    public static String decrypt(String data) {
        int c = 0;
        String key = "KHgyJgpOKLòj";
        StringBuilder cesarOut = new StringBuilder();

        StringBuilder xorOut = new StringBuilder(data.length());
        for (char singleChar : data.toCharArray()){
            char keyChar = key.charAt(c%key.length());
            int result = (int)singleChar^(int)keyChar;
            xorOut.append((char)result);
        }

        data = xorOut.toString();
        char[] charList = data.toCharArray();

        for(int i=0; i<charList.length; i++){
            cesarOut.append((char)(charList[i]-10));
        }       
        
        return cesarOut.toString();
    }
}