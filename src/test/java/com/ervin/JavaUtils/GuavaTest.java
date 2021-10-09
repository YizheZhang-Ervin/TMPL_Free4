package com.ervin.JavaUtils;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import com.google.common.primitives.Ints;
import org.apache.commons.lang3.StringUtils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuavaTest {
    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        // null设替代
        Joiner joiner = Joiner.on(",").useForNull("null替代物");
        // 跳过null
        // Joiner joiner = Joiner.on(",").skipNulls();
        System.out.println(joiner.join(list));
        // 其他join实现方法
        System.out.println(list.stream().filter(StringUtils::isNotBlank).collect(Collectors.joining(",")));
    }
    @Test
    public void test2(){
        String str = "a,,b, c ";
        // 分割+过滤空白字符串(不含“”)+去除每个元素前后空格
        Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();
        Iterable<String> iterable = splitter.split(str);
        System.out.println(iterable);
        List<String> list = splitter.splitToList(str);
        System.out.println(list);
    }
    @Test
    public void test3(){
        String str = "xxx_yy";
        // 下划线转驼峰(开头大写/小写)
        String strConvert = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,str);
        String strConvert2 = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL,str);
        System.out.println(strConvert+strConvert2);
    }
    @Test
    public void test4(){
        // 一次性list赋值
        List<String> list = Lists.newArrayList("a","b","c");
        // list切分
        List<List<String>> partition = Lists.partition(list,2);
        System.out.println(partition);
        for(List<String> ids:partition){
            System.out.println(ids);
        }
    }@Test
    public void test5(){
        // Ints,Floats,Longs
        List<Integer> integers = Ints.asList(1,2,3);
        System.out.println(integers);
    }
    @Test
    public void test6(){
        // Multiset
    }
    @Test
    public void test7(){
        // HashMultimap
    }
    @Test
    public void test8(){
        // ImmutableList
    }
    @Test
    public void test9(){
        // Preconditions
    }
}
