import random
import os

class Account:
    def __init__(self, first_name: str, last_name: str, pin: str):
        self.first_name = first_name
        self.last_name = last_name
        self.pin = pin
        self.account_number = self._generate_account_number()
        self.balance = 0.0
        
        self._print_account_details_after_creation()
    
    def _print_account_details_after_creation(self):
        print("Account Created Successfully ✅️: ")
        print(f"Account Name: {self.get_full_name()}")
        print(f"Account number: {self.get_account_number()}")
        print("Pin (reserved for security): **** ")
        print(f"Current balance: ${self.get_balance()}")
    
    def _generate_account_number(self):
        return ''.join([str(random.randint(0, 9)) for _ in range(10)])
    
    def get_pin(self):
        return self.pin
    
    def deposit(self, amount):
        self.balance += amount
    
    def withdraw(self, amount, pin):
        if amount < self.balance and amount > 0 and self.pin == pin:
            self.balance -= amount
            return True
        return False
    
    def get_balance(self):
        return self.balance
    
    def get_account_number(self):
        return self.account_number
    
    def get_first_name(self):
        return self.first_name.upper()
    
    def get_last_name(self):
        return self.last_name.upper()
    
    def get_full_name(self):
        return f"{self.get_first_name()} {self.get_last_name()}"
    
    def change_pin(self, old_pin, new_pin):
        if old_pin == self.pin:
            self.pin = new_pin
            return True
        return False



class BankeBank:
    def __init__(self):
        self.accounts = []
    
    def clear_screen(self):
        print("\033[H\033[2J", end='', flush=True)
        # os.system("clear")
    
    def transfer_to(self, account_number, amount, account, pin):
        for recipient in self.accounts:
            if recipient.get_account_number() == account_number:
                if account.withdraw(amount, pin):
                    recipient.deposit(amount)
                    return True
        return False
    
    def create_account(self):
        print("Banke Account Creation Form")
        
        first_name = input("Enter First Name >> ")
        last_name = input("Enter Last Name >> ")
        
        while True:
            pin = input("Enter Account Pin (must be 4 digit) >> ")
            if len(pin) == 4:
                break
        
        self.clear_screen()
        self.accounts.append(Account(first_name, last_name, pin))
    
    def login(self):
        self.clear_screen()
        print("Login to account")
        
        first_name = input("Enter first name: ")
        pin = input("Enter 4 digit PIN: ")
        
        for account in self.accounts:
            if account.get_first_name() == first_name.upper() and account.get_pin() == pin:
                return account
        return None
    
    def manage_account(self, account):
        menu = """
1. Make Deposit
2. Make Withdrawal
3. Make Transfer
4. View Balance
5. Change Account pin
6. View account number
7. Close account
0. Logout
>  """
        
        print(f"Welcome, {account.get_last_name()}🫡️")
        option = input(menu)
        
        match option:
            case "1":
                amount = float(input("Enter amount to deposit >> "))
                account.deposit(amount)
                self.clear_screen()
                print(f"Deposit Successful 💰️ New account balance: ${account.get_balance()}")
                self.manage_account(account)
                
            case "2":
                amount = float(input("Enter amount to withdraw >> "))
                pin = input("Enter account pin >> ")
                
                message = account.withdraw(amount, pin)
                self.clear_screen()
                print("Withdrawal Successful 💰️ New account balance: $" + str(account.get_balance()) if message else "Withdrawal Failed")
                self.manage_account(account)
                
            case "3":
                amount = float(input("Enter amount to tranfer >> "))
                account_number = input("Enter account number >> ")
                pin = input("Enter account pin >> ")
                
                message = self.transfer_to(account_number, amount, account, pin)
                self.clear_screen()
                print(
                    f"Transfer Successful 💰️ New account balance: ${account.get_balance()}"
                    if message else
                    "Transfer failed ❌️"
                )
                self.manage_account(account)
                
            case "4":
                self.clear_screen()
                print(f"Available balance: {account.get_balance():,.2f}")
                self.manage_account(account)
                
            case "5":
                self.clear_screen()
                current_pin = input("Enter current pin >> ")
                new_pin = input("Enter new pin >> ")
                message = account.change_pin(current_pin, new_pin)
                print("Pin changed successfully" if message else "Incorrect pin")
                self.manage_account(account)
                
            case "6":
                self.clear_screen()
                print(f"ACCOUNT NUMBER: {account.get_account_number()}")
                self.manage_account(account)
                
            case "7":
                pin = input("Enter account pin to confirm account closure >> ")
                if account.get_pin() == pin:
                    self.clear_screen()
                    self.accounts.remove(account)
                    print("Closing account .................")
                    print("Account Closed successfully, we regret seeing you leave.")
                    self.main_menu()
                else:
                    print("Invalid Account Pin")
                    self.manage_account(account)
                    
            case "0":
                self.clear_screen()
                self.main_menu()
                
            case _:
                self.clear_screen()
                print("Invalid input")
                self.manage_account(account)
    
    def main_menu(self):
        main_menu = """
Welcome to Banke 🏦️🏧️
1. Create Account
2. Login
3. Exit
>  """
        
        option = input(main_menu)
        
        match option:
            case "1":
                self.create_account()
                self.main_menu()
            case "2":
                while True:
                    account = self.login()
                    if account:
                        self.clear_screen()
                        self.manage_account(account)
                        break
                    else:
                        self.clear_screen()
                        print("Invalid Log in credentials ❌️")
            case "3":
                self.clear_screen()
                print("Shutting down...🏦️🏧️")
                exit(0)
            case _:
                self.clear_screen()
                print("Wrong option ❌️")
                self.main_menu()

if __name__ == "__main__":
    bank = BankeBank()
    bank.main_menu()
