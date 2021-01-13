package mypkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mypkg.bean.Reservation;

public class ReservationDao extends SuperDao{

	public int InsertData(Reservation bean) {
		String sql = " insert into reservations (re_no, re_id, re_date, re_stime, re_etime, re_hour, re_type, re_seat, re_person, re_pday, re_price, remark ) ";
		sql+= " values ( res_seq.nextval, ? ,to_date(?,'yy/MM/dd') ,? ,? ,?, ?, ?, ?, sysdate, ?, ? )";
	
	Connection conn =null;
	PreparedStatement pstmt = null;
	
	int cnt =-999999;
	try {
		conn = super.getConnection();
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, bean.getRe_id());
		pstmt.setString(2, bean.getRe_date());
		pstmt.setInt(3, bean.getRe_stime());
		pstmt.setInt(4, bean.getRe_etime());
		pstmt.setInt(5, bean.getRe_hour());
		pstmt.setString(6, bean.getRe_type());
		pstmt.setString(7, bean.getRe_seat());
		pstmt.setInt(8, bean.getRe_person());
		pstmt.setInt(9, bean.getRe_price());
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

	public Reservation SelectDataById(String id) {
		Reservation bean =null;
		String sql = " select * from reservations where re_id = ?";
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bean = new Reservation();
				bean.setRe_person(rs.getInt("re_person"));
				bean.setRe_date(String.valueOf(rs.getDate("re_date")));
				bean.setRe_etime(rs.getInt("re_etime"));
				bean.setRe_hour(rs.getInt("re_hour"));
				bean.setRe_id(rs.getString("re_id"));
				bean.setRe_no(rs.getInt("re_no"));
				bean.setRe_pday(String.valueOf(rs.getDate("re_pday")));
				bean.setRe_price(rs.getInt("re_price"));
				bean.setRe_seat(rs.getString("re_seat"));
				bean.setRe_stime(rs.getInt("re_stime"));
				bean.setRe_type(rs.getString("re_type"));
				bean.setRemark(rs.getString("remark"));
			}
			conn.commit();
		} catch (Exception e) {
			SQLException err = (SQLException) e;
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				if(conn!=null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
				}
		}
		return bean;
	
	
	}

	public int DeleteData(int re_no) {
		String sql = " delete reservations where num = ? ";
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setInt(1, re_no);
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
				if(pstmt != null){pstmt.close();}
				if(conn != null){conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
	}
	

}
