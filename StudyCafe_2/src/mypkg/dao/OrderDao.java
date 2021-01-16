package mypkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mypkg.bean.Member;
import mypkg.bean.Order;

public class OrderDao extends SuperDao{

	public int InsertData(Order bean) {
		String sql = " insert into orders (or_no, or_id, or_rnum, or_seat, or_date, or_stime, or_etime, or_hour, or_price, or_pday, remark ) ";
		sql+= " values ( ord_seq.nextval, ? ,?, ?, to_date(?,'yy/MM/dd'),  ?, ?, ?, ?,to_date(?,'yy/MM/dd'), ? )";
	
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		int cnt =-999999;
		try {
			
			// 결제 내역 테이블 insert 처리 
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
			
			if (cnt > 0) {
				System.out.println("결제 내역 테이블에 insert 완료");
			}else {
				System.out.println("결제 내역 테이블에 insert 완료 안됨");
			}
			
			// 예약 테이블 delete 처리
			if (pstmt != null) {
				pstmt.close();
			}
			
			sql = " delete from reservations where re_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getOr_id());
			
			cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println("예약 테이블에 delete 완료");
			}else {
				System.out.println("예약 테이블에 delete 완료 안됨");
			}
			
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

	public int DeleteDate(int or_no) {
		String sql = " delete orders where or_no = ? ";
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setInt(1, or_no);
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

	public List<Order> SelectDataByID(String id) {

		String sql = " select * from orders ";
		sql += " where or_id = ? order by or_no desc ";

		List<Order> lists = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);

			// placeholder
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Order bean = new Order();
				bean.setOr_date(String.valueOf(rs.getDate("or_date")));
				bean.setOr_etime(rs.getInt("or_etime"));
				bean.setOr_hour(rs.getInt("or_hour"));
				bean.setOr_id(rs.getString("or_id"));
				bean.setOr_no(rs.getInt("or_no"));
				bean.setOr_pday(String.valueOf(rs.getDate("or_pday")));
				bean.setOr_price(rs.getInt("or_price"));
				bean.setOr_rnum(rs.getInt("or_rnum"));
				bean.setOr_seat(rs.getString("or_seat"));
				bean.setOr_stime(rs.getInt("or_stime"));
				bean.setRemark(rs.getString("remark"));
				lists.add( bean ) ;
			}

			System.out.println("ok");
		} catch (Exception e) {
			SQLException err = (SQLException) e;
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return lists;
	}

	public List<Order> SelectAllOrder() {
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;

		String sql = " select * from orders order by or_no desc"; 
		
		List<Order> lists = new ArrayList<Order>();

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder

			rs = pstmt.executeQuery() ;			
			while( rs.next() ){
				Order bean = new Order();
				bean.setOr_date(String.valueOf(rs.getDate("or_date")));
				bean.setOr_etime(rs.getInt("or_etime"));
				bean.setOr_hour(rs.getInt("or_hour"));
				bean.setOr_id(rs.getString("or_id"));
				bean.setOr_no(rs.getInt("or_no"));
				bean.setOr_pday(String.valueOf(rs.getDate("or_pday")));
				bean.setOr_price(rs.getInt("or_price"));
				bean.setOr_rnum(rs.getInt("or_rnum"));
				bean.setOr_seat(rs.getString("or_seat"));
				bean.setOr_stime(rs.getInt("or_stime"));
				bean.setRemark(rs.getString("remark"));
				lists.add( bean ) ;
			}
		} catch (Exception e) {
			SQLException err = (SQLException)e ;			
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally{
			try {
				if(rs != null){ rs.close(); }
				if(pstmt != null){ pstmt.close(); }
				if(conn != null){conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		
		return lists ;
	}

	public int checkduplicate(String p_seat, String p_date, int p_stime, int p_etime) {
		String sql = " select count(*) cnt from orders where or_seat = ? and or_date = ? and or_stime < ? and or_etime > ?" ;
	
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		int cnt =-999999;
		try {
			
			// 결제 내역 테이블 insert 처리 
			conn = super.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p_seat);
			pstmt.setString(2, p_date);
			pstmt.setInt(3, p_etime);
			pstmt.setInt(4, p_stime);
			
			rs = pstmt.executeQuery() ;
			
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
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
				if(rs!=null) {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				if(conn!=null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
				}
		}
		return cnt;
	}

}
