import random

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
        
