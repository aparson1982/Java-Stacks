
/**
 * Write a description of class Balanced here.
 * 
 * @author (Robert Parson) 
 * @version (2/25/2016)
 */
import java.util.*;


public class Balanced
{
    private static final String OPENDEL = "([{";
    private static final String CLOSEDEL = ")]}";
    
   public static boolean Balance(String line)
   {
       Stack<Character> delStack = new Stack<>();
       boolean isBalanced = true;
       
       try
       {
           if(isBalanced)
           {
               for(int i = 0; i<line.length(); i++)
               {
                   char c = line.charAt(i);
                   
                   if(isOpen(c))
                   {
                       delStack.push(c);
                   }
                   
                   else if(isClosed(c))
                   {
                       char topChar = delStack.pop();
                       isBalanced = OPENDEL.indexOf(topChar) == CLOSEDEL.indexOf(c);
                   }
               }
           }
       }
       catch(EmptyStackException ex)
       {
           isBalanced = false;
       }
          
       return (isBalanced && delStack.empty());
   }
   
   private static boolean isOpen(char c)
   {
       return OPENDEL.indexOf(c) > -1;
   }
   
   private static boolean isClosed(char c)
   {
       return CLOSEDEL.indexOf(c) > -1;
   }
   
   public static void main(String[] args)
   {
       Scanner input = new Scanner(System.in);
       
       String line = input.nextLine();

       while(!(line.isEmpty()))
       {
         
                if(Balance(line))
                {
                    System.out.println("Balanced");
                }
                else
                {
                    System.out.println("Unbalanced");
                }
                line = input.nextLine();
        }    
       
       System.exit(0);
   }      
       
}