import java.util.Stack;

public class EvaluacionExpresionAritmetica2017 {
    public int evaluar(String exp) {
    // Precondición: La expresión aritmética es correcta.
    // Postcondición: el resultado es el valor de la expresión

        Stack<Integer> operandos= new Stack<Integer>();
        Stack<String> operadores = new Stack<String>();

        for(int i = 0; i< exp.length(); i++){
            int o = exp.charAt(i);
            if(exp.charAt(i) == '(' ){}//No hacemos nada
            else if (exp.charAt(i)  != ')'){
                String s = "" + exp.charAt(i);
                if(Character.isDigit(exp.charAt(i))) operandos.push((int)exp.charAt(i) - (int)'0') ;
                else operadores.push(s);
            }else{
                int op1 = operandos.pop();
                int op2 = operandos.pop();
                if(operadores.peek().equals("+")){
                    operandos.add(op1 + op2);
                }
                else if(operadores.peek().equals("*")) operandos.add(op1 * op2);
                else operandos.add(op1 - op2);
                operadores.pop();
            }

        }
        return operandos.peek();
    }

    public void test(){System.out.println(evaluar("(1+((2+3)*(4*5)))"));}

    public static void main(String[] args) {
        new EvaluacionExpresionAritmetica2017().test();
    }
}
