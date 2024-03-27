package blanco.domain.model;

public class Customer {
	
	public void setCustomerId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String id;
	private String password;
	
	public String getCustomerId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
}
