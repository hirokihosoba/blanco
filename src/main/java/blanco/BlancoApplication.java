package blanco;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("blanco.adapter.database.mapper")
@SpringBootApplication
public class BlancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlancoApplication.class, args);
	}

}
