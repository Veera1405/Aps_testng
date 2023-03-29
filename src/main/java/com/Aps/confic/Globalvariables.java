package com.Aps.confic;

import java.io.File;

public interface Globalvariables {
	String BASE_URL = Config.getProperty("url"); // "http://demowebshop.tricentis.com/";
	String EMAIL = Config.getProperty("userEmail"); // "test321@yahoo.com";
	String PASSWORD = Config.getProperty("userPassword"); // "test321";
	String NOT_APPLICABLE = "NA";

	String WORKBOOK = Config.getProperty("workbook"); // "TestData.xlsx";
	String SCENARIO_SHEET_NAME = Config.getProperty("sheet"); // "Scenarios";
	int RUN_MODE_COLUMN = 3;
	int TEST_CASE_COLUMN = 1;
	String RUN_MODE_YES = "YES";

	String START = "STARTED";
	String PASS = "PASSED";
	String FAIL = "FAILED";
	String SKIP = "SKIPED";

	String CONFIG_FILE = "Config.properties";
	String DATA_FOLDER = new File(Config.getProperty("dataPath")).getAbsolutePath() + File.separator;
	String SCREENSHOT_FOLDER = new File("screenshots").getAbsolutePath() + File.separator;
	String DOWNLOAD_FOLDER = new File("downloads").getAbsolutePath() + File.separator;
	String ALLURE_RESULTS = new File("allure-results").getAbsolutePath() + File.separator;
	String IMAGE_TYPE = ".png";
	String TEST_PACKAGE = "com.Aps.test.%s";

	// Time unit in seconds
	int EXPLICIT_WAIT = Integer.valueOf(Config.getProperty("explicitWait")); // 15;
	int IMPLICIT_WAIT = Integer.valueOf(Config.getProperty("implicitWait")); // 5;
	int DOWNLOAD_WAIT = Integer.valueOf(Config.getProperty("downloadTime")); // 60;
	int MAX_TRY = Config.getProperty("retry").equalsIgnoreCase("TRUE") ? 1 : 0; // 1;

	String EXTENT_REPORT = Config.getProperty("reportPath"); // "target/reports/extent/index.html";
	String EXTENT_CONFIG = Config.getProperty("configPath"); // "src/test/resources/html-config.xml";

	// Db connection
	public final static String connectionUrl = "jdbc:sqlserver://VEERA-IT;" + "databaseName=APS_2.0;"
			+ "integratedSecurity=true;" + "encrpt=true;" + "trustServerCertificate=true;"
			+ "MultipleActiveResultSets=True;" + "Connection Timeout=30";

	public final static String DBdriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

}
