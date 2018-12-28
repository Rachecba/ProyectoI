/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.view.cmd;

/**
 *
 * @author Rachel
 */
public class Screen implements atm.view.Screen{

    @Override
    public void displayDollarAmount(double amount) {
        System.out.printf( "$%,.2f", amount );   
    }

    @Override
    public void displayMessage(String message) {
        System.out.println( message );
    }

    @Override
    public void displayMessageLine(String message) {
        System.out.println( message );
    }
    
    
    
}
