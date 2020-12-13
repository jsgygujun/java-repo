package 枚举;

/**
 * @author GuJun
 * @date 2020/12/13
 */
public enum 枚举_星期 {
    星期日(0, "星期日"),
    星期一(1, "星期一"),
    星期二(2, "星期二"),
    星期三(3, "星期三"),
    星期四(4, "星期四"),
    星期五(5, "星期五"),
    星期六(6, "星期六");

    枚举_星期(int id, String day) {
        this.id      = id;
        this.day     = day;
    }

    public static 枚举_星期 from(int id) {
        for (枚举_星期 天 : 枚举_星期.values()) {
            if (天.id == id) return 天;
        }
        return 星期日;
    }

    private final int id;
    private final String day;

    @Override
    public String toString() {
        return "枚举_星期{" +
                "day='" + day + '\'' +
                '}';
    }
}
