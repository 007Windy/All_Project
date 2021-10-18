package model;

public class course {
	String CNO;
	String CNAME;
	String CDEPT;
	String TNAME;
	
	public course() {}

	public course(String cNO, String cNAME, String cDEPT, String tNAME) {
		super();
		CNO = cNO;
		CNAME = cNAME;
		CDEPT = cDEPT;
		TNAME = tNAME;
	}

	public String getCNO() {
		return CNO;
	}

	public void setCNO(String cNO) {
		CNO = cNO;
	}

	public String getCNAME() {
		return CNAME;
	}

	public void setCNAME(String cNAME) {
		CNAME = cNAME;
	}

	public String getCDEPT() {
		return CDEPT;
	}

	public void setCDEPT(String cDEPT) {
		CDEPT = cDEPT;
	}

	public String getTNAME() {
		return TNAME;
	}

	public void setTNAME(String tNAME) {
		TNAME = tNAME;
	}

	//重写返回值避免返回的是地址值
	public String toString() {
		return "course [CNO=" + CNO + ", CNAME=" + CNAME + ", CDEPT=" + CDEPT + ", TNAME=" + TNAME + "]";
	}
	
	
}
