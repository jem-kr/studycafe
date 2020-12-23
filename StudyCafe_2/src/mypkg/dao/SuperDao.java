package mypkg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SuperDao {
	protected Connection conn = null;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "bitcamp";
	String password = "bitcamp";

	public SuperDao() {
		try {
			Class.forName(this.driver);
			this.conn = this.getConnection();

			if (this.conn != null) {
				System.out.println("DB 접속 성공");
			} else {
				System.out.println("DB 접속 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 커넥션 객체 얻기
	protected Connection getConnection() {
		try {
			return DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	// 커넥션 닫기
	protected void CloseConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
