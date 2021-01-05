package mypkg.utility;

public class Paging {
	private int totalCount = 0; //총 게시물 건수
	private int totalPage = 0;	//총 페이지 수
	
	private int pageNumber = 0;	// 현재 페이지 번호
	private int pageSize = 0;	// 한 페이지 당 보여줄 건 수
	private int beginRow = 0;	// 현재 페이지의 첫번째 글 번호
	private int endRow = 0;		// 현재 페이지의 마지막 글 번호
	
	private int pageCount =10;	// 하단에 보여줄 페이지 링크의 수 (1~10페이지)
	private int beginPage=0;	// 하단에 보여질 첫 페이지 번호
	private int endPage = 0;	// 하단에 보여질 마지막 페이지 번호
		
	private String url = "";		// 공지사항 게시판의 url
	private String pagingHtml="";	// 하단에 보여지는 페이지 번호를 눌렀을때의 링크
	private String pagingStatus="";	// 현재 페이지가 몇페이지인지 보여줌
	
	private String mode ="";	// 검색모드
	private String keyword="";	// 검색 단어
	
	private String PaginationSize = "pagination-sm";

	public Paging(
			String _pageNumber,
			String _pageSize,
			int totalCount,
			String url,
			String mode,
			String keyword) {
		if(_pageNumber == null || _pageNumber.equals("null")||_pageNumber.equals("")) {
			_pageNumber="1";
		}
		this.pageNumber=Integer.parseInt(_pageNumber);
		
		if(_pageSize == null || _pageSize.equals("null") || _pageSize.equals("")) {
			_pageSize = "10";
		}
		this.pageSize=Integer.parseInt(_pageSize);
		
		this.totalCount=totalCount;
		this.url=url;
		this.mode=mode;
		this.keyword=keyword;
		
		this.totalPage=(int)Math.ceil((double)totalCount / pageSize);
		this.beginRow=(pageNumber-1)*pageSize+1;
		this.endRow=this.pageNumber*this.pageSize;
		
		this.beginPage=(this.pageNumber-1)/this.pageCount*this.pageCount+1;
		this.endPage=this.beginPage+this.pageCount-1;
		
		if(this.totalPage<this.endPage) {
			this.endPage=this.totalPage;
		}
		
		this.pagingHtml = this.getPagingHtml(url);
		this.pagingStatus = "총 " +totalCount+"건["+this.pageNumber
				+"/"+this.totalPage+"]";
//		this.DisplayInformation(); 
	}

	private String getPagingHtml(String url) {
		String result="";
		String add_param = "&mode=" + mode + "&keyword=" + keyword;
		
		result+= "<ul class='pagination " + PaginationSize+ "'>";
		if(pageNumber<=pageCount) {
		
		}else {
		result+="<li><a href='"+url+"&pageNumber="+1+
				"&pageSize="+pageSize+add_param+"'>맨처음</a></li>&nbsp;&nbsp;";
		result += "<li><a href='" + url + "&pageNumber=" + (beginPage - 1) + 
				"&pageSize=" + pageSize + add_param + "'>이전</a></li>&nbsp;&nbsp;";		
		}
		
		for (int i = beginPage; i <= endPage; i++) {
			if(i==pageNumber) {
				result += "<li class='active'><a><font color='red'><b>" + i + "</b></font></a></li>&nbsp;";
			}else{
				result += "<li><a href='" + url + "&pageNumber=" + i + 
					"&pageSize=" + pageSize + add_param + "'>" + i + "</li></a>&nbsp;";
		
			}
		}
		if ( pageNumber >= (totalPage / pageCount * pageCount + 1) ) {
			//result += "다음&nbsp;&nbsp;";
			//result += "맨 끝&nbsp;&nbsp;";	
		} else {			
			result += "<li><a href='" + url + "&pageNumber=" + (endPage + 1) + 
				"&pageSize=" + pageSize + add_param + "'>다음</a></li>&nbsp;&nbsp;";
			
			result += "<li><a href='" + url + "&pageNumber=" + totalPage + 
				"&pageSize=" + pageSize + add_param + "'>맨 끝</a></li>";
		}
		result += "</ul>"; 
		return result ;
	}

	public int getPageSize() {
		return pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public int getBeginRow() {
		return beginRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public String getPagingHtml() {
		return pagingHtml;
	}
	public String getPagingStatus() {
		return pagingStatus;
	}
	public String getMode() {
		return mode;
	}
	public String getKeyword() {
		return keyword;
	}

	
//	private void DisplayInformation() {
//		System.out.println("총 레코드 건수 : " + totalCount + "\n");
//		System.out.println("전체 페이지 수 : " + totalPage + "\n");
//		System.out.println("보여줄 페이지 넘버 : " + pageNumber + "\n");
//		System.out.println("한 페이지에 보여줄 건수 : " + pageSize + "\n");
//		System.out.println("현재 페이지의 시작 행 : " + beginRow + "\n");
//		System.out.println("현재 페이지의 끝 행 : " + endRow + "\n");
//		System.out.println("보여줄 페이지 링크 수 : " + pageCount + "\n");
//		System.out.println("페이징 처리 시작 페이지 번호 : " + beginPage + "\n");
//		System.out.println("페이징 처리 끝 페이지 번호 : " + endPage + "\n");
//		System.out.println("요청 URL : " + url + "\n");
//		//System.out.println("하단의 숫자 페이지 링크 : " + pagingHtml + "\n");
//		System.out.println("상단 우측의 현재 페이지 위치 표시 : " + pagingStatus + "\n");	
//		System.out.println("검색 모드 : " + mode + "\n");
//		System.out.println("검색 키워드 : " + keyword + "\n");
//	}
	
}
