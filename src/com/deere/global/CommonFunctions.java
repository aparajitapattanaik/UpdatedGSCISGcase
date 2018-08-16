package com.deere.global;

import static com.deere.global.GlobalThings.listOfBrowser;
import static com.deere.global.GlobalThings.listOfEnv;
import static com.deere.global.GlobalThings.listOfInputs;
import static com.deere.global.GlobalThings.listOfsuite;
import static com.deere.global.GlobalThings.reportDirectory;
import static com.deere.global.GlobalThings.executionStartTimeForScenario;
import static com.deere.global.GlobalThings.testDirectory;
import static com.deere.global.GlobalThings.testResultReports;
import static com.deere.global.GlobalThings.downloadFilePath;
import static com.deere.global.GlobalThings.executionEndTimeForScenario;
import static com.deere.global.GlobalThings.listOfTestSkipped;
import static com.deere.global.GlobalThings.filePathImage;
import static com.deere.global.GlobalThings.openBtnImage;
import static com.deere.global.GlobalThings.listOfEmail;

import java.awt.Color;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import java.util.function.Function;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class CommonFunctions {
	public static String curDir;
	static FileOutputStream reportOut;
	static HSSFWorkbook reportWorkbook;
	static HSSFSheet reportWorksheet;
	static Integer currRow;
	static Integer currBakRow;
	static ExtentReports extentReports;

	/**
	 * Method to setup report directory
	 */
	public static void createReportDirectory(){
		String curTS = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Timestamp(new Date().getTime()));
		File file = new File(reportDirectory);
		file.mkdir();
		curDir = reportDirectory + curTS;
		file = new File(curDir);
		file.mkdir();
		createReportExcel();
	}

	private static void createReportExcel() {
		//Create report excel
		try{
			reportOut = new FileOutputStream(curDir + "/TestReport.xls");
			reportWorkbook = new HSSFWorkbook();
			reportWorksheet = reportWorkbook.createSheet("Result");
			setColumnStyle();
			reportOut.flush();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		currRow = 0;
		currBakRow = 0;
	}

	private static void setColumnStyle() {
		for(int x = 0; x <10 ; x++){
			if (x==0 || x==1 || x==4 ){
				reportWorksheet.setColumnWidth(x, 4000);
			} else if(x==3 || x==2) {
				reportWorksheet.setColumnWidth(x, 7000);
			} else if(x==5) {
				reportWorksheet.setColumnWidth(x, 4500);
			}else if(x==9) {
				reportWorksheet.setColumnWidth(x, 6000);
			}else{
				reportWorksheet.setColumnWidth(x, 12800);
			}
		}
	}

	public static void getEnvironemtToBeExecuted(){
		try {
			FileInputStream file = new FileInputStream(new File(testDirectory + "JDCCMSExcel.xls"));
			HSSFWorkbook resultWorkbook;
			resultWorkbook = new HSSFWorkbook(file);
			HSSFSheet resultWorksheet = resultWorkbook.getSheet("Environment");
			Iterator<Row> rowIterator = resultWorksheet.iterator();
			iterateRowsAndColumnsForReadingAndStoringEnvironemt(rowIterator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void iterateRowsAndColumnsForReadingAndStoringEnvironemt(Iterator<Row> rowIterator) {
		while (rowIterator.hasNext()){
			Row row = rowIterator.next();
			InputEnvironmentDetails inputEnvDetails = new InputEnvironmentDetails();
			if (row.getRowNum()>0 && row.getCell(2).toString().equals("Y")){
				Iterator<Cell> cellIterator = row.cellIterator();
				iterateColumnsAndBuildEnvObject(inputEnvDetails,cellIterator);
			}
			if(row.getRowNum()>0 && inputEnvDetails.getExecute().equals("Y")){
				listOfEnv.add(inputEnvDetails);
			}
		}
	}

	public static void getEmailAddresses(){
		try {
			FileInputStream file = new FileInputStream(new File(testDirectory + "JDCCMSExcel.xls"));
			HSSFWorkbook resultWorkbook;
			resultWorkbook = new HSSFWorkbook(file);
			HSSFSheet resultWorksheet = resultWorkbook.getSheet("Email");
			Iterator<Row> rowIterator = resultWorksheet.iterator();
			iterateRowsAndColumnsForReadingAndStoringEmail(rowIterator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void iterateRowsAndColumnsForReadingAndStoringEmail(Iterator<Row> rowIterator) {
		while (rowIterator.hasNext()){
			Row row = rowIterator.next();
			InputEmailDetails inputEmailDetails = new InputEmailDetails();
			if (row.getRowNum()>0 && row.getCell(2).toString().equals("Y")){
				Iterator<Cell> cellIterator = row.cellIterator();
				iterateColumnsAndBuildEmailObject(inputEmailDetails,cellIterator);
			}
			if(row.getRowNum()>0 && inputEmailDetails.getSendEmail().equals("Y")){
				listOfEmail.add(inputEmailDetails);
			}
		}
	}

	private static void iterateColumnsAndBuildEmailObject(InputEmailDetails inputEmailDetails, Iterator<Cell> cellIterator) {
		while (cellIterator.hasNext()){
			Cell cell = cellIterator.next();
			TestEmailEnum testExcelEnum = TestEmailEnum.getTestEmailEnum(cell.getColumnIndex());
			testExcelEnum.process(cell, inputEmailDetails);
		}
	}

	public static void getSuiteToBeExecuted(){
		try {
			FileInputStream file = new FileInputStream(new File(testDirectory + "JDCCMSExcel.xls"));
			HSSFWorkbook resultWorkbook;
			resultWorkbook = new HSSFWorkbook(file);
			HSSFSheet resultWorksheet = resultWorkbook.getSheet("Module");
			Iterator<Row> rowIterator = resultWorksheet.iterator();
			iterateRowsAndColumnsForReadingAndStoringSuites(rowIterator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getBrowserToBeExecuted(){
		try {
			FileInputStream file = new FileInputStream(new File(testDirectory + "JDCCMSExcel.xls"));
			HSSFWorkbook resultWorkbook;
			resultWorkbook = new HSSFWorkbook(file);
			HSSFSheet resultWorksheet = resultWorkbook.getSheet("Browser");
			Iterator<Row> rowIterator = resultWorksheet.iterator();
			iterateRowsAndColumnsForReadingAndStoringBrowser(rowIterator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void iterateRowsAndColumnsForReadingAndStoringSuites(Iterator<Row> rowIterator) {
		while (rowIterator.hasNext()){
			Row row = rowIterator.next();
			InputSuiteDetails inputSuiteDetails = new InputSuiteDetails();
			if (row.getRowNum()>0 && row.getCell(3).toString().equals("Y")){
				Iterator<Cell> cellIterator = row.cellIterator();
				iterateColumnsAndBuildSuiteObject(inputSuiteDetails,cellIterator);
			}
			if(row.getRowNum()>0 && inputSuiteDetails.getExecute().equals("Y")){
				listOfsuite.add(inputSuiteDetails);
			}
		}
	}

	private static void iterateRowsAndColumnsForReadingAndStoringBrowser(Iterator<Row> rowIterator) {
		while (rowIterator.hasNext()){
			Row row = rowIterator.next();
			InputBrowserDetails inputBrowserDetails = new InputBrowserDetails();
			if (row.getRowNum()>0 && row.getCell(1).toString().equals("Y")){
				Iterator<Cell> cellIterator = row.cellIterator();
				iterateColumnsAndBuildBrowserObject(inputBrowserDetails,cellIterator);
			}
			if(row.getRowNum()>0 && inputBrowserDetails.getExecute().equals("Y")){
				listOfBrowser.add(inputBrowserDetails);
			}
		}
	}

	/**
	 * Method to collect test case related information in list of InputTestDetails.class
	 */
	public static void getTestsToBeExecuted(String SheetName){
		try {
			FileInputStream file = new FileInputStream(new File(testDirectory + "JDCCMSExcel.xls"));
			HSSFWorkbook resultWorkbook;
			resultWorkbook = new HSSFWorkbook(file);
			HSSFSheet resultWorksheet = resultWorkbook.getSheet(SheetName);
			Iterator<Row> rowIterator = resultWorksheet.iterator();
			iterateRowsAndColumnsForReadingAndStoring(rowIterator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void iterateRowsAndColumnsForReadingAndStoring(Iterator<Row> rowIterator) {
		while (rowIterator.hasNext()){
			Row row = rowIterator.next();
			InputTestDetails inputTestDetails = new InputTestDetails();
			if (row.getRowNum()>0){
				Iterator<Cell> cellIterator = row.cellIterator();
				iterateColumnsAndBuildInputObject(inputTestDetails,	cellIterator);
			}
			if(row.getRowNum()>0 && inputTestDetails.getExecute().equals("Y")){
				listOfInputs.add(inputTestDetails);
			} else if(row.getRowNum()>0) {
				listOfTestSkipped.add(inputTestDetails);
			}
		}
		
	}

	private static void iterateColumnsAndBuildEnvObject(InputEnvironmentDetails inputEnvDetails, Iterator<Cell> cellIterator) {
		while (cellIterator.hasNext()){
			Cell cell = cellIterator.next();
			TestEnvironmentEnum testExcelEnum = TestEnvironmentEnum.getTestEnvironmentEnum(cell.getColumnIndex());
			testExcelEnum.process(cell, inputEnvDetails);
		}
	}

	private static void iterateColumnsAndBuildSuiteObject(InputSuiteDetails inputSuiteDetails, Iterator<Cell> cellIterator) {
		while (cellIterator.hasNext()){
			Cell cell = cellIterator.next();
			TestSuiteEnum testExcelEnum = TestSuiteEnum.getTestExcelEnum(cell.getColumnIndex());
			testExcelEnum.process(cell, inputSuiteDetails);
		}
	}

	private static void iterateColumnsAndBuildBrowserObject(InputBrowserDetails inputBrowserDetails, Iterator<Cell> cellIterator) {
		while (cellIterator.hasNext()){
			Cell cell = cellIterator.next();
			TestBrowserEnum testExcelEnum = TestBrowserEnum.getTestExcelEnum(cell.getColumnIndex());
			testExcelEnum.process(cell, inputBrowserDetails);
		}
	}

	private static void iterateColumnsAndBuildInputObject(InputTestDetails inputTestDetails, Iterator<Cell> cellIterator) {
		while (cellIterator.hasNext()){
			Cell cell = cellIterator.next();
			TestExcelEnum testExcelEnum = TestExcelEnum.getTestExcelEnum(cell.getColumnIndex());
			testExcelEnum.process(cell, inputTestDetails);
		}
	}

	public static String getSelectedValueFromDropdown(By elmt , WebDriver driver)
	{
		Select s = new Select(driver.findElement(elmt));
		return s.getFirstSelectedOption().getText().trim();
	}
	
	/**
	 * In case of Pass result send only first parameter and rest send as null
	 * @param inputTestDetails
	 * @param exceptionError
	 * @param userDefinedError
	 * @param driver
	 * @return TestResultReport.class
	 * @throws Exception 
	 */
	public static TestResultReport updateResultObject(InputTestDetails inputTestDetails, String techError,String functionalError, String userDefinedError, WebDriver driver,InputEnvironmentDetails inputEnvDetails ,String browser, String ssPath) throws Exception{
		String result = "Pass";
		TestResultReport testResultReport = new TestResultReport();
		if(techError != null || functionalError != null){
			result = "Fail";
			testResultReport.setFunctionalError(functionalError);
			testResultReport.setTechnicalError(techError);
			testResultReport.setUserDefinedError(userDefinedError);
			testResultReport.setSSPath(ssPath);
		}
		testResultReport.setDriver(driver);
		testResultReport.setEnvironment(inputEnvDetails.getEnvironment());
		testResultReport.setTestCaseId(inputTestDetails.getTestCaseID());
		testResultReport.setBrowser(browser);
		testResultReport.setTestCaseDescription(inputTestDetails.getTestCaseDescription());
		testResultReport.setResult(result);
		testResultReport.setExecutionTime(CommonFunctions.getExecutionTime());
		return testResultReport;
	}

	/**
	 * 	Function to write results in excel at the end of execution and launch report file
	 */
	public static void writeReportExcel(){
		HSSFRow row = reportWorksheet.createRow(currRow);
		HSSFFont font = reportWorkbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFCellStyle cellStyleHeader = reportWorkbook.createCellStyle();
		setReportHeader(row, cellStyleHeader , font);
		HSSFCellStyle cellStyleInGeneral = reportWorkbook.createCellStyle();
		HSSFCellStyle cellStyleForFailed = reportWorkbook.createCellStyle();
		HSSFCellStyle cellStyleForPass = reportWorkbook.createCellStyle();
		setReportStyle(cellStyleInGeneral, cellStyleForFailed ,cellStyleForPass);
		updateReportRowsWithResult(cellStyleInGeneral, cellStyleForFailed , cellStyleForPass);
		try {
			createPieChart(reportWorkbook, reportWorksheet);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		writeReportExcelInWindowsFileSystem();
	}

	private static void updateReportRowsWithResult(HSSFCellStyle cellStyleInGeneral, HSSFCellStyle cellStyleForFailed , HSSFCellStyle cellStyleForPass) {
		HSSFRow row;
		HSSFCell cell;
		for(TestResultReport testResultReport:testResultReports){
			currRow++;
			row = reportWorksheet.createRow(currRow);
			for(int i=0; i<10; i++){
				cell = row.createCell(i);
				TestResultEnum testResultEnum = TestResultEnum.getTestResultEnum(i);
				testResultEnum.process(testResultReport, cell, cellStyleInGeneral, cellStyleForFailed , cellStyleForPass);
			}
		}
		for(TestResultReport testResults : testResultReports) {
			if(testResults.getResult().equalsIgnoreCase("fail")) {
				for(int i=5;i<9;i++) {
					reportWorksheet.setColumnHidden(i, false);
				}
				break;
			} else {
				for(int i=5;i<9;i++) {
					reportWorksheet.setColumnHidden(i, true);
				}
			}
		}
	}

	private static void setReportHeader(HSSFRow row, HSSFCellStyle cellStyleHeader , HSSFFont font) {
		cellStyleHeader.setFillForegroundColor(HSSFColor.GOLD.index);
		cellStyleHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyleHeader.setBorderBottom((short) 1);
		cellStyleHeader.setBorderLeft((short) 1);
		cellStyleHeader.setBorderRight((short) 1);
		cellStyleHeader.setBorderTop((short) 1);
		cellStyleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyleHeader.setFont(font);
		putReportHeaders(row, cellStyleHeader);
	}

	private static void putReportHeaders(HSSFRow row, HSSFCellStyle cellStyleHeader) {
		HSSFCell cell;
		String [] columnHeadings = {"Environment","Browser", "TestCase ID", "Description", "Result", "Screenshot Link" , "Functional Error","Technical Error", "Error Description", "Execution Time"};

		//loop for writing column headings
		for (int i = 0; i < columnHeadings.length; i++){
			cell = row.createCell(i);
			cell.setCellValue(columnHeadings[i]);
			cell.setCellStyle(cellStyleHeader);
		}
	}

	private static void setReportStyle(HSSFCellStyle cellStyleInGeneral,HSSFCellStyle cellStyleForFailed , HSSFCellStyle cellStyleForPass) {
		cellStyleInGeneral.setWrapText(true);
		cellStyleInGeneral.setBorderBottom((short) 1);
		cellStyleInGeneral.setBorderLeft((short) 1);
		cellStyleInGeneral.setBorderRight((short) 1);
		cellStyleInGeneral.setBorderTop((short) 1);
		cellStyleForPass.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
		cellStyleForPass.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyleForFailed.setFillForegroundColor(HSSFColor.RED.index);
		cellStyleForFailed.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	}

	private static void writeReportExcelInWindowsFileSystem() {
		try{
			reportOut = new FileOutputStream(curDir + "/TestReport.xls");
			reportWorkbook.write(reportOut);
			reportOut.flush();
			reportOut.close();
			//String[] excelOpen = new String[]{"cmd.exe","/c",curDir + "/TestReport.xls"}; 
			//Runtime.getRuntime().exec(excelOpen);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Author : Sachin Mashalkar
	 * Description : Waiting for an Element until it is visible
	 * @param driver
	 * @param element
	 * @return
	 */
	public static WebElement waitForElement(WebDriver driver, WebElement element){
		try{
			WebElement tempElement;
			WebDriverWait wait = new WebDriverWait(driver, 30);
			tempElement = wait.until(ExpectedConditions.visibilityOf(element));
			return highlightElement(tempElement, driver);
		}

		catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	

	/**
	 * Author : Sachin Mashalkar
	 * Description : Waiting for an Element until it is clickable
	 * @param driver
	 * @param element
	 * @return
	 */
	public static WebElement waitForElementClickable(WebDriver driver, WebElement element){
		try{
			WebElement tempElement;
			WebDriverWait wait = new WebDriverWait(driver, 80);
			tempElement = wait.until(ExpectedConditions.elementToBeClickable(element));
			return highlightElement(tempElement, driver);
		}

		catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Waiting for an Element until it is disappear
	 * @param driver
	 * @param element
	 */
	public static void waitForElementToBeDisappear(WebDriver driver, List<WebElement> elements){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 80);
			wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
		}
		catch(Exception e){
			
		}
	}
	
	public static void waitForElementToDisappear(WebDriver driver, WebElement element){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 80);
			wait.until(ExpectedConditions.invisibilityOf(element));
		}
		catch(Exception e){
			
		}
	}
	
	
		public static boolean verifyInvisibilityOfElement(WebDriver driver , WebElement elmt)
		{
			try
			{
				waitForLoadingIcontoDisappear(driver);
					WebDriverWait wait = new WebDriverWait(driver, 5);
					wait.until(ExpectedConditions.visibilityOf(elmt));
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
	
		/**
		 * Author : Tushita Chaturvedi
		 * Description : Waiting for an Element to disappear with less wait time
		 * @param driver
		 * @param element
		 */
	public static void waitForElementToDisappearLess(WebDriver driver, WebElement element){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.pollingEvery(2, TimeUnit.SECONDS).until(ExpectedConditions.invisibilityOf(element));
		}
		catch(Exception e){
			
		}
	}
	
	
	
	
	/**
	 * Author : Sachin Mashalkar
	 * @param driver
	 * @param elementList
	 * @return List<WebElement>
	 * @Desc Wait for all elements to be visible in the list
	 */
	public static List<WebElement> waitForElements(WebDriver driver, List<WebElement> elementList){
		try{
				waitForLoadingIcontoDisappear(driver);
				WebDriverWait wait = new WebDriverWait(driver, 20);
				return wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
		}
		catch(Exception e){
				throw new AssertionError("Elements are not found.....");
		}
	}

	public static void selectFromDropdown(WebDriver driver, String Value , WebElement elmt)
	{
		Select select = new Select(waitForElement(driver, elmt));
		select.selectByVisibleText(Value);

	}
	
	public static void selectFromDropdownByIndex(WebDriver driver, int indexnum , WebElement elmt)
	{
		Select select = new Select(waitForElement(driver, elmt));
		select.selectByIndex(indexnum);

	}

	public static boolean isElementExist(WebDriver driver , WebElement elmt)
	{
		try
		{
			waitForLoadingIcontoDisappear(driver);
			waitForElement(driver, elmt);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean isElementsExist(WebDriver driver ,List< WebElement> elmt)
	{
		try
		{
			waitForLoadingIcontoDisappear(driver);
			waitForElements(driver, elmt);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	} 

	/**
	 * Author : Sachin Mashalkar
	 * Description : Highlight focused WebElement
	 * @param elmt
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 */
	private static WebElement highlightElement(WebElement elmt, WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid Red'", elmt);
		Thread.sleep(800);
		js.executeScript("arguments[0].style.border=''", elmt);
		return elmt;
	}

	/**
	 * Author : Sachin Mashalkar
	 * Description : Copy file path to Clip Board
	 * @param filePath
	 */
	private static void setClipboardData(String filePath) {
		//StringSelection class is used to copy and paste operations
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	/**
	 * Author : Sachin Mashalkar
	 * Description : Upload a file using Robot Class
	 * @param filePath
	 * @throws Throwable
	 */
	public static void uploadFileUsingRobotClass(String filePath) throws Throwable {
		try {
			Thread.sleep(1500);
			
			//Copy the file path to clip board
			setClipboardData(filePath);
			
			//Paste the copied data from clip board using Robot class
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1200);
			
			//Click on Select button of Window Form
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Switching between windows
	 * @param driver
	 */
	public static void switchToNextWindow(WebDriver driver) {
		for(String handle: driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}
	
	
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Switching to an iframe using index value
	 * @param driver
	 * @param index
	 */
	public static void switchToiFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
		
	}
	
	
	public static void switchToiFrameByWebElement(WebDriver driver, WebElement iFrameElement) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameElement));
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Waiting for Loading Icon to disappear
	 * @param driver
	 */
	public static void waitForLoadingIcontoDisappear(WebDriver driver) {
		try {
			waitForElementToBeDisappear(driver, driver.findElements(By.xpath("//div[@class='spinner']")));
		} catch(Exception e) {
		}
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Verify the file is downloaded
	 * @return
	 */
	public static boolean hasFileDownloaded() {
		try {
			Thread.sleep(1500);
			File dir = new File(downloadFilePath);
			File[] dirContents = dir.listFiles();
			if(pollingWaitForFiles(dirContents)) {
				deleteFileContents(dirContents);
				return true;
			} else {
				return false;
			}
		} catch(Throwable e) {
			throw new AssertionError("File not found in the directory");
		}
    }
	
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Delete Contents of Directory/File
	 * @param dirContents
	 */
	private static void deleteFileContents(File[] dirContents) {
		for (int i = 0; i < dirContents.length;) {
			dirContents[i].delete();
			break;
		}
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Accessing Shadow DOM Element
	 * @param element
	 * @param driver
	 * @return
	 */
	public static WebElement expandShadowRootElement(WebElement element, WebDriver driver) {
		WebElement ele = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
		return ele;
	}
	
	public static List<WebElement> expandShadowRootElements(List<WebElement> element, WebDriver driver) {
		List<WebElement> eleList = (List<WebElement>) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
		return eleList;
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Waiting for a File Download to complete
	 * @param driver
	 * @param element
	 */
	public static boolean waitForDownloadToComplete(WebDriver driver, WebElement element){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * Author : Sachin Mashalkar
	 * Description : Get execution time for test case
	 * @return
	 */
	public static String getExecutionTime() {
		executionEndTimeForScenario = System.currentTimeMillis()-executionStartTimeForScenario;
		String temp = (executionEndTimeForScenario/1000)/60 + " Minute(s) " + (executionEndTimeForScenario/1000)%60 + " Second(s)";
		return temp;
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Create JFree Pie Chart for Suite
	 * @throws Throwable
	 */
	private static void createPieChart(HSSFWorkbook workBook, HSSFSheet sheet) throws Throwable {
		sheet = workBook.createSheet("Chart");
		DefaultPieDataset pieChartData = new DefaultPieDataset();
		int passedTests = 0;
		int failedTests = 0;
		for(TestResultReport result : testResultReports) {
			if(result.getResult().equalsIgnoreCase("pass")) {
				++passedTests;
				pieChartData.setValue("Pass", passedTests);
			} else {
				++failedTests;
				pieChartData.setValue("Fail", failedTests);
			}
		}
		JFreeChart testChart = ChartFactory.createPieChart3D("CCMS Suite Result", pieChartData, true, true, false);
		int width = 640;
		int height = 480;
		float quality = 1;
		
		PiePlot plot = (PiePlot) testChart.getPlot();
		plot.setSectionPaint("Pass", Color.GREEN);
		plot.setSectionPaint("Fail", Color.RED);
		plot.setSectionPaint("Not Executed", Color.CYAN);
		plot.setStartAngle(90);             
	    plot.setForegroundAlpha( 0.60f );             
	    plot.setInteriorGap( 0.02 );

		PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
	    plot.setLabelGenerator(gen);
	    
		ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
		ChartUtilities.writeChartAsJPEG(chart_out, quality, testChart, width, height);
		int testResultId = workBook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_JPEG);
		chart_out.close();
		
		HSSFPatriarch drawing = sheet.createDrawingPatriarch();
		HSSFClientAnchor resultAnchor = new HSSFClientAnchor();
		resultAnchor.setCol1(3);
		resultAnchor.setRow1(4);
		
		HSSFPicture testResultPic = drawing.createPicture(resultAnchor, testResultId);
		testResultPic.resize();
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Return object of Dynamic Class
	 * @param className
	 * @return
	 */
	public static Object getDynamicClassObject(Class<?> className) {
		Object obj = className.toString().substring(className.toString().indexOf("com")).getClass();
		return obj;
	}
	
	/**
	 * Author : Kiran Wankhade
	 * Description : Create a method that checks if PIN exists in file
	 * @throws Throwable
	 */
	
	public static boolean isPinExistInfile(String filename) throws Throwable {
		
		//String filename = GlobalThings.registrationReviewPins;
		FileReader fr;
		BufferedReader br = null;
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			while (br.readLine() == null) {
				return false;

			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return true;
	}
	
	/**
	 * Author : Kiran Wankhade
	 * Description : Create a method that reads the first PIN from file
	 * @throws Throwable
	 */
	
	public static String getPINFromFile(String filename) throws Throwable {
		String firstLine = "";
		firstLine = getPinList(filename).get(0);
		return firstLine;
	}
	
	/**
	 * Author : Kiran Wankhade
	 * Description : Create a method that reads all the PINs from file
	 * @throws Throwable
	 */
	private static List<String> getPinList(String filename)
	{
		//String filename = GlobalThings.registrationReviewPins;
		FileReader fr;
		BufferedReader br = null;
		
		ArrayList<String> arrListPINs = new ArrayList<String>();
		try {
			String currentLine = "";
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			
			// insert all the PINs in array list
			while ((currentLine = br.readLine()) != null) {
				arrListPINs.add(currentLine);
			}
		}catch (IOException e) {
				e.printStackTrace();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} 
		finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
			return arrListPINs;
			
	}
	
	/**
	 * Author : Kiran Wankhade
	 * Description : Create a method that calls method to delete PIN from file
	 */
	
	public static boolean deletePinFromFile(String filename) {
		try {
			deleteDataFromFile(filename, getPinList(filename));
			return true;
			
		} catch (Throwable e) {
			return false;
			
		}
	}
	
	
	/**
	 * Author : Kiran Wankhade
	 * Description : Create a method that deletes first PIn from the file
	 * @throws Throwable
	 */
	
	private static void deleteDataFromFile(String filename, List<String> arrListPINs)throws Throwable {

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(filename);
			
			//Remove first element from the file
			arrListPINs.remove(0);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		writer.print("");
		writer.close();
		try {
			fw = new FileWriter(filename);
			bw = new BufferedWriter(fw);
			for (String pin : arrListPINs) {
				bw.write(pin);
				bw.newLine();
			}
		} catch (IOException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Scroll To Element
	 * @param driver
	 * @param element
	 * @return
	 */
	public static WebElement scrollToElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,"+(element.getLocation().getY())+");");
		return element;
	}
	
	/**
	 * Author : Kiran Wankhade
	 * Description : Scroll To bottom of page
	 * @param driver
	 * @param element
	 * @return
	 */
	
	public static void scrollToBottomOfPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	

	
	/**
	 * Author : Kiran Wankhade
	 * Description : Scroll To WebelementElement
	 * @param driver
	 * @param element
	 * @return
	 */
	public static void scrollSomeDown(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
	
	/**
	 * Author : Kiran Wankhade
	 * Description : Scroll To WebelementElement
	 * @param driver
	 * @param element
	 * @return
	 */
	public static WebElement scrollToWebElement(WebDriver driver, WebElement element) {
		waitForElement(driver, element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
		return element;
	}
	
	/**
	 * Author : Kiran Wankhade
	 * Description : Scroll To Elements
	 * @param driver
	 * @param element
	 * @return
	 */
	public static List<WebElement> scrollDownToElements(WebDriver driver, List<WebElement> elements) {
		for(WebElement e : elements) {
			scrollToElement(driver, e);
		}
		return elements;
	}

	/**
	 * Author : Kiran Wankhade
	 * Description : Scroll to top of page
	 * @param driver
	 * @param 
	 * @return
	 */
	
	public static void scrollVerticallyUp(WebDriver driver){
		((JavascriptExecutor)driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Custom assertTrue method for Logger 
	 * @param condition
	 * @param message
	 */
	public static void assertTrue(boolean condition, String message) {
		Assert.assertTrue(condition, message);
		ExtentReportManager.getLogger().log(LogStatus.PASS, "Verified that " + getLogMessage(message));
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Custom assertFalse method for Logger 
	 * @param condition
	 * @param message
	 */
	public static void assertFalse(boolean condition, String message) {
		Assert.assertFalse(condition, message);
		ExtentReportManager.getLogger().log(LogStatus.PASS, "Verified that " + getLogMessage(message));
	}

	/**
	 * Author : Sachin Mashalkar
	 * Description : Custom Generic assertEquals for Logger
	 * @param actual
	 * @param expected
	 * @param message
	 * @return
	 */
	public static <T> T assertEquals(T actual, T expected, String message) {
		Assert.assertEquals(actual, expected, message);
		ExtentReportManager.getLogger().log(LogStatus.PASS, "Verified that " + getLogMessage(message));
		return expected;
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Converting negative statement to positive for Log
	 * @param message
	 * @return
	 */
	private static String getLogMessage(String message) {
		if(message.toLowerCase().contains("not")) {
			return message.replace("not", "");
		} else if(message.toLowerCase().contains("unsuccessful")) {
			return message.replace("Unsuccessful", "Successful");
		}else if(message.toLowerCase().contains("No")) {
			return message.replace("No", "");
		} else if (message.contains("Exists")) {
			return message.replace("Exists", "Not Exists");
		}else {
			return message;
		}
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Close all CKC Call errors
	 * @param driver
	 */
	public static void closeSAPErrorMessages(WebDriver driver) {
		for(WebElement e : CommonFunctions.waitForElements(driver, driver.findElements(By.className("dismiss-btn")))) {
			e.click();
		}		
	}

	/**
	 * Author : Sachin Mashalkar
	 * Description : Longer Wait for Elements List
	 * @param driver
	 * @param element
	 * @return
	 */
	public static List<WebElement> longWaitForElements(WebDriver driver, final List<WebElement> elementList){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 40);
			return wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
		}
		catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private static boolean pollingWaitForFiles(File[] dirContents) throws Throwable {
		int count = 0;
		boolean flag = false;
		for(count = 0; count < 5; count++) {
			Thread.sleep(2500);
			if(dirContents.length > 0) {
				for (int i = 0; i < dirContents.length; i++) {
					if(dirContents[i].getName().contains("csv") || dirContents[i].getName().contains("xlsx") || dirContents[i].getName().contains("xls")) {
						flag = true;
						break;
					}					
				}
			} else {
				flag = false;
			}
			if(flag) {
				break;
			}
		}
		return flag;
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Verify method for continuing the execution if any verification step fails
	 * @param object1
	 * @param object2
	 * @return
	 */
	public static <T> boolean verify(T object1, T object2, String message) {
		try {
			boolean temp = object1.equals(object2);
			if(temp)
				ExtentReportManager.getLogger().log(LogStatus.PASS, getLogMessage(message));
			else
				ExtentReportManager.getLogger().log(LogStatus.FAIL, message + " expected " + object2.toString() + " found " + object1.toString());
			return temp;
		} catch(Exception e) {
			ExtentReportManager.getLogger().log(LogStatus.FAIL, message + " expected " + object2.toString() + " found " + object1.toString());
			return false;
		}
	}
	
	/**
	 * Author : Kiran Wankhade
	 * Description : Verify method for continuing the execution if any verification step fails
	 * @param boolean value
	 * @return
	 */
	
	public static void verify(boolean value, String message) {
		try {
		if(value)	
			ExtentReportManager.getLogger().log(LogStatus.PASS, getLogMessage(message));
		else
			ExtentReportManager.getLogger().log(LogStatus.FAIL, "No " + message);
		}
		catch(Exception  e) {
			ExtentReportManager.getLogger().log(LogStatus.FAIL, "No " + message);
		}
			
	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Verify all elements are displayed
	 * @param driver
	 * @param elmt
	 * @return
	 */
	public static boolean areElementsExists(WebDriver driver , List<WebElement> elmt)
	{
		try
		{
			waitForElements(driver, elmt);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static void takeScreenShot(WebDriver driver, String sSPath) {
		if(driver!=null){
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(sSPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static InputTestDetails getTestDataDetails(String methodName) {
		InputTestDetails itd = null;
		for(InputTestDetails inputTestDetails : listOfInputs) {
			if(inputTestDetails.getTestCaseID().equals(methodName.replaceAll("test_", ""))) {
				itd = inputTestDetails;
			}
		}
		return itd;
	}
	
	
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Wait for iFrame to be visible 
	 * @param driver
	 * @param element
	 * @return
	 */
	public static WebElement waitAndSwitchToFrame(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
			return element;
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static WebElement clickElementUsingJavaScript(WebDriver driver, WebElement element) {
        try {
			((JavascriptExecutor)driver).executeScript("arguments[0].click()", highlightElement(element, driver));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return element;
	}
	
	/**
	 * Author : Kiran Wankhade
	 * Description : Wait for alert to be visible 
	 * @param driver
	 * @param element
	 * @return
	 */
	 
	public static void waitForAlert(WebDriver driver) {
			try {
				WebDriverWait wait = new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.alertIsPresent());
				Thread.sleep(500);
				driver.switchTo().alert().accept();
				Thread.sleep(1000);
			}catch(Exception e) {
				}
		} 

	
	public static boolean retryingFindElement(WebDriver driver, WebElement ele) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                isElementExist(driver, ele);
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
}
	
	public static boolean retryingFindElements(WebDriver driver, List<WebElement> ele) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                isElementsExist(driver, ele);
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
	}
	
	public static WebElement waitForErrorMessage(WebDriver driver, WebElement element){
		try{
			WebElement tempElement;
			WebDriverWait wait = new WebDriverWait(driver, 5);
			tempElement = wait.until(ExpectedConditions.visibilityOf(element));
			return highlightElement(tempElement, driver);
		}

		catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}

	
    /**
    * Author : Tushita Chaturvedi
    * Description : Waiting for an Element to reappear
    * @param driver
    * @param element
    */
    public static WebElement waitForElementToReappear(WebDriver driver, WebElement element){
          try{
               try{
                    WebDriverWait wait1 = new WebDriverWait(driver, 6);
                    wait1.pollingEvery(2, TimeUnit.SECONDS).until(ExpectedConditions.invisibilityOf(element));
                    }catch(Exception e)  {
                          WebDriverWait wait = new WebDriverWait(driver, 20);
                          WebElement tempElement = wait.pollingEvery(3, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(element));
                          return highlightElement(tempElement, driver);
               }
               WebDriverWait wait = new WebDriverWait(driver, 20);
               WebElement tempElement = wait.pollingEvery(3, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(element));
               return highlightElement(tempElement, driver);
          }
          catch(Exception e){
               throw new RuntimeException(e.getMessage());
          }
    }
    
    /**
    * Author : Tushita Chaturvedi
    * Description : Waiting for List of Elements to reappear
    * @param driver
    * @param element
    */
    public static void waitForElementsToReappear(WebDriver driver,List<WebElement> elements){
          int count=0;
          try{
               try{
                    WebDriverWait wait1 = new WebDriverWait(driver, 6);
                    wait1.pollingEvery(2, TimeUnit.SECONDS).until(ExpectedConditions.invisibilityOfAllElements(elements));
                    }catch(Exception e)  {
                    WebDriverWait wait = new WebDriverWait(driver, 20);
                    wait.pollingEvery(2, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOfAllElements(elements));
                    count++;
               }
               if(count==0) {
               WebDriverWait wait = new WebDriverWait(driver, 20);
               wait.pollingEvery(2, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOfAllElements(elements));
               }
          }
          catch(Exception e){
               
          }
    }


	public static void waitForPageLoad(WebDriver driver) {

	    Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver1) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}

	
	/**
	 * Author : Jyothsna sameera
	 * Description : Wait and Switch to default content 
	 * @param driver
	 * @return
	 */
		public static void switchToDefaultFrame(WebDriver driver) {
				driver.switchTo().defaultContent();
			} 
		
		
		public static void HiddenElements(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
		}

}

