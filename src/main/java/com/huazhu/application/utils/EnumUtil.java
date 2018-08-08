package com.huazhu.application.utils;



import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class EnumUtil {

    public static String combineCode(Integer... code) {

        if (code == null) {
            return "";
        }
        return Arrays.stream(code).distinct().map(codeEnum -> String.valueOf(code))
                .collect(Collectors.joining(","));
    }






}
