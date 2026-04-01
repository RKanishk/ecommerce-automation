package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.pages.CartPage;
import com.example.pages.LoginPage;
import com.example.pages.ProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Login and add item to cart before each test
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        cartPage = new CartPage(driver);
    }

    @Test
    public void testCartPageTitle() {
        String title = cartPage.getPageTitle();
        Assert.assertEquals(title, "Your Cart");
        System.out.println("✅ Cart Page Title Test Passed!");
    }

    @Test
    public void testCartHasItem() {
        int count = cartPage.getCartItemCount();
        Assert.assertTrue(count > 0, "Cart is empty!");
        System.out.println("✅ Cart Has Item Test Passed! Items: " + count);
    }

    @Test
    public void testRemoveItemFromCart() {
        cartPage.removeFirstItem();
        int count = cartPage.getCartItemCount();
        Assert.assertEquals(count, 0, "Item was not removed!");
        System.out.println("✅ Remove Item Test Passed!");
    }

    @Test
    public void testCheckoutNavigation() {
        cartPage.clickCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"));
        System.out.println("✅ Checkout Navigation Test Passed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
