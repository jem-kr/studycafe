package mypkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mypkg.bean.Product;


public class ProductDao extends SuperDao {
	
	//해당 Bean객체를 사용해 상품 등록하기
	public int InsertData(Product bean) {
		System.out.println(this.getClass() + " : 상품을 등록합니다.");
		String sql = " insert into products(pnum, item, seatnum, ptype, price, hours, category, pic)";
		sql += " valuse(proseq.nextval, ?, ?, ?, ?, ?, ?, ?) ";
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		
		int cnt = -999999 ;
		try {
			conn = super.getConnection() ;
			conn.setAutoCommit( false );
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getItem());
			pstmt.setString(2, bean.getSeatnum());
			pstmt.setString(3, bean.getPtype());
			pstmt.setInt(4, bean.getPrice());
			pstmt.setInt(5, bean.getHours());
			pstmt.setString(6, bean.getCategory());
			pstmt.setString(7, bean.getPic());
			
			cnt = pstmt.executeUpdate() ; 
			conn.commit(); 
			
		} catch (Exception e) {
			SQLException err = (SQLException)e ;			
			cnt = - err.getErrorCode() ;			
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		} finally{
			try {
				if( pstmt != null ){ pstmt.close(); }
				if(conn != null){conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
	}
	
	
	//페이징 처리와 필드 검색을 통한 상품 목록 구하기
	public List<Product> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select pnum, item, seatnum, ptype, price, hours, category, pic ";
		sql += " from ";
		sql += " ( ";
		sql += " select pnum, item, seatnum, ptype, price, hours, category, pic, ";
		sql += " rank() over(order by num desc) as ranking ";
		sql += " from products ";
		
		if(mode.equalsIgnoreCase("all") == false) {
			sql += " where " + mode + " like '" + keyword + "'";
		}
		
		sql += " )  ";
		sql += " where ranking between ? and ? ";
		
		List<Product> lists = new ArrayList<Product>();
		
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product bean = new Product();
				
				bean.setCategory(rs.getString("category"));
				bean.setItem(rs.getString("item"));
				bean.setPic(rs.getString("pic"));
				bean.setPtype(rs.getString("ptype"));
				bean.setSeatnum(rs.getString("seatnum"));
				
				bean.setPnum(rs.getInt("pnum"));
				bean.setHours(rs.getInt("hours"));
				bean.setPrice(rs.getInt("price"));
				
				lists.add(bean);
			}
			
		} catch (Exception e) {
			SQLException err = (SQLException)e;
			int cnt = - err.getErrorCode();
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if(rs != null){ rs.close(); }
				if(pstmt != null){ pstmt.close(); }
				if(conn != null){conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return lists;
	}
	
	
	
	//해당 검색모드에 충족하는 항목들의 개수 구하기
	public int SelectTotalCount(String mode, String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select count(*) as cnt from products ";
		
		if(mode.equalsIgnoreCase("all") == false) {
			sql += " where " + mode + " like '" + keyword + "'";
		}
		
		int cnt = -999999;
		
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			SQLException err = (SQLException) e;
			cnt = - err.getErrorCode();
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}




	

}
