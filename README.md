# ATM Simulator

A desktop ATM app I built in Java using Swing/AWT for the screens and MySQL (through JDBC) for storing everything. You can sign up for a new account, log in with a card number and PIN, and do the usual ATM things: deposit, withdraw, check your balance, print a mini statement and change your PIN.

I made this to learn how a Java GUI talks to a real database. It's a learning project, so please don't treat it like real banking software (more on that at the bottom).

## What it does

- **Sign up** in three steps: personal details, extra details, then account type and services. A card number and PIN are generated at the end.
- **Login** with card number and PIN
- **Deposit** and **Withdrawal**
- **Fast Cash** for quick withdrawals of fixed amounts
- **Balance Enquiry**
- **Mini Statement** showing your transactions and current balance
- **PIN Change**

## Built with

- Java 
- Swing / AWT for the interface
- MySQL 8 with JDBC
- JCalendar (for the date picker on the signup page)

## Before you run it

You'll need:

1. JDK 17 or newer 
2. MySQL Server running on your machine
3. VS Code with the Extension Pack for Java, or any Java IDE you like

The jar files the project needs (JCalendar, JGoodies and the MySQL connector) are already in the `lib` folder, so there's nothing extra to download.

## Setting it up

**1. Create the database**

Open MySQL (Workbench or the command line) and run:

```sql
CREATE DATABASE bankmanagementsystem;
USE bankmanagementsystem;
SOURCE database.sql;
```

Or just open `database.sql` in Workbench and run it. It only creates the empty tables, with no data in them.

**2. Set your MySQL password**

The app reads your database password from an environment variable called `DB_PASSWORD`, so it never lives in the code. 


**3. Run it**

Open the project in VS Code and run `Login.java` (press F5 if you went with the `.env` option). The login window should pop up.


## Project structure

```
src/bank/management/system/   all the Java source files
src/icons/                    images used in the screens
lib/                          jar dependencies
database.sql                  table structure for MySQL
.env.example                  template for your password file
```


## Author

Made by **CHITRA JOSHI**. Feel free to open an issue if something breaks, or message me on GitHub.
