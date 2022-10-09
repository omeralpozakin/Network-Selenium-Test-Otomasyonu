package com.network.driver;

import com.network.testlogs.TestResultLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver; //public static bir web driver nesnesi oluşturuyoruz. BeforeAll AND AfterALL
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@ExtendWith(TestResultLogger.class)
public class Driver {
    public static WebDriver driver; // static tanımlıyoruz çünkü daha sonra static olarak çağırıp dinamik parametre almasını istemediğimiz için.
    @BeforeAll // junit notasyonları
    public static void driverPlace(){
        System.out.println("TESTİMİZİ BAŞLATIYORUM");
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe"); // driver'ımıza chrome driver özelliği ekliyoruz ve projemizde bulunan yolu belirtiyoruz.
    }
    @BeforeEach // test boyunca her adımda yapacağımız chrome driverımızın başlangıçtaki özelliklerini tanımlıyoruz, nasıl açılacağı veya ne kadar süre döneceği vb.
    public void driverBegin(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.network.com.tr/"); // driver'ımızın gideceği adresi belirttik.
    }
    @AfterAll // tüm testin sonunda yapılacak işlem ve isteğe göre konsola bir çıktı çıkarıyoruz.
    public static void finishtime(){
        driver.quit(); // driver'dan çıkıyoruz
        System.out.println("TESTİMİZİ BİTİRİYORUM"); // console'a yazdırdığımız çıktı.
    }
}
