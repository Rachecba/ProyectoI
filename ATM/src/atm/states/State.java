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
    
    public abstract String authenticateUser(); //login
    public abstract String performTransaction(int num); //aqui envia al programa al estado correspondiente.
    public abstract String message(); //para los mensajes de cada estado que deben salir en pantalla
    public abstract int input();
    public abstract String balanceTransaction(); //ejecuta metodo de ver balance de cuenta
    public abstract String withdrawalTransaction(); // ejecuta metodo de sacar dinero
    public abstract String depositTransaction(); // ejecuta metodo de deposito de dinero
    public abstract String exit();
    
}
