package com.cjc.export;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.cjc.model.Student;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportToPdf {

	public static ByteArrayInputStream StudentExport(List<Student> sList) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			PdfPTable table = new PdfPTable(8);
			table.setWidthPercentage(100);
			table.setWidths(new int[] { 5, 5, 5, 5, 5, 5, 5, 5 });

			Font headFont = FontFactory.getFont(FontFactory.COURIER_BOLD);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("id", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("uname", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("pass", headFont));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("name", headFont));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("mobno", headFont));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("pincode", headFont));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("areaname", headFont));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("cityname", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(hcell);

			for (Student ss : sList) {
				PdfPCell cell;

				cell = new PdfPCell(new Phrase(String.valueOf(ss.getId())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(ss.getUname()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(ss.getPass()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(ss.getName()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(ss.getMobno()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(ss.getAddress().getPincode()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(ss.getAddress().getAreaname()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(ss.getAddress().getCityname()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			}

			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);
			document.close();

		}
		catch (DocumentException e) {
			e.printStackTrace();
		}

		return new ByteArrayInputStream(out.toByteArray());
	}

}
