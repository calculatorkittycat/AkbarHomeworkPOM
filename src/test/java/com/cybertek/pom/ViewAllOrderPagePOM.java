package com.cybertek.pom;

import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewAllOrderPagePOM {



    @FindBy (xpath = "//h2[normalize-space(.)='List of All Orders']")
    public WebElement header;

    @FindBy (xpath = "//*[@id=\"ctl00_MainContent_btnCheckAll\"]")
    public WebElement checkAllButton;

    @FindBy (xpath =  "//input[@type='checkbox']")
    public WebElement allCheckBoxes;

    public void ViewAllOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public boolean isAtViewAllOrderPage(){
        boolean result = false;




        try {
//            WebElement header = driverParam.findElement(By.xpath("//h2[normalize-space(.)='List of All Orders']"));
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(this.header))));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space(.)='List of All Orders']")));
            System.out.println("ELEMENT WAS IDENTIFIED ");
//            System.out.println("header.isDisplayed() = " + header.isDisplayed());
            result = true;
//        }catch (NoSuchElementException e){
        } catch (TimeoutException e) {
            System.out.println("you are not at the right page");
        }

        return result;

    }

    public void testCheckBoxButton(){
       this.checkAllButton.click();
    }

    public void checkAll() {
        //   xpath =     //input[@type='checkbox']     1/8 found

        this.checkAllButton.click();
        /*
        BrowserUtility.waitFor(2);
        int selectec = 0;

        for (int i = 0; i < 9; i++) {
            if(this.checkAllButton.isSelected())
                selectec++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(selectec == 8){
            return true;
        }else{
            return false;
        }
    }

         */


    }
}


