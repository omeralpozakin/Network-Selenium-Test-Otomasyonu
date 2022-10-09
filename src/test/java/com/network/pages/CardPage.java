package com.network.pages;

import com.network.method.Methods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.network.driver.Driver.driver;


public class CardPage {
    Methods method = new Methods();
    By cardPriceValue = By.xpath("//div//span[text()='3.149,00 TL']");
    By orderPriceValue = By.xpath("//div//div[text()=\" 3.149,00 TL \"]");
    By continueShopping = By.xpath("//button[@type=\"button\"][@class=\"continueButton n-button large block text-center -primary\"]");
    By mail = By.xpath("//input[@class=\"input js-trim\"]");
    By password = By.xpath("//input[@type=\"password\"]");
    By networkLogo = By.xpath("//a[@class=\"headerCheckout__logo\"]");
    By shoppingBasket = By.className("\"header__basketTrigger js-basket-trigger -desktop\"");
    By clearShoppingBasket = By.className("\"header__basketProductRemove\"");
    By controlTheShoppingBasket = By.xpath("//div//span[text()=\"Sepetiniz Henüz Boş\"]");
    By approveToClear = By.className("\"btn -black o-removeCartModal__button\"");

    public void checkTheValues(){
        String element = driver.findElement(cardPriceValue).getText();
        String element1 = driver.findElement(orderPriceValue).getText();
        if (element1.equals(element)){
            System.out.println("ÜRÜN FİYATI VE SEPETTEKİ DEĞERİ BİRBİRİNE EŞİTTİR");
        }
    }
    public void continueShopping(){
        method.clickElement(continueShopping);
        System.out.println("CSV FORMATINDA EXELL'DEN VERİ ÇEKMEYE HAKİM OLMADIĞIM İÇİN BİLGİLERİ MANUEL OLARAK ATADIM");
        method.waitSecond(15);
    }
    public void loginIdPassword(){
        method.clickElement(mail);
        method.sendText(mail,"omeralpozakin@gmail.com");
        method.clickElement(password);
        method.sendText(password,"123456789");
    }


    public void clickLogo(){
        method.clickElement(networkLogo);
    }



    public void shppingBasket(){
        method.clickElement(shoppingBasket);
    }


    public void clearShoppingBasket(){
        method.clickElement(clearShoppingBasket);
        method.waitSecond(2);
        method.clickElement(approveToClear);
    }
    public void controlTheShoppingBasket(){
        method.clickElement(shoppingBasket);
        Assertions.assertTrue(method.isElementVisible(controlTheShoppingBasket,3), "SEPETİNİZ BOŞ DEĞİL");
    }
}
