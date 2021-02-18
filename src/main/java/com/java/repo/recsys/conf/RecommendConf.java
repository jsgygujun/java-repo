package com.java.repo.recsys.conf;

import com.google.gson.GsonBuilder;
import com.java.repo.util.ConfigUtil;
import lombok.Data;

import java.util.List;

/**
 * @author GuJun
 * @date 2021/2/18
 */
@Data
public class RecommendConf {
    private String name;
    private List<String> bkt;
    private List<String> trigger;
    private List<String> fetcher;
    private List<String> filter;
    private String merger;
    private String ranker;
    private String reRanker;

    public static void main(String[] args) {
        RecommendConf conf = ConfigUtil.getConfig("recommendBase.conf", "baseRecommendConf", RecommendConf.class);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(conf));
    }
}
