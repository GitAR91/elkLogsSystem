package com.elkSystem.elkLogSystem.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOptions;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.ExistsQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.elkSystem.elkLogSystem.models.elasticsearch.LogDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {
    private final ElasticsearchClient elasticsearchClient;

    public List<LogDocument> getLogsByRequestId(String requestId){
        SortOptions sort = new SortOptions.Builder().field(f -> f.field("timestamp").order(SortOrder.Asc)).build();
//        String searchString = "\"bool\": {\"must\": [{\"match\": {\"requestId\": {\"query\": \"2c4d1ad2-c05c-4d80-9d0b-7894ba3fda19\"}}}],\"must_not\": [{\"exists\": {\"field\": \"objectId\"}}]}";
        List<LogDocument> result = new ArrayList<>();
        Query byRequestId = MatchQuery.of(m -> m
                .field("requestId")
                .query(requestId))._toQuery();
        Query byExistObjectId = ExistsQuery.of(e -> e.field("objectId"))._toQuery();

        try{
            SearchResponse<LogDocument> response = elasticsearchClient.search(s -> s
                            .index("logs")
                            .sort(sort)
                            .query(q -> q
                                    .bool(b -> b
                                            .must(byRequestId)
                                            .mustNot(byExistObjectId)
                                    )
                            ),
                    LogDocument.class
            );
            List<Hit<LogDocument>> hits = response.hits().hits();
            for (Hit<LogDocument> hit: hits) {
                LogDocument log = hit.source();
                result.add(log);
            }
            return result;

        } catch (IOException exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
