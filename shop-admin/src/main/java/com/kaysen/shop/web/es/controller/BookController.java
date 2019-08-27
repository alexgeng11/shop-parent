package com.kaysen.shop.web.es.controller;

import com.alibaba.fastjson.JSON;
import com.kaysen.shop.web.es.bean.Book;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.*;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/book")
public class BookController {
    @Autowired
    private RestClient client;
    @Autowired
    private TransportClient transportClient;
//    // RequestOptions类保存应在同一应用程序中的多个请求之间共享的部分请求
//    private static final RequestOptions COMMON_OPTIONS;
//
//    static {
//        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
//        // 添加所有请求所需的任何标头。
//        builder.addHeader("Authorization", "Bearer " + TOKEN);
//        // 自定义响应使用者
//        builder.setHttpAsyncResponseConsumerFactory(
//                new HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory(30 * 1024 * 1024 * 1024));
//        COMMON_OPTIONS = builder.build();
//    }

    @RequestMapping(value = "/go", method = RequestMethod.GET)
    public ResponseEntity<String> go() {
        return new ResponseEntity<>("go", HttpStatus.OK);
    }

    /**
     * 同步执行HTTP请求
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/es", method = RequestMethod.GET)
    public ResponseEntity<String> getEsInfo() throws IOException {
        Request request = new Request("GET", "_cat/nodes");
        Response response = client.performRequest(request);
        String responseBody = EntityUtils.toString(response.getEntity());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }


    /**
     * 异步执行HTTP请求
     * @return
     */
    @RequestMapping(value = "/es/asyn", method = RequestMethod.GET)
    public ResponseEntity<String> asynchronous() {
        Request request = new Request(
                "GET",
                "/");
        client.performRequestAsync(request, new ResponseListener() {
            @Override
            public void onSuccess(Response response) {
                System.out.println("异步执行HTTP请求并成功");
            }

            @Override
            public void onFailure(Exception exception) {
                System.out.println("异步执行HTTP请求并失败");
            }
        });
        return null;
    }

    /**
     * 并行异步执行HTTP请求
     */
    @RequestMapping(value = "/ps", method = RequestMethod.POST)
    public void parallAsyn(@RequestBody Book[] documents) {
//        final CountDownLatch latch = new CountDownLatch(documents.length);
//        for (int i = 0; i < documents.length; i++) {
//            Request request = new Request("PUT", "/posts/doc/" + i);
//            //let's assume that the documents are stored in an HttpEntity array
//            request.setEntity(documents[i]);
//            client.performRequestAsync(
//                    request,
//                    new ResponseListener() {
//                        @Override
//                        public void onSuccess(Response response) {
//
//                            latch.countDown();
//                        }
//
//                        @Override
//                        public void onFailure(Exception exception) {
//
//                            latch.countDown();
//                        }
//                    }
//            );
//        }
//        latch.await();
    }

