
public class DepositAccount {
	private String code;
	private String label;
	private double apr;
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getApr() {
		return apr;
	}

	public void setApr(double apr) {
		this.apr = apr;
	}

	public DepositAccount(){
		code = "";
		label = "";
		apr = 0.0;
	}
	
	public DepositAccount(String code, String label, double apr){
		this.code = code;
		this.label = label;
		this.apr = apr;
	}
}
