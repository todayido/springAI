package demoStudy.es;

import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.*;
import org.elasticsearch.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class ElasticsearchInit {
    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchInit.class);
    private static final String TEMPLATE_NAME = "gm-test";
    private static final String INDEX_NAME = "gm-test";

    @Autowired
    private RestHighLevelClient esClient;

    @PostConstruct
    public void init() {
        try {
            initTemplateAndIndex();
        } catch (Exception e) {
            logger.error("Elasticsearch初始化失败", e);
        }
    }

    public void initTemplateAndIndex() throws IOException {
    // 检查模板是否存在
    boolean templateExists = esClient.indices().existsTemplate(
            new IndexTemplatesExistRequest(TEMPLATE_NAME),
            RequestOptions.DEFAULT
    );

    if (!templateExists) {
        logger.info("模板{}不存在，开始创建", TEMPLATE_NAME);

        // 读取settings
        ClassPathResource settingsResource = new ClassPathResource("gm-test-settings.json");
        String settingsSource = new String(Files.readAllBytes(Paths.get(settingsResource.getURI())));

        // 读取mappings
        ClassPathResource mappingsResource = new ClassPathResource("gm-test-mappings.json");
        String mappingsSource = new String(Files.readAllBytes(Paths.get(mappingsResource.getURI())));

        // 创建模板
        PutIndexTemplateRequest request = new PutIndexTemplateRequest(TEMPLATE_NAME)
                .patterns(java.util.Arrays.asList(TEMPLATE_NAME + "-*"))
                .settings(settingsSource, XContentType.JSON)
                .mapping(mappingsSource, XContentType.JSON);

        AcknowledgedResponse response = esClient.indices()
                .putTemplate(request, RequestOptions.DEFAULT);

        if (response.isAcknowledged()) {
            logger.info("模板{}创建成功", TEMPLATE_NAME);
        } else {
            logger.error("模板{}创建失败", TEMPLATE_NAME);
        }
    } else {
        logger.info("模板{}已存在", TEMPLATE_NAME);
    }

    // 检查索引是否存在
    boolean indexExists = esClient.indices()
            .exists(new GetIndexRequest(INDEX_NAME), RequestOptions.DEFAULT);

    if (!indexExists) {
        logger.info("索引{}不存在，开始创建", INDEX_NAME);
        esClient.indices()
                .create(new CreateIndexRequest(INDEX_NAME), RequestOptions.DEFAULT);
        logger.info("索引{}创建成功", INDEX_NAME);
    } else {
        logger.info("索引{}已存在", INDEX_NAME);
    }
}
}