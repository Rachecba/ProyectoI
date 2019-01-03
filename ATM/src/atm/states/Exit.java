/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.states;

import atm.model.AtmImpl;

/**
 *
 * @author Rachel
 */
public class Exit extends State{
    
    public Exit(AtmImpl context) {
        super(context);
    }
    
    @Override
    public boolean authenticateUser(int account, int pin){
        return false;
    }
    
   
}
