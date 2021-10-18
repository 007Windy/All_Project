package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.student;
import service.service;

public class stuController {
	private service ser = null;

	public stuController() {
		ser = new service();
	}

	// 查询年龄在20岁以下的学生姓名及年龄
	public ArrayList<student> findUndertwenty() {
		return ser.findUndertwenty();
	}

	// 查考试成绩有不及格的学生的学号
	public ArrayList<student> findFail() {
		return ser.findFail();
	}

	// 查所有年龄在 20至 23岁之间的学生姓名、系别及年龄
	public ArrayList<student> findTwentytothree() {
		return ser.findTwentytothree();
	}

	// 查计算机系、数学系、信息系的学生姓名、性别
	public ArrayList<student> findScin() {
		return ser.findScin();
	}

	// 查既不是计算机系、数学系、又不是信息系的学生姓名、性别
	public ArrayList<student> findScnotin() {
		return ser.findScnotin();
	}

	// 查所有姓“刘”的学生的姓名、学号和性别
	public ArrayList<student> findLiu() {
		return ser.findLiu();
	}

	// 查姓“上官”且全名为 3个汉字的学生姓名
	public ArrayList<student> findShangguan() {
		return ser.findShangguan();
	}

	// 查所有不姓“张”的学生的姓名
	public ArrayList<student> findNotzhang() {
		return ser.findNotzhang();
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * stuController sController=new stuController(); ArrayList<student>
	 * arrayList=new ArrayList<student>(); arrayList=sController.findUndertwenty();
	 * for(Object obj:arrayList) {
	 * 
	 * System.out.println(obj); }
	 * 
	 * }
	 */

}
