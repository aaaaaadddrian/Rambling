import java.util.HashMap;
import java.util.Stack;

public class TestingMyCode {

    public static void main(String[] args) {
        System.out.println(isValid("(){}}{"));
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

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.length() == 1){
            return false;
        }

        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')'){
                if(stack.empty()){
                    return false;
                }
                if(stack.pop() != '('){
                    return false;
                }
            }else if(c == '}'){
                if(stack.empty()){
                    return false;
                }
                if(stack.pop() != '{'){
                    return false;
                }
            }else if(c == ']'){
                if(stack.empty()){
                    return false;
                }
                if(stack.pop() != '['){
                    return false;
                }
            }else{
                return true;
            }
        }
        return false;
    }
}
