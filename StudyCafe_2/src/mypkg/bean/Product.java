
package mypkg.bean;

public class Product {
	
	//상품 변수 정의
	private int pnum;
	private String item;
	private String seatnum;
	private String ptype; 
	private int price;
	private int hours; 
	private String category; 
	private String pic;
	
	//생성자
	public Product() { 
		
	}
	
	//toString
	@Override
	public String toString() {
		return "Product [pnum=" + pnum + ", item=" + item + ", seatnum=" + seatnum + ", ptype=" + ptype + ", price="
				+ price + ", hours=" + hours + ", category=" + category + ", pic=" + pic + "]";
	}
	
	//getter & setter
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(String seatnum) {
		this.seatnum = seatnum;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	
	
	
	
	
	
	
}
