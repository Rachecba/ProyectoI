/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.model;

import atm.states.State;
import java.util.function.Consumer;

/**
 *
 * @author Rachel
 */
public class CajeroImpl implements Cajero{
    State state;
    Consumer<String> listener;

    @Override
    public void attach(Consumer<String> listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
