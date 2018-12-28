/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.view.cmd;

import java.util.Scanner;

/**
 *
 * @author Rachel
 */
public class Keypad implements atm.view.Keypad{
    
    private Scanner input; // reads data from the command line
                         
   // no-argument constructor initializes the Scanner
   public Keypad()
   {
      input = new Scanner( System.in );    
   } // end no-argument Keypad constructor


    @Override
    public int getInput() {
        return input.nextInt();
    }
    
}
