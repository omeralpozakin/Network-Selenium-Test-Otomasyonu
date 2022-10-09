package com.network.pages;

import com.network.method.Methods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;


import static com.network.driver.Driver.driver;

public class GuestPage {
    By guestPageUniqueElement = By.xpath("//strong[text()=\"#SocialNetWork\"]"); // anasayfada olup olmadığımızı kontrol etmek için anasayfada unique olan bir elementin (text olarak anasayfada belirtiler #SocialNetWork yazısı) varlığını xpath aracılığıyla kontrol ettik.
    By searchBox = By.id("search");

    By url = By.linkText("https://www.network.com.tr"); // silinebilir


    Methods method = new Methods();
    public void isGuestPage(){
        // Assertions.assertTrue(method.isElementVisible(guestPageUniqueElement,10),"Anasayfada belirlediğimiz kontrol elementini görüntüleyemedik yani ANASAYFADA DEĞİLİZ");
        //String element = driver.findElement(url).getText();
        //Assertions.assertEquals(element,"https://www.network.com.tr");
        // String Actualtext = driver.findElement(By.linkText("https://www.network.com.tr/")).getText();
        //Assert.assertEquals(Actualtext, "https://www.network.com.tr/" );
        //System.out.println("URL matching --> Part executed");
        // FARKLI ŞEKİLLERDE DENEMEME RAĞMEN EN SON AÇIK KAYNAKTAN BULDUĞUM SELENİUM'DA TANIMLI BİR METHOD SAYESİNDE URL CHECK YAPABİLDİM.
        String URL = driver.getCurrentUrl(); Assertions.assertEquals(URL, "https://www.network.com.tr/" );
    }
    public void searchWord(){
        Assertions.assertTrue(method.isElementClickable(searchBox,10),"SEARCH BOX BULUNAMADI");
        method.clickElement(searchBox);
        method.sendText(searchBox,"ceket");
        driver.findElement(searchBox).submit();
    }

}
