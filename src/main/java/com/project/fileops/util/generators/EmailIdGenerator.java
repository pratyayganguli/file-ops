package com.project.fileops.util.generators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

/**
 * created on: 08 15 2023
 * 11:18 am
 */

public class EmailIdGenerator implements Generator<String>{
    private final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Override
    public String generate(int length) {
        return appendUserDomain(length);
    }

    private String appendUserDomain(int length){
        return addRandomUser(length) + "@fileops.com";
    }

    private String addRandomUser(int length){
        int start = 65;
        int end = 91;
        Random random = new Random();
        String user = new String();
        for(int i = 0; i < length; i++){
            int randomInt = random.nextInt(start, end);
            char c = (char) randomInt;
            user = c + user;
        }
        return user.toLowerCase();
    }
}
