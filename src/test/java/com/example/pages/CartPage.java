package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    // Locators
    By cartItems        = By.className("cart_item");
    By checkoutBtn      = By.id("checkout");
    By continueShopBtn  = By.id("continue-shopping");
    By removeBtn        = By.xpath("(//button[text()='Remove'])[1]");
    By pageTitle        = By.className("title");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    public void clickContinueShopping() {
        driver.findElement(continueShopBtn).click();
    }

    public void removeFirstItem() {
        driver.findElement(removeBtn).click();
    }
}