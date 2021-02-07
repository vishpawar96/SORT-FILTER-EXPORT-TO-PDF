package com.cjc.export;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cjc.model.Student;

public class ExportToExcel {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<Student> sList;

	public ExportToExcel(List<Student> sList) {
		this.sList = sList;
		workbook = new XSSFWorkbook();
	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Students");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		font.setItalic(true);
		style.setFont(font);

		createCell(row, 0, "ID", style);
		createCell(row, 1, "Uname", style);
		createCell(row, 2, "Pass", style);
		createCell(row, 3, "Name", style);
		createCell(row, 4, "Mob No", style);
		createCell(row, 5, "Pincode", style);
		createCell(row, 6, "Area Name", style);
		createCell(row, 7, "City Name", style);

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		}
		else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		}
		else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void writeDataLines() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Student ss : sList) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, ss.getId(), style);
			createCell(row, columnCount++, ss.getUname(), style);
			createCell(row, columnCount++, ss.getPass(), style);
			createCell(row, columnCount++, ss.getName(), style);
			createCell(row, columnCount++, ss.getMobno(), style);
			createCell(row, columnCount++, ss.getAddress().getPincode(), style);
			createCell(row, columnCount++, ss.getAddress().getAreaname(), style);
			createCell(row, columnCount++, ss.getAddress().getCityname(), style);

		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}

}
