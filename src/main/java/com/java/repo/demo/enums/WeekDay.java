package com.java.repo.demo.enums;

public enum  WeekDay {
    Sunday(0, "星期日"),
    Monday(1, "星期一"),
    Tuesday(2, "星期二"),
    Wednesday(3, "星期三"),
    Thursday(4, "星期四"),
    Friday(5, "星期五"),
    Saturday(6, "星期六");

    WeekDay(int id, String day) {
        this.id     = id;
        this.day    = day;
    }

    private final int id;
    private final String day;

    public static WeekDay from(int id) {
        for (WeekDay weekDay : WeekDay.values()) {
            if (weekDay.id == id) return weekDay;
        }
        return Sunday;
    }

    @Override
    public String toString() {
        return "WeekDay{" +
                "id=" + id +
                ", day='" + day + '\'' +
                '}';
    }
}
