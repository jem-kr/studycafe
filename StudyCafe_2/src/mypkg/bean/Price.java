package mypkg.bean;

public class Price {
	private String id;
	private int sumtotal;
	private String or_date;
	private int cnt;
	private int month_total;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSumtotal() {
		return sumtotal;
	}
	public void setSumtotal(int sumtotal) {
		this.sumtotal = sumtotal;
	}
	public String getOr_date() {
		return or_date;
	}
	public void setOr_date(String or_date) {
		this.or_date = or_date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getMonth_total() {
		return month_total;
	}
	public void setMonth_total(int month_total) {
		this.month_total = month_total;
	}
	@Override
	public String toString() {
		return "Price [id=" + id + ", sumtotal=" + sumtotal + ", or_date=" + or_date + ", cnt=" + cnt + ", month_total="
				+ month_total + "]";
	}
	public Price(String id, int sumtotal, String or_date, int cnt, int month_total) {
		super();
		this.id = id;
		this.sumtotal = sumtotal;
		this.or_date = or_date;
		this.cnt = cnt;
		this.month_total = month_total;
	}

public Price() {
	// TODO Auto-generated constructor stub
}
	
	
}
