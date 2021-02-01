package com.java.repo.demo.spi;

import java.util.ServiceLoader;

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
 *
 * 使用场景： 比如你有一个工程A，有一个接口A，接口A在工程A是没有实现类的，那么问题来了，系统运行时，怎么给接口A选择一个实现类？
 *          让工程A来依赖你的jar包，然后在系统运行时，工程A跑起来，对于接口A，就会扫描依赖的jar包，看看有没有META-INF/services/文件夹，
 *          如果有，在看看有没有名为接口A的文件，如果有，在里面找一下指定的接口A的实现是你的jar包里的哪个类！
 *
 * Java 中的 SPI
 *          Java定义了一套JDBC的接口，但是并没有提供其实现类，但实际上项目运行时，要使用JDBC接口的哪些实现类呢？
 *          一般来说，我们要根据自己使用的数据库，比如
 *          * MySQL，你就用 mysql-jdbc-connector.jar
 *          * Oracle，你就用 oracle-jdbc-connector.jar
 *          系统运行时，碰到你使用JDBC的接口，就会在底层使用你引入的那个jar中提供的实现类。
 * @author GuJun
 * @date 2021/1/12
 */
public class SpiDemo {
    public static void main(String[] args) {
        ServiceLoader<Search> sl = ServiceLoader.load(Search.class);
        for (Search search : sl) {
            search.searchDoc("hello world");
        }
    }
}
