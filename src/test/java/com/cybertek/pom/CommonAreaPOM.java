package com.cybertek.pom;

import com.cybertek.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonAreaPOM {

    @FindBy( id = "ctl00_logout")
    public WebElement logoutLink;

    @FindBy(xpath = "//ul[@id='ctl00_menu']/li[1]/a")
    public WebElement viewAllOrderTab;

    @FindBy(xpath = "//ul[@id='ctl00_menu']/li[2]/a")
    public WebElement viewAllProductsTab;

    @FindBy(xpath = "//ul[@id='ctl00_menu']/li[3]/a")
    public WebElement orderTab;

    public CommonAreaPOM(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void logout(){
        this.logoutLink.click();

    }

    public void selectSideBarTab(String tabName) {

        if (tabName.equalsIgnoreCase("View all orders")) {
            Driver.getDriver().findElement(By.xpath("//ul[@id='ctl00_menu']/li[1]/a")).click();
        }

        if (tabName.equalsIgnoreCase("View all products")) {
            Driver.getDriver().findElement(By.xpath("//ul[@id='ctl00_menu']/li[2]/a")).click();
        }

        if (tabName.equalsIgnoreCase("Order")) {
            Driver.getDriver().findElement(By.xpath("//ul[@id='ctl00_menu']/li[3]/a")).click();
        }
    }

}
