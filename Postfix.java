
/**
 * Write a description of class postfix here.
 * 
 * @author (Robert Parson) 
 * @version (2/25/2016)
 */
import java.util.*;
import java.io.*;

/**
 *
 * @author Robert
 */
public class Postfix
{
    private static final char ADD = '+', SUBTRACT = '-';
    private static final char MULTIPLY = '*', DIVIDE = '/';
    
    public static void main(String args[])
    {
       //System.out.println("Enter a Postfix Expression:  ");
       Scanner input = new Scanner(System.in);
       String line = input.nextLine();
            
       Stack stack = new Stack();
       
        while(!(line.isEmpty()))
        {
            int countDoubles = 0;
            int countOperators = 0;
            Scanner lineScanner = new Scanner(line);
            
            while(lineScanner.hasNext())
            {
                double answer = 0;
                
                if (lineScanner.hasNextDouble())
                {
                    double d = lineScanner.nextDouble();
                    stack.push(d);
                    countDoubles++;
                }
                else
                {
                    String operator = lineScanner.next();
                    StringTokenizer tokenizer = new StringTokenizer(operator);
                    String token = tokenizer.nextToken();
                    
                    if(isOperator(token))
                    {
                        double operand1 = ((Double)stack.pop());
                        double operand2 = ((Double)stack.pop());
                        answer = Solve(token.charAt(0), operand1, operand2);
                        stack.push(new Double(answer));
                        countOperators++;
                    }
                    else
                    {
                        System.out.println("Expression is invalid.");
                    }
                    
                }
                
            } 
            if(countOperators == countDoubles - 1)
            {
                System.out.println(stack.peek()); 
            }
            else
            {
                System.out.println("Expression is invalid");
            }
            System.out.println("\n");
            line = input.nextLine();
            
       }
       System.exit(0);
    }
   
    public static boolean isOperator(String token)
    {
        return(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
    
    public static double Solve(char operation, double operand1, double operand2)
    {
        double answer = 0;
        switch(operation)
        {
            case ADD:
                answer = operand1 + operand2;
                break;
            case SUBTRACT:
                answer = operand2 - operand1;
                break;
            case MULTIPLY:
                answer = operand1 * operand2;
                break;
            case DIVIDE:
                answer = operand2 / operand1;
                break;
        }
        return answer;
    }
    
}
