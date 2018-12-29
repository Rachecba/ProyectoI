
package atm.view.cmd;

import java.util.Scanner;

/**
 *
 * @author Rachel
 */
public class Keypad implements atm.view.Keypad{
    
    private Scanner input; 
                         
   public Keypad()
   {
      input = new Scanner( System.in );    
   } 


    @Override
    public int getInput() {
        return input.nextInt();
    }
    
}
