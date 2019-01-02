
package atm.model;

import atm.data.BankDatabaseImpl;
import atm.view.Screen;

/**
 *
 * @author Rachel
 */


public class BalanceInquiry extends Transaction{
    
    public BalanceInquiry( int userAccountNumber, Screen atmScreen,
            BankDatabaseImpl atmBankDatabase )
    {
        super( userAccountNumber, atmScreen, atmBankDatabase );
    }     
    
    @Override
    public void execute()
    {
        BankDatabaseImpl bankDatabase = getBankDatabase();
        Screen screen = getScreen();
        
        double availableBalance =
                bankDatabase.getAvailableBalance( getAccountNumber() );
        
        double totalBalance =
                bankDatabase.getTotalBalance( getAccountNumber() );
        
        screen.displayMessageLine( "\nBalance Information:" );
        screen.displayMessage( " - Available balance: " );
        screen.displayDollarAmount( availableBalance );
        screen.displayMessage( "\n - Total balance:     " );
        screen.displayDollarAmount( totalBalance );
        screen.displayMessageLine( "" );
    } 
    
}
