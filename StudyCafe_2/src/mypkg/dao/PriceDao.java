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

		String sql = " select m.id, sum(o.or_price) as sumtotal ";
		sql += " from members m inner join orders o ";
		sql += " on m.id=o.or_id ";
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
	
}
