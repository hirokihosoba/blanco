package blanco.domain.model;

public class Customer {
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
}
