package processorpackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ValidateAndRead {
	String ans="";
	String error = "";
	public String validatenRead(String ext, FileInputStream fileInputStream) throws IOException{
	
		HSSFWorkbook hssfWorkbook;
		HSSFSheet hssfSheet;
		XSSFWorkbook xssfWorkbook;
		XSSFSheet xssfSheet;
		Iterator<Row> row;
		if (ext.compareTo("xls") == 0) {
			hssfWorkbook = new HSSFWorkbook(fileInputStream);
			hssfSheet = hssfWorkbook.getSheetAt(0);
			row = hssfSheet.iterator();
		} else {
			xssfWorkbook = new XSSFWorkbook(fileInputStream);
			xssfSheet = xssfWorkbook.getSheetAt(0);
			row = xssfSheet.iterator();

		}
		int ro = 0;

		// Iterator<Row> row = hssfSheet.iterator();
		int flag = 0;
		while (row.hasNext()) {
			Row r = row.next();
			System.out.println("Row " + ro);
			ro++;
			Iterator<Cell> celliterator = r.iterator();
			int c = 0;
			while (celliterator.hasNext()) {

				c++;
				System.out.println("Cell " + c);
				Cell cell = celliterator.next();

				int type = cell.getCellType();
				if (flag == 0) {
					if (type == Cell.CELL_TYPE_STRING) {
						System.out.println(cell.getRichStringCellValue());
						//ans=ans+cell.getRichStringCellValue()+"|";
					} else {
						error = error + "|Heading of the Excel Column in String at cell number" + c + " at row " + ro
								+ " |";
					}
				} else {

					if (c == 1) {
						System.out.println(cell.getNumericCellValue());
						int t=(int)cell.getNumericCellValue();
						ans=ans+t+"|";
						isNumber(type, ro, c);
					} else if (c == 2 || c == 3 || c == 4 || c == 5) {

						System.out.println(cell.getRichStringCellValue());
						ans=ans+cell.getRichStringCellValue()+"|";
						isBlank(type, ro, c);
					}

					else if (c == 6) {
						isNumber(type, ro, c);
						if (type == Cell.CELL_TYPE_NUMERIC && (!(type == Cell.CELL_TYPE_BLANK))) {
							int t = (int) cell.getNumericCellValue();
							System.out.println(t);
							ans=ans+t+"|";
							if (t > 24 || t < 22) {
								error = error + "The age at cell " + c + " row " + ro + " should be between 22 and 24|";
							}

						}
					} else if (c == 7) {
						isNumber(type, ro, c);
						// System.out.println(cell.getNumericCellValue());
						if (type == Cell.CELL_TYPE_NUMERIC && (!(type == Cell.CELL_TYPE_BLANK))) {
							int t = (int) cell.getNumericCellValue();
							System.out.println(t);
							ans=ans+t+"|";
							if (t < 2014 || t > 2017) {
								error = error + "The passing year at cell " + c + " row " + ro
										+ " should be between 2014 and 2017|";
							}
						}
					}
				}

			}
			flag = 1;
		}
		return error;
		
	}
	
	protected void isString(int type, int ro, int c) {

		if (!(type == Cell.CELL_TYPE_STRING)) {
			error = error + "The cell at row " + ro + " cell " + c + " should be string|";
		}
		if ((type == Cell.CELL_TYPE_BLANK)) {
			error = error + "The cell at row " + ro + " cell " + c + " cannot be blank|";
		}

	}

	protected void isNumber(int type, int ro, int c) {

		if (!(type == Cell.CELL_TYPE_NUMERIC)) {
			error = error + "The cell at row " + ro + " cell " + c + " should be number|";
		}

		if ((type == Cell.CELL_TYPE_BLANK)) {
			error = error + "The cell at row " + ro + " cell " + c + " cannot be blank|";
		}

	}

	protected void isBlank(int type, int ro, int c) {

		if ((type == Cell.CELL_TYPE_BLANK)) {
			error = error + "The cell at row " + ro + " cell " + c + " cannot be blank|";
		}

	}
}
