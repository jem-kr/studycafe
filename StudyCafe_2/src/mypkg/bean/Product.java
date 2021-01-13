
package mypkg.bean;

public class Product {
	
	//상품 변수 정의
	private String p_type;
	private String p_seat;
	private int p_price;
	private String p_date;
	private int p_stime;
	private int p_etime;
	private int p_hour;
	private String p_pic;
	private String remark;


	public Product() {
		// TODO Auto-generated constructor stub
	}


	public String getP_type() {
		return p_type;
	}


	public void setP_type(String p_type) {
		this.p_type = p_type;
	}


	public String getP_seat() {
		return p_seat;
	}


	public void setP_seat(String p_seat) {
		this.p_seat = p_seat;
	}


	public int getP_price() {
		return p_price;
	}


	public void setP_price(int p_price) {
		this.p_price = p_price;
	}


	public String getP_date() {
		return p_date;
	}


	public void setP_date(String p_date) {
		this.p_date = p_date;
	}


	public int getP_stime() {
		return p_stime;
	}


	public void setP_stime(int p_stime) {
		this.p_stime = p_stime;
	}


	public int getP_etime() {
		return p_etime;
	}


	public void setP_etime(int p_etime) {
		this.p_etime = p_etime;
	}


	public int getP_hour() {
		return p_hour;
	}


	public void setP_hour(int p_hour) {
		this.p_hour = p_hour;
	}


	public String getP_pic() {
		return p_pic;
	}


	public void setP_pic(String p_pic) {
		this.p_pic = p_pic;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "Product [p_type=" + p_type + ", p_seat=" + p_seat + ", p_price=" + p_price + ", p_date=" + p_date
				+ ", p_stime=" + p_stime + ", p_etime=" + p_etime + ", p_hour=" + p_hour + ", p_pic=" + p_pic
				+ ", remark=" + remark + "]";
	}
	
	

}


