package com.greatbank.transactionprocessor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CSVProcessorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNotNullReport() {
		String envVar = System.getenv("TRANSACTION_PROCESSING");
		CSVProcessor  csvProcessor = new CSVProcessor();
		CustomerReportBO reportBO = csvProcessor.readCsvFile(envVar+"/pending/"+"finance_customer_transactions.csv");
		assertNotNull(reportBO);
	}
	@Test
	public void testCustomerObjectFilenameValue() {
		CSVProcessor  csvProcessor = new CSVProcessor();
		CustomerReportBO reportBO = csvProcessor.readCsvFile("finance_customer_transactions.csv");
		assertNotNull(reportBO);
		assertEquals("finance_customer_transactions.csv", reportBO.getNameOfFile());
	}
	@Test
	public void testReportNumberOfAccountProcessed() {
		CSVProcessor  csvProcessor = new CSVProcessor();
		CustomerReportBO reportBO = csvProcessor.readCsvFile("finance_customer_transactions.csv");
		assertNotNull(reportBO);
		assertEquals(2, reportBO.getNumberOfProcessedAccounts());
	}
	@Test
	public void testReportTotalDebit() {
		CSVProcessor  csvProcessor = new CSVProcessor();
		CustomerReportBO reportBO = csvProcessor.readCsvFile("finance_customer_transactions.csv");
		assertNotNull(reportBO);
		assertEquals(50.0d, reportBO.getTotalDebit(),0);
	}
	@Test
	public void testReportTotalCredit() {
		CSVProcessor  csvProcessor = new CSVProcessor();
		CustomerReportBO reportBO = csvProcessor.readCsvFile("finance_customer_transactions.csv");
		assertNotNull(reportBO);
		assertEquals(100.0d, reportBO.getTotalCredit(),0);
	}
}
