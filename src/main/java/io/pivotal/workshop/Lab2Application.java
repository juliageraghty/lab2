package io.pivotal.workshop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import io.pivotal.workshop.domain.StockInfo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@SpringBootApplication
public class Lab2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}

	@Bean
	CommandLineRunner runner(StockService stockService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			try {
				URL url = new URL("https://bootcamp-training-files.cfapps.io/week2/week2-stocks.json");
				StockInfo stockInfo = mapper.readValue(url, StockInfo.class);
				System.out.println(stockInfo);
			} catch (IOException e) {
				e.printStackTrace();
			}

			};
	}

}
