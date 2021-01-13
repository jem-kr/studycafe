package mypkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mypkg.bean.Order;

public class OrderDao extends SuperDao{

	public int InsertData(Order bean) {
		String sql = " insert into orders (or_no, or_id, or_rnum, or_seat, or_date, or_stime, or_etime, or_hour, or_price, or_pday, remark ) ";
		sql+= " values ( ord_seq.nextval, ? ,?, to_date(?,'yy/MM/dd'), ?, ?, ?, ?, ?, to_date(?,'yy/MM/dd'), ? )";
	
	Connection conn =null;
	PreparedStatement pstmt = null;
	
	int cnt =-999999;
	try {
		conn = super.getConnection();
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, bean.getOr_id());
		pstmt.setInt(2, bean.getOr_rnum());
		pstmt.setString(3, bean.getOr_seat());
		pstmt.setString(4, bean.getOr_date());
		pstmt.setInt(5, bean.getOr_stime());
		pstmt.setInt(6, bean.getOr_etime());
		pstmt.setInt(7, bean.getOr_hour());
		pstmt.setInt(8, bean.getOr_price());
		pstmt.setString(9, bean.getOr_pday());
		pstmt.setString(10, bean.getRemark());
		
		
		cnt= pstmt.executeUpdate();
		conn.commit();
	} catch (Exception e) {
		SQLException err = (SQLException) e;
		cnt = -err.getErrorCode();
		e.printStackTrace();
		try {
			conn.rollback();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}finally {
		try {
			if(pstmt!=null) {pstmt.close();}
			if(conn!=null) {conn.close();}
		} catch (Exception e2) {
			e2.printStackTrace();
			}
	}
	return cnt;
	}

}
