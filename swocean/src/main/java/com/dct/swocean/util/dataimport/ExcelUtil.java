package com.dct.swocean.util.dataimport;

import java.io.File;
import java.io.FileInputStream;
/*用于处理Excel的工具类*/
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * excel读写工具类
 */
public class ExcelUtil {
	private final static String xls = "xls";
	private final static String xlsx = "xlsx";

	/**
	 * 
	 * @param file
	 *            excel文件流
	 * @param customContent
	 *            读取指定位置的单元格数据 （可读取表头数据）例如： {"0,0","1,4"}读取 0行0列 和1行4列的数据
	 * @param mianContentStart
	 *            正文开始行
	 * @param mainContentColumCount
	 *            正文数据最大截止列
	 * @return
	 * @throws Exception
	 */
	public static ExcelResult readExcelFromMultipartFile(MultipartFile file, String[] customContent,
			int mianContentStart, int mainContentColumCount) throws Exception {
		checkFile(file);
		// 获得Workbook工作薄对象
		Workbook workbook = getWorkBook(file);
		// 创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
		ExcelResult result = new ExcelResult();
		List<String> headerList = new ArrayList<String>();
		List<String[]> contentList = new ArrayList<String[]>();
		if (workbook != null) {
			int sheetNum = 0;
			for (sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
				Sheet sheet = workbook.getSheetAt(sheetNum);
				if (sheet == null) {
					continue;
				}
				
				// 读取excel表头数据 (指定位置)
				if(customContent!=null){
					if(customContent.length>0){
						for (int i = 0; i < customContent.length; i++) {
							String temp[] = customContent[i].split(",");
							Integer rowIndex = Integer.parseInt(temp[0]);
							Integer colIndex = Integer.parseInt(temp[1]);
							Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
							String str = getCellValue(cell);
							headerList.add(str);
						}
					}
				}
				
				// 读取excel正文数据
				int rowNum;
				for (rowNum = mianContentStart; rowNum <= sheet.getLastRowNum(); rowNum++) {
					Row row = sheet.getRow(rowNum);
					if (row == null) {
						continue;
					}
					String[] strings = new String[mainContentColumCount+1];
					for (int i = 0; i < mainContentColumCount+1; i++) {
						strings[i] = getCellValue(row.getCell(i));
					}
					contentList.add(strings);
				}
			}
		}
		result.setDataContent(contentList);
		result.setHeaderContent(headerList);
		return result;
	}

	/**
	 * 
	 * @param path
	 *            excel文件路径
	 * @param customContent
	 *            读取指定位置的单元格数据 （可读取表头数据）例如： {"0,0","1,4"}读取 0行0列 和1行4列的数据
	 * @param mianContentStart
	 *            正文开始行
	 * @param mainContentColumCount
	 *            正文数据最大截止列
	 * @return
	 * @throws Exception
	 */
	public static ExcelResult readExcelFromPath(String path, String[] customContent, int mianContentStart,
			int mainContentColumCount) throws Exception {
		checkFile(path);
		Workbook workbook = getWorkBook(path);
		// 创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
		ExcelResult result = new ExcelResult();
		List<String> headerList = new ArrayList<String>();
		List<String[]> contentList = new ArrayList<String[]>();
		if (workbook != null) {
			int sheetNum = 0;
			for (sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
				Sheet sheet = workbook.getSheetAt(sheetNum);
				if (sheet == null) {
					continue;
				}

				// 读取excel表头数据 (指定位置)
				for (int i = 0; i < customContent.length; i++) {
					String temp[] = customContent[i].split(",");
					Integer rowIndex = Integer.parseInt(temp[0]);
					Integer colIndex = Integer.parseInt(temp[1]);
					Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
					String str = getCellValue(cell);
					headerList.add(str);
				}

				// 读取excel正文数据
				int rowNum;
				for (rowNum = mianContentStart; rowNum <= sheet.getLastRowNum(); rowNum++) {
					Row row = sheet.getRow(rowNum);
					if (row == null) {
						continue;
					}
					String[] strings = new String[mainContentColumCount];
					for (int i = 0; i < mainContentColumCount; i++) {
						strings[i] = getCellValue(row.getCell(i));
					}
					contentList.add(strings);
				}
			}
		}
		result.setDataContent(contentList);
		result.setHeaderContent(headerList);
		return result;
	}

	
	/**
	 * 
	 * @param customContent
	 *            自定义表头(如果全都是正文，设置为空) 参数类型: Map<string[],string[]> map 例如：
	 *            key：{"1,1,0,0","1,1,1,1"}（每个字符串包括4个数字，分别是：起始行，截止行，起始列，截止列）
	 *            value：{"账号"，"用户名"} map.put(key,value)
	 * @param mainContent
	 *            正文数据 参数类型： list<String[]> list 例如 : String[]
	 *            user={"255611","张三"} list.add(user)
	 * @param contentStart
	 *            正文开始行（从0开始计数）
	 * @param excel
	 *            可设置excel表格的的样式字体,样式,行高,列宽,冻结excel某块区域 （具体操作看文档说明或demo）
	 * @param sheetName
	 *            页面标签名
	 * @return
	 */
	public static boolean writeExcel(Map<String[], String[]> customContent, List<String[]> mainContent,
			int mianContentStart, Excel excel, String sheetName) {

		Workbook wb = excel.getWorkbook();
		// 生成一个表格
		Sheet sheet = wb.createSheet(sheetName);

		sheet.setDefaultRowHeight(excel.getDefaultRowHeight());// 设置全局行高

		// 设置全局默认样式
		CellStyle defaultStyle = excel.getDefaultStyle();
		Font defaultFont = excel.getDefaultFont();
		defaultStyle.setFont(defaultFont);

		Row rows[] = new Row[mianContentStart + mainContent.size()];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = sheet.createRow(i);
		}

