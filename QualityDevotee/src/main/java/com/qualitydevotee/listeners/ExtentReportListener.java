package com.qualitydevotee.listeners;

import java.io.File;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportListener implements ITestListener{
    public static ExtentReports reports;
    public static ExtentTest test;

    public static String resultpath = getResultPath();


    public static void deleteDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files!=null) {
                for (int i = 0; i < files.length; i++) {
                    //					System.out.println(files[i].getName());
                    if (files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                        files[i].delete();
                    } else {
                        files[i].delete();
                    }
                }
            }
        }
    }

    private static String getResultPath() {
        resultpath = "test";//new SimpleDateFormat("yyyy-MM-dd hh-mm.ss").format(new Date());
        if (!new File(resultpath).isDirectory()) {
            new File(resultpath);
        }
        return resultpath;
    }

    String ReportLocation = "test-output/Report/" + resultpath + "/";

    public void onTestStart(ITestResult result) {

        test = reports.startTest(result.getMethod().getMethodName());
        test.log(LogStatus.INFO, result.getMethod().getMethodName());
//		System.out.println(result.getTestClass().getTestName());
//		System.out.println(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.log(LogStatus.PASS, "Test is Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.log(LogStatus.FAIL, "Test is Failed");
    }

    public void onTestSkipped(ITestResult result) {
        test.log(LogStatus.SKIP, "Test is Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

        reports = new ExtentReports(ReportLocation + "OpenWeatherAPIReport.html");
        test = reports.startTest("OpenWeatherStartTest");
    }

    public void onFinish(ITestContext context) {
        reports.endTest(test);
        reports.flush();
    }
}