        /**
     * 添加ES对象, Book的ID就是ES中存储的document的ID，所以最好不要为空，自定义生成的ID太浮夸
     *
     * @return ResponseEntity
     * @throws IOException
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestBody Book book) throws IOException {
        // 构造HTTP请求，第一个参数是请求方法，第二个参数是服务器的端点，host默认是http://localhost:9200，
        // endpoint直接指定为index/type的形式
        Request request = new Request("POST", new StringBuilder("/book/book/").
                append(book.getId()).toString());
        // 设置其他一些参数比如美化json
        request.addParameter("pretty", "true");
        JSONObject jsonObject = new JSONObject(book);
        System.out.println(jsonObject.toString());
        // 设置请求体并指定ContentType，如果不指定默认为APPLICATION_JSON
        request.setEntity(new NStringEntity(jsonObject.toString(), ContentType.APPLICATION_JSON));

        // 发送HTTP请求
        Response response = client.performRequest(request);

        // 获取响应体, id: AWXvzZYWXWr3RnGSLyhH
        String responseBody = EntityUtils.toString(response.getEntity());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * 根据id获取ES对象
     *
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getBookById(@PathVariable("id") String id) {
        Request request = new Request("GET", new StringBuilder("/book/book/").
                append(id).toString());
        // 添加json返回优化
        request.addParameter("pretty", "true");
        Response response = null;
        String responseBody = null;
        try {
            // 执行HHTP请求
            response = client.performRequest(request);
            responseBody = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            return new ResponseEntity<>("can not found the book by your id", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * 根据id更新Book
     *
     * @param id
     * @param book
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBook(@PathVariable("id") String id, @RequestBody Book book) throws IOException {
        // 构造HTTP请求
        Request request = new Request("POST", new StringBuilder("/book/book/").
                append(id).append("/_update").toString());
        request.addParameter("pretty", "true");

        // 将数据丢进去，这里一定要外包一层“doc”，否则内部不能识别
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("doc", new JSONObject(book));
        request.setEntity(new NStringEntity(jsonObject.toString()));

        // 执行HTTP请求
        Response response = client.performRequest(request);

        // 获取返回的内容
        String responseBody = EntityUtils.toString(response.getEntity());

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @RequestMapping(value = "/queryBook", method = RequestMethod.POST)
    public ResponseEntity queryBook(String title,String author) throws IOException {
//        String endPoint=new StringBuilder("/book/").append("/_search").toString();
//        Request request = new Request("POST",endPoint);
//        request.addParameter("pretty", "true");
//
//        // 将数据丢进去，这里一定要外包一层“doc”，否则内部不能识别
//        Book book=new Book();
//        if(title!=null){
//            book.setName(title);
//        }
//        if (author!=null){
//            book.setAuthor(author);
//        }
//      String queryStr="{" +
//              "  \"query\": {" +
//
//              "    \"match\": " +JSON.toJSONString(book)+
//              "  }," +
//              "  \"from\": 0," +
//              "  \"size\": 1" +
//              "}";
//        System.out.println(queryStr);
//        request.setEntity(new NStringEntity(queryStr, ContentType.APPLICATION_JSON));
//        Response response = client.performRequest(request);
//        // 获取返回的内容
//        String responseBody = EntityUtils.toString(response.getEntity());
//
//        return new ResponseEntity<>(responseBody, HttpStatus.OK);
        BoolQueryBuilder boolQueryBuilder= QueryBuilders.boolQuery();
        if (title!=null){
            boolQueryBuilder.must(QueryBuilders.matchQuery("name",title));
        }
        if (author!=null){
            boolQueryBuilder.must(QueryBuilders.matchQuery("author",author));
        }
        SearchRequestBuilder builder = transportClient.prepareSearch("book")
                .setTypes("book")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(boolQueryBuilder);
        System.out.println(boolQueryBuilder);
        SearchResponse searchResponse = builder.get();
        List<Map<String,Object>> result=new ArrayList<>();
        SearchHits hits = searchResponse.getHits();
        for (SearchHit hit:hits) {
            result.add(hit.getSource());
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    /**
     * 使用脚本更新Book
     * @param id
     * @param
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/update2/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBook2(@PathVariable("id") String id, @RequestParam("name") String name) throws IOException {
        // 构造HTTP请求
        Request request = new Request("POST", new StringBuilder("/book/book/").
                append(id).append("/_update").toString());
        request.addParameter("pretty", "true");

        JSONObject jsonObject = new JSONObject();
        // 创建脚本语言，如果是字符变量，必须加单引号
        StringBuilder op1 = new StringBuilder("ctx._source.name=").append("'" + name + "'");
        jsonObject.put("script", op1);

        request.setEntity(new NStringEntity(jsonObject.toString(), ContentType.APPLICATION_JSON));

        // 执行HTTP请求
        Response response = client.performRequest(request);

        // 获取返回的内容
        String responseBody = EntityUtils.toString(response.getEntity());

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteById(@PathVariable("id") String id) throws IOException {
        Request request = new Request("DELETE", new StringBuilder("/book/book/").append(id).toString());
        request.addParameter("pretty", "true");
        // 执行HTTP请求
        Response response = client.performRequest(request);
        // 获取结果
        String responseBody = EntityUtils.toString(response.getEntity());

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
