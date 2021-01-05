package mypkg.bean;

public class Notice {
	private String writer;	//작성자
	private int num;		//굴번호
	private String title;	//제목
	private String content;	//내용
	private String image;	//첨부파일
	private int readhit;	//조회수
	private String regdate;	//작성일자
	private String remark;	//비고
	
	private int fix;
	
	
	
	public int getFix() {
		return fix;
	}
	public void setFix(int fix) {
		this.fix = fix;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getReadhit() {
		return readhit;
	}
	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Notice [writer=" + writer + ", num=" + num + ", title=" + title + ", content=" + content + ", image="
				+ image + ", readhit=" + readhit + ", regdate=" + regdate + ", remark=" + remark + ", fix=" + fix + "]";
	}
	public Notice() {
	}



}
