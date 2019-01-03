
package atm.states;

import atm.data.Account;
import atm.model.AtmImpl;

/**
 *
 * @author Rachel
 */
public class Balance extends State{
    
    public Balance(AtmImpl context) {
        super(context);
    }
    
    @Override
    public double[] getBalance(int number){
        Account account = context.getDao().loadAccount(number);
        double availableBalance = account.getAvailableBalance();
        double totalBalance = account.getTotalBalance();
        context.setState(new Start(context));
        
        return new double[]{availableBalance, totalBalance};
    }
    
}
