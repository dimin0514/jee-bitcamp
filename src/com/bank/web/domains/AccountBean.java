package com.bank.web.domains;
import java.io.Serializable;
public class AccountBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String accuntNum, money, today;

	public String getAccuntNum() {
		return accuntNum;
	}

	public void setAccuntNum(String accuntNum) {
		this.accuntNum = accuntNum;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	@Override
	public String toString() {
		return "계좌정보 [계좌번호=" + accuntNum 
				+ ", 금액=" + money 
				+ ", 날짜=" + today + "]";
	}
	
	

}
