import java.util.Stack;

public class Rambles{

    /*
    O(N^2)
    \Omega(1)
     */

    public static void main(String[] args) {

        System.out.println(decoder("3[a2[c]]"));
    }

    public static int Hash(String key){
        int hash = 0;
        for(int j = 0; j != key.length(); j++){
            hash = hash ^ key.charAt(j);
            hash = hash * (j%32);
        }
        return hash;
    }

    public static String decoder(String encodedString){
        Stack<Integer> stackerton = new Stack<>();
        Stack<StringBuilder> stackertonDos = new Stack<>();
        StringBuilder stringerton = new StringBuilder();
        StringBuilder lastly = new StringBuilder();
        int count = 0;

        for(char c : encodedString.toCharArray()){
            if(Character.isDigit(c)){
                count = count * 10 +(c -'0');
            } else if(c == '['){
                stackerton.push(count);
                count = 0;
                stackertonDos.push(stringerton);
                stringerton = new StringBuilder();
            } else if(c == ']'){
                int temp = stackerton.pop();

                for(int i = 0; i < temp; i++){
                    lastly.append(stringerton);
                }
                stringerton = new StringBuilder();
            }else{
                stringerton.append(c);
            }
        }

        return lastly.append(stringerton).toString();
    }

}
