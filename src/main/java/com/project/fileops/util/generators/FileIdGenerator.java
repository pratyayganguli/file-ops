package com.project.fileops.util.generators;

import com.project.fileops.common.data.FileFormat;

import java.util.Random;

/**
 * created on: 08 15 2023
 * 11:58 am
 */

public class FileIdGenerator implements Generator<String>{
    private final FileFormat fileFormat;

    public FileIdGenerator(FileFormat fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public String generate(int length) {
        int start = 65;
        int end = 91;
        Random random = new Random();
        String user = new String();
        for(int i = 0; i < length; i++){
            int randomInt = random.nextInt(start, end);
            char c = (char) randomInt;
            user = c + user;
        }
        return user.toLowerCase() + "." + fileFormat.name().toLowerCase();
    }
}
