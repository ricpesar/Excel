/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author f2 a55m-s1
 */
public class Excel {

    private final String nombreArchivo;
    private final String pathArchivo;
    private Map<Integer, List> datos;
    private HSSFWorkbook workbook;

    private Excel(String nombreArchivo, String pathArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.pathArchivo = pathArchivo;
    }

    public static Excel instanciar(String nombreArchivo, String pathArchivo) {
        return new Excel(nombreArchivo, pathArchivo);
    }

    public Map<Integer, List> getInformacion(int indiceHoja) {
        leerArchivo(indiceHoja);
        return this.datos;
    }

    private boolean abrirArchivo() {
        FileInputStream file;
        try {
            file = new FileInputStream(new File(pathArchivo + "\\" + nombreArchivo));
            workbook = new HSSFWorkbook(file);
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel2007.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Excel2007.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean cerrarArchivo() {
        try {
            workbook.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Excel2007.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void leerArchivo(int indiceHoja) {
        abrirArchivo();
        this.datos = new HashMap<>();      
        HSSFSheet sheet = workbook.getSheetAt(indiceHoja);
        Iterator<Row> rowIterator = sheet.iterator();
        int fila = 0;
        Row row;

        while (rowIterator.hasNext()) {
            List<Object> datosFila = new ArrayList<>();
            Cell celda;
            row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Object dato = null;
                celda = cellIterator.next();
                switch (celda.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(celda)) {
                            System.out.print(celda.getDateCellValue());
                            dato = celda.getDateCellValue();
                        } else {
                            System.out.print(celda.getNumericCellValue());
                            dato = celda.getNumericCellValue();
                        }
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(celda.getStringCellValue());
                        dato = celda.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(celda.getBooleanCellValue());
                        dato = celda.getBooleanCellValue();
                        break;
                }
                datosFila.add(dato);
            }
            datos.put(fila++, datosFila);
            System.out.println("");
        }
        cerrarArchivo();
    }
}
