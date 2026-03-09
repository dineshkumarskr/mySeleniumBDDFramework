package com.WJ.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;

    public static ExtentReports getInstance() {
    	
    	String time = LocalDateTime.now()
    	        .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        if (extent == null) {
           ExtentSparkReporter spark =
                    new ExtentSparkReporter("target/ExtentReport_"+time+".html");

            spark.config().setReportName("Cucumber Demo Report");
            spark.config().setDocumentTitle("Cucumber Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }

}
