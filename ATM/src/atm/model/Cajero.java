/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.model;

import java.util.function.Consumer;

/**
 *
 * @author Rachel
 */
public interface Cajero {
    
    void attach(Consumer<String> listener);
    
    
}
