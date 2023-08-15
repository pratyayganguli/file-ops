package com.project.fileops.util.generators;

import org.junit.jupiter.api.Test;

class EmailIdGeneratorTest {
    private final EmailIdGenerator emailIdGenerator = new EmailIdGenerator();

    @Test
    void generate(){
        String mailId = emailIdGenerator.generate(10);
        System.out.println(mailId);
    }
}