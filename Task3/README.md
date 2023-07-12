# Task 3



Transaction (Abstract)
transactionId: int
double execute(Account)


Lab3








Withdraw
amount: double
double execute(Account)


BalanceInquiry
String currencyType()
double execute(Account )

Deposit
amount: double
double execute(Account)             
                           
Rollback
(interface)
double cancelTransaction(Account)

Account
accountNumber: integer
ownerName: String
balance: double













Design the previous classes and note that
a)	"execute" method of each class will return the new account balance.
b)	"execute" method in balance inquiry will return the account balance in the specified currencyType, currencyType could be "U" for USD or "E" for euro
c)	"cancelTransaction" of each class will be opposite to the execute method, i.e. "execute" method in case of "Deposit" class will increase the balance of the account by the specified amount while "cancelTrasnaction" will decrease the balance by the specified amount.

2)	Create main function and test your classes using the following
Display the following menu to the user:
-	Press 1 to enter account details
-	Press 2 to deposit
-	Press 3 to withdraw
-	Press 4 to show current balance
-	Press 5 to cancel last transaction
-	Press 6 to exit

- If '1' is entered, you will ask the user to enter all account details (balance, owner name …etc) then save these values in an Account object
- If '2' is entered, ask the user to enter the required amount then increase the account balance by the specified amount using an object of "Deposit"  class then print the new balance.
- If '3' is entered, ask the user to enter the required amount then decrease the account balance by the specified amount using an object of "Withdraw" class then print the new balance
¬
- If '5' is entered cancel the last transaction and display the new balance.

