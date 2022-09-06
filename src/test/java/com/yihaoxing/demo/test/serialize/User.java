package com.yihaoxing.demo.test.serialize;

/**
 * <p></p>
 *
 * @author yihaoxing
 * @since 2022/8/3 21:59
 */
public class User {
    private String name;
    private int age;

    private boolean isSuccess;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", isSuccess=" + isSuccess + '}';
    }
}
