package com.java.repo.design_pattern.创建型模式.原型模式.原型模式实现周报_深拷贝;

import com.java.repo.util.ClonerUtil;
import lombok.Data;

/**
 * @author GuJun
 * @date 2021/2/8
 */
@Data
public class WeeklyLog {
    private String name;
    private String date;
    private String content;
    private Attachment attachment;

    @Data
    public static class Attachment {
        private String name;
    }

    public void download() {
        System.out.println("下载附件，文件名为： " + name);
    }

    public WeeklyLog deepClone() {
        return ClonerUtil.deepClone(this);
    }

}
