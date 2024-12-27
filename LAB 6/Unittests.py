import unittest

class BankAccount:
    def __init__(self, account_number: str, balance: float = 0.0):
        if balance < 0:
            raise ValueError("Initial balance cannot be negative")
        self.account_number = account_number
        self.balance = balance

    def deposit(self, amount: float):
        if amount <= 0:
            raise ValueError("Deposit amount must be positive")
        self.balance += amount

    def withdraw(self, amount: float):
        if amount <= 0:
            raise ValueError("Withdrawal amount must be positive")
        if amount > self.balance:
            raise ValueError("Insufficient funds")
        self.balance -= amount

    def get_balance(self) -> float:
        return self.balance


class TestBankAccount(unittest.TestCase):

    def test_create_account_with_valid_initial_balance(self):
        account = BankAccount("12345", 100.0)
        self.assertEqual(account.get_balance(), 100.0)

    def test_create_account_with_negative_balance(self):
        with self.assertRaises(ValueError) as context:
            BankAccount("12345", -50.0)
        self.assertEqual(str(context.exception), "Initial balance cannot be negative")

    def test_deposit_positive_amount(self):
        account = BankAccount("12345", 100.0)
        account.deposit(50.0)
        self.assertEqual(account.get_balance(), 150.0)

    def test_deposit_zero_or_negative_amount(self):
        account = BankAccount("12345", 100.0)
        with self.assertRaises(ValueError) as context:
            account.deposit(0)
        self.assertEqual(str(context.exception), "Deposit amount must be positive")

        with self.assertRaises(ValueError) as context:
            account.deposit(-50)
        self.assertEqual(str(context.exception), "Deposit amount must be positive")

    def test_withdraw_valid_amount(self):
        account = BankAccount("12345", 100.0)
        account.withdraw(50.0)
        self.assertEqual(account.get_balance(), 50.0)

    def test_withdraw_more_than_balance(self):
        account = BankAccount("12345", 100.0)
        with self.assertRaises(ValueError) as context:
            account.withdraw(150.0)
        self.assertEqual(str(context.exception), "Insufficient funds")

    def test_withdraw_zero_or_negative_amount(self):
        account = BankAccount("12345", 100.0)
        with self.assertRaises(ValueError) as context:
            account.withdraw(0)
        self.assertEqual(str(context.exception), "Withdrawal amount must be positive")

        with self.assertRaises(ValueError) as context:
            account.withdraw(-50.0)
        self.assertEqual(str(context.exception), "Withdrawal amount must be positive")

    def test_balance_after_operations(self):
        account = BankAccount("12345", 100.0)
        account.deposit(50.0)
        account.withdraw(30.0)
        self.assertEqual(account.get_balance(), 120.0)

    def test_multiple_operations(self):
        account = BankAccount("12345")
        account.deposit(100.0)
        account.withdraw(30.0)
        account.deposit(20.0)
        self.assertEqual(account.get_balance(), 90.0)

if __name__ == "__main__":
    unittest.main()
