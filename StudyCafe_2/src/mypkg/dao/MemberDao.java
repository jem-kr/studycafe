package mypkg.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mypkg.bean.Member;

public class MemberDao extends SuperDao {

	public Member SelectDataId(String id) {
		// 중복체크를 담당하는 메소드
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
				System.out.println("id 발견 안됨");
			} else {
				System.out.println("id 발견");
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
				//1건 발견
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

}
