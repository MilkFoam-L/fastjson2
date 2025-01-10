package com.alibaba.fastjson2.benchmark.jjb;

import static com.alibaba.fastjson2.benchmark.JMH.BH;

public class ClientsWriteCNBytesTest {
    static final ClientsWriteCNBytes benchmark = new ClientsWriteCNBytes();

    public static void jsonb() {
        for (int j = 0; j < 5; j++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000 * 1000; ++i) {
                benchmark.jsonb(BH);
            }
            long millis = System.currentTimeMillis() - start;
            System.out.println("ClientsWriteUTF8Bytes-jsonb millis : " + millis);
            // zulu17.40.19 : 609
            // zulu17.40.19_vec :
        }
    }

    public static void jsonb_beanToArray() {
        for (int j = 0; j < 5; j++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000 * 1000; ++i) {
                benchmark.jsonb_beanToArray(BH);
            }
            long millis = System.currentTimeMillis() - start;
            System.out.println("ClientsWriteUTF8Bytes-jsonb_beanToArray millis : " + millis);
            // zulu17.40.19 : 311 303
            // zulu17.40.19_vec :
        }
    }

    public static void fastjson2() {
        for (int j = 0; j < 5; j++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000 * 1000; ++i) {
                benchmark.fastjson2(BH);
            }
            long millis = System.currentTimeMillis() - start;
            System.out.println("ClientsWriteUTF8Bytes-fastjson2 millis : " + millis);
            // zulu8.70.0.23 :
            // zulu17.40.19 : 1027
            // zulu17.40.19_vec :
            // zulu17.40.19_reflect :
        }
    }

    public static void wast() {
        for (int j = 0; j < 5; j++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000 * 1000; ++i) {
                benchmark.wast(BH);
            }
            long millis = System.currentTimeMillis() - start;
            System.out.println("ClientsWriteUTF8Bytes-wast millis : " + millis);
            // zulu8.70.0.23 :
            // zulu17.40.19 : 1364
            // zulu17.40.19_vec :
            // zulu17.40.19_reflect :
        }
    }

    public static void fastjson2_str() {
        for (int j = 0; j < 5; j++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000 * 1000; ++i) {
                benchmark.fastjson2_str(BH);
            }
            long millis = System.currentTimeMillis() - start;
            System.out.println("ClientsWriteUTF8Bytes-fastjson2 millis : " + millis);
            // zulu17.40.19 :
            // zulu17.40.19_vec : 1139 1313 1307 1206
        }
    }

    public static void dsljson() throws Exception {
        for (int j = 0; j < 5; j++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000 * 1000; ++i) {
                benchmark.dsljson(BH);
            }
            long millis = System.currentTimeMillis() - start;
            System.out.println("ClientsWriteUTF8Bytes-dsljson millis : " + millis);
            // zulu17.40.19 : 2169 1487
        }
    }

    public static void jackson() throws Exception {
        for (int j = 0; j < 10; j++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000 * 1000; ++i) {
                benchmark.jackson(BH);
            }
            long millis = System.currentTimeMillis() - start;
            System.out.println("jackson millis : " + millis);
        }
    }

    public static void main(String[] args) throws Exception {
        fastjson2();
//        wast();
//        jsonb();
//        jsonb_beanToArray();
//        fastjson2_str();
//        dsljson();
//        jackson();
    }
}