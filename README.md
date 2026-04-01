# E-Commerce Automation Framework

Selenium TestNG automation framework for [SauceDemo](https://www.saucedemo.com/)

## 🛠️ Tech Stack
- Java 23
- Selenium 4.18.1
- TestNG 7.9.0
- Maven
- WebDriverManager
- Allure Reports

## 📁 Project Structure
```
src/test/java/com/example/
├── pages/          # Page Object Model classes
│   ├── LoginPage.java
│   ├── ProductsPage.java
│   └── CartPage.java
└── tests/          # Test classes
    ├── LoginTest.java
    ├── ProductsTest.java
    └── CartTest.java
```
## ✅ Test Cases (9 Total)
- Valid Login
- Invalid Login
- Products Page Title
- Products Count Verification
- Add Product to Cart
- Cart Item Verification
- Cart Page Title
- Remove Item from Cart
- Checkout Navigation

## ▶️ How to Run
# Run all tests
```
mvn clean test
```
# Generate Allure Report
```
mvn allure:serve
```
