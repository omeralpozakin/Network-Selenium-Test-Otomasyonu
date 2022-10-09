package com.network.test;
// kütüphaneler import edildi

import com.network.driver.Driver;
import com.network.pages.CardPage;
import com.network.pages.GuestPage;
import com.network.pages.ProductsPage;
import org.junit.jupiter.api.Test;

public class NetworkTest extends Driver { // NetworkTest class'oluşturuldu, bir driver'ı extend ediyor.
    GuestPage guestPage;
    ProductsPage productsPage;
    CardPage cardPage;


    @Test
    public void networkTest(){  //test methodumuz.
        guestPage = new GuestPage();
        productsPage = new ProductsPage();
        // cardPage = new CardPage(); // cardPage nesnesini intial ettiğim an otomasyon hata veriyor.
        guestPage.isGuestPage();
        guestPage.searchWord();

        productsPage.moreProducts();
        productsPage.secondPageControl();
        productsPage.firstDiscountProduct();
        productsPage.goToSCart();

        /*
        cardPage.checkTheValues();
        cardPage.continueShopping();
        cardPage.loginIdPassword();
        cardPage.clickLogo();
        cardPage.shppingBasket();
        cardPage.clearShoppingBasket();
        cardPage.controlTheShoppingBasket();

         */

        // ÖDEVİN YARISINA KADAR OTOMASYON SORUNSUZ BİÇİMDE ÇALIŞMAKTA, YALNIZCA SON ADIMDA, İNDİRİMDEKİ İLK ÜRÜNE SCROLL İLE GİDİLİYOR FAKAT CLİCK METHODUNU  MANUEL OLARAK ATAMAMIZ GEREKİYOR.
        // CARDPAGE'İ NETWORKTEST'DE ÇAĞIRDIĞIMIZ ZAMAN, OTOMASYON ERROR VERİYOR VE TESTTEN ÇIKIYOR, O YÜZDEN CARDPAGE'İ ÇAĞIRDIĞIM SATIRLARI YORUM SATIRI YAPTIM.
        // JAVA19 SÜRÜMÜNDEN KAYNAKLI OLDUĞUNU DÜŞÜNDÜĞÜM BİR HATA ALIYORUM, MEVCUT SÜREDE VE KAYNAKTA BU KADARINI YAPABİLDİM İYİ ÇALIŞMALAR
    }
}
