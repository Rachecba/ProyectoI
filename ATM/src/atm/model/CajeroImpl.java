
package atm.model;

import atm.data.BankDatabase;
import atm.states.Login;
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
public class CajeroImpl implements Cajero {
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
    public static final int BALANCE_INQUIRY = 1;
    public static final int WITHDRAWAL = 2;
    public static final int DEPOSIT = 3;
    public static final int EXIT = 4;
    
    public CajeroImpl(Screen screen, Keypad keypad, CashDispenser cashDispenser, DepositSlot depositSlot, BankDatabase bankDatabase)
    {
        userAuthenticated = false; 
        currentAccountNumber = 0; 
        this.screen = screen; 
        this.keypad = keypad; 
        this.cashDispenser = cashDispenser; 
        this.depositSlot = depositSlot; 
        this.bankDatabase = bankDatabase; 
        
        //inicializar el estado en login
        this.state = new Login(this);
    }
      
    public void changeState(State state){
        this.state = state;
    }
    
    public State getState(){
        return state;
    }
    
    @Override
    public void attach(Consumer<String> listener) {
        this.listener = listener;
    }

    @Override
    public void onInit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void authenticate() {
        listener.accept(state.authenticateUser());
    }

    @Override
    public void message() {
        listener.accept(state.message());
    }

    @Override
    public void optionMenu() {
        listener.accept(Integer.toString(state.menuOpt()));
    }

    @Override
    public void transaction(int num) {
        listener.accept(state.performTransaction(num));
    }

    @Override
    public void deposit() {
        listener.accept(state.depositTransaction());
    }

    @Override
    public void withdrawal() {
        listener.accept(state.withdrawalTransaction());
    }

    @Override
    public void balance() {
        listener.accept(state.balanceTransaction());
    }

    @Override
    public void exit() {
        listener.accept(state.exit());
    } 
}
