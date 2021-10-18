package model;

public class student {
	private String SNO;			//学号
	private String SNAME;		//姓名
	private int AGE;			//年龄
	private String SEX;			//性别
	private String SDEPT;		//系别
	
	public student() {}
	
	

	public student(String sNO, String sNAME, int aGE, String sEX, String sDEPT) {
		super();
		SNO = sNO;				//学号
		SNAME = sNAME;			//姓名
		AGE = aGE;				//年龄	
		SEX = sEX;				//性别
		SDEPT = sDEPT;			//系别
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

	//重写返回值避免返回的是地址值
	public String toString() {
		return "student [SNO=" + SNO + ", SNAME=" + SNAME + ", AGE=" + AGE + ", SEX=" + SEX + ", SDEPT=" + SDEPT + "]";
	}
	
	
		
	
	
}
