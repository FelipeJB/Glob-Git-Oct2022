# Globant Bank program
> This project is a program which allows users to make transactions with their savings
accounts.

## Objectives

- The bank has many users, so there should be an option to print all clients and their related
information.
- Each client has a savings account, user and a password.
- Each bank account has an account number, an opening date and a balance.
- The user should be able to withdraw, add money, and transfer money to another bank
account.
- Some transactions are taxed the following way:
  - Withdrawals tax is $200 for amounts less than $1000. Withdrawals of more than $1000
  tax is $200 plus 15% of the amount to withdraw.
  - Adding money to the account does not have any cost.
  - Transferring money to another account tax is $100.


## Table of content

* [Environment](#environment)
    * [File Descriptions](#file-descriptions)
* [Usage](#usage)
* [Bugs](#bugs)
* [Author](#author)
* [License](#license)

##  Environment
This project was developed on IntelliJ IDEA 2022.2.3 (Community Edition).

### File Descriptions
- ```src/``` contains classes used for this project.
- ```Bank.java``` contains the class Bank and different methods for different transactions.
- ```BankAccount.java``` contains the class BankAccount and different methods that affect the bank accounts.
- ```Client.java``` contains the class Client and the basic information of each client.
- ```Main.java``` contains the code to start execution of the Java program.

## Usage

For this program, there are three user profiles:

- Administrator
- Ana
- Maria
 
Using the administrator profile is able to check the basic information of all the bank clients.
The other two profiles are bank clients. This program is limited to deposit, withdraw and transfer money from Ana´s account. The transfer can be done from Ana´s account to Maria´s account only. 

This program starts with the main menu, which has three profile options:

1. Administrator
2. Client
3. Exit

If you want to check the list of clients, select option 1 and insert user and password. For this scenario, the user is ```admin``` and the password is ```Bank```. Then, the program will show two options:

1. Print list of clients
2. Exit

Once you print the list of clients, you can return to the main menu.

If you want to continue as a client, select the option 2 and insert user and password. For this scenario, we are going to work with Ana´s bank account. The user is ```Ana``` and the password is ```Ken```. Then, the program will show up a menu with five options:

1. Check current balance
2. Deposit
3. Withdraw
4. Transfer
5. Exit

You can select the option depending on the operation you want.

- For checking the current balance of Ana's account, select 1.
- For deposit an amount of money into Ana´s account, select 2.
- For withdraw an amount of money from Ana´s account (take into account the taxes generated), select 3.
- For transfer an amount of money from Ana's account to Maria's account (take into account the taxes generated), select 4.
- For exit the program, select 5.

For this program, deposit, withdraw or transfer operations equal to zero are not valid and an alert message will appear. Also, withdraw and transfer operations will not be allowed if the money amount plus taxes are higher than the current balance in the bank account.

## Bugs

Only integers must be entered when options are show during the execution of the program. Otherwise, the program will finish immediately.


## Author

- Juan Camilo González <a href="https://twitter.com/juankter" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/twitter.svg" alt="juankter" height="30" width="40" /></a>
  <a href="https://bit.ly/2MBNR0t" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="https://bit.ly/2mbnr0t" height="30" width="40" /></a>

## License

Public Domain. No copy write protection.