package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains excel file specific methods
 * @author vikram
 *
 */
public class ExcelFileUtility {

	/**
	 * This method will read data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return cell value as String
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {

		try (FileInputStream fis = new FileInputStream(ConstantsUtility.excelfilepath);
				Workbook wb = WorkbookFactory.create(fis)) {

			Sheet sh = wb.getSheet(sheetName);
			if (sh == null) {
				throw new IllegalArgumentException("Sheet not found : " + sheetName);
			}

			Row rw = sh.getRow(rowNum);
			if (rw == null) {
				throw new IllegalArgumentException(
						"Row " + rowNum + " not found in sheet " + sheetName);
			}

			Cell ce = rw.getCell(cellNum);
			if (ce == null) {
				throw new IllegalArgumentException(
						"Cell " + cellNum + " not found in row " + rowNum);
			}

			return ce.getStringCellValue();
		}
	}

	/**
	 * This method will set data into excel, editing the target cell in place
	 * without disturbing other cells/rows in the sheet.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, int rowNum, int cellNum, String value)
			throws EncryptedDocumentException, IOException {

		Workbook wb;

		// Read the full workbook into memory first, then close the input
		// stream before writing, since reading and writing the same file
		// path concurrently can corrupt it or throw a file-lock error.
		try (FileInputStream fis = new FileInputStream(ConstantsUtility.excelfilepath)) {
			wb = WorkbookFactory.create(fis);
		}

		Sheet sh = wb.getSheet(sheetName);
		if (sh == null) {
			wb.close();
			throw new IllegalArgumentException("Sheet not found : " + sheetName);
		}

		// Get-or-create: never blow away an existing row's other cells
		Row rw = sh.getRow(rowNum);
		if (rw == null) {
			rw = sh.createRow(rowNum);
		}

		Cell ce = rw.getCell(cellNum);
		if (ce == null) {
			ce = rw.createCell(cellNum);
		}

		ce.setCellValue(value);

		try (FileOutputStream fos = new FileOutputStream(ConstantsUtility.excelfilepath)) {
			wb.write(fos);
		} finally {
			wb.close();
		}
	}

	/**
	 * Reads all data rows (excluding header row 0) from a sheet.
	 * @param sheetName
	 * @return 2D array of cell values as Strings
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName)
			throws EncryptedDocumentException, IOException {

		try (FileInputStream fis = new FileInputStream(ConstantsUtility.excelfilepath);
				Workbook wb = WorkbookFactory.create(fis)) {

			Sheet sh = wb.getSheet(sheetName);
			if (sh == null) {
				throw new IllegalArgumentException("Sheet not found : " + sheetName);
			}

			// getLastRowNum() is a zero-based index; the actual number of
			// data rows (excluding the header at row 0) is lastRowNum.
			int lastRowNum = sh.getLastRowNum();
			int lastCellNum = sh.getRow(0).getLastCellNum();

			Object[][] data = new Object[lastRowNum][lastCellNum];

			for (int i = 0; i < lastRowNum; i++) {

				Row row = sh.getRow(i + 1);

				for (int j = 0; j < lastCellNum; j++) {

					if (row != null && row.getCell(j) != null) {
						data[i][j] = row.getCell(j).getStringCellValue();
					} else {
						data[i][j] = "";
					}
				}
			}

			return data;
		}
	}

	/**
	 * Reads a single column's data (excluding header row) from a sheet.
	 * @param filePath path to the excel file to read from
	 * @param sheetName
	 * @param columnIndex
	 * @return column values as a String array, or null if reading failed
	 */
	public static String[] getSingleColumnData(String filePath, String sheetName, int columnIndex) {

		String[] data = null;

		try (FileInputStream fis = new FileInputStream(filePath);
				Workbook wb = WorkbookFactory.create(fis)) {

			Sheet sheet = wb.getSheet(sheetName);
			if (sheet == null) {
				throw new IllegalArgumentException("Sheet not found : " + sheetName);
			}

			int rowCount = sheet.getLastRowNum();
			data = new String[rowCount];

			for (int i = 1; i <= rowCount; i++) {

				Row row = sheet.getRow(i);

				if (row != null && row.getCell(columnIndex) != null) {
					data[i - 1] = row.getCell(columnIndex).toString();
				} else {
					data[i - 1] = "";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}
}
