package mypkg.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.member.MemberLoginController;

public class MemberDao extends SuperDao {

	public Member SelectByPk(String id, String password) {
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
				bean.setVisit(rs.getString("visit"));

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

}
