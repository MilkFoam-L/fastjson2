package com.alibaba.fastjson2.codec;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONB;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONBTableTest3 {
    final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void test_0() {
        A a = new A();
        a.list2 = new com.alibaba.fastjson.JSONArray();
        a.list2.add(new com.alibaba.fastjson.JSONObject()
                .fluentPut("id", 101)
                .fluentPut("name", "DataWorks")
        );
        a.list2.add(new com.alibaba.fastjson.JSONObject()
                .fluentPut("id", 102)
                .fluentPut("name", "MaxCompute")
        );
        a.list2.add(new com.alibaba.fastjson.JSONObject()
                .fluentPut("id", 103)
                .fluentPut("name", "EMR")
        );

        byte[] bytes = JSONB.toBytes(a);
        A a1 = JSONB.parseObject(bytes, A.class);
        assertMapsEqual(a, a1);
    }

    @Test
    public void test_1() {
        A a = new A();
        a.list2 = new com.alibaba.fastjson.JSONArray();
        a.list2.add(new com.alibaba.fastjson.JSONObject()
                .fluentPut("id", 101)
                .fluentPut("name", "DataWorks")
        );
        a.list2.add(new com.alibaba.fastjson.JSONObject()
                .fluentPut("id", 102)
                .fluentPut("name", "MaxCompute")
        );
        a.list2.add(new com.alibaba.fastjson.JSONObject()
                .fluentPut("id", 103)
                .fluentPut("name", "EMR")
                .fluentPut("ext", "101")
        );

        byte[] bytes = JSONB.toBytes(a);
        A a1 = JSONB.parseObject(bytes, A.class);
        assertMapsEqual(a, a1);
    }

    private void assertMapsEqual(A a, A a1) {
        try {
            Map<String, Object> mapa = mapper.readValue(JSON.toJSONString(a), Map.class);
            Map<String, Object> mapa1 = mapper.readValue(JSON.toJSONString(a1), Map.class);
            assertEquals(mapa, mapa1);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read value as Map", e);
        }
    }

    public static class A {
        public com.alibaba.fastjson.JSONArray list2;
    }
}
