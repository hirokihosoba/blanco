package blanco.domain;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import blanco.adapter.database.Data;

@Service
public class DomainService{
	
	public String salude() {
		Data data = new Data("cota");
		
		LocalDate today = LocalDate.now();
		
		return "Hello " + data.getName() + "." + "Today's date is " + today.toString();
	}
}