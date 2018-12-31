/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.states;

import atm.model.CajeroImpl;
import java.util.Scanner;

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
        return "Not available";
    }

    @Override
    public String performTransaction(int num) {
        
        switch(num){
            case CajeroImpl.BALANCE_INQUIRY:
                atm.changeState(new Balance(atm));
                return "\n Changing to Balance State";
            case CajeroImpl.WITHDRAWAL:
                atm.changeState(new Withdraw(atm));
                return "\n Changing to Withdrawal State";
            case CajeroImpl.DEPOSIT:
                atm.changeState(new Deposit(atm));
                return "\n Changing to Deposit State";
            case CajeroImpl.EXIT:
                atm.changeState(new Exit(atm));
                return "\n Changing to Exit State";
            default:
                return "\\nYou did not enter a valid selection. Try again.";
                
        } 
    }
    

    @Override
    public String message() {
         return "\nMain menu:" + 
                "\n 1 - View my balance" + 
                "\n 2 - Withdraw cash" + 
                "\n 3 - Deposit funds" + 
                "\n 4 - Exit" + 
                "\nEnter a choice: ";
    }

    @Override
    public int menuOpt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    @Override
    public String balanceTransaction() {
        return "Not available";
    }

    @Override
    public String withdrawalTransaction() {
        return "Not available";
    }

    @Override
    public String depositTransaction() {
        return "Not available";
    }

    @Override
    public String exit() {
        return "Not available";
    }
        
    
    
}
