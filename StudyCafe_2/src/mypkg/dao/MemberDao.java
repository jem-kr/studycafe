package mypkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mypkg.bean.Member;

public class MemberDao extends SuperDao {

	public Member SelectDataId(String id) {
		// 중복체크를 담당하는 메소드
		// 회원 상세정보 보기를 담당하는 메소드
		// 회원 정보 수정을 담당하는 메소드
		// 회원 탈퇴를 담당하는 메소드
		// id 로 해당하는 data를 찾음
		Member bean = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from members where id = ? ";

		try {
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 1건 발견
				bean = new Member();

				bean.setAgreement(rs.getString("agreement"));
				bean.setBirth(rs.getString("birth"));
				bean.setEmail01(rs.getString("email01"));
				bean.setEmail02(rs.getString("email02"));
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setPhone(rs.getString("phone"));
				bean.setPwanswer(rs.getString("pwanswer"));
				bean.setPwquestion(rs.getString("pwquestion"));
				bean.setRemark(rs.getString("remark"));

				String[] visit = rs.getString("visit").split(",");
				bean.setVisit(visit);
			}

			if (bean == null) {
				System.out.println("회원 정보 발견 안됨");
			} else {
				System.out.println("회원 정보 발견");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.CloseConnection();
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return bean;
	}

	public Member SelectByPk(String id, String password) {
		// 로그인을 담당하는 메소드
		// id와 password 로 DB에 있는 해당하는 한사람의 정보를 찾는다.
		Member bean = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from members where id = ? and password = ? ";

		try {
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 1건 발견
				bean = new Member();

				bean.setAgreement(rs.getString("agreement"));
				bean.setBirth(rs.getString("birth"));
				bean.setEmail01(rs.getString("email01"));
				bean.setEmail02(rs.getString("email02"));
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setPhone(rs.getString("phone"));
				bean.setPwanswer(rs.getString("pwanswer"));
				bean.setPwquestion(rs.getString("pwquestion"));
				bean.setRemark(rs.getString("remark"));

				String[] visit = rs.getString("visit").split(",");
				bean.setVisit(visit);
			}

			if (bean == null) {
				System.out.println("데이터 베이스에서 해당하는 id, pw를 찾을 수 없습니다.");
			} else {
				System.out.println("데이터 베이스에서 해당하는 id, pw를 찾았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.CloseConnection();
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return bean;
	}

	public int MemberInsertData(Member bean) {
		// 회원 가입을 담당하는 메소드
		String sql = " insert into members( id, password, pwquestion, pwanswer, name, birth, gender, phone, email01, email02, visit, agreement )";
		sql += " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

		PreparedStatement pstmt = null;
		int cnt = -1;

		try {
			super.conn = super.getConnection();
			super.conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);

			// placeholder
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getPwquestion());
			pstmt.setString(4, bean.getPwanswer());
			pstmt.setString(5, bean.getName());
			pstmt.setString(6, bean.getBirth());
			pstmt.setString(7, bean.getGender());
			pstmt.setString(8, bean.getPhone());
			pstmt.setString(9, bean.getEmail01());
			pstmt.setString(10, bean.getEmail02());
			pstmt.setString(11, bean.getVisit());
			pstmt.setString(12, bean.getAgreement());

			cnt = pstmt.executeUpdate();

			super.conn.commit();

			System.out.println("회원 가입 성공");

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				SQLException err = (SQLException) e;
				// getErrorCode() : 오라클 오류 상수가 리턴
				// 예 : not null 이면 1400
				cnt = -err.getErrorCode();
				super.conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				super.CloseConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return cnt;
	}

	public Member IdSearchData(String name, String phone) {
		// 아이디 찾기를 담당하는 메소드
		Member bean = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from members where name = ? and phone = ? ";

		try {
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, phone);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 발견
				bean = new Member();

				bean.setAgreement(rs.getString("agreement"));
				bean.setBirth(rs.getString("birth"));
				bean.setEmail01(rs.getString("email01"));
				bean.setEmail02(rs.getString("email02"));
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("agreement"));
				bean.setPhone(rs.getString("phone"));
				bean.setPwanswer(rs.getString("pwanswer"));
				bean.setPwquestion(rs.getString("pwquestion"));
				bean.setRemark(rs.getString("remark"));

				String[] visit = rs.getString("visit").split(",");
				bean.setVisit(visit);
			}

			if (bean == null) {
				System.out.println("데이터 베이스에서 해당하는 id를 찾을 수 없습니다.");
			} else {
				System.out.println("데이터 베이스에서 해당하는 id를 찾았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				super.CloseConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	public Member SelectDataPwquestion(String id, String phone) {
		// 회원가입 당시 설정했던 비밀번호 질문을 찾는 메소드

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " Select * from members where id = ? and phone = ? ";

		Member bean = null;

		try {
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, phone);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 1건 발견
				bean = new Member();

				bean.setAgreement(rs.getString("agreement"));
				bean.setBirth(rs.getString("birth"));
				bean.setEmail01(rs.getString("email01"));
				bean.setEmail02(rs.getString("email02"));
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setPhone(rs.getString("phone"));
				bean.setPwanswer(rs.getString("pwanswer"));
				bean.setPwquestion(rs.getString("pwquestion"));
				bean.setRemark(rs.getString("remark"));

				String[] visit = rs.getString("visit").split(",");
				bean.setVisit(visit);
			}

			if (bean != null) {
				System.out.println("비밀번호 찾기에 대한 질문을 발견");
			} else {
				System.out.println("비밀번호 찾기에 대한 질문 미발견");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				super.CloseConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	public int UpdatePassword(String id, String new_pw) {
		// 비밀번호 재설정을 담당하는 메소드
		int cnt = -1;

		PreparedStatement pstmt = null;
		String sql = " update members set password = ? ";
		sql += " where id = ? ";

		try {
			super.conn = super.getConnection();
			super.conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setString(1, new_pw);
			pstmt.setString(2, id);

			cnt = pstmt.executeUpdate();

			super.conn.commit();

		} catch (SQLException e) {
			try {
				SQLException err = (SQLException) e;
				// getErrorCode() : 오라클 오류 상수가 리턴
				// 예 : not null 이면 1400
				cnt = -err.getErrorCode();
				super.conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				super.CloseConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}

	public List<Member> SelectAllData(int beginRow, int endRow) {
		// 회원 전체 목록을 가져오는 메소드
		List<Member> lists = new ArrayList<Member>();
		Member bean = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select id, password, pwquestion, pwanswer, name, birth, gender, phone, email01, email02, visit, agreement, remark, ranking ";
		sql += " from ";
		sql += " ( ";
		sql += " select id, password, pwquestion, pwanswer, name, birth, gender, phone, email01, email02, visit, agreement, remark, rank() over( order by id asc ) as ranking ";
		sql += " from members ";
		sql += " ) ";
		sql += " where ranking between ? and ? ";
		try {
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new Member(); // 1건 발견

				bean.setAgreement(rs.getString("agreement"));
				bean.setBirth(rs.getString("birth"));
				bean.setEmail01(rs.getString("email01"));
				bean.setEmail02(rs.getString("email02"));
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setPhone(rs.getString("phone"));
				bean.setPwanswer(rs.getString("pwanswer"));
				bean.setPwquestion(rs.getString("pwquestion"));

				String[] visit = rs.getString("visit").split(",");
				bean.setVisit(visit);

				bean.setRemark(rs.getString("remark"));

				lists.add(bean);
			}

			if (lists != null) {
				System.out.println("회원목록을 list 컬렉션에 담았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				super.CloseConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return lists;
	}

	public List<Member> SelectAllDataASC(String sort, int beginRow, int endRow) {
		// 회원목록에서 오름차순 정렬을 담당하는 메소드
		List<Member> lists = new ArrayList<Member>();
		Member bean = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select id, password, pwquestion, pwanswer, name, birth, gender, phone, email01, email02, visit, agreement, remark, ranking ";
		sql += " from ";
		sql += " ( ";
		sql += " select id, password, pwquestion, pwanswer, name, birth, gender, phone, email01, email02, visit, agreement, remark, rank() over( order by "
				+ sort + " asc ) as ranking ";
		sql += " from members ";
		sql += " ) ";
		sql += " where ranking between ? and ? ";

		try {
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new Member(); // 1건 발견

				bean.setAgreement(rs.getString("agreement"));
				bean.setBirth(rs.getString("birth"));
				bean.setEmail01(rs.getString("email01"));
				bean.setEmail02(rs.getString("email02"));
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setPhone(rs.getString("phone"));
				bean.setPwanswer(rs.getString("pwanswer"));
				bean.setPwquestion(rs.getString("pwquestion"));

				String[] visit = rs.getString("visit").split(",");
				bean.setVisit(visit);

				bean.setRemark(rs.getString("remark"));

				lists.add(bean);
			}

			if (lists != null) {
				System.out.println("회원목록 오름차순 정렬 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				super.CloseConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists;
	}

	public List<Member> SelectAllDataDESC(String sort, int beginRow, int endRow) {
		// 회원목록에서 내림차순 정렬을 담당하는 메소드
		List<Member> lists = new ArrayList<Member>();
		Member bean = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select id, password, pwquestion, pwanswer, name, birth, gender, phone, email01, email02, visit, agreement, remark, ranking ";
		sql += " from ";
		sql += " ( ";
		sql += " select id, password, pwquestion, pwanswer, name, birth, gender, phone, email01, email02, visit, agreement, remark, rank() over( order by "
				+ sort + " desc ) as ranking ";
		sql += " from members ";
		sql += " ) ";
		sql += " where ranking between ? and ? ";

		try {
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new Member(); // 1건 발견

				bean.setAgreement(rs.getString("agreement"));
				bean.setBirth(rs.getString("birth"));
				bean.setEmail01(rs.getString("email01"));
				bean.setEmail02(rs.getString("email02"));
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setPhone(rs.getString("phone"));
				bean.setPwanswer(rs.getString("pwanswer"));
				bean.setPwquestion(rs.getString("pwquestion"));

				String[] visit = rs.getString("visit").split(",");
				bean.setVisit(visit);

				bean.setRemark(rs.getString("remark"));

				lists.add(bean);
			}

			if (lists != null) {
				System.out.println("회원목록 내림차순 정렬 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				super.CloseConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists;
	}

	public int SelectTotalCount() {
		// 회원목록에서 페이징 처리 시 총 회원목록의 건수를 가져오는 메소드
		int cnt = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select count(*) as cnt from members ";

		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

		} catch (SQLException e) {
			SQLException err = (SQLException) e;
			cnt = -err.getErrorCode();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
		return cnt;
	}

	public int UpdateAllData(Member bean) {
		// 회원 정보 수정을 담당하는 메소드

		PreparedStatement pstmt = null;

		String sql = " update members set ";
		sql += " name = ? ,";
		sql += " gender = ? ,";
		sql += " birth = ? ,";
		sql += " phone = ? ,";
		sql += " email01 = ? ,";
		sql += " email02 = ? ,";
		sql += " pwquestion = ? ,";
		sql += " pwanswer = ? ,";
		sql += " visit = ? ";
		sql += " where id = ? ";

		int cnt = -1;

		try {
			super.conn = super.getConnection();
			pstmt = super.conn.prepareStatement(sql);
			super.conn.setAutoCommit(false);

			System.out.println("bean.getName ===>" + bean.getName());
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getGender());
			pstmt.setString(3, bean.getBirth());
			pstmt.setString(4, bean.getPhone());
			pstmt.setString(5, bean.getEmail01());
			pstmt.setString(6, bean.getEmail02());
			pstmt.setString(7, bean.getPwquestion());
			pstmt.setString(8, bean.getPwanswer());
			pstmt.setString(9, bean.getVisit());
			pstmt.setString(10, bean.getId());

			cnt = pstmt.executeUpdate();

			super.conn.commit();

		} catch (SQLException e) {
			try {
				SQLException err = (SQLException) e;
				cnt = -err.getErrorCode();
				super.conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				super.CloseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;

	}

	public int DeleteDataById(String id) {
		// 회원 정보 삭제를 담당하는 메소드

		System.out.println("delete 메소드 호출");
		int cnt = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		Member bean = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		String time = sdf.format(date);
		int _time = Integer.parseInt(time);
		
		

		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);

			bean = this.SelectDataId(id);

			// notices 테이블 remark 컬럼 수정
			sql = " update notices set remark = ? where writer = ? ";
			pstmt = conn.prepareStatement(sql);

			String imsi = "ID : " + bean.getId() + " , 회원 탈퇴 일자 :  " + time ;

			pstmt.setString(1, imsi);
			pstmt.setString(2, id);

			cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("공지사항 테이블 비고 컬럼 수정");
			}else {
				System.out.println("공지사항 테이블 비고 컬럼 수정 안됨");
			}

			// reservations 테이블 remark 컬럼 수정
			sql = " update reservations set remark = ? where re_id = ? ";

			if (pstmt != null) {
				pstmt.close();
			}

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, imsi);
			pstmt.setString(2, id);

			cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("예약 테이블 비고 컬럼 수정");
			}else {
				System.out.println("예약 테이블 비고 컬럼 수정 안됨");
			}

			// orders 테이블 remark 컬럼 수정
			sql = " update orders set remark = ? where or_id = ? ";

			if (pstmt != null) {
				pstmt.close();
			}

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, imsi);
			pstmt.setString(2, id);

			cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("결제내역 테이블 비고 컬럼 수정");
			}else {
				System.out.println("결제내역 테이블 비고 컬럼 수정 안됨");
			}

			if (pstmt != null) {
				pstmt.close();
			}

			// members 테이블 id 삭제
			sql = " delete from members where id = ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			cnt = pstmt.executeUpdate();

			conn.commit();

			if (cnt > 0) {
				System.out.println("회원 테이블 삭제 성공");
			} else {
				System.out.println("회원 테이블 삭제 실패");
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
}
