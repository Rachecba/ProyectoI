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
public class Account extends State{
    
    public Account(CajeroImpl atm){
        super(atm);
    }

    @Override
    public String botones(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void execute(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
