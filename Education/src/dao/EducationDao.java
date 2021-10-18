package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.student;

public interface EducationDao {
	
	//��ѯ������20�����µ�ѧ������������
	public ArrayList<student> findUndertwenty() ;
	
	//�鿼�Գɼ��в������ѧ����ѧ��
	public ArrayList<student> findFail();
	
	//������������ 20�� 23��֮���ѧ��������ϵ������
	public ArrayList<student> findTwentytothree();
	
	//������ϵ����ѧϵ����Ϣϵ��ѧ���������Ա�
	public ArrayList<student> findScin();
	
	//��Ȳ��Ǽ����ϵ����ѧϵ���ֲ�����Ϣϵ��ѧ���������Ա�
	public ArrayList<student> findScnotin();
	
	//�������ա�������ѧ����������ѧ�ź��Ա�
	public ArrayList<student> findLiu();
	
	//���ա��Ϲ١���ȫ��Ϊ 3�����ֵ�ѧ������
	public ArrayList<student> findShangguan();
	
	//�����в��ա��š���ѧ��������
	public ArrayList<student> findNotzhang();
	
}
