package service;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import dao.EducationDao;
import helper.DataManager;
import model.student;

/**
 * 
 * 单例模式连接数据库
 *
 */

public class service implements EducationDao{
	private Connection conn=null;
	
	public service() {
		try {
			conn=getConn();
			System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//开启数据库连接
	private Connection getConn() throws Exception {
		String url="jdbc:mysql://localhost:3306/education?serverTimezone=UTC";
		conn=(Connection)DataManager.getConn(url, "root", "123456");
		
		return conn;
		
		
	}
	//关闭数据库连接
	public void closeData() {
		if(conn!=null) {
			
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}

	
	
	//查询年龄在20岁以下的学生姓名及年龄
	public ArrayList<student> findUndertwenty() {
	
		ArrayList<student> list1=new ArrayList<student> ();
		String sql="select SNAME,AGE from student where AGE<20";
		PreparedStatement pst;
		try {
			pst =  conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				student stu=new student();
				stu.setSNAME(rs.getString("SNAME"));
				stu.setAGE(rs.getInt("AGE"));
				list1.add(stu);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return list1;
	}
		

	//查考试成绩有不及格的学生的学号
	public ArrayList<student> findFail(){
		ArrayList<student> list2=new ArrayList<student> ();
		String sql="SELECT SNO from sc where GRADE<60";
		PreparedStatement pst;
		try {
			pst =  conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				student stu=new student();
				stu.setSNO(rs.getString("SNO"));
				list2.add(stu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return list2;
	
	}

	
	//查所有年龄在 20至 23岁之间的学生姓名、系别及年龄
	public ArrayList<student> findTwentytothree() {
		ArrayList<student> list3=new ArrayList<student> ();
		String sql="SELECT SNAME,AGE,SDEPT from student where AGE BETWEEN 20 AND 23";
		PreparedStatement pst;
		try {
			pst =  conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				student stu=new student();
				stu.setSNAME(rs.getString("SNAME"));
				stu.setAGE(rs.getInt("AGE"));
				stu.setSDEPT(rs.getString("SDEPT"));
				list3.add(stu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return list3;
		
	}

	
	//查计算机系、数学系、信息系的学生姓名、性别
	public ArrayList<student> findScin() {
		ArrayList<student> list4=new ArrayList<student> ();
		String sql="SELECT SNAME,SEX from student WHERE SDEPT IN('计算机系','数学系','信息系')";
		PreparedStatement pst;
		try {
			pst =  conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				student stu=new student();
				stu.setSNAME(rs.getString("SNAME"));
				stu.setSEX(rs.getString("SEX"));
				
				list4.add(stu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return list4;
		
		
	}

	
	//查既不是计算机系、数学系、又不是信息系的学生姓名、性别
	public ArrayList<student> findScnotin() {
		ArrayList<student> list5=new ArrayList<student> ();
		String sql="SELECT SNAME,SEX from student WHERE SDEPT NOT IN('计算机系','数学系','信息系')";
		PreparedStatement pst;
		try {
			pst =  conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				student stu=new student();
				stu.setSNAME(rs.getString("SNAME"));
				stu.setSEX(rs.getString("SEX"));
				
				list5.add(stu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return list5;
	}

	
	//查所有姓“刘”的学生的姓名、学号和性别
	public ArrayList<student> findLiu() {
		ArrayList<student> list6=new ArrayList<student> ();
		String sql="SELECT SNAME,SNO,SEX from student WHERE SNAME LIKE '刘%'";
		PreparedStatement pst;
		try {
			pst =  conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				student stu=new student();
				stu.setSNO(rs.getString("SNO"));
				stu.setSNAME(rs.getString("SNAME"));
				stu.setSEX(rs.getString("SEX"));
				
				list6.add(stu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return list6;
	}

	
	//查姓“上官”且全名为 3个汉字的学生姓名
	public ArrayList<student> findShangguan() {
		ArrayList<student> list7=new ArrayList<student> ();
		String sql="SELECT SNAME FROM student WHERE SNAME LIKE '上官_'";
		PreparedStatement pst;
		try {
			pst =  conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				student stu=new student();
				stu.setSNAME(rs.getString("SNAME"));
			

				list7.add(stu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return list7;
	}

	
	//查所有不姓“张”的学生的姓名
	public ArrayList<student> findNotzhang() {
		ArrayList<student> list8=new ArrayList<student> ();
		String sql="SELECT SNAME FROM student WHERE SNAME NOT LIKE '张%'";
		PreparedStatement pst;
		try {
			pst =  conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				student stu=new student();
				
				stu.setSNAME(rs.getString("SNAME"));
				
				
				list8.add(stu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return list8;
	}


	public static void main(String[] args)  {
		
	}

}
