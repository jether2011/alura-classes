package br.com.alura.escola.dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TesteHttpDAO {

	public void testarConexaoHttp() throws IOException, InterruptedException, URISyntaxException {
		URI uri = new URI("https://www.google.com");
		HttpClient client = HttpClient.newBuilder()
				.followRedirects(HttpClient.Redirect.ALWAYS).build();
		HttpRequest req = HttpRequest.newBuilder(uri).GET().build();
		HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
		System.out.println(resp.body());
	}
}
