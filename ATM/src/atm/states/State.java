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
public abstract class State {
    CajeroImpl atm;
    
    State(CajeroImpl atm) {
        this.atm = atm; 
    }
    
    // **** metodos de las clases **** 
    
    public abstract String authenticateUser();
    public abstract String performTransaction(int num);
    public abstract String mainMenu();
}
