package model;

public class sc {
	String SNO;
	String CNO;
	String GRADE;
	
	public sc() {}

	public sc(String sNO, String cNO, String gRADE) {
		super();
		SNO = sNO;
		CNO = cNO;
		GRADE = gRADE;
	}

	public String getSNO() {
		return SNO;
	}

	public void setSNO(String sNO) {
		SNO = sNO;
	}

	public String getCNO() {
		return CNO;
	}

	public void setCNO(String cNO) {
		CNO = cNO;
	}

	public String getGRADE() {
		return GRADE;
	}

	public void setGRADE(String gRADE) {
		GRADE = gRADE;
	}

	//��д����ֵ���ⷵ�ص��ǵ�ֵַ
	public String toString() {
		return "sc [SNO=" + SNO + ", CNO=" + CNO + ", GRADE=" + GRADE + "]";
	}
	
	
}
