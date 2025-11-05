package demoStudy.controller;

import demoStudy.es.ElasticsearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/es")
public class ElasticsearchController {

    @Autowired
    private ElasticsearchUtil elasticsearchUtil;

    /**
     * 查询 gm-test 索引中的所有数据
     */
    @GetMapping("/gm-test/search")
    public Map<String, Object> searchGmTestData(@RequestParam(defaultValue = "10") int size) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            // 获取文档总数
            long totalCount = elasticsearchUtil.getDocumentCount("gm-test");
            
            // 获取文档列表
            List<Map<String, Object>> documents = elasticsearchUtil.searchAllDocuments("gm-test", size);
            
            result.put("success", true);
            result.put("totalCount", totalCount);
            result.put("returnedCount", documents.size());
            result.put("documents", documents);
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        
        return result;
    }

    /**
     * 获取 gm-test 索引的统计信息
     */
    @GetMapping("/gm-test/stats")
    public Map<String, Object> getGmTestStats() {
        Map<String, Object> result = new HashMap<>();
        
        try {
            long totalCount = elasticsearchUtil.getDocumentCount("gm-test");
            
            result.put("success", true);
            result.put("index", "gm-test");
            result.put("totalDocuments", totalCount);
            
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        
        return result;
    }
}