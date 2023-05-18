package com.testPage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.utilities.WrapperClass;

public class PetCoPage extends WrapperClass {

WebDriver driver;
String sheetName="petCo";
 
public PetCoPage(WebDriver driver) {
this.driver = driver;

}

public void dog() throws InterruptedException {
Thread.sleep(2000);
Actions action = new Actions(driver);

//action.moveToElement(driver.findElement(By.xpath("//*[@id='shop-by-pet']"))).build().perform();
driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/header/div[3]/div/nav[1]/div[3]/button")).click();
Thread.sleep(2000);
//action.moveToElement(driver.findElement(By.linkText("Dog"))).build().perform();
driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/header/div[3]/div/nav[1]/div[3]/div/div/ul/li[3]/button")).click();
Thread.sleep(1000);


action.moveToElement(driver.findElement(By.linkText("Veterinary Diets"))).click().build().perform();

Thread.sleep(1000);
}

public void sortByTopRated() throws InterruptedException {
//Select select = new Select( driver.findElement(By.id("product-listing-sort-by_4_3074457345618259661_4099276460824412685")));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)","");
	Thread.sleep(1000);
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.linkText("Most Popular"))).click().build().perform();
	action.moveToElement(driver.findElement(By.linkText("Top Rated"))).click().build().perform();
//select.selectByValue("1");
	
Thread.sleep(2000);

String nameOfSecodProduct=driver.findElement(By.linkText("blue buffalo blue natural veterinary diet ")).getText();
System.out.println("name of the second product after sortung A to Z :::::::::::::"+nameOfSecodProduct);
String price= driver.findElement(By.xpath("//span[contains(text(),'$92.99')]")).getText();
System.out.println("price of the product ::::::::::::::::::::::::"+price);


}
public void priceSort() throws InterruptedException {
driver.findElement(By.xpath("//span[contains(text(),'$10 to $25')]")).click();
Thread.sleep(2000);

}
public void writeExcel() throws IOException {
String value=driver.findElement(By.linkText("instinct freeze dried raw meals grain free cage free chicken recipe dry food by natures variety")).getText();
ExcelWrite ew= new ExcelWrite();
ew.putCellValue(sheetName, value);


}


}
