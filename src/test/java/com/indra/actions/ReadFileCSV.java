package com.indra.actions;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFileCSV {
    private BufferedReader reader;
    private String line;
    private String parts[]= null;
    public ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    public void readFile(String rutaArchivo){
        try {
            reader = new BufferedReader(new FileReader(rutaArchivo));
            while((line = reader.readLine())!=null){
                parts = line.split(";");
                ArrayList<String> temporaryData = new ArrayList<>();
                for (String d: parts){
                    temporaryData.add(d);
                }
                data.add(temporaryData);
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        //System.out.println(datos.get(1).get(0));
    }
}
