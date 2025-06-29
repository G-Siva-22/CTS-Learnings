BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Transactions';
EXCEPTION WHEN OTHERS THEN NULL; END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Loans';
EXCEPTION WHEN OTHERS THEN NULL; END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Accounts';
EXCEPTION WHEN OTHERS THEN NULL; END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION WHEN OTHERS THEN NULL; END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION WHEN OTHERS THEN NULL; END;
/

-- Create tables
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

-- Insert sample data
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 15000, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (3, 'Old Customer', TO_DATE('1950-01-01', 'YYYY-MM-DD'), 500, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (1, 1, 'Savings', 1000, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (2, 2, 'Checking', 15000, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (3, 3, 'Savings', 500, SYSDATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (1, 1, SYSDATE, 200, 'Deposit');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate) VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate) VALUES (2, 3, 10000, 6, SYSDATE, SYSDATE + 20);

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

COMMIT;

-- Add IsVIP column
ALTER TABLE Customers ADD IsVIP CHAR(1) DEFAULT 'N';

SET SERVEROUTPUT ON
DECLARE
  v_age NUMBER;
BEGIN
  -- Scenario 1: Discount interest rate for customers older than 60
  FOR cust IN (SELECT CustomerID, DOB FROM Customers) LOOP
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, cust.DOB) / 12);
    IF v_age > 60 THEN
      UPDATE Loans SET InterestRate = InterestRate - 1 WHERE CustomerID = cust.CustomerID;
    END IF;
  END LOOP;

  -- Scenario 2: Set IsVIP flag based on balance
  FOR cust IN (SELECT CustomerID, Balance FROM Customers) LOOP
    IF cust.Balance > 10000 THEN
      UPDATE Customers SET IsVIP = 'Y' WHERE CustomerID = cust.CustomerID;
    ELSE
      UPDATE Customers SET IsVIP = 'N' WHERE CustomerID = cust.CustomerID;
    END IF;
  END LOOP;

  COMMIT;

  -- Scenario 3: Print loan reminders due in next 30 days
  -- plus print customer VIP status table
  DECLARE
    CURSOR c_loan_reminders IS
      SELECT l.LoanID, c.Name, l.EndDate
      FROM Loans l JOIN Customers c ON l.CustomerID = c.CustomerID
      WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;

    CURSOR c_customers IS
      SELECT CustomerID, Name, Balance, IsVIP FROM Customers ORDER BY CustomerID;
  BEGIN
    -- Print Loan Reminders header
    DBMS_OUTPUT.PUT_LINE('Loan Reminders Due in Next 30 Days:');
    DBMS_OUTPUT.PUT_LINE(RPAD('LoanID',10) || RPAD('Customer Name',20) || RPAD('Due Date',15));
    DBMS_OUTPUT.PUT_LINE(RPAD('-', 10, '-') || RPAD('-', 20, '-') || RPAD('-', 15, '-'));

    FOR loan_rec IN c_loan_reminders LOOP
      DBMS_OUTPUT.PUT_LINE(
        RPAD(loan_rec.LoanID,10) ||
        RPAD(loan_rec.Name,20) ||
        TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY')
      );
    END LOOP;

    DBMS_OUTPUT.PUT_LINE(CHR(10)); -- blank line

    -- Print Customer VIP Status header
    DBMS_OUTPUT.PUT_LINE('Customer VIP Status:');
    DBMS_OUTPUT.PUT_LINE(
      RPAD('CustomerID',12) || RPAD('Name',20) || RPAD('Balance',10) || RPAD('IsVIP',6)
    );
    DBMS_OUTPUT.PUT_LINE(
      RPAD('-', 12, '-') || RPAD('-', 20, '-') || RPAD('-', 10, '-') || RPAD('-', 6, '-')
    );

    FOR cust IN c_customers LOOP
      DBMS_OUTPUT.PUT_LINE(
        RPAD(cust.CustomerID,12) ||
        RPAD(cust.Name,20) ||
        RPAD(TO_CHAR(cust.Balance, '9999999'),10) ||
        RPAD(cust.IsVIP,6)
      );
    END LOOP;
  END;
END;
/
