package io.pivotal.workshop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.pivotal.workshop.domain.StockInfo;
import io.pivotal.workshop.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@SpringBootApplication
public class Lab2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}

	@Bean
	CommandLineRunner runner(StockRepository stockRepository){
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<StockInfo>> typeReference = new TypeReference<List<StockInfo>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/stocks.json");
			try {
				List<StockInfo> stocks = mapper.readValue(inputStream,typeReference);
				stockRepository.saveAll(stocks);
				System.out.println("Stocks Saved!");
			} catch (IOException e){
				System.out.println("Unable to save stocks: " + e.getMessage());
			}
		};
	}

}

