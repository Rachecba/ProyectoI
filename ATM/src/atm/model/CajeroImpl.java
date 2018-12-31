
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
    
    private final static int CANCELED = 6;// constant corresponding to menu option to cancel
    
    private int amount;
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
    
    public double getAvailableBalance(){
        
        return bankDatabase.getAvailableBalance( this.currentAccountNumber);
    }
    
    public double getTotalBalance(){
        return bankDatabase.getTotalBalance(currentAccountNumber);
    }
      
    public void changeState(State state){
        this.state = state;
    }
    
    public State getState(){
        return state;
    }
    
    public boolean retiro(int cant){
        boolean cashDispensed = false; 
        double availableBalance; 
        do{
            amount = displayMenuOfAmounts();  
            if ( amount != CANCELED ){
                availableBalance = bankDatabase.getAvailableBalance( this.currentAccountNumber );
                if ( amount <= availableBalance &&amount!=7){// el diferente de 7 es para que retorne falso por mal uso del usuario
                    if ( cashDispenser.isSufficientCashAvailable( amount ) ){
                        bankDatabase.debit( currentAccountNumber, amount );
                        cashDispenser.dispenseCash( amount ); 
                        cashDispensed = true;
                        return true;
                     //   screen.displayMessageLine( "\nYour cash has been dispensed. Please take your cash now." );
                    }else 
                        return false;
                    //    screen.displayMessageLine("\nInsufficient cash available in the ATM.\n\nPlease choose a smaller amount." );
                }else{ // no hay dinero disponible
                  return false;
                    //screen.displayMessageLine("\nInsufficient funds in your account.\n\nPlease choose a smaller amount." );
                } 
            } 
            else{
                //screen.displayMessageLine( "\nCanceling transaction..." );
                return false; 
            } 
        } while ( !cashDispensed );
    }
    private int displayMenuOfAmounts()
    {
        int userChoice = 0; 
        
        // array of amounts to correspond to menu numbers
        int[] amounts = { 0, 20, 40, 60, 100, 200 };
        
        while ( userChoice == 0 )
        {
            int input = keypad.getInput();
            switch ( input )
            {
                case 1:
                    userChoice = amounts[ input ]; 
                    break;
                case 2: 
                    userChoice = amounts[ input ]; 
                    break;
                case 3:
                    userChoice = amounts[ input ];
                    break;
                case 4:
                    userChoice = amounts[ input ];
                    break;
                case 5:
                    userChoice = amounts[ input ];
                    break;
                case CANCELED: 
                    userChoice = CANCELED;
                    break;
                default: 
                    return 7;//si retorna 7 tiene que retornar falso la funcion que llama a esta
                    //"\nInvalid selection. Try again." );
            } 
        } 
        
        return userChoice; 
    } 
    
    @Override
    public void attach(Consumer<String> listener) {
        this.listener = listener;
    }

    @Override
    public void onInit() {
        //listener.accept(state.inicializa());
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
    public void input() {
        listener.accept(Integer.toString(state.input()));
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