		int colCountMax = 0;
		if (!customContent.isEmpty()) {
			for (String[] key : customContent.keySet()) {
				String[] custom = customContent.get(key);
				int[] colIndex = new int[key.length]; // 保存表头的所在列，为了后面写入表头内容
				int[] rowIndex = new int[key.length]; // 保存表头的所在行，为了后面写入表头内容
				int rowCount = 0; // 表头所占行的数量
				int colCount = 0;
				for (int i = 0; i < key.length; i++) {
					String[] temp = key[i].split(",");
					Integer startrow = Integer.parseInt(temp[0]);
					Integer overrow = Integer.parseInt(temp[1]);
					Integer startcol = Integer.parseInt(temp[2]);
					Integer overcol = Integer.parseInt(temp[3]);
					if (overrow > startrow || overcol > startcol) {
						sheet.addMergedRegion(new CellRangeAddress(startrow, overrow, startcol, overcol)); // 合并单元格
					}

					if (overrow + 1 > rowCount) {
						rowCount = overrow + 1;
					}
					if (overcol + 1 > colCount) {
						colCount = overcol + 1;
					}
					if (colCount > colCountMax) {
						colCountMax = colCount;
					}
					colIndex[i] = startcol;
					rowIndex[i] = startrow;
				}

				// 给合并后的单元格加边框
				for (int i = 0; i < rowCount; i++) {
					for (int j = 0; j < colCount; j++) {
						Cell cell = rows[i].createCell(j);
						cell.setCellValue("");
						cell.setCellStyle(defaultStyle);
					}
				}

				// 写入自定义表头内容
				for (int i = 0; i < colIndex.length; i++) {
					int col = colIndex[i];
					Cell cell = rows[rowIndex[i]].getCell(col);
					setCell(wb, cell, custom[i], defaultStyle);
				}
			}
		}
		// 写入正文数据到excel
		for (int i = 0; i < mainContent.size(); i++) {

			String[] strings = (String[]) mainContent.get(i);

			// 导入对应列的数据
			for (int n = 0; n < strings.length; n++) {
				Cell cell = rows[i + mianContentStart].createCell(n);
				setCell(wb, cell, strings[n], defaultStyle);
			}
		}
		for (int i = 0; i < colCountMax; i++) {
			sheet.autoSizeColumn(i, true);// 根据字段长度自动调整列的宽度
		}

		// 设定具体的样式,字体，行高，列宽
		setStyle(sheet, rows, excel);

		createFreezePane(sheet, excel); // 冻结excel某块区域

		String path = excel.getSavePath();
		File file = new File(path);
		if (!file.exists()) {
			String fileDir = path.substring(0, path.lastIndexOf("/") + 1);
			createFolder(fileDir);
		}
		try {
			wb.write(new FileOutputStream(file));
			file.createNewFile();
			wb.close();// 最后记得关闭工作簿
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	};

