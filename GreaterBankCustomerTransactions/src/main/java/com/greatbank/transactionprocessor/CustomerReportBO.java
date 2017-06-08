package com.greatbank.transactionprocessor;

/**
 * @author Sinto
 *
 */
public class CustomerReportBO {
	private String nameOfFile;
	private int numberOfProcessedAccounts;
	private double totalDebit;
	private double totalCredit;
	private int numberOfSkippedAccounts;
	public String getNameOfFile() {
		return nameOfFile;
	}
	public void setNameOfFile(String nameOfFile) {
		this.nameOfFile = nameOfFile;
	}
	public int getNumberOfProcessedAccounts() {
		return numberOfProcessedAccounts;
	}
	public void setNumberOfProcessedAccounts(int numberOfProcessedAccounts) {
		this.numberOfProcessedAccounts = numberOfProcessedAccounts;
	}
	public double getTotalDebit() {
		return totalDebit;
	}
	public void setTotalDebit(double totalDebit) {
		this.totalDebit = totalDebit;
	}
	public double getTotalCredit() {
		return totalCredit;
	}
	public void setTotalCredit(double totalCredit) {
		this.totalCredit = totalCredit;
	}
	public int getNumberOfSkippedAccounts() {
		return numberOfSkippedAccounts;
	}
	public void setNumberOfSkippedAccounts(int numberOfSkippedAccounts) {
		this.numberOfSkippedAccounts = numberOfSkippedAccounts;
	}
	@Override
	public String toString() {
		return "CustomerReportBO [nameOfFile=" + nameOfFile + ", numberOfProcessedAccounts=" + numberOfProcessedAccounts
				+ ", totalDebit=" + totalDebit + ", totalCredit=" + totalCredit + ", numberOfSkippedAccounts="
				+ numberOfSkippedAccounts + "]";
	}

}
