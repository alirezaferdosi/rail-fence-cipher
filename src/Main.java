import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.print("please enter the text : ");
        String s = new Scanner(System.in).nextLine();
        System.out.println(Encrypt(s, 3));
        System.out.println(encryptRailFence(s, 3));

    }

    public static String Encrypt(String str, int key) {
        if (key == 1) return str;
        else {
            char[] ch = str.toCharArray();
            String code = "";

            int orginalkey = key;
            int KEY = key * 2 - 2;

            for (int i = 0; i < key; i++) {
                int j = i;

                if (i != key - 1) {
                    while (j < ch.length) {
                        code += Character.toString(ch[j]);
                        j += KEY;
                    }

                } else {
                    int k = key - 1;
                    while (k < ch.length) {
                        code += Character.toString(ch[k]);
                        k += orginalkey + 1;
                    }
                }
                KEY -= 2;
            }
            return code;
        }
    }

    public static String encryptRailFence(String text, int key) {

        // create the matrix to cipher plain text
        // key = rows , length(text) = columns
        char[][] rail = new char[key][text.length()];

        // filling the rail matrix to distinguish filled
        // spaces from blank ones
        for (int i = 0; i < key; i++)
            Arrays.fill(rail[i], '\n');

        boolean dirDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < text.length(); i++) {

            // check the direction of flow
            // reverse the direction if we've just
            // filled the top or bottom rail
            if (row == 0 || row == key - 1)
                dirDown = !dirDown;

            // fill the corresponding alphabet
            rail[row][col++] = text.charAt(i);

            // find the next row using direction flag
            if (dirDown)
                row++;
            else
                row--;
        }

        // now we can construct the cipher using the rail
        // matrix
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < key; i++)
            for (int j = 0; j < text.length(); j++)
                if (rail[i][j] != '\n')
                    result.append(rail[i][j]);

        return result.toString();
    }
//    public static String decrypt(String str, int key) {
//        if (key == 1) {
//            return str;
//        } else {
//            String code = "";
//            int start_index = 0;
//            for(int i=0 ; i<key ; i++){
//                if(i < key-1){
//                    while(){
//
//                    }
//
//                }else{
//                    int j=0;
//                    while(){
//
//                    }
//                }
//
//            }
//            return  code;
//
//        }
//
//    }
}