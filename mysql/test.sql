CREATE DATABASE USER_MANAGEMENT;
CREATE DATABASE `product-inventory`;
CREATE DATABASE OrderManagement;

USE USER_MANAGEMENT;

CREATE TABLE Users (
UserID INT PRIMARY KEY AUTO_INCREMENT,
01NAME VARCHAR(50),
$Email VARCHAR(100),
PasswordHash CHAR(64),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE PROFILES (
ProfileID INT PRIMARY KEY AUTO_INCREMENT,
UserID INT,
FirstName VARCHAR(50),
LastName VARCHAR(50),
BirthDate DATE,
FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

USE `product-inventory`;

CREATE TABLE `Products-` (
ProductID INT PRIMARY KEY AUTO_INCREMENT,
ProductName VARCHAR(100),
Category VARCHAR(50),
Price DECIMAL(10, 2),
StockQuantity INT,
CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Suppliers (
SupplierID INT PRIMARY KEY AUTO_INCREMENT,
ProductID INT,
SupplierName VARCHAR(100),
ContactEmail VARCHAR(100),
PhoneNumber VARCHAR(20),
FOREIGN KEY (ProductID) REFERENCES `Products-`(ProductID)
);

USE OrderManagement;

CREATE TABLE Orders (
OrderID INT PRIMARY KEY AUTO_INCREMENT,
UserID INT,
OrderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
TotalAmount DECIMAL(10, 2),
FOREIGN KEY (UserID) REFERENCES USER_MANAGEMENT.Users(UserID)
);

CREATE TABLE OrderItems (
OrderItemID INT PRIMARY KEY AUTO_INCREMENT,
OrderID INT,
ProductID INT,
Quantity INT,
PriceEach DECIMAL(10, 2),
FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
FOREIGN KEY (ProductID) REFERENCES `product-inventory`.`Products-`(ProductID)
);


USE USER_MANAGEMENT;

-- Usersテーブルにデータを挿入
INSERT INTO Users (01NAME, $Email, PasswordHash) VALUES
('JohnDoe', 'john.doe@example.com', '5f4dcc3b5aa765d61d8327deb882cf99'),
('JaneSmith', 'jane.smith@example.com', '5f4dcc3b5aa765d61d8327deb882cf99');

-- PROFILESテーブルにデータを挿入
INSERT INTO PROFILES (UserID, FirstName, LastName, BirthDate) VALUES
(1, 'John', 'Doe', '1980-05-15'),
(2, 'Jane', 'Smith', '1990-07-22');


USE `product-inventory`;

-- Products-テーブルにデータを挿入
INSERT INTO `Products-` (ProductName, Category, Price, StockQuantity) VALUES
('Laptop', 'Electronics', 999.99, 50),
('Smartphone', 'Electronics', 599.99, 100);

-- Suppliersテーブルにデータを挿入
INSERT INTO Suppliers (ProductID, SupplierName, ContactEmail, PhoneNumber) VALUES
(1, 'TechSupplier Inc.', 'contact@techsupplier.com', '123-456-7890'),
(2, 'MobileWorld LLC', 'info@mobileworld.com', '098-765-4321');

USE OrderManagement;

-- Ordersテーブルにデータを挿入
INSERT INTO Orders (UserID, TotalAmount) VALUES
(1, 1599.98),
(2, 599.99);

-- OrderItemsテーブルにデータを挿入
INSERT INTO OrderItems (OrderID, ProductID, Quantity, PriceEach) VALUES
(1, 1, 1, 999.99),
(1, 2, 1, 599.99),
(2, 2, 1, 599.99);