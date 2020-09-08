package com.ashwani.soap.country;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Experiment {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		final File requestFile = new File("src/main/resources/request.xml");
		final InputStream fileInputStream = new FileInputStream(requestFile);

		final HttpPost post = new HttpPost("http://localhost:8080/as/countries");
		post.setEntity(new InputStreamEntity(fileInputStream, requestFile.length()));
		post.setHeader("Content-type", "text/xml; charset=UTF-8");
		post.setHeader("SOAPAction", "");

		final HttpClient client = HttpClientBuilder.create().build();

		final HttpResponse response = client.execute(post);

		final String res_xml = EntityUtils.toString(response.getEntity());
		System.err.println(res_xml);

	}
}
