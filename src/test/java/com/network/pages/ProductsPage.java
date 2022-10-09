package com.network.pages;

import com.network.method.Methods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.network.driver.Driver.driver;

public class ProductsPage {
    Methods method = new Methods();
    By endScroll = By.xpath("//button[@class=\"button -secondary -sm relative\"]");
    public void moreProducts(){
        method.scrollElement(endScroll);
        method.waitSecond(1); // "Daha fazla göster" butonuna kadar scroll yapılıp 5 saniye beklendi (long tipinde)
        method.clickElement(endScroll);
        method.waitSecond(2); // "Daha fazla göster" butonuna bastıktan sonra 7 saniye beklendi (long tipinde)
        // otomasyonun manuel takibi açısından bekleme sürelerini uzun tuttum.

    }
    public void secondPageControl(){
        String URL = driver.getCurrentUrl(); Assertions.assertEquals(URL, "https://www.network.com.tr/search?searchKey=ceket&page=2" );
    }
    By productSize = By.xpath("(//span[@class=\"product__price -label -old -size\"])[1]");
    public void firstDiscountProduct(){
        method.scrollElement(productSize);
        method.waitSecond(0); // İlk indirimli ürüne gittim fakat, random methodları yazarak parent üzerinden beden seçimi yapamadım
        // bu etapta bekleme süresini 15 saniyeye çıkartarak testin bu kısmını manuel olarak gerçekleştirdim.
        // method.hoverElement(productSize);
        // method.randomSelect(productSize);
    }
    By button = By.xpath("(//a[@href=\"/cart\"])[2]");
    public void goToSCart(){
        // method.clickElement(button);
        method.setFluentWait(15).until(ExpectedConditions.elementToBeClickable(button)).click();
        System.out.println("BEDEN SEÇİMİ MANUEL OLARAK YAPILDI ÇÜNKÜ PARRENT VE RANDOM KULLANARAK STOKTAKİ BEDENİ SEÇME AŞAMASINDA HATALAR ALDIM");
    }

}
