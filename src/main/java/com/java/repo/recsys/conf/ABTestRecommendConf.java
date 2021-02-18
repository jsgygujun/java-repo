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
public class ABTestRecommendConf {
    private List<RecommendConf> recommendConfList;

    public static void main(String[] args) {
        ABTestRecommendConf conf = ConfigUtil.getConfig("recommendTest.conf", "abTestRecommendConf", ABTestRecommendConf.class);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(conf));
    }
}
