package com.java.repo.recsys.core.bucket;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public enum Bucket {
    Bucket_00("bkt_00"),
    Bucket_01("bkt_01"),
    Bucket_02("bkt_02"),
    Bucket_03("bkt_03"),
    Bucket_04("bkt_04"),
    Bucket_05("bkt_05"),
    Bucket_06("bkt_06"),
    Bucket_07("bkt_07"),
    Bucket_08("bkt_08"),
    Bucket_09("bkt_09"),
    Bucket_10("bkt_10"),
    Bucket_11("bkt_11"),
    Bucket_12("bkt_12"),
    Bucket_13("bkt_13"),
    Bucket_14("bkt_14"),
    Bucket_15("bkt_15"),
    Bucket_16("bkt_16"),
    Bucket_17("bkt_17"),
    Bucket_18("bkt_18"),
    Bucket_19("bkt_19");

    Bucket(String name) {
        this.name = name;
    }

    private final String name;

    public static Bucket from(String name) {
        for (Bucket bucket : Bucket.values()) {
            if (bucket.name.equals(name)) return bucket;
        }
        return Bucket_00;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "name='" + name + '\'' +
                '}';
    }
}
