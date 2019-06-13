package Stack;

import java.util.Stack;
public class solution {
   public static boolean solution(String s){
     Stack<Character> strs = new Stack<>();
       for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(c=='{'||c=='['||c=='(')
                strs.push(c);
            else{
                if(strs.isEmpty())
                    return false;
                char topchar = strs.pop();
                if(topchar=='('&& c!=')')
                    return false;
                if(topchar=='['&& c!=']')
                    return false;
                if(topchar=='{'&& c!='}')
                    return false;
            }
       }
       return strs.isEmpty();
   }

   public static void main(String[] args){
       System.out.println(solution("[][]"));
   }
}
