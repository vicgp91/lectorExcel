package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import modelos.CarneInfo;

public class LectorExcel {

	public List<CarneInfo> covertExcel(File rutaExcel) {
		List<CarneInfo> listaCar = new ArrayList<CarneInfo>();

		try {
			FileInputStream file = new FileInputStream(rutaExcel);
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row;
			Integer i;
			while (rowIterator.hasNext()) {
				i = 1;
				CarneInfo infoCar = new CarneInfo();
				row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell celda;
				while (cellIterator.hasNext()) {
					celda = cellIterator.next();

					switch (i) {
					case 1:
						infoCar.setCedula(celda.toString());
						break;
					case 2:
						infoCar.setNombre(celda.toString());
						break;

					case 3:
						infoCar.setApellido(celda.toString());
						break;
					case 4:

						infoCar.setAño(celda.toString());
						break;
					}
					i++;
				}
				listaCar.add(infoCar);
				System.out.println(infoCar.getCedula()+" "+infoCar.getNombre()+" "+infoCar.getApellido()+" "+infoCar.getAño());
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			System.out.println("Documento no encontrado " + e.toString());
			e.printStackTrace();
		} catch (IOException IOe) {
			System.out.println("ERROR " + IOe.toString());
		}

		listaCar.remove(0);// Elimina el encabezado
		return listaCar;
	}

	/*
	 * public CarneInfo covertExcel(File rutaExcel) { try { FileInputStream file
	 * = new FileInputStream(rutaExcel); XSSFWorkbook workbook = new
	 * XSSFWorkbook(file);
	 * 
	 * XSSFSheet sheet = workbook.getSheetAt(0); Iterator<Row> rowIterator =
	 * sheet.iterator(); Row row; while (rowIterator.hasNext()) { row =
	 * rowIterator.next(); Iterator<Cell> cellIterator = row.cellIterator();
	 * Cell celda; while (cellIterator.hasNext()) { celda = cellIterator.next();
	 * 
	 * switch (celda.getCellType()) { case Cell.CELL_TYPE_NUMERIC: if
	 * (DateUtil.isCellDateFormatted(celda)) {
	 * System.out.println("CELL_TYPE_NUMERIC"+celda.getDateCellValue()); } else
	 * { System.out.println("else CELL_TYPE_NUMERIC"
	 * +celda.getNumericCellValue()); } break; case Cell.CELL_TYPE_STRING:
	 * System.out.println("CELL_TYPE_STRING "+celda.getStringCellValue());
	 * break; case Cell.CELL_TYPE_BOOLEAN: System.out.println(
	 * "CELL_TYPE_BOOLEAN "+celda.getBooleanCellValue()); break; } } }
	 * workbook.close(); } catch (FileNotFoundException e) { System.out.println(
	 * "Documento no encontrado " + e.toString()); e.printStackTrace(); } catch
	 * (IOException IOe) { System.out.println("ERROR " + IOe.toString()); }
	 * 
	 * return null; }
	 */

}
