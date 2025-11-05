package demoStudy.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ElasticsearchUtil {

    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchUtil.class);

    @Autowired
    private RestHighLevelClient client;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 创建或更新文档
     * @param index 索引名称
     * @param id 文档ID
     * @param document 文档对象
     * @return IndexResponse
     */
    public IndexResponse indexDocument(String index, String id, Object document) {
        try {
            String jsonDocument = objectMapper.writeValueAsString(document);
            IndexRequest request = new IndexRequest(index)
                    .id(id)
                    .source(jsonDocument, XContentType.JSON);

            IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            logger.info("Document indexed: index={}, id={}, result={}", index, id, response.getResult());
            return response;
        } catch (IOException e) {
            logger.error("Error indexing document: index={}, id={}", index, id, e);
            throw new RuntimeException("Failed to index document", e);
        }
    }

    /**
     * 查询索引中的所有文档
     * @param index 索引名称
     * @param size 返回文档数量限制
     * @return 文档列表
     */
    public List<Map<String, Object>> searchAllDocuments(String index, int size) {
        try {
            SearchRequest searchRequest = new SearchRequest(index);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.matchAllQuery());
            searchSourceBuilder.size(size);
            searchRequest.source(searchSourceBuilder);

            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            
            List<Map<String, Object>> documents = new ArrayList<>();
            for (SearchHit hit : searchResponse.getHits().getHits()) {
                documents.add(hit.getSourceAsMap());
            }
            
            logger.info("Found {} documents in index: {}", documents.size(), index);
            return documents;
        } catch (IOException e) {
            logger.error("Error searching documents in index: {}", index, e);
            throw new RuntimeException("Failed to search documents", e);
        }
    }

    /**
     * 获取索引统计信息
     * @param index 索引名称
     * @return 文档总数
     */
    public long getDocumentCount(String index) {
        try {
            SearchRequest searchRequest = new SearchRequest(index);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.matchAllQuery());
            searchSourceBuilder.size(0); // 只获取总数，不返回文档
            searchRequest.source(searchSourceBuilder);

            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            long totalHits = searchResponse.getHits().getTotalHits().value;
            
            logger.info("Total documents in index {}: {}", index, totalHits);
            return totalHits;
        } catch (IOException e) {
            logger.error("Error getting document count for index: {}", index, e);
            throw new RuntimeException("Failed to get document count", e);
        }
    }
}
