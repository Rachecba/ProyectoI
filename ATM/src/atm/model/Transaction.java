
package atm.model;

import atm.data.BankDatabaseImpl;
import atm.view.Screen;

/**
 *
 * @author Rachel
 */
public abstract class Transaction {
     private int accountNumber; 
   private Screen screen; 
   private BankDatabaseImpl bankDatabase; 

   public Transaction( int userAccountNumber, Screen atmScreen, 
      BankDatabaseImpl atmBankDatabase )
   {
      accountNumber = userAccountNumber;
      screen = atmScreen;
      bankDatabase = atmBankDatabase;
   } 

   public int getAccountNumber()
   {
      return accountNumber; 
   } 

   public Screen getScreen()
   {
      return screen;
   } 

   public BankDatabaseImpl getBankDatabase()
   {
      return bankDatabase;
   } 

   abstract public void execute();
}

