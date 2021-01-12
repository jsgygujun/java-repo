package com.java.repo.code.spi;

import java.util.List;

/**
 * Java SPI
 * 1. 目录「resources/META-INF/services」
 * 2. 目录下放置一个配置文件。
 *          文件名是要扩展的接口全类名；
 *          文件内部为要实现的接口实现类；
 *          文件必须为UTF-8编码。
 * 3. 使用方法：
 *          ServiceLoad.load(XX.class)
 *          ServiceLoad<HelloInterface> sl = Service.load(HelloInterface.class);
 * @author GuJun
 * @date 2021/1/12
 */
public interface Search {
    List<String> searchDoc(String keyword);
}
