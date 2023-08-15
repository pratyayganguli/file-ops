package com.project.fileops.util.builder;

/**
 * created on: 08 15 2023
 * 2:03 pm
 */

public class URLBuilder {
    private final String key;
    private final String userId;
    public URLBuilder(String key, String userId) {
        this.key = key;
        this.userId = userId;
    }

    public String build(){
        return String.format("https://content.fileops.com?content=%s&user=%s", key, userId);
    }
}
