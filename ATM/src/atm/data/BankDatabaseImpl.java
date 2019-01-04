
package atm.data;

/**
 *
 * @author Rachel
 */
public class BankDatabaseImpl implements BankDatabase{
    Account[] accounts;
    
    public BankDatabaseImpl()
    {
        accounts = new Account[ 2 ];
        accounts[ 0 ] = new Account( 12345, 54321, 1000.0, 1200.0 );
        accounts[ 1 ] = new Account( 98765, 56789, 200.0, 200.0 );
        //account prueba
    }
    
    @Override
    public boolean authenticateUser( int userAccountNumber, int userPIN )
    {
        Account userAccount = loadAccount(userAccountNumber);
        
        if ( userAccount != null )
            return userAccount.validatePIN( userPIN );
        else
            return false;
    }

    @Override
    public Account loadAccount(int number) {
        for(Account account : accounts){
            if(account.getAccountNumber() == number)
                return account;
        }
        
        return null;
    }

    @Override
    public boolean saveAccount(Account account) {
        //no se que se supone que se haga aqui
        return true;
    }
} 