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

	// ��ѯ������20�����µ�ѧ������������
	public ArrayList<student> findUndertwenty() {
		return ser.findUndertwenty();
	}

	// �鿼�Գɼ��в������ѧ����ѧ��
	public ArrayList<student> findFail() {
		return ser.findFail();
	}

	// ������������ 20�� 23��֮���ѧ��������ϵ������
	public ArrayList<student> findTwentytothree() {
		return ser.findTwentytothree();
	}

	// ������ϵ����ѧϵ����Ϣϵ��ѧ���������Ա�
	public ArrayList<student> findScin() {
		return ser.findScin();
	}

	// ��Ȳ��Ǽ����ϵ����ѧϵ���ֲ�����Ϣϵ��ѧ���������Ա�
	public ArrayList<student> findScnotin() {
		return ser.findScnotin();
	}

	// �������ա�������ѧ����������ѧ�ź��Ա�
	public ArrayList<student> findLiu() {
		return ser.findLiu();
	}

	// ���ա��Ϲ١���ȫ��Ϊ 3�����ֵ�ѧ������
	public ArrayList<student> findShangguan() {
		return ser.findShangguan();
	}

	// �����в��ա��š���ѧ��������
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
