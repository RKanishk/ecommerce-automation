package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    // Locators
    By pageTitle        = By.className("title");
    By productItems     = By.className("inventory_item");
    By addToCartBtn     = By.xpath("(//button[text()='Add to cart'])[1]");
    By cartIcon         = By.className("shopping_cart_link");
    By cartBadge        = By.className("shopping_cart_badge");
    By sortDropdown     = By.className("product_sort_container");

    // Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public int getProductCount() {
        return driver.findElements(productItems).size();
    }

    public void addFirstProductToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }
}