package mypkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mypkg.bean.Price;

public class PriceDao extends SuperDao {

	public List<Price> prPrice() {
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		List<Price> lists = new ArrayList<Price>();
		
		// 회원별 매출 현황에 대한 쿼리입니다.
		// 1. 매출이력이 있는 회원 아이디
		// 2. 해당 회원의 누적 금액 sumtotal
		String sql = " select m.id, sum(o.or_price) as sumtotal ";
		sql += " from members m right outer join orders o ";
		sql += " on m.id = o.or_id ";
		sql += " group by m.id ";

		
		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;
			
			while(rs.next()) {
				Price bean = new Price() ;
				
				bean.setId(rs.getString("id"));				
				bean.setSumtotal(rs.getInt("sumtotal"));				
				
				lists.add(bean) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if( rs != null ){ rs.close(); }
				if( pstmt != null ){ pstmt.close(); }
				if( conn != null){ conn.close(); } 
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}		
		return lists;
	}	
	
	public List<Price> prPrice1() {
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		List<Price> lists1 = new ArrayList<Price>();
		
		// 월별 매출 현황에 대한 쿼리입니다.
		// 1. 매출이력이 있는 월 or_date
		// 2. 해당 월에 누적된 건수 count
		// 3. 해당 월에 누적된 매출 총금액 month_total
		String sql = " select to_char(or_date, 'YYYY/MM') as or_date, count(or_id) as cnt, sum(or_price) as month_total ";
		sql += " from orders where or_date >= '21/01/01' and or_date < '22/01/31' ";
		sql += " group by to_char(or_date, 'YYYY/MM') ";
	
		
		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;
			
			while(rs.next()) {
				Price bean = new Price() ;
				
				bean.setOr_date(rs.getString("or_date"));
				bean.setCnt(rs.getInt("cnt"));
				bean.setMonth_total(rs.getInt("month_total"));
				
				lists1.add(bean) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if( rs != null ){ rs.close(); }
				if( pstmt != null ){ pstmt.close(); }
				if( conn != null){ conn.close(); } 
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}		
		return lists1;
	}	
	
	
}
