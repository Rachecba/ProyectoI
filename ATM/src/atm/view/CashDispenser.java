package atm.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zunigaur
 */
public interface CashDispenser {

    // simulates dispensing of specified amount of cash
    void dispenseCash(int amount);

    // indicates whether cash dispenser can dispense desired amount
    boolean isSufficientCashAvailable(int amount);
    
}
