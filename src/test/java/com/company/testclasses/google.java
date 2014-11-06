package com.company.testclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.company.util.excel;

public class google {
	
private WebDriver driver = new FirefoxDriver();
	
	
	@BeforeTest
	public void setUp(){
	System.out.print("flow has started");
	driver.manage().window().maximize();
	}
	
	@Test(enabled = true)
	public void googlePage() throws Exception{
		excel excel1 = new excel();
		excel1.setExcel("C://Users//admin//workspace//web//src//test//resources//data//excel.xls", "Sheet2");
		driver.get("https://www.google.com");
		WebElement googlefield = driver.findElement(By.xpath("//input[@id = 'gbqfq']"));
		int noOfRows = excel1.totalRows();
		for (int rows=1; rows <= noOfRows; rows++){
				String frst = excel1.getcellvalue(rows,1);
				if(!frst.isEmpty()){
					
					googlefield.sendKeys(frst);
				}

}
	}

@AfterTest
public void Quit(){
System.out.print("flow has stopped");
driver.quit();
}
}
