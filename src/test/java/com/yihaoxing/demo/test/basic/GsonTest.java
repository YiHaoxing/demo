package com.yihaoxing.demo.test.basic;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yhx
 * @date 2020/10/9 22:00
 */
@SpringBootTest
public class GsonTest {
    static Gson gson = new Gson();

    @Test
    public void test01() throws IOException {
        String data = "{\"PRE_BREAKFAST\":{\"low\":3.3,\"high\":5.3},\"POST_SUPPER\":{\"low\":1.2,\"high\":35.0},\"POST_BREAKFAST_1\":{\"low\":4.0,\"high\":7.8},\"RANDOM\":{\"low\":1.2,\"high\":35.0},\"POST_SUPPER_1\":{\"low\":4.0,\"high\":7.8},\"POST_LUNCH_1\":{\"low\":4.0,\"high\":7.8},\"MIDNIGHT\":{\"low\":3.3,\"high\":5.3},\"PRE_SLEEP\":{\"low\":3.3,\"high\":5.3},\"POST_LUNCH\":{\"low\":1.2,\"high\":35.0},\"PRE_LUNCH\":{\"low\":1.0,\"high\":33.7},\"POST_BREAKFAST\":{\"low\":1.2,\"high\":35.0},\"PRE_SUPPER\":{\"low\":1.0,\"high\":33.7}}";
        Map<String, SimpleModel> map = toMap(data, String.class, SimpleModel.class);
        ArrayList<SimpleModel> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(map.get(s));
        }

        List<SimpleModel> strings = toList(JSON.toJSONString(list), SimpleModel.class);

        //Map<String, SimpleModel> toMap = toMap(data, SimpleModel.class);

        ArrayList<SimpleModel> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SimpleModel simpleModel = new SimpleModel();
            simpleModel.setHigh((float) i);
            simpleModel.setLow((float) i);
            simpleModel.setTime(LocalDateTime.now());
            Demo2 demo2 = new Demo2();
            demo2.setB(i);
            simpleModel.setDemos(Lists.newArrayList(demo2));
            arrayList.add(simpleModel);
        }
        String json = gson.toJson(arrayList);

        List<SimpleModel> simpleModels = toList(json, SimpleModel.class);


    }

    public <K, V> Map<K, V> toMap(String json, Class<K> kClazz, Class<V> vClazz) {
        return gson.fromJson(json, TypeToken.getParameterized(LinkedHashMap.class, kClazz, vClazz).getType());
    }

    public <V> Map<String,V> toMap(String json, Class<V> vClazz) {
        return gson.fromJson(json, TypeToken.getParameterized(LinkedHashMap.class, String.class, vClazz).getType());
    }

    public <T> List<T> toList(String json, Class<T> clazz) {
        return gson.fromJson(json, TypeToken.getParameterized(ArrayList.class, clazz).getType());
    }

    @Test
    public void test02(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            list.add(i);
        }
        if(list.size()>20){
            list = list.subList(0, 20);
        }
    }
}
