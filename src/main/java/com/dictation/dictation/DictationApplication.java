package com.dictation.dictation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dictation.dictation.dao")
public class DictationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DictationApplication.class, args);
    }
}
