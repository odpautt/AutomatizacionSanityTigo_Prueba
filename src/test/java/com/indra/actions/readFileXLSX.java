package com.indra.actions;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class readFileXLSX {
    public ArrayList<ArrayList<String>> excelArray = new ArrayList<>();

    public void readFileExcel(){
        try {
            FileInputStream f = new FileInputStream("C:\\Repo\\serviciosRest_Assured\\src\\test\\resources\\config_access\\excelito.xlsx");
            XSSFWorkbook libro = new XSSFWorkbook(f);
            XSSFSheet hoja = libro.getSheetAt(0);
            Iterator<Row> filas = hoja.iterator();
            Iterator<Cell> celdas;
            Row fila;
            Cell celda;
            while (filas.hasNext()){
                fila=filas.next();
                celdas = fila.cellIterator();
                ArrayList<String> temporaryData = new ArrayList<>();
                while (celdas.hasNext()){
                    celda = celdas.next();

                    switch (celda.getCellType()) {
                        case STRING:
                            temporaryData.add(celda.getStringCellValue());
                            System.out.print(celda.getStringCellValue()+"  |  ");
                            break;
                        case NUMERIC:
                            int num = (int) celda.getNumericCellValue();
                            temporaryData.add(String.valueOf(num));
                            System.out.print(num+"  |  ");
                            break;
                    }

                }
                excelArray.add(temporaryData);
                System.out.println();
            }
        libro.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(excelArray.get(4).get(5));
    }
}
