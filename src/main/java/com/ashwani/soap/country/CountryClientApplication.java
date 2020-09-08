package com.ashwani.soap.country;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.ashwani.country.wsdl.GetCountryResponse;

@SpringBootApplication
public class CountryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return args -> {
			String country = "India";

			if (args.length > 0) {
				country = args[0];
			}
			final GetCountryResponse response = quoteClient.getCountry(country);
			System.err.println(response.getCountry().getCurrency());
		};
	}

}
