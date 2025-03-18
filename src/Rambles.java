import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Rambles{


    public static void main(String[] args) {
        String s = "abaccb";
        int[] distance = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        checkDistances(s, distance);

    }

    public static boolean checkDistances(String s, int[] distance) {
        char[] charList = s.toCharArray();
        for(int i = 0; i < charList.length; i++){
            for(int k = i + 1; k < charList.length; k++){
                if(charList[i] == charList[k]){
                    int num = charList[i] - 'a';
                    if(distance[num] != ((k-i) - 1)){
                        return false;
                    }
                    break;
                }
            }
        }
        return true;

    }


    public TreeNode invertTree(TreeNode root) {
        return method(root);
    }

    public TreeNode method(TreeNode node){
        TreeNode temp;

        if(node == null){
            return node;
        }

        if(node.left == null){
            node.left = node.right;
            node.right = null;
        }

        if(node.right == null){
            node.right = node.left;
            node.left = null;
        }

        if(node.left != null && node.right != null){
            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        if(node.left != null){
            method(node.left);
        }
        if(node.right != null){
            method(node.right);
        }

        return node;
    }

    public static int Hash(String key){
        int hash = 0;
        for(int j = 0; j != key.length(); j++){
            hash = hash ^ key.charAt(j);
            hash = hash * (j%32);
        }
        return hash;
    }

    public static  String decoder(String encode){
        Stack<String> stackStr = new Stack<>();
        Stack<Integer> stackInt = new Stack<>();
        String current = "";
        int count = 0;

        for(char c : encode.toCharArray()){
            if(Character.isDigit(c)){
                count = count * 10 + (c - '0');
            }else if(c == '['){
                stackInt.push(count);
                stackStr.push(current);
                count = 0;
                current = "";
            }else if(c == ']'){
                int k = stackInt.pop();
                String temp = stackStr.pop();
                for(int i = 0; i < k; i++){
                    temp = temp + current;
                }
                current = temp;

            }else{
                current = current + c;
            }
        }
        return current;
    }

    public static int romanToInt(String s){

        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int total = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i = s.length()- 1; i >= 0; i--){
            if(i >= 1 && map.get(arr[i - 1]) < map.get(arr[i])){
                total = total + map.get(arr[i]) - map.get(arr[i - 1]);
                i--;
            }else{
                total = total + map.get(arr[i]);
            }
        }
        return total;
    }

    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();
        String containsDupe = t;
        String other = s;

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i -1)){
                containsDupe = s;
                other = t;
                break;
            }
        }

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            map.put(containsDupe.charAt(i),other.charAt(i));
        }

        if(map.keySet().size() == map.values().size()){
            return true;
        }

        return false;
    }

    public int radixMaxLength(int[] A){
        int maxDigits = 0;
        for(int i = 0; i < A.length; i++){
            int digitCount = radixLength(A[i]);
            if(digitCount > maxDigits){
                maxDigits = digitCount;
            }
        }
        return maxDigits;
    }

    public int radixLength(int num){
        if(num == 0){
            return 1;
        }

        int digits = 0;
        while(num != 0){
            digits++;
            num /= 10;
        }
        return digits;
    }

    public void radixSort(int[] A){
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < 10; i++){
            buckets.add(new ArrayList<Integer>());
        }

        int copyBackIndex = 0;
        int maxDigits = radixMaxLength(A);
        int  pow10 = 1;

        for(int digitIndex = 0; digitIndex < maxDigits; digitIndex++) {
            for (int i = 0; i < A.length; i++) {
                int num = A[i];
                int bucketIndex = (Math.abs(num) / pow10) % 10;
                buckets.get(bucketIndex).add(num);
            }


            for (int i = 0; i < 10; i++) {
                ArrayList<Integer> bucket = buckets.get(i);
                for (int j = 0; j < bucket.size(); j++) {
                    A[copyBackIndex] = bucket.get(j);
                    copyBackIndex++;
                }
                bucket.clear();
            }

            pow10 = pow10 * 10;
        }


        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> nonegatives = new ArrayList<>();
        for(int i : A){
            if(i < 0){
                negative.add(i);
            }else{
                nonegatives.add(i);
            }
        }

        copyBackIndex = 0;
        for(int i = 0; i < 10; i++){

        }



    }

    public static String findIndOfDupe(int[] A){
        for(int i = 0; i < A.length; i++){
            if(A[0] == A[A.length - i - 1]){
                return "(" + 0 + "," + (A.length - i - 1) + ")";
            }
        }
        return "-1";
    }

}
