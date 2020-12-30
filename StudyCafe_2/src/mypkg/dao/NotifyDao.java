package mypkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mypkg.bean.Notice;

public class NotifyDao extends SuperDao {

	public int SelectTotalCount(String mode, String keyword) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		String sql = " select count(*) as cnt from notices ";
		if(mode.equalsIgnoreCase("all") == false) {
			sql += " where " + mode + "like '" + keyword + "' ";
		}
		
		int cnt =-9999999;
		 try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
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
		} finally {
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

	public List<Notice> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		int cnt = -999999;
		String sql= " select writer, num, title, content, image, readhit, regdate, remark, groupno, orderno, depth ";
		sql+= " from ( ";
		sql+= " select writer, num, title, content, image, readhit, regdate, remark, groupno, orderno, depth, ";
		sql+= " rank()over (order by num desc) as ranking";
		sql+= " from notices ";
		if (mode.equalsIgnoreCase("all")==false) {
			sql+= " where " + mode + " like '" + keyword +"' ";
		}
		sql += " ) where ranking between ? and ? ";
		
		List<Notice>lists = new ArrayList<Notice>();
		
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Notice bean = new Notice();
				
				bean.setContent(rs.getString("content"));
				bean.setDepth(rs.getInt("depth"));
				bean.setGroupno(rs.getInt("groupno"));
				bean.setImage(rs.getString("image"));
				bean.setNum(rs.getInt("num"));
				bean.setOrderno(rs.getInt("orderno"));
				bean.setReadhit(rs.getInt("readhit"));
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				bean.setRemark(rs.getString("remark"));
				bean.setTitle(rs.getString("title"));
				bean.setWriter(rs.getString("writer"));
				lists.add(bean);
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
		
		
		return lists;
	}

	public int InsertData(Notice bean) {
		System.out.println("공지사항을 등록합니다.");
		String sql =" insert into notices (writer, num, title, content, image, readhit, regdate, remark,  groupno, orderno, depth ) ";
			sql+= "values ( ?, notiseq.nextval, ?, ?, ?, default, to_date(?, 'yyyy/MM/dd'), ?, notiseq.currval, default, default ) ";
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		int cnt =-999999;
		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getWriter());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			pstmt.setString(4, bean.getImage());
			pstmt.setString(5, bean.getRegdate());
			pstmt.setString(6, bean.getRemark());
			
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


	public Notice SelectDataByPk(int num) {
		Notice bean =null;
		String sql = " select * from notices where num = ?";
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bean = new Notice();
				bean.setContent(rs.getString("content"));
				bean.setDepth(rs.getInt("depth"));
				bean.setGroupno(rs.getInt("groupno"));
				bean.setImage(rs.getString("image"));
				bean.setNum(rs.getInt("num"));
				bean.setOrderno(rs.getInt("orderno"));
				bean.setReadhit(rs.getInt("readhit"));
				bean.setRegdate(String.valueOf(rs.getDate("regdate")));
				bean.setRemark(rs.getString("remark"));
				bean.setTitle(rs.getString("title"));
				bean.setWriter(rs.getString("writer"));
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

	public int UpdateReadhit(int num) {
		String sql = " update notices set readhit = readhit + 1 ";
		sql += " where num = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = -999999;

		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);

			// placeholder
			pstmt.setInt(1, num);
			cnt = pstmt.executeUpdate();
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
		} finally {
			try {
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
		return cnt;
		
	}

	public int UpdateData(Notice bean) {
		System.out.println( bean.toString() ); 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update notices set " ;
		sql += " title = ?, content = ?, image = ?, regdate = ?, remark= ? ";
		sql += " where num = ? " ;

		int cnt = -999999 ;
		try {
			conn = super.getConnection() ;
			conn.setAutoCommit( false );
			pstmt = conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getContent());
			pstmt.setString(3, bean.getImage());
			pstmt.setString(4, bean.getRegdate());
			pstmt.setString(5, bean.getRemark());
			pstmt.setInt(6, bean.getNum());
			
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

	public int DeleteData(int num) {
		String sql = " delete notices where num = ? ";
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		int cnt = -999999 ;

		try {
			conn = super.getConnection() ;
			pstmt = conn.prepareStatement(sql) ;

			// placeholder
			pstmt.setInt(1, num);
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
