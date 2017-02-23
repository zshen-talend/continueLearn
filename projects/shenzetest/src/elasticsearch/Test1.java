// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package elasticsearch;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class Test1 {

    static private TransportClient client = null;

    public static void main(String args[]) throws UnknownHostException {
        Settings settings = Settings.settingsBuilder().put("cluster.name", "my-application777").build();
        client = TransportClient.builder().settings(settings).build();
        // Add transport addresses and do something with the client...
        // on startup

        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        initIndex();
        // deleteIndex();
        getIndex();
        searchIndex();
        stop();
    }

    /**
     * DOC zshen Comment method "searchIndex".
     */
    private static void searchIndex() {
        SearchResponse response = client.prepareSearch("twitter").setTypes("tweet")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(QueryBuilders.termQuery("content", "content"))// 智能匹配单个单词
                .addSort("_score", SortOrder.DESC).setFrom(0).setSize(6).setExplain(true).execute().actionGet();
        SearchHits hits = response.getHits();
        if (hits.totalHits() > 0) {
            for (SearchHit hit : hits) {
                System.out.println("score:" + hit.getScore() + ":\t" + hit.getSource());// .get("title")
            }
        } else {
            System.out.println("搜到0条结果");
        }

    }

    /**
     * DOC zshen Comment method "deleteIndex".
     */
    private static void deleteIndex() {
        DeleteResponse response = client.prepareDelete("twitter", "tweet", "1").get();

    }

    /**
     * DOC zshen Comment method "getIndex".
     */
    private static void getIndex() {
        GetResponse response = client.prepareGet("twitter", "tweet", "4").get();
        System.out.println(response.toString());
    }

    /**
     * DOC zshen Comment method "initIndex".
     */
    private static void initIndex() {
        try {

            XContentBuilder builder = XContentFactory.jsonBuilder().startObject().field("user", "kimchy")
                    .field("postDate", new Date()).field("message", "trying out Elasticsearch")
                    .field("content", "three a content").endObject();
            IndexResponse indexResponse = client.prepareIndex("twitter", "tweet", "1").setSource(builder).get();
            indexResponse = client.prepareIndex("twitter", "tweet", "2").setSource(builder).get();

            builder = XContentFactory.jsonBuilder().startObject().field("user", "zshen").field("postDate", new Date())
                    .field("message", "trying out Elasticsearch").field("content", "first a content").endObject();
            indexResponse = client.prepareIndex("twitter", "tweet", "3").setSource(builder).get();
            builder = XContentFactory.jsonBuilder().startObject().field("user", "zshen").field("postDate", new Date())
                    .field("message", "trying out Elasticsearch").field("content", "second a content").endObject();
            indexResponse = client.prepareIndex("twitter", "tweet", "4").setSource(builder).get();
            builder = XContentFactory.jsonBuilder().startObject().field("user", "zshen").field("postDate", new Date())
                    .field("message", "trying out Elasticsearch").field("content", "second a content").field("new1", "1111")
                    .endObject();
            indexResponse = client.prepareIndex("twitter", "tweet", "5").setSource(builder).get();
            indexResponse.getId();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void stop() {
        // on shutdown
        client.close();
    }
}
