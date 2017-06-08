package com.greatbank.transactionprocessor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 * @author Sinto
 *
 */
public class CSVProcessor {
	private static final String [] FILE_HEADER_MAPPING = {"Customer Account","Transaction Amount"};
	private static final String ACCOUNT_NUM = "Customer Account";
	private static final String TRANS_AMOUNT = "Transaction Amount";
	private static Customer isRecordValid(CSVRecord record){
		Customer customer = null;
		boolean accvalidity = true;
		try{
			String accNumString = record.get(ACCOUNT_NUM);
			accvalidity = GBUtil.isInteger(accNumString);
			int accNum = Integer.parseInt(accNumString);
			double transAmount = Double.parseDouble(record.get(TRANS_AMOUNT));
			customer = new Customer(accNum,transAmount);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(accvalidity==false){
			customer = null;
		}
		return customer;
	}
	public CustomerReportBO readCsvFile(String fileName) {
		FileReader fileReader = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
		CustomerReportBO reportBO=null;
		try {
			fileReader = new FileReader(fileName);
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			List<CSVRecord> csvRecords = csvFileParser.getRecords(); 
			Map<Integer,Customer> customerMap =new ConcurrentHashMap<Integer,Customer>();
			double totalCredit=0;
			double totalDebit=0;
			int skippedAccount = 0;
			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord record = csvRecords.get(i);
				if(reportBO==null){
					reportBO = new CustomerReportBO();
					reportBO.setNameOfFile(fileName);
				}
				Customer customer = isRecordValid(record);
				if(customer==null){
					skippedAccount++;
					continue;
				}

				int accNum = customer.getAccNum();
				double transAmount = customer.getBalancAmount();
				Customer existingCustomer = customerMap.get(accNum);
				if(existingCustomer ==null) {
					customerMap.put(customer.getAccNum(), customer);
				}else{
					if(transAmount<0){
						existingCustomer.setBalancAmount(existingCustomer.getBalancAmount()- transAmount);
					}else{
						existingCustomer.setBalancAmount(existingCustomer.getBalancAmount()+ transAmount);
					}
				}
				if(transAmount<0){
					totalDebit=totalDebit-transAmount;
				}else{
					totalCredit = totalCredit+transAmount;
				}
			}
			if(customerMap !=null){
				reportBO.setNumberOfProcessedAccounts(customerMap.size());
				reportBO.setTotalCredit(totalCredit);
				reportBO.setTotalDebit (totalDebit);
				reportBO.setNumberOfSkippedAccounts(skippedAccount);
			}
			System.out.println(reportBO);
		} 
		catch (FileNotFoundException e) {
			System.out.println("The mentioned file "+fileName+" doesn't exist");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvFileParser.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader/csvFileParser !!!");
				e.printStackTrace();
			}
		}
		return reportBO;
	}
}
