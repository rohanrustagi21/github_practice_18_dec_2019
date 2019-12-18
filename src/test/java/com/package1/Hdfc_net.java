package com.package1;

 import java.util.Iterator;

import java.util.Set;

import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

 

public class Hdfc_net {

   WebDriver driver;

   @Test

   public void hdfc_frame() throws Exception {

      System.setProperty("webdriver.chrome.driver", "C://driver9999//chromedriver.exe");

 

      //Create Browser object

      driver = new ChromeDriver();

   driver.get("https://netbanking.hdfcbank.com/netbanking/");

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

   //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.manage().window().maximize();

 

   //driver.get("https://netbanking.hdfcbank.com/netbanking/");

      Thread.sleep(2000);

      int total_frame = driver.findElements(By.tagName("frame")).size();

      System.out.println("Total frames - "+ total_frame);

 

      //driver.switchTo().frame("login_page");// switch to first frame

      driver.switchTo().frame(0);

   driver.findElement(By.name("fldLoginUserId")).sendKeys("444378");

      driver.switchTo().defaultContent();

      driver.switchTo().frame("footer");// switch to first frame

 

      driver.findElement(By.linkText("Privacy Policy")).click();

      Set<String> winIds = driver.getWindowHandles();

 

 

      Iterator<String> it = winIds.iterator();

      System.out.println("Total windows - "+ winIds.size());

 

      String parentwindow = it.next();

String childwindow = it.next();

System.out.println(parentwindow);

System.out.println(childwindow);

driver.switchTo().window(childwindow);

   driver.findElement(By.linkText("Personal")).click();

      String str1=driver.getTitle();

      System.out.println(str1);

 

 

      //driver.switchTo().defaultContent();

      Thread.sleep(2000);

 

      driver.switchTo().window(parentwindow);

      driver.switchTo().frame(0);

      //                    driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[2]/table/tbody/tr[6]/td[2]/a/img")).click();

   driver.findElement(By.xpath("//img[@alt='continue']")).click();

   


}
 
}










