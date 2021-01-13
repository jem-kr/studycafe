package mypkg.bean;

public class Order {
	private int or_no;
	private String or_id;
	private int or_rnum;
	private String or_seat;
	private String or_date;
	private int or_stime;
	private int or_etime;
	private int or_hour;
	private int or_price;
	private String or_pday;
	private String remark;
	public int getOr_no() {
		return or_no;
	}
	public void setOr_no(int or_no) {
		this.or_no = or_no;
	}
	public String getOr_id() {
		return or_id;
	}
	public void setOr_id(String or_id) {
		this.or_id = or_id;
	}
	public int getOr_rnum() {
		return or_rnum;
	}
	public void setOr_rnum(int or_rnum) {
		this.or_rnum = or_rnum;
	}
	public String getOr_seat() {
		return or_seat;
	}
	public void setOr_seat(String or_seat) {
		this.or_seat = or_seat;
	}
	public String getOr_date() {
		return or_date;
	}
	public void setOr_date(String or_date) {
		this.or_date = or_date;
	}
	public int getOr_stime() {
		return or_stime;
	}
	public void setOr_stime(int or_stime) {
		this.or_stime = or_stime;
	}
	public int getOr_etime() {
		return or_etime;
	}
	public void setOr_etime(int or_etime) {
		this.or_etime = or_etime;
	}
	public int getOr_hour() {
		return or_hour;
	}
	public void setOr_hour(int or_hour) {
		this.or_hour = or_hour;
	}
	public int getOr_price() {
		return or_price;
	}
	public void setOr_price(int or_price) {
		this.or_price = or_price;
	}
	public String getOr_pday() {
		return or_pday;
	}
	public void setOr_pday(String or_pday) {
		this.or_pday = or_pday;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Order [or_no=" + or_no + ", or_id=" + or_id + ", or_rnum=" + or_rnum + ", or_seat=" + or_seat
				+ ", or_date=" + or_date + ", or_stime=" + or_stime + ", or_etime=" + or_etime + ", or_hour=" + or_hour
				+ ", or_price=" + or_price + ", or_pday=" + or_pday + ", remark=" + remark + "]";
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
}
