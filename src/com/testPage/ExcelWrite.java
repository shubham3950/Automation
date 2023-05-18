package com.testPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

public static void putCellValue(String sheetName,String value) throws IOException {

try {
FileInputStream fp = new FileInputStream("C:\\Users\\929083\\OneDrive - Cognizant\\Desktop\\demo\\PetCo\\Excel\\petCo.xlsx");
File f = new File("C:\\Users\\929083\\OneDrive - Cognizant\\Desktop\\demo\\PetCo\\Excel\\petCo.xlsx");
XSSFWorkbook workBook = new XSSFWorkbook(fp);
XSSFSheet sheet = workBook.getSheet(sheetName);
sheet.createRow(0).createCell(0).setCellValue(value);
FileOutputStream fo= new FileOutputStream(f);
workBook.write(fo);




} catch (FileNotFoundException e) {

e.printStackTrace();
}

}

}