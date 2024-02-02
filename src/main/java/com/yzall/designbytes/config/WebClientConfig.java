package com.yzall.designbytes.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {

	Logger logger = LoggerFactory.getLogger(WebClientConfig.class);

	@Value("${openai.api.url}")
	private String targetUrl;

	@Bean
	public WebClient webClient() {
		HttpClient httpClient = HttpClient.create()
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);
//				.responseTimeout(Duration.ofMillis(10000))
//				.doOnConnected(conn ->
//						conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
//								.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

		return WebClient.builder()
				.baseUrl(targetUrl)
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				.filter(
						ExchangeFilterFunction.ofRequestProcessor(
								clientRequest -> {
									logger.info(">>>>>>>>> REQUEST <<<<<<<<<<");
									logger.info("Request: {} {}", clientRequest.method(), clientRequest.url());
									clientRequest.headers().forEach(
											(name, values) -> values.forEach(value -> logger.info("{} : {}", name, value))
									);
									return Mono.just(clientRequest);
								}
						)
				)
				.filter(
						ExchangeFilterFunction.ofResponseProcessor(
								clientResponse -> {
									logger.info(">>>>>>>>>> RESPONSE <<<<<<<<<<");
									clientResponse.headers().asHttpHeaders().forEach(
											(name, values) -> values.forEach(value -> logger.info("{} {}", name, value))
									);
									return Mono.just(clientResponse);
								}
						)
				)
				.defaultHeader("Content-Type", "application/json;charset=utf-8")
				.build();
	}
}