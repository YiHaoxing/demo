package com.yihaoxing.demo.test.enums;

public enum AppTypeEnum{
    ANDROID(1, "ANDROID"),
    IOS(2, "IOS"),
    ;


    private final Integer type;
    private final String name;

    AppTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String getNameByType(Integer type) {
        for (AppTypeEnum appTypeEnum : values()) {
            if (appTypeEnum.getType().equals(type))
                return appTypeEnum.getName();
        }
        return null;
    }

    public static AppTypeEnum getAppTypeEnum(Integer type) {
        for (AppTypeEnum appTypeEnum : values()) {
            if (appTypeEnum.getType().equals(type))
                return appTypeEnum;
        }
        return null;
    }
    public String getName() {
        return name;
    }
    public Integer getType() {
        return type;
    }
}
