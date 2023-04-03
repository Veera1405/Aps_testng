package com.Aps.testrunner;

import com.Aps.confic.Globalvariables;
import com.Aps.utils.ExcelUtil;
import org.testng.annotations.Factory;

import java.util.ArrayList;

public class TestExecutor implements Globalvariables {


    @Factory
    public Object[] testCasesToExecute() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ArrayList<Object> tests = new ArrayList<Object>();
        ExcelUtil excel = new ExcelUtil();
        excel.setExcelFile(DATA_FOLDER + WORKBOOK);
        for (String scenario : excel.getScenariosToRun(SCENARIO_SHEET_NAME, RUN_MODE_COLUMN, TEST_CASE_COLUMN)) {
            tests.add(createObject(scenario));
        }
        return tests.toArray();
    }

    public Object createObject(String test) {
        Object object = null;
        try {
            object = Class.forName(String.format(TEST_PACKAGE, test)).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
