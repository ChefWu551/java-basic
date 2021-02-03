package com.yuefeng.hashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @Test
    public void showHashMapResize() {
        Map hashMap = new HashMap();

        // default length
        // 非默认长度：resize 使用 X = X | >>> 2^n + 1变成2的幂次方
    }
}
