package com.yg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "user0112";
		String dbPw = "user1234";
		
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public String checkLogin(String id,String pw) throws Exception{
		Connection conn = getConnection();
		String sql = "SELECT name FROM member WHERE id=? AND pw=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pw);
		ResultSet rs = pstmt.executeQuery();
		String name="";
		while(rs.next()) {
			name = rs.getString("name");
		}
		rs.close();
		pstmt.close();
		conn.close();
		return name;
	}
	public int checkPoint(String id,String pw) throws Exception{
		Connection conn = getConnection();
		String sql = "SELECT point FROM member WHERE id=? AND pw=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pw);
		ResultSet rs = pstmt.executeQuery();
		int point = 0;
		while(rs.next()) {
			point = rs.getInt("point");
		}
		rs.close();
		pstmt.close();
		conn.close();
		return point;
	}
	
	public void insertMember(String id, String pw, String name) throws Exception {
		Connection conn = getConnection();
		String sql = "INSERT INTO member(id,pw,name,point)"
				+ " VALUES(?,?,?,1000)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pw);
		pstmt.setString(3,name);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	public int advPoint(int random,String name) throws Exception{
		
		Connection conn = getConnection();
		String sql = "UPDATE member SET point = point+? WHERE name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,random);
		pstmt.setString(2, name);
		pstmt.executeUpdate();
		String sql2= "SELECT point FROM member WHERE name=?";
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt2.setString(1,name);
		ResultSet rs = pstmt2.executeQuery();
		int point = 0;
		while(rs.next()) {
			point = rs.getInt("point");
		}
		rs.close();
		pstmt.close();
		conn.close();
		return point;
	}
	
	public int returnPoint(String name) throws Exception{
		int point =0;
		Connection conn = getConnection();
		String sql = "SELECT point FROM member WHERE name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,name);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			point = rs.getInt("point");
		}
		rs.close();
		pstmt.close();
		conn.close();
		return point;
	}
	public void buyContents(String name,int value) throws Exception{
		Connection conn = getConnection();
		String sql = "UPDATE member SET point = point-? WHERE name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,value);
		pstmt.setString(2, name);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	public int UpPointSch() throws Exception{
		Connection conn = getConnection();
		String sql = "UPDATE member SET point = point+1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		String sql2 = "SELECT COUNT(*) cnt FROM member";
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		int cnt = 0;
		ResultSet rs = pstmt2.executeQuery();
		while(rs.next()) {
			cnt = rs.getInt("cnt");
		}
		rs.close();
		pstmt.close();
		conn.close();
		return cnt;
	}
	
	public ArrayList<MemberDTO> getAllBoardList() throws Exception {
		ArrayList<MemberDTO> list1 = new ArrayList<MemberDTO>();
		
		Connection conn = getConnection();
		String sql = "SELECT * FROM member";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			int point = rs.getInt("point");
			MemberDTO dto = new MemberDTO(id,pw,point,name);
			list1.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list1;
	}
	public void updateMember(String id, String pw, String name, int point) throws Exception{
		Connection conn = getConnection();
		String sql = "UPDATE member SET pw=?,name=?,point = ? WHERE id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,pw);
		pstmt.setString(2,name);
		pstmt.setInt(3,point);
		pstmt.setString(4, id);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	public void deleteMember(String id) throws Exception{
		Connection conn = getConnection();
		String sql = "DELETE FROM member WHERE id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
}