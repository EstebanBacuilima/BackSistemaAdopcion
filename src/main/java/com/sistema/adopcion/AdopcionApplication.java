package com.sistema.adopcion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


@SpringBootApplication
public class AdopcionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopcionApplication.class, args);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void runSQLScript() {
		String sqlFile = "data.sql";
		try {
			ClassPathResource resource = new ClassPathResource(sqlFile);
			InputStream inputStream = resource.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			while ((line = reader.readLine()) != null) {
				jdbcTemplate.execute(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		runSQLScript();
	}


}
