package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.student;

public interface EducationDao {
	
	//查询年龄在20岁以下的学生姓名及年龄
	public ArrayList<student> findUndertwenty() ;
	
	//查考试成绩有不及格的学生的学号
	public ArrayList<student> findFail();
	
	//查所有年龄在 20至 23岁之间的学生姓名、系别及年龄
	public ArrayList<student> findTwentytothree();
	
	//查计算机系、数学系、信息系的学生姓名、性别
	public ArrayList<student> findScin();
	
	//查既不是计算机系、数学系、又不是信息系的学生姓名、性别
	public ArrayList<student> findScnotin();
	
	//查所有姓“刘”的学生的姓名、学号和性别
	public ArrayList<student> findLiu();
	
	//查姓“上官”且全名为 3个汉字的学生姓名
	public ArrayList<student> findShangguan();
	
	//查所有不姓“张”的学生的姓名
	public ArrayList<student> findNotzhang();
	
}