	/**
	 * 导出数据到excel模板
	 * 
	 * @param customContent
	 *            自定义表头(如果设置为空map集合，则不创建自定义表头) 参数类型: Map<string[],string[]> map
	 *            例如： key：{"0,0","0,1"}（写入表头数据所在的坐标：每个字符串必须包含两个数字，对应所在的行列）
	 *            value：{"账号"，"用户名"}（0行0列，0行1列） map.put(key,value)
	 * @param content
	 *            正文数据 参数类型： list<String[]> list 例如 : String[]
	 *            user={"255611","张三"} list.add(user)
	 * @param templatePath
	 *            模板路径
	 * @param savePath
	 *            保存路径
	 * @param startRow
	 *            正文开始行
	 * @param sheetName
	 *            页脚签名
	 * @return
	 * @throws IOException
	 */

	public static boolean exportToTemplate(Map<String[], String[]> customContent, List<String[]> mainContent,
			String templatePath, String savePath, int contentStart, String sheetName) throws IOException {
		checkFile(templatePath);
		Workbook wb = getWorkBook(templatePath);
		if (wb != null) {
			int sheetNum = 0;
			for (sheetNum = 0; sheetNum < wb.getNumberOfSheets(); sheetNum++) {
				Sheet sheet = wb.getSheetAt(sheetNum);
				if (sheet == null) {
					continue;
				}

				// 如果这行没有了，整个公式都不会有自动计算的效果的
				sheet.setForceFormulaRecalculation(true);

				Row rows[] = new Row[contentStart + mainContent.size()];
				for (int i = 0; i < rows.length; i++) {
					rows[i] = sheet.getRow(i);
				}

				for (String[] key : customContent.keySet()) {
					String[] value = customContent.get(key);
					for (int i = 0; i < key.length; i++) {
						String[] temp = key[i].split(",");
						Integer row = Integer.parseInt(temp[0]);
						Integer col = Integer.parseInt(temp[1]);
						Cell cell = rows[row].getCell(col);
						if (cell == null) {
							cell = rows[row].createCell(col);
						}
						CellStyle style = cell.getCellStyle();
						setCell(wb, cell, value[i], style);
					}
				}
				if (!mainContent.isEmpty()) {
					int i = 0;
					int j = 0;

					for (i = 0; i < mainContent.size(); i++) {
						String[] strings = mainContent.get(i);
						for (j = 0; j < strings.length; j++) {
							Row row = sheet.getRow(i + contentStart);
							if (row == null) {
								row = sheet.createRow(i + contentStart);
							}
							Cell cell = row.getCell(j);
							if (cell == null) {
								cell = row.createCell(j);
							}
							CellStyle style = cell.getCellStyle();
							setCell(wb, cell, strings[j], style);
						}
					}
				}
			}
		}

		// 根据模板导出内容到新excel文件并保存
		String dir = savePath.substring(0, savePath.lastIndexOf("/"));
		createFolder(dir);
		FileOutputStream out = new FileOutputStream(savePath);
		wb.write(out);
		out.close();
		return true;
	};

