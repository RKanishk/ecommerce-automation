package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.pages.LoginPage;
import com.example.pages.ProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductsTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Login before each test
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        productsPage = new ProductsPage(driver);
    }

    @Test
    public void testProductPageTitle() {
        String title = productsPage.getPageTitle();
        Assert.assertEquals(title, "Products");
        System.out.println("✅ Products Page Title Test Passed!");
    }

    @Test
    public void testProductsAreDisplayed() {
        int count = productsPage.getProductCount();
        Assert.assertTrue(count > 0, "No products displayed!");
        System.out.println("✅ Products Displayed: " + count + " items found!");
    }

    @Test
    public void testAddProductToCart() {
        productsPage.addFirstProductToCart();
        String badge = productsPage.getCartBadgeCount();
        Assert.assertEquals(badge, "1");
        System.out.println("✅ Add to Cart Test Passed! Cart count: " + badge);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}