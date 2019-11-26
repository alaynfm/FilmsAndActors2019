package parenthesesBalance;

import java.util.Stack;

public class ParentheseBalance {


    private void sequenceCorrect(String sequence){

        boolean expresionC=true;
        Stack<Character>abrir = new Stack<Character>();
        for(int a = 0; a<sequence.length();a++){
            char i = sequence.charAt(a);
            if(i == '(' || i== '[' || i=='{') abrir.push(i);
            else if(i == ')' || i== ']' || i =='}') {
                if (!abrir.isEmpty()) {
                     if(i == ')' & abrir.peek()=='(')abrir.pop();
                     else if(i == ']' & abrir.peek()=='[')abrir.pop();
                     else if(i == '}' & abrir.peek()=='{')abrir.pop();
                     else break;
                } else break;
            }
        }
        if(abrir.isEmpty()) System.out.println("Yes");
        else System.out.println("No");
    }

    private void test() {

        sequenceCorrect("(((([[[[]]]])))"); //False;
        sequenceCorrect("(((([[[[{}]]]]))))"); //true;
        sequenceCorrect("(//[[[{{{{}}}}]]]//)"); //true;





    }
    public static void main(String[] args) {new ParentheseBalance().test(); }
}
