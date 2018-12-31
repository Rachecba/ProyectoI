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
public class Withdraw extends State{
    
    public Withdraw(CajeroImpl atm){
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
    public String message() {
        //menu cuanto dinero quiere retirar
        return "\nWithdrawal Menu: \n1 - $20 \n 2 - $40 \n 3 - $60 \n 4 - $100 \n 5 - $200 \n 6 - Cancel transaction \nChoose a withdrawal amount: ";
    }

    @Override
    public int input() {
        return 0;
    }

    @Override
    public String balanceTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String withdrawalTransaction() {
        //switch segun la cantidad de dinero a retirar
        //la logica se hace en el CajeroImpl
        if(this.atm.retiro(0)){
            //
            return "Transaccion exitosa";//por poner algo
        }else{
            return "Transaccion invalida";
        }
        //int cantidad;
    }

    @Override
    public String depositTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String exit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
