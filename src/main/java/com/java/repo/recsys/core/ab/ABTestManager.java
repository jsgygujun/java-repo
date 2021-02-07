package com.java.repo.recsys.core.ab;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.java.repo.recsys.core.bucket.Bucket;
import com.java.repo.util.ConfigUtil;
import com.typesafe.config.ConfigValue;
import lombok.val;

import javax.annotation.PostConstruct;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public class ABTestManager {
    private final Map<Bucket, ABTest> context = new HashMap<>();
    private static final Gson GSON = new Gson();
    private static final Type TYPE_TOKEN = new TypeToken<List<String>>(){}.getType();

    @PostConstruct
    private void init() {
        config();
        check();
    }

    private void config() {
        Set<Map.Entry<String, ConfigValue>> entrySet = ConfigUtil.getConfig("ab.conf").entrySet();
        for (val entry : entrySet) {
            List<String> bktList = GSON.fromJson(entry.getValue().unwrapped().toString(), TYPE_TOKEN);
            for (val bkt : bktList) {
                context.put(Bucket.from(bkt), ABTest.from(entry.getKey()));
            }
        }
        for (val entry : context.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    /**
     * 检查分桶配置的合法性
     * @throws RuntimeException
     */
    private void check() throws RuntimeException {
        for (val bucket : Bucket.values()) {
            if (!context.containsKey(bucket)) {
                throw new RuntimeException("Failed to check ab test config, " + bucket + " not config!");
            };
        }
    }

    public ABTest getABTest(Bucket bucket) {
        return context.get(bucket);
    }
}
