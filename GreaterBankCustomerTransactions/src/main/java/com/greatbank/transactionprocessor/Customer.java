package com.greatbank.transactionprocessor;
/**
 * @author Sinto
 *
 */
public class Customer {

	public Customer(int accNum, double balancAmount) {
		super();
		this.accNum = accNum;
		this.balancAmount = balancAmount;
	}
	private int accNum;
	private double balancAmount;
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public double getBalancAmount() {
		return balancAmount;
	}
	public void setBalancAmount(double balancAmount) {
		this.balancAmount = balancAmount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accNum;
		long temp;
		temp = Double.doubleToLongBits(balancAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (accNum != other.accNum)
			return false;
		if (Double.doubleToLongBits(balancAmount) != Double.doubleToLongBits(other.balancAmount))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [accNum=" + accNum + ", balancAmount=" + balancAmount + "]";
	}
}