	/**
	 * 导出数据到下拉列表(如果模板路径和保存路径一样，会直接修改模板内容)
	 * 
	 * @param explicitListValues
	 *            数据源
	 * @param firstRow
	 *            开始行
	 * @param lastRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param lastCol
	 *            结束列
	 * @param templatePaht
	 *            模板路径
	 * @param savePath
	 *            保存路径
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	public static boolean setValidationData(String[] explicitListValues, int firstRow, int lastRow, int firstCol,
			int lastCol, String templatePaht, String savePath) throws IllegalArgumentException, IOException {
		if (firstRow < 0 || lastRow < 0 || firstCol < 0 || lastCol < 0 || lastRow < firstRow || lastCol < firstCol) {
			throw new IllegalArgumentException(
					"Wrong Row or Column index : " + firstRow + ":" + lastRow + ":" + firstCol + ":" + lastCol);
		}
		checkFile(templatePaht);
		Workbook wb = getWorkBook(templatePaht);
		Sheet sheet = wb.getSheetAt(0);
		if (sheet instanceof XSSFSheet) {
			XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper((XSSFSheet) sheet);
			XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper
					.createExplicitListConstraint(explicitListValues);
			CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
			XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);
			validation.setSuppressDropDownArrow(true);
			validation.setShowErrorBox(true);
			sheet.addValidationData(validation);
		} else if (sheet instanceof HSSFSheet) {
			CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
			DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(explicitListValues);
			DataValidation validation = new HSSFDataValidation(addressList, dvConstraint);
			validation.setSuppressDropDownArrow(true);
			validation.setShowErrorBox(true);
			sheet.addValidationData(validation);
		}

		String dir = savePath.substring(0, savePath.lastIndexOf("/"));
		createFolder(dir);
		FileOutputStream out = new FileOutputStream(savePath);
		wb.write(out);
		out.close();
		return true;
	}

	/**
	 * 导出数据到指定的Excel下拉列表
	 * 
	 * @param explicitListValues
	 *            数据源
	 * @param firstRow
	 *            开始行
	 * @param lastRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param lastCol
	 *            结束列
	 * @param templatePaht
	 *            模板路径
	 * @param savePath
	 *            保存路径
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	public static boolean setValidationData(String[] explicitListValues, int firstRow, int lastRow, int firstCol,
			int lastCol, String filePath) throws IllegalArgumentException, IOException {
		if (firstRow < 0 || lastRow < 0 || firstCol < 0 || lastCol < 0 || lastRow < firstRow || lastCol < firstCol) {
			throw new IllegalArgumentException(
					"Wrong Row or Column index : " + firstRow + ":" + lastRow + ":" + firstCol + ":" + lastCol);
		}
		checkFile(filePath);
		Workbook wb = getWorkBook(filePath);
		Sheet sheet = wb.getSheetAt(0);
		if (sheet instanceof XSSFSheet) {
			XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper((XSSFSheet) sheet);
			XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper
					.createExplicitListConstraint(explicitListValues);
			CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
			XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);
			validation.setSuppressDropDownArrow(true);
			validation.setShowErrorBox(true);
			sheet.addValidationData(validation);
		} else if (sheet instanceof HSSFSheet) {
			CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
			DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(explicitListValues);
			DataValidation validation = new HSSFDataValidation(addressList, dvConstraint);
			validation.setSuppressDropDownArrow(true);
			validation.setShowErrorBox(true);
			sheet.addValidationData(validation);
		}

		String dir = filePath.substring(0, filePath.lastIndexOf("/"));
		createFolder(dir);
		FileOutputStream out = new FileOutputStream(filePath);
		wb.write(out);
		out.close();
		return true;
	}

	
	/**
	 * 保存excel文件
	 * 
	 * @param stream
	 *            excel文件流
	 * @param path
	 *            保存路径（包括文件名）
	 * @param fileType   文件类型（文件后缀）
	 * @throws IOException
	 */
	public static void saveExcel(InputStream stream, String path, String fileType) throws IOException {
		if(!path.endsWith(fileType)){
			throw new IOException(path + "和指定的文件类型不同");
		}
		String dir = path.substring(0, path.lastIndexOf("/"));
		createFolder(dir);
		FileOutputStream fs = new FileOutputStream(path);
		byte[] buffer = new byte[1024 * 1024];
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
	}
	
