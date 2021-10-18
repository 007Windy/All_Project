package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.stuController;
import model.student;
import service.service;






public class StuView extends JFrame{
	
	public static class views extends JFrame {
		
		private JButton jbFind1 = null;
		private JButton jbFind2 = null;
		private JButton jbFind3 = null;
		private JButton jbFind4 = null;
		private JButton jbFind5 = null;
		private JButton jbFind6 = null;
		private JButton jbFind7 = null;
		private JButton jbFind8 = null;
		private DefaultTableModel model = null;
		private JTable table = null;
		private String[] headers;
		private JPanel jpl;


		public views() throws ParseException {
			// ��ͷ
			headers = new String[] { "SNO", "SNAME", "AGE", "SEX", "SDEPT" };
			String[][] rows = null;

			// ʵ��������
			model = new DefaultTableModel(rows, headers);
			table = new JTable(model);

			// ����¼�����
			
			jbFind1 = new JButton("����1");
			jbFind2 = new JButton("����2");
			jbFind3 = new JButton("����3");
			jbFind4 = new JButton("����4");
			jbFind5 = new JButton("����5");
			jbFind6 = new JButton("����6");
			jbFind7 = new JButton("����7");
			jbFind8 = new JButton("����8");
			
			
			jbFind1.addMouseListener(new ButtonMouseAdapter(rows));
			jbFind2.addMouseListener(new ButtonMouseAdapter(rows));
			jbFind3.addMouseListener(new ButtonMouseAdapter(rows));
			jbFind4.addMouseListener(new ButtonMouseAdapter(rows));
			jbFind5.addMouseListener(new ButtonMouseAdapter(rows));
			jbFind6.addMouseListener(new ButtonMouseAdapter(rows));
			jbFind7.addMouseListener(new ButtonMouseAdapter(rows));
			jbFind8.addMouseListener(new ButtonMouseAdapter(rows));
			
			
			//����
			jpl = new JPanel();
			jpl.setLayout(new GridLayout(3, 3));
			jpl.add(jbFind1);
			jpl.add(jbFind2);
			jpl.add(jbFind3);
			jpl.add(jbFind4);
			jpl.add(jbFind5);
			jpl.add(jbFind6);
			jpl.add(jbFind7);
			jpl.add(jbFind8);
			add(jpl, BorderLayout.SOUTH);
			jpl.setPreferredSize(new Dimension(450, 200));
			
			JScrollPane jsp = new JScrollPane(table);
			this.add(jsp, BorderLayout.CENTER);
			this.setLocation(100, 100);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.pack();
		}

		// ����¼�������
		class ButtonMouseAdapter extends MouseAdapter {
			private String[][] data;

			public ButtonMouseAdapter(String[][] data) {
				this.data = data;
			}

			public void mouseClicked(MouseEvent e) {		
				JButton jb = (JButton) e.getSource();
				if (jb.equals(jbFind1)) {						// ��ѯ������20�����µ�ѧ������������
					stuController stu = new stuController();
					ArrayList<student> list = stu.findUndertwenty();
					data = new String[list.size()][5];
					for (int i = 0; i < list.size(); i++) {
						student student = list.get(i);
						// ����ת����ַ���
						data[i][1] = student.getSNAME();
						data[i][2] = student.getAGE() + "";
						
						
					}
				}else if (jb.equals(jbFind2)) {						// �鿼�Գɼ��в������ѧ����ѧ��
					stuController stu = new stuController();
					ArrayList<student> list = stu.findFail();
					data = new String[list.size()][5];
					for (int i = 0; i < list.size(); i++) {
						student student = list.get(i);
						data[i][0] = student.getSNO();
						
					}
				}else if(jb.equals(jbFind3)){						// ������������ 20�� 23��֮���ѧ��������ϵ������
					stuController stu = new stuController();
					ArrayList<student> list = stu.findTwentytothree();
					data = new String[list.size()][5];
					for (int i = 0; i < list.size(); i++) {
						student student = list.get(i);
						data[i][1] = student.getSNAME();
						data[i][2] = student.getAGE()+"";
						data[i][1] = student.getSDEPT();
						
						
					}
				}else if(jb.equals(jbFind4)){						// ������ϵ����ѧϵ����Ϣϵ��ѧ���������Ա�
					stuController stu = new stuController();
					ArrayList<student> list = stu.findScin();
					data = new String[list.size()][5];
					for (int i = 0; i < list.size(); i++) {
						student student = list.get(i);
						data[i][1] = student.getSNAME();
						data[i][3] = student.getSEX();
						
					}
					/*
					 * }else if(jb.equals(jbFind5)){ // ������ϵ����ѧϵ����Ϣϵ��ѧ���������Ա� stuController stu =
					 * new stuController(); ArrayList<student> list = stu.findScnotin(); data = new
					 * String[list.size()][5]; for (int i = 0; i < list.size(); i++) { student
					 * student = list.get(i); data[i][1] = student.getSNAME(); data[i][3] =
					 * student.getSEX(); }
					 */
				}else if(jb.equals(jbFind5)){						// ��Ȳ��Ǽ����ϵ����ѧϵ���ֲ�����Ϣϵ��ѧ���������Ա�
					stuController stu = new stuController();
					ArrayList<student> list = stu.findScnotin();
					data = new String[list.size()][5];
					for (int i = 0; i < list.size(); i++) {
						student student = list.get(i);
						data[i][1] = student.getSNAME();
						data[i][3] = student.getSEX();
					}
				}else if(jb.equals(jbFind6)){						// �������ա�������ѧ����������ѧ�ź��Ա�
					stuController stu = new stuController();
					ArrayList<student> list = stu.findLiu();
					data = new String[list.size()][5];
					for (int i = 0; i < list.size(); i++) {
						student student = list.get(i);
						data[i][0] = student.getSNO()+"";
						data[i][1] = student.getSNAME();
						data[i][3] = student.getSEX();
					}
				}else if(jb.equals(jbFind7)){						// ���ա��Ϲ١���ȫ��Ϊ 3�����ֵ�ѧ������
					stuController stu = new stuController();
					ArrayList<student> list = stu.findShangguan();
					data = new String[list.size()][5];
					for (int i = 0; i < list.size(); i++) {
						student student = list.get(i);
						data[i][1] = student.getSNAME();
					}
				}else if(jb.equals(jbFind8)){						// �����в��ա��š���ѧ��������
					stuController stu = new stuController();
					ArrayList<student> list = stu.findNotzhang();
					data = new String[list.size()][5];
					for (int i = 0; i < list.size(); i++) {
						student student = list.get(i);
						data[i][1] = student.getSNAME();
					}
				}
				// ˢ�±�����
				model = new DefaultTableModel(data, headers);
				table.setModel(model);
				
			}
		}

		
	}
	public static void main(String[] args) {
		
		try {
			new views();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	 
		
	
}
}

