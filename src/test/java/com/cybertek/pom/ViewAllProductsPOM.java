package com.cybertek.pom;

import com.cybertek.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewAllProductsPOM {

    @FindBy (xpath = "//table/tbody/tr/td/div/table/tbody/tr[2]/td" )
    public WebElement firstColumn;

    @FindBy (xpath = "//table/tbody/tr/td/div/table/tbody/tr[3]/td")
    public WebElement secondColumn;

    @FindBy (xpath = "//table/tbody/tr/td/div/table/tbody/tr[4]/td")
    public WebElement thirdColmn;


    public ViewAllProductsPOM(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    public boolean getAllProducts(){

        List<String> list = new ArrayList<>();
        list.add(this.firstColumn.getText());
        list.add(this.secondColumn.getText());
        list.add(this.thirdColmn.getText());


        ArrayList arr = new ArrayList(Arrays.asList("MyMoney","FamilyAlbum","ScreenSaver"));
        if(list.equals(arr)){
            return true;
        }else {
            return false;
        }

    }


}
