/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.model;

import atm.data.BankDatabase;
import atm.view.Screen;

/**
 *
 * @author Rachel
 */
public class BalanceInquiry extends Transaction{
public BalanceInquiry( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase )
   {
      super( userAccountNumber, atmScreen, atmBankDatabase );
   } // end BalanceInquiry constructor

   // performs the transaction
   
   //***** public void boton1(){execute(boton1);} //segun el boton que va a hacer el ATM
   //**** public void boton2(){}....
   
   
   @Override
   public void execute(/*num boton*/)
   {
      // get references to bank database and screen
      BankDatabase bankDatabase = getBankDatabase();
      Screen screen = getScreen();

      // get the available balance for the account involved
      double availableBalance = 
         bankDatabase.getAvailableBalance( getAccountNumber() );

      // get the total balance for the account involved
      double totalBalance = 
         bankDatabase.getTotalBalance( getAccountNumber() );
      
      // display the balance information on the screen
      screen.displayMessageLine( "\nBalance Information:" );
      screen.displayMessage( " - Available balance: " ); 
      screen.displayDollarAmount( availableBalance );
      screen.displayMessage( "\n - Total balance:     " );
      screen.displayDollarAmount( totalBalance );
      screen.displayMessageLine( "" );
   } // end method execute
    
}
