
package atm.states;

import atm.model.CajeroImpl;

/**
 *
 * @author Rachel
 */
public class Balance extends State{
    
    public Balance(CajeroImpl atm){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
