package com.codesdowork.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public abstract class Json {

    private final static Gson GSON = new Gson();

    public static String toJson(Object o) {
        return GSON.toJson(o);
    }

    public static <T>T fromJson(String json, Class<T> classOf) {
        return GSON.fromJson(json, classOf);
    }

    public static <T>T fromJson(String json, Type type) {
        return GSON.fromJson(json, type);
    }
}
