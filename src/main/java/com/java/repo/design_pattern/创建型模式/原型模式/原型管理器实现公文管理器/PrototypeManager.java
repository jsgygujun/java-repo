package com.java.repo.design_pattern.创建型模式.原型模式.原型管理器实现公文管理器;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class PrototypeManager {

    private PrototypeManager() {
        addOfficialDocument("far", new FAR());
        addOfficialDocument("srs", new SRS());
    }

    private static PrototypeManager pm = new PrototypeManager();

    private Map<String, OfficialDocument> prototypeContainer = new HashMap<>();

    public void addOfficialDocument(String key, OfficialDocument officialDocument) {
        prototypeContainer.put(key, officialDocument);
    }

    public OfficialDocument getOfficialDocument(String key) {
        return prototypeContainer.get(key).clone();
    }

    public static PrototypeManager getInstance() {
        return pm;
    }
}
