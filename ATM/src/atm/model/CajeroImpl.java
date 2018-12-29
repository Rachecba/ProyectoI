
package atm.model;

import atm.data.BankDatabase;
import atm.states.State;
import atm.view.CashDispenser;
import atm.view.DepositSlot;
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
    
    private boolean userAuthenticated; 
    private int currentAccountNumber; 
    private Screen screen; 
    private Keypad keypad;
    private CashDispenser cashDispenser; 
    private DepositSlot depositSlot; 
    private BankDatabase bankDatabase; 
    
    private static final String CLASSNAME = CajeroImpl.class.getCanonicalName();
    private static final Logger logger = Logger.getLogger(CLASSNAME);
    
    // constants corresponding to main menu options
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;
    
    public CajeroImpl(Screen screen, Keypad keypad, CashDispenser cashDispenser, DepositSlot depositSlot, BankDatabase bankDatabase)
    {
        userAuthenticated = false; 
        currentAccountNumber = 0; 
        this.screen = screen; 
        this.keypad = keypad; 
        this.cashDispenser = cashDispenser; 
        this.depositSlot = depositSlot; 
        this.bankDatabase = bankDatabase; 
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
            
            performTransactions(); 
            this.userAuthenticated = false;
            this.currentAccountNumber = 0;
            this.screen.displayMessageLine( "\nThank you! Goodbye!" );
        }
    }
    
    private void authenticateUser()
    {
        this.screen.displayMessage( "\nPlease enter your account number: " );
        int accountNumber = this.keypad.getInput(); 
        this.screen.displayMessage( "\nEnter your PIN: " ); 
        int pin = this.keypad.getInput(); 
        
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
        Transaction currentTransaction = null;
        
        boolean userExited = false; // user has not chosen to exit
        
        while ( !userExited )
        {
            int mainMenuSelection = displayMainMenu();
            
            switch ( mainMenuSelection )
            {
                case BALANCE_INQUIRY:
                case WITHDRAWAL:
                case DEPOSIT:
                    currentTransaction =
                            createTransaction( mainMenuSelection );
                    
                    currentTransaction.execute(); 
                    break;
                case EXIT: 
                    this.screen.displayMessageLine( "\nExiting the system..." );
                    userExited = true;
                    break;
                default:
                    this.screen.displayMessageLine(
                            "\nYou did not enter a valid selection. Try again." );
                    break;
            } 
        } 
    }
    
    private int displayMainMenu()
    {
        this.screen.displayMessageLine( "\nMain menu:" );
        this.screen.displayMessageLine( "1 - View my balance" );
        this.screen.displayMessageLine( "2 - Withdraw cash" );
        this.screen.displayMessageLine( "3 - Deposit funds" );
        this.screen.displayMessageLine( "4 - Exit\n" );
        this.screen.displayMessage( "Enter a choice: " );
        
        return this.keypad.getInput(); 
    } 
    
    private Transaction createTransaction( int type )
    {
        Transaction temp = null; 
        
        switch ( type )
        {
            case BALANCE_INQUIRY:
                temp = new BalanceInquiry(
                        this.currentAccountNumber, this.screen, this.bankDatabase );
                break;
            case WITHDRAWAL: 
                temp = new Withdrawal( this.currentAccountNumber, this.screen,
                        this.bankDatabase, this.keypad, this.cashDispenser );
                break;
            case DEPOSIT: 
                temp = new Deposit( this.currentAccountNumber, this.screen,
                        this.bankDatabase, this.keypad, this.depositSlot );
                break;
        } 
        
        return temp; 
    }
    
    @Override
    public void attach(Consumer<String> listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
