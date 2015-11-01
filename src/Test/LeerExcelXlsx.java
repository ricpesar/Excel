/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerExcelXlsx {

    public static void main(String args[]) throws IOException{
	FileInputStream file = new FileInputStream(new File("C:\\Users\\f2 a55m-s1\\Documents\\baseSqlLite\\Libro1.xlsx"));
	// Crear el objeto que tendra el libro de Excel
	XSSFWorkbook workbook = new XSSFWorkbook(file);

	/*
	 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
	 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator
	 * que nos permite recorrer cada una de las filas que contiene.
	 */
	XSSFSheet sheet = workbook.getSheetAt(0);
	Iterator<Row> rowIterator = sheet.iterator();

	Row row;        
	// Recorremos todas las filas para mostrar el contenido de cada celda
	while (rowIterator.hasNext()){
	    row = rowIterator.next();

	    // Obtenemos el iterator que permite recorres todas las celdas de una fila
	    Iterator<Cell> cellIterator = row.cellIterator();
	    Cell celda;

	    while (cellIterator.hasNext()){
		celda = cellIterator.next();

		// Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
		switch(celda.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
		    if( DateUtil.isCellDateFormatted(celda) ){
		       System.out.print(celda.getDateCellValue());
		    }else{
		       System.out.print(celda.getNumericCellValue());
		    }
		    break;
		case Cell.CELL_TYPE_STRING:
		    System.out.print(celda.getStringCellValue());
		    break;
		case Cell.CELL_TYPE_BOOLEAN:
		    System.out.print(celda.getBooleanCellValue());
		    break;
		}
	    }
            System.out.println("");
	}

	// cerramos el libro excel
	workbook.close();
    }

}

