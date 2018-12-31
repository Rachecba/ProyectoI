/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.states;

import atm.model.CajeroImpl;

/**
 *
 * @author Rachel
 */
public class Menu extends State{
    
    public Menu(CajeroImpl atm){
        super(atm);
    }

    @Override
    public String authenticateUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String performTransaction(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String mainMenu() {
        return "\nMain menu:" + 
                "\n 1 - View my balance" + 
                "\n 2 - Withdraw cash" + 
                "\n 3 - Deposit funds" + 
                "\n 4 - Exit" + 
                "\nEnter a choice: ";
    }
        
    
    
}
