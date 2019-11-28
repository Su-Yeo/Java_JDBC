package bank;

import login.ChangeLev;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String account;
	private long money;
	private String lev;
	private int point;
	
	public Member() {}
	public Member(String id, String pw, String name, String account, long money, String lev, int point) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.account = account;
		this.money = money;
		this.lev = lev;
		this.point =point;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
