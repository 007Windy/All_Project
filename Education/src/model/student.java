package model;

public class student {
	private String SNO;			//ѧ��
	private String SNAME;		//����
	private int AGE;			//����
	private String SEX;			//�Ա�
	private String SDEPT;		//ϵ��
	
	public student() {}
	
	

	public student(String sNO, String sNAME, int aGE, String sEX, String sDEPT) {
		super();
		SNO = sNO;				//ѧ��
		SNAME = sNAME;			//����
		AGE = aGE;				//����	
		SEX = sEX;				//�Ա�
		SDEPT = sDEPT;			//ϵ��
	}



	public String getSNO() {
		return SNO;
	}

	public void setSNO(String sNO) {
		SNO = sNO;
	}

	public String getSNAME() {
		return SNAME;
	}

	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public String getSEX() {
		return SEX;
	}

	public void setSEX(String sEX) {
		SEX = sEX;
	}

	public String getSDEPT() {
		return SDEPT;
	}

	public void setSDEPT(String sDEPT) {
		SDEPT = sDEPT;
	}

	//��д����ֵ���ⷵ�ص��ǵ�ֵַ
	public String toString() {
		return "student [SNO=" + SNO + ", SNAME=" + SNAME + ", AGE=" + AGE + ", SEX=" + SEX + ", SDEPT=" + SDEPT + "]";
	}
	
	
		
	
	
}
