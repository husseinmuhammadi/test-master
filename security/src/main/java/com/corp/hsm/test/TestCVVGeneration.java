package com.corp.hsm.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.jpos.core.SimpleConfiguration;
import org.jpos.iso.packager.DummyPackager;

import com.edp.data.DataMgr;
import com.en.datavsn.EFTswitch.codec.Parser;
import com.en.datavsn.EFTswitch.hsm.HSMChannel;
import com.en.datavsn.EFTswitch.hsm.RacalCommands;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestCVVGeneration {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		DataMgr dataMgr = new DataMgr();		

		HSMChannel hsm = HSM.getHSMChannelInstanse();

		List<CardData> cardList = readExcelFile("card-gen.xls");
		// List<CardData> cardList = readSampleCard();

		HSMCommands commands = new HSMCommands(hsm);

		for (CardData cardData : cardList) {
			String cvv1 = commands.generateCvv1(cardData.getCardNumber(), cardData.getExpDate());
			cardData.setCvv1(cvv1);

			String cvv2 = commands.generateCvv2(cardData.getCardNumber(), cardData.getExpDate());
			cardData.setCvv2(cvv2);

			String track2Data = commands.generateTrack2Data(cardData.getCardNumber(), cardData.getExpDate());
			cardData.setTrack2Data(track2Data);
		}		

		writeExcelFile("card-gen-out.xlsx", cardList);

	}

	private static void writeExcelFile(String fileName, List<CardData> cardList) {
		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Card Data");

		int rownum = 0;

		WriteRow(sheet, rownum++, CardData.getHeaders());

		for (CardData cardData : cardList) {
			WriteRow(sheet, rownum++, cardData.getValues());
		}

		try {
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(fileName));
			workbook.write(out);
			out.close();
			System.out.println(fileName + " written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void WriteRow(XSSFSheet sheet, int rownum, Object[] values) {
		Row row = sheet.createRow(rownum);
		int cellnum = 0;
		for (Object obj : values) {
			Cell cell = row.createCell(cellnum);
			if (obj instanceof String)
				cell.setCellValue((String) obj);
			else if (obj instanceof Integer)
				cell.setCellValue((Integer) obj);
			else if (obj instanceof Date)
				cell.setCellValue((Date) obj);
			cellnum++;
		}
	}

	private static List<CardData> readSampleCard() {
		List<CardData> list = new ArrayList<CardData>();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String cardNumber;
			Date expDate;
			CardData cardData;

			cardData = new CardData();
			cardNumber = "5859476520116727";
			expDate = sdf.parse("08/31/2019");
			cardData.setCardNumber(cardNumber);
			cardData.setExpDate(expDate);
			list.add(cardData);

			cardData = new CardData();
			cardNumber = "5859472010004747";
			expDate = sdf.parse("10/31/2019");
			cardData.setCardNumber(cardNumber);
			cardData.setExpDate(expDate);
			list.add(cardData);

			cardData = new CardData();
			cardNumber = "5859471010006892";
			expDate = sdf.parse("10/31/2019");
			cardData.setCardNumber(cardNumber);
			cardData.setExpDate(expDate);
			list.add(cardData);

			cardData = new CardData();
			cardNumber = "5859472020000024";
			expDate = sdf.parse("11/30/2019");
			cardData.setCardNumber(cardNumber);
			cardData.setExpDate(expDate);
			list.add(cardData);

			cardData = new CardData();
			cardNumber = "5859472020001105";
			expDate = sdf.parse("05/31/2020");
			cardData.setCardNumber(cardNumber);
			cardData.setExpDate(expDate);
			list.add(cardData);

			cardData = new CardData();
			cardNumber = "5859476530692451";
			expDate = sdf.parse("10/31/2019");
			cardData.setCardNumber(cardNumber);
			cardData.setExpDate(expDate);
			list.add(cardData);

			cardData = new CardData();
			cardNumber = "5859471010067860";
			expDate = sdf.parse("05/31/2020");
			cardData.setCardNumber(cardNumber);
			cardData.setExpDate(expDate);
			list.add(cardData);

			cardData = new CardData();
			cardNumber = "5859476520110738";
			expDate = sdf.parse("08/31/2019");
			cardData.setCardNumber(cardNumber);
			cardData.setExpDate(expDate);
			list.add(cardData);

			cardData = new CardData();
			cardNumber = "5859476520116727";
			expDate = sdf.parse("08/31/2019");
			cardData.setCardNumber(cardNumber);
			cardData.setExpDate(expDate);
			list.add(cardData);

			cardData = new CardData();
			cardNumber = "5859471010119539";
			expDate = sdf.parse("06/30/2020");
			cardData.setCardNumber(cardNumber);
			cardData.setExpDate(expDate);
			list.add(cardData);

			cardData = new CardData();
			cardNumber = "5859471010067944";
			expDate = sdf.parse("05/31/2020");
			cardData.setCardNumber(cardNumber);
			cardData.setExpDate(expDate);
			list.add(cardData);

			cardData = new CardData();
			cardNumber = "5859476710001895";
			expDate = sdf.parse("04/30/2018");
			cardData.setCardNumber(cardNumber);
			cardData.setExpDate(expDate);
			list.add(cardData);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return list;
	}

	private static List<CardData> readExcelFile(String fileName) {
		try {

			File input = new File(fileName);
			System.out.println("Read data from : " + input.getAbsolutePath());
			FileInputStream file = new FileInputStream(input);

			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);

			List<CardData> cardList = new ArrayList<CardData>();

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();

			// Header row
			if (rowIterator.hasNext()) {
				rowIterator.next();
			}

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				CardData cardData = new CardData();

				int colIndex = 0;

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						if (HSSFDateUtil.isCellDateFormatted(cell)) {
							cardData.setExpDate(cell.getDateCellValue());
							System.out.print(Convert.toString(cardData.getExpDate(), "MM/dd/yyyy") + "\t");
						} else {
							System.out.print(cell.getNumericCellValue() + "\t");
						}
						break;
					case Cell.CELL_TYPE_STRING:
						if (colIndex == 0) {
							cardData.setCardNumber(cell.getStringCellValue());
							System.out.print(cardData.getCardNumber() + "\t");
						} else if (colIndex == 1) {
							cardData.setExpDate(Convert.toDate(cell.getStringCellValue(), "MM/dd/yyyy"));
							System.out.print(Convert.toString(cardData.getExpDate(), "MM/dd/yyyy") + "\t");
						}

						break;
					}

					colIndex++;
				}
				System.out.println("");

				if (cardData.getCardNumber() == null)
					break;

				cardList.add(cardData);
			}
			file.close();

			return cardList;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void test() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Java Books");

		Object[][] bookData = { { "Head First Java", "Kathy Serria", 79 }, { "Effective Java", "Joshua Bloch", 36 }, { "Clean Code", "Robert martin", 42 },
				{ "Thinking in Java", "Bruce Eckel", 35 }, };

		int rowCount = 0;

		for (Object[] aBook : bookData) {
			Row row = sheet.createRow(++rowCount);

			int columnCount = 0;

			for (Object field : aBook) {
				Cell cell = row.createCell(++columnCount);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}

		}

		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream("JavaBooks.xlsx");
			workbook.write(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}