	/**
	 * 读入excel文件，解析后返回
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static void checkFile(MultipartFile file) throws IOException {
		// 判断文件是否存在
		if (null == file) {
			throw new FileNotFoundException("文件不存在！");
		}
		// 获得文件名
		String fileName = file.getOriginalFilename();
		// 判断文件是否是excel文件
		if (!fileName.endsWith(xls) && !fileName.endsWith(xlsx)) {
			throw new IOException(fileName + "不是excel文件");
		}
	}

	public static void checkFile(String path) throws IOException {
		File file = new File(path);
		// 判断文件是否存在
		if (!file.exists()) {
			throw new FileNotFoundException("文件不存在！");
		}
		// 判断文件是否是excel文件
		if (!path.endsWith(xls) && !path.endsWith(xlsx)) {
			throw new IOException(path + "不是excel文件");
		}
	}

	public static Workbook getWorkBook(MultipartFile file) {
		// 获得文件名
		String fileName = file.getOriginalFilename();
		// 创建Workbook工作薄对象，表示整个excel
		Workbook workbook = null;
		try {
			// 获取excel文件的io流
			InputStream is = file.getInputStream();
			// 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
			if (fileName.endsWith(xls)) {
				// 2003
				workbook = new HSSFWorkbook(is);
			} else if (fileName.endsWith(xlsx)) {
				// 2007
				workbook = new XSSFWorkbook(is);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}

	public static Workbook getWorkBook(String path) {
		Workbook workbook = null;
		InputStream is;
		try {
			is = new FileInputStream(path);
			if (path.endsWith(xls)) {
				// 2003
				workbook = new HSSFWorkbook(is);
			} else if (path.endsWith(xlsx)) {
				// 2007
				workbook = new XSSFWorkbook(is);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return workbook;
	}

	public static Workbook getEmptyWorkBook(String path) {
		Workbook workbook = null;
		if (path.endsWith(xls)) {
			// 2003
			workbook = new HSSFWorkbook();
		} else if (path.endsWith(xlsx)) {
			// 2007
			workbook = new XSSFWorkbook();
		}
		return workbook;
	}

	public static String getCellValue(Cell cell) {
		String cellValue = "";
		if (cell == null) {
			return cellValue;
		}
		// 把数字当成String来读，避免出现1读成1.0的情况
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				return DateFormatUtils.format(date, "yyyy-MM-dd");
			}
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		// 判断数据的类型
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // 数字
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING: // 字符串
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN: // Boolean
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA: // 公式
			cellValue = String.valueOf(cell.getCellFormula());
			break;
		case Cell.CELL_TYPE_BLANK: // 空值
			cellValue = "";
			break;
		case Cell.CELL_TYPE_ERROR: // 故障
			cellValue = "非法字符";
			break;
		default:
			cellValue = "未知类型";
			break;
		}
		return cellValue;
	}

	public static void setCell(Workbook wb, Cell cell, String str, CellStyle style) {
		Boolean isNum = false;// data是否为数值型
		Boolean isInteger = false;// data是否为整数
		Boolean isPercent = false;// data是否为百分数
		if (str != null || "".equals(str)) {
			// 判断data是否为数值型
			isNum = str.toString().matches("^(-?\\d+)(\\.\\d+)?$");
			// 判断data是否为整数（小数部分是否为0）
			isInteger = str.toString().matches("^[-\\+]?[\\d]*$");
			// 判断data是否为百分数（是否包含“%”）
			isPercent = str.toString().contains("%");
		}

		if (isNum && !isPercent) {
			DataFormat df = wb.createDataFormat(); // 此处设置数据格式
			if (isInteger) {
				style.setDataFormat(df.getFormat("#,#0"));// 数据格式只显示整数
			} else {
				style.setDataFormat(df.getFormat("#,##0.00"));// 保留两位小数点
			}
			// 设置单元格格式
			cell.setCellStyle(style);
			// 设置单元格内容为double类型
			cell.setCellValue(Double.parseDouble(str.toString()));
		} else {
			cell.setCellStyle(style);
			// 设置单元格内容为字符型
			cell.setCellValue(str.toString());
		}
	}

	public static void setStyle(Sheet sheet, Row[] rows, Excel excel) {
		Map<CellStyle, String> styles = excel.getDetailStyles();
		Map<String, Short> rowHeights = excel.getDetailRowHeights();
		Map<String, Integer> columWidths = excel.getDetailColumWidths();
		if (!styles.isEmpty()) {
			for (CellStyle key : styles.keySet()) {
				String str = styles.get(key);
				String[] temp = str.split(",");
				Integer startrow = Integer.parseInt(temp[0]);
				Integer overrow = Integer.parseInt(temp[1]);
				Integer startcol = Integer.parseInt(temp[2]);
				Integer overcol = Integer.parseInt(temp[3]);
				for (int i = startrow; i <= overrow; i++) {
					for (int j = startcol; j <= overcol; j++) {
						Row row = null;
						Cell cell = null;
						if (i < rows.length) {
							row = rows[i];
						}
						row = sheet.getRow(i);
						if (row == null) {
							row = sheet.createRow(i);
						}
						cell = row.getCell(j);
						if (null == cell) {
							cell = row.createCell(j);
						}
						cell.setCellStyle(key);
					}
				}
			}
		}
		if (!rowHeights.isEmpty()) {
			for (String key : rowHeights.keySet()) {
				Short height = rowHeights.get(key);
				String[] temp = key.split(",");
				Integer startrow = Integer.parseInt(temp[0]);
				Integer overrow = Integer.parseInt(temp[1]);
				for (int i = startrow; i <= overrow; i++) {
					rows[i].setHeight(height);
				}
			}
		}
		if (!columWidths.isEmpty()) {
			for (String key : columWidths.keySet()) {
				int width = columWidths.get(key);
				String[] temp = key.split(",");
				Integer startcol = Integer.parseInt(temp[0]);
				Integer overcol = Integer.parseInt(temp[1]);
				for (int i = startcol; i <= overcol; i++) {
					sheet.setColumnWidth(i, width);
				}
			}
		}
	}


	public static void createFreezePane(Sheet sheet, Excel excel) {
		String str = excel.getFreezePane();
		if (null != str) {
			String[] temp = str.split(",");
			Integer col = Integer.parseInt(temp[0]);
			Integer row = Integer.parseInt(temp[1]);
			sheet.createFreezePane(row + 1, col + 1);
		}
	}

	
	
	public static void createFolder(String sPath) {
		File file1 = new File(sPath);
		// 判断目录或文件是否存在
		if (!file1.exists()) {
			file1.mkdirs();
		}
	}



}