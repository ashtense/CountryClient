package com.ashwani.soap.country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.ashwani.country.wsdl.GetCountryRequest;
import com.ashwani.country.wsdl.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

	public GetCountryResponse getCountry(String country) {
		final GetCountryRequest request = new GetCountryRequest();
		request.setName(country);
		log.info("Requesting location for " + country);
		final GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/as/countries", request,
				new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
		return response;
	}
}
