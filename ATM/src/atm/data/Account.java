/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.data;

/**
 *
 * @author Rachel
 */
public class Account {
   
    private int accountNumber; // account number
    private int pin; // PIN for authentication
    private double availableBalance; // funds available for withdrawal
    private double totalBalance; // funds available + pending deposits
    
    public Account( int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance) {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
   }
    
    public boolean validatePIN( int userPIN )
   {
      if ( userPIN == pin )
         return true;
      else
         return false;
   }
   
   public double getAvailableBalance()
   {
      return availableBalance;
   }

   public double getTotalBalance()
   {
      return totalBalance;
   } 
   
   public void credit( double amount )
   {
      totalBalance += amount; // add to total balance
   } 

   public void debit( double amount )
   {
      availableBalance -= amount; // subtract from available balance
      totalBalance -= amount; // subtract from total balance
   }
   
   public int getAccountNumber()
   {
      return accountNumber;  
   } 
}
