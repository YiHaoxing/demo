package com.yihaoxing.demo.test.basic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class JacksonTest {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test01() throws IOException {
        Double d = 1.44999999999D;

        System.out.println(String.format("%.1f", d));

        Map<String, BigDecimal> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), BigDecimal.valueOf(i + Math.random()));
        }
        String s = objectMapper.writeValueAsString(map);
        Map<String, BigDecimal> decimalMap = parseObject(s, new TypeReference<Map<String, BigDecimal>>() {
        });


    }

    public static <T> T parseObject(String text, TypeReference<T> typeReference) {
        T t;
        try {
            t = objectMapper.readValue(text, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
}
