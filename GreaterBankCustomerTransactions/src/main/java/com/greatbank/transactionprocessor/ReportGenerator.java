package com.greatbank.transactionprocessor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Sinto
 *
 */
public class ReportGenerator {
	public static final String FILEPROCESSED = "File Processed: ";
	public static final String TOTALACCOUNTS = "Total Accounts: "; 
	public static final String TOTALCREDITS = "Total Credits : ";
	public static final String TOTALDEBITS = "Total Debits : ";
	public static final String SKIPPEDTRANS = "Skipped Transactions: ";
	public static void writeToFile(String env,String filename,CustomerReportBO bo){
		File directory = new File(env+"\\reports");
		if (! directory.exists()){
			directory.mkdir();
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(env+"\\reports\\"+filename,true))) {
			bw.write(FILEPROCESSED +bo.getNameOfFile());
			bw.newLine();
			bw.write(TOTALACCOUNTS +bo.getNumberOfProcessedAccounts());
			bw.newLine();
			bw.write(TOTALCREDITS +bo.getTotalCredit());
			bw.newLine();
			bw.write(TOTALDEBITS +bo.getTotalDebit());
			bw.newLine();
			bw.write(SKIPPEDTRANS +bo.getNumberOfSkippedAccounts());
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
