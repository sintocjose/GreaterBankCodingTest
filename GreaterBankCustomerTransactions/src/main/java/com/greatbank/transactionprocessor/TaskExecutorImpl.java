package com.greatbank.transactionprocessor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Sinto
 *
 */
public class TaskExecutorImpl implements TaskExecutor {
	public void execute(){
		String envVar = System.getenv("TRANSACTION_PROCESSING");
		System.out.println(envVar);
		CSVProcessor  csvProcessor = new CSVProcessor();
		CustomerReportBO reportBO = csvProcessor.readCsvFile(envVar+"/pending/"+"finance_customer_transactions.csv");
		String fileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		fileName = "finance_customer_transactions_report-"+fileName+".txt";
		ReportGenerator.writeToFile(envVar,fileName,reportBO);
	}
}
