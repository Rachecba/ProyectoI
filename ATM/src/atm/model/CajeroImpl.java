/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.model;

import atm.data.BankDatabase;
import atm.states.State;
import atm.view.Keypad;
import atm.view.Screen;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 *
 * @author Rachel
 */
public class CajeroImpl implements Cajero{
    State state;
    Consumer<String> listener;
    
    private boolean userAuthenticated; // whether user is authenticated
   private int currentAccountNumber; // current user's account number
   private Screen screen; // ATM's screen
   private Keypad keypad; // ATM's keypad
   private BankDatabase bankDatabase; // account information database
   
   private static final String CLASSNAME = CajeroImpl.class.getCanonicalName(); 
   private static final Logger logger = Logger.getLogger(CLASSNAME); 

   // constants corresponding to main menu options
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int EXIT = 4;
   
   public CajeroImpl(Screen screen, Keypad keypad, BankDatabase bankDatabase) 
   {
      userAuthenticated = false; // user is not authenticated to start
      currentAccountNumber = 0; // no current account number to start
      this.screen = screen; // create screen
      this.keypad = keypad; // create keypad 
      this.bankDatabase = bankDatabase; // create acct info database
   } 
   
   public void run() 
   {
      
      while ( true )
      {
         
         while ( !this.userAuthenticated ) 
         {
            this.screen.displayMessageLine( "\nWelcome!" );       
            authenticateUser();    
         } 
         
         performTransactions(); // user is now authenticated 
         this.userAuthenticated = false; // reset before next ATM session
         this.currentAccountNumber = 0; // reset before next ATM session 
         this.screen.displayMessageLine( "\nThank you! Goodbye!" );
      }  
   }
   
   private void authenticateUser() 
   {
      this.screen.displayMessage( "\nPlease enter your account number: " );
      int accountNumber = this.keypad.getInput(); // input account number
      this.screen.displayMessage( "\nEnter your PIN: " ); // prompt for PIN
      int pin = this.keypad.getInput(); // input PIN
      
      this.userAuthenticated = 
         this.bankDatabase.authenticateUser( accountNumber, pin );
      
      if ( this.userAuthenticated )
      {
         this.currentAccountNumber = accountNumber; 
      } 
      else
         this.screen.displayMessageLine( 
             "Invalid account number or PIN. Please try again." );
   } 
   
   private void performTransactions() 
   {
      // local variable to store transaction currently being processed
      Transaction currentTransaction = null;
      
      boolean userExited = false; // user has not chosen to exit

      // loop while user has not chosen option to exit system
      while ( !userExited )
      {     
         // show main menu and get user selection
         int mainMenuSelection = displayMainMenu();

         // decide how to proceed based on user's menu selection
         switch ( mainMenuSelection )
         {
            // user chose to perform one of three transaction types
            case BALANCE_INQUIRY: 
            case WITHDRAWAL: 
            case DEPOSIT:

               // initialize as new object of chosen type
               currentTransaction = 
                  createTransaction( mainMenuSelection );

               currentTransaction.execute(); // execute transaction
               break; 
            case EXIT: // user chose to terminate session
               this.screen.displayMessageLine( "\nExiting the system..." );
               userExited = true; // this ATM session should end
               break;
            default: // user did not enter an integer from 1-4
               this.screen.displayMessageLine( 
                  "\nYou did not enter a valid selection. Try again." );
               break;
         } // end switch
      } // end while
   } // end method performTransactions
   
   // display the main menu and return an input selection
   private int displayMainMenu()
   {
      this.screen.displayMessageLine( "\nMain menu:" );
      this.screen.displayMessageLine( "1 - View my balance" );
      this.screen.displayMessageLine( "2 - Withdraw cash" );
      this.screen.displayMessageLine( "3 - Deposit funds" );
      this.screen.displayMessageLine( "4 - Exit\n" );
      this.screen.displayMessage( "Enter a choice: " );
      
      return this.keypad.getInput(); // return user's selection
   } // end method displayMainMenu
         
   // return object of specified Transaction subclass
   private Transaction createTransaction( int type )
   {
      Transaction temp = null; // temporary Transaction variable
      
      // determine which type of Transaction to create     
      switch ( type )
      {
         case BALANCE_INQUIRY: // create new BalanceInquiry transaction
            temp = new BalanceInquiry( 
               this.currentAccountNumber, this.screen, this.bankDatabase );
            break;
         case WITHDRAWAL: // create new Withdrawal transaction
            temp = new Withdrawal( this.currentAccountNumber, this.screen, 
               this.bankDatabase, this.keypad, this.cashDispenser );
            break; 
         case DEPOSIT: // create new Deposit transaction
            temp = new Deposit( this.currentAccountNumber, this.screen, 
               this.bankDatabase, this.keypad, this.depositSlot );
            break;
      } // end switch

      return temp; // return the newly created object
   } 

    @Override
    public void attach(Consumer<String> listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
