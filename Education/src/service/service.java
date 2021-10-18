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
 * ����ģʽ�������ݿ�
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
	
	//�������ݿ�����
	private Connection getConn() throws Exception {
		String url="jdbc:mysql://localhost:3306/education?serverTimezone=UTC";
		conn=(Connection)DataManager.getConn(url, "root", "123456");
		
		return conn;
		
		
	}
	//�ر����ݿ�����
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

	
	
	//��ѯ������20�����µ�ѧ������������
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
		

	//�鿼�Գɼ��в������ѧ����ѧ��
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

	
	//������������ 20�� 23��֮���ѧ��������ϵ������
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

	
	//������ϵ����ѧϵ����Ϣϵ��ѧ���������Ա�
	public ArrayList<student> findScin() {
		ArrayList<student> list4=new ArrayList<student> ();
		String sql="SELECT SNAME,SEX from student WHERE SDEPT IN('�����ϵ','��ѧϵ','��Ϣϵ')";
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

	
	//��Ȳ��Ǽ����ϵ����ѧϵ���ֲ�����Ϣϵ��ѧ���������Ա�
	public ArrayList<student> findScnotin() {
		ArrayList<student> list5=new ArrayList<student> ();
		String sql="SELECT SNAME,SEX from student WHERE SDEPT NOT IN('�����ϵ','��ѧϵ','��Ϣϵ')";
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

	
	//�������ա�������ѧ����������ѧ�ź��Ա�
	public ArrayList<student> findLiu() {
		ArrayList<student> list6=new ArrayList<student> ();
		String sql="SELECT SNAME,SNO,SEX from student WHERE SNAME LIKE '��%'";
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

	
	//���ա��Ϲ١���ȫ��Ϊ 3�����ֵ�ѧ������
	public ArrayList<student> findShangguan() {
		ArrayList<student> list7=new ArrayList<student> ();
		String sql="SELECT SNAME FROM student WHERE SNAME LIKE '�Ϲ�_'";
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

	
	//�����в��ա��š���ѧ��������
	public ArrayList<student> findNotzhang() {
		ArrayList<student> list8=new ArrayList<student> ();
		String sql="SELECT SNAME FROM student WHERE SNAME NOT LIKE '��%'";
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
