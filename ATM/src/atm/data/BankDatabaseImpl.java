
package atm.data;

/**
 *
 * @author Rachel
 */
public class BankDatabaseImpl implements BankDatabase{
    
    public BankDatabaseImpl()
    {
        Account[] accounts = new Account[ 2 ];
        accounts[ 0 ] = new Account( 12345, 54321, 1000.0, 1200.0 );
        accounts[ 1 ] = new Account( 98765, 56789, 200.0, 200.0 );
    }
    
    @Override
    public boolean authenticateUser( int userAccountNumber, int userPIN )
    {
//        Account userAccount = getAccount( userAccountNumber );
//        
//        if ( userAccount != null )
//            return userAccount.validatePIN( userPIN );
//        else
            return false;
    }

    @Override
    public Account loadAccount(int account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveAccount(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 