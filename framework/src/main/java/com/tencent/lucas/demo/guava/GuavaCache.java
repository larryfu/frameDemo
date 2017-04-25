package com.tencent.lucas.demo.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by lucasfu on 2017/4/20.
 */
public class GuavaCache {

    public static void main(String[] args) throws ExecutionException {
        LoadingCache<String, Integer> scoreCache = CacheBuilder.newBuilder()
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(String s) throws Exception {
                        return null;
                    }
                });
        String key = "key";
        scoreCache.get(key, key::length);
    }

}
