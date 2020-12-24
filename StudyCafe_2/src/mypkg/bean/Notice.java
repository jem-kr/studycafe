package mypkg.bean;

public class Notice {
	private String writer;	//작성자
	private int num;		//굴번호
	private String title;	//제목
	private String content;	//내용
	private String image;	//첨부파일
	private int readhit;	//조회수
	private String regdate;	//작성일자
	private int groupno;	//답글 그룹
	private int orderno;	//답글 순서
	private int depth;		//답글 깊이
	private String remark;	//비고
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
	public int getGroupno() {
		return groupno;
	}
	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
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
				+ image + ", readhit=" + readhit + ", regdate=" + regdate + ", groupno=" + groupno + ", orderno="
				+ orderno + ", depth=" + depth + ", remark=" + remark + "]";
	}

	public Notice() {
	}



}
