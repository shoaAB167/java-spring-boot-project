package com.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return Arrays.asList(
            new Topic("spring","spring framework","spring framework description"),
            new Topic("java","Core java","Core java description"),
            new Topic("javascript","javascript","javascript description")
        );
    }
}
