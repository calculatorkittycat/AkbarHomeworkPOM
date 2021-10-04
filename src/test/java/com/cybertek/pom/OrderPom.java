package com.cybertek.pom;

import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderPom {

    @FindBy (id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement dropdown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityTextBox;

    @FindBy(xpath = "//li/input[@type='submit']")
    public WebElement submitButtoon;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    public WebElement pricePerUnitTextBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    public WebElement discountTextBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    public WebElement totalTextBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement nameTextBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetTextBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityTextBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateTextBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipTextBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expirationDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processBtn;

    @FindBy(xpath = "//strong")
    public WebElement hasBeenProcessed;

    Faker faker = new Faker();

    public OrderPom(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public int getUnitPriceFromForm(String productName, int quantity){
        Select selectObj = new Select(this.dropdown);
        selectObj.selectByVisibleText(productName);
        String quantStr = String.valueOf(quantity);

        this.quantityTextBox.clear();
        this.quantityTextBox.sendKeys(quantStr);
        this.submitButtoon.click();
        String priceString = this.pricePerUnitTextBox.getAttribute("value");

        int pricePerUnitOutput = Integer.parseInt(priceString);
        System.out.println("price per unit for " + quantity + " " + productName + "s is " + pricePerUnitOutput + "$");
        return pricePerUnitOutput;

    }

    public int getDiscountFromForm(String productName, int quantity){
        Select selectObj = new Select(this.dropdown);
        selectObj.selectByVisibleText(productName);

        this.quantityTextBox.clear();
        String str = String.valueOf(quantity);
        this.quantityTextBox.sendKeys(str);

        this.submitButtoon.click();

        String discountStr = this.discountTextBox.getAttribute("value");

        int discountParse = Integer.parseInt(discountStr);
        System.out.println("discount for " + quantity + " " + productName + "s is "+ discountParse + "%");
        return discountParse;

    }

    public int calculateTotal(String productName, int quantity){
        Select selectObj = new Select(this.dropdown);
        selectObj.selectByVisibleText(productName);

        this.quantityTextBox.clear();
        String str = String.valueOf(quantity);
        this.quantityTextBox.sendKeys(str);

        this.submitButtoon.click();

        String totalStr = this.totalTextBox.getAttribute("value");

        int totalParse = Integer.parseInt(totalStr);
        System.out.println("total for " + quantity + productName + " s is "  + totalParse + "$");
        return totalParse;


    }

    public int getExpectedDiscount(String productName, int quantity){
        Select selectObj = new Select(this.dropdown);
        selectObj.selectByVisibleText(productName);

        this.quantityTextBox.clear();
        String str = String.valueOf(quantity);
        this.quantityTextBox.sendKeys(str);

        int discount = 0;

        if(quantity > 10){
            if (productName.equalsIgnoreCase("MyMoney")){
                selectObj.selectByVisibleText(productName);
                discount = 8;
            }else if (productName.equalsIgnoreCase("FamilyAlbum")){
                selectObj.selectByVisibleText(productName);
                discount = 15;
            }else if (productName.equalsIgnoreCase("ScreenSaver")){
                selectObj.selectByVisibleText(productName);
                discount = 10;
            }
        } else {
            discount = 0;
        }
        System.out.println("discount for " + quantity + " " + productName + " is " + discount + "%");
        return discount;


    }

    public void enterAddressInfo(){

        this.nameTextBox.sendKeys(faker.name().fullName());
        this.streetTextBox.sendKeys(faker.address().streetAddress());
        this.cityTextBox.sendKeys(faker.address().city());
        this.stateTextBox.sendKeys(faker.address().state());
        this.zipTextBox.sendKeys(faker.numerify("98###"));
    }

    public void enterPaymentInfo(String cardType){
        ////input[@type='radio' and @value='American Express']
       // WebElement radioButtonVisa = Driver.getDriver().findElement(By.xpath("//input[@type='radio' and @value='"+cardType+"']"));
       // WebElement radioButtonMasterCard = Driver.getDriver().findElement(By.id("//input[@type='radio' and @value='"+cardType+"']"));
        //WebElement radioButtonAmericanExpress = Driver.getDriver().findElement(By.id("//input[@type='radio' and @value='"+cardType+"']"));

        if(cardType.equals("Visa")){
            Driver.getDriver().findElement(By.xpath("//input[@type='radio' and @value='"+cardType+"']")).click();
        }else if (cardType.equals("Mastercard")){
            Driver.getDriver().findElement(By.xpath("//input[@type='radio' and @value='"+cardType+"']")).click();
        }else if(cardType.equals("American Express")){
            Driver.getDriver().findElement(By.xpath("//input[@type='radio' and @value='"+cardType+"']")).click();
        }

        this.cardNumber.sendKeys(faker.numerify("################"));
        this.expirationDate.sendKeys(faker.numerify("09/2#"));

    }

    public boolean submitAndVerify(){
        this.processBtn.click();
        BrowserUtility.waitFor(1);
        System.out.println("this.hasBeenProcessed.getText() = " + this.hasBeenProcessed.getText());


        if(this.hasBeenProcessed.getText().equals("New order has been successfully added.")){
            return true;
        }else {
            return false;
        }

    }

    public void fillForm(String productName, int quantity){
        Select selectObj = new Select(this.dropdown);
        selectObj.selectByVisibleText(productName);
        String quantStr = String.valueOf(quantity);

        this.quantityTextBox.clear();
        this.quantityTextBox.sendKeys(quantStr);


    }


}


