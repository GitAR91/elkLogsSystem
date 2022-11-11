package com.elkSystem.elkLogSystem.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ElasticSearchConfig{
    @Value("${elasticsearch.data.host}")
    String elasticsearchHost;

    @Value("${elasticsearch.data.port}")
    Integer elasticsearchPort;

    @Bean
    public ElasticsearchClient getElasticSearchClient(){
        RestClient restClient = RestClient.builder(
                new HttpHost(elasticsearchHost, elasticsearchPort)).build();

        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        return new ElasticsearchClient(transport);
    }
}
