package mypkg.bean;

public class Reservation {
	 	private int re_no;
	 	private String re_id;
	 	private String re_date;
	 	private int re_stime;
	 	private int re_etime;
	 	private int re_hour;
	 	private String re_type;
	 	private String re_seat;
	 	private int person;
	 	private String re_pday;
	 	private int re_price;
	 	private String remark;
		public int getRe_no() {
			return re_no;
		}
		public void setRe_no(int re_no) {
			this.re_no = re_no;
		}
		public String getRe_id() {
			return re_id;
		}
		public void setRe_id(String re_id) {
			this.re_id = re_id;
		}
		public String getRe_date() {
			return re_date;
		}
		public void setRe_date(String re_date) {
			this.re_date = re_date;
		}
		public int getRe_stime() {
			return re_stime;
		}
		public void setRe_stime(int re_stime) {
			this.re_stime = re_stime;
		}
		public int getRe_etime() {
			return re_etime;
		}
		public void setRe_etime(int re_etime) {
			this.re_etime = re_etime;
		}
		public int getRe_hour() {
			return re_hour;
		}
		public void setRe_hour(int re_hour) {
			this.re_hour = re_hour;
		}
		public String getRe_type() {
			return re_type;
		}
		public void setRe_type(String re_type) {
			this.re_type = re_type;
		}
		public String getRe_seat() {
			return re_seat;
		}
		public void setRe_seat(String re_seat) {
			this.re_seat = re_seat;
		}
		public int getPerson() {
			return person;
		}
		public void setPerson(int person) {
			this.person = person;
		}
		public String getRe_pday() {
			return re_pday;
		}
		public void setRe_pday(String re_pday) {
			this.re_pday = re_pday;
		}
		public int getRe_price() {
			return re_price;
		}
		public void setRe_price(int re_price) {
			this.re_price = re_price;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		@Override
		public String toString() {
			return "Reservation [re_no=" + re_no + ", re_id=" + re_id + ", re_date=" + re_date + ", re_stime="
					+ re_stime + ", re_etime=" + re_etime + ", re_hour=" + re_hour + ", re_type=" + re_type
					+ ", re_seat=" + re_seat + ", person=" + person + ", re_pday=" + re_pday + ", re_price=" + re_price
					+ ", remark=" + remark + "]";
		}
	 	
	 	public Reservation() {
			// TODO Auto-generated constructor stub
		}
}
