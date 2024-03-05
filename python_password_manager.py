import hashlib
import getpass

storedPassword = {}

def newAccount():
    username = input("Enter a new username: ")
    password = getpass.getpass("Enter a new password: ")
    hashed_password = hashlib.sha256(password.encode()).hexdigest()
    storedPassword[username] = hashed_password
    
def login():
    username = input("Enter the username: ")
    password = input("Enter the password: ")
    hashed_password = hashlib.sha256(password.encode()).hexdigest()
    if username in storedPassword.keys() and storedPassword[username]:
        print("Login successful.")
    else:
        print("Login failed. Invalid username or password.")
    
def main():
    while(True):
        userChoice = input("Do you want to create an account, login, or exit? (create/login/exit): ")
        if userChoice.lower() == "create":
            newAccount()
        elif userChoice.lower() == "login":
            login()
        elif userChoice.lower() == "exit":
            break
        else:
            print("Invalid choice. Please chose one of the following options create, login, or exit.")
            
if __name__ == "__main__":
    main()