package com.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    // private List<Topic> topics =
    //      new ArrayList<>(Arrays.asList(
    //         new Topic("spring","spring framework","spring framework description"),
    //         new Topic("java","Core java","Core java description"),
    //         new Topic("javascript","javascript","javascript description")
    //     ));

        //findAll() connecting database run a query to get all topics
        //convert those rows in topic instances
    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isPresent()) {
            return optionalTopic.get();
        } else {
            // Handle the case where the topic with the given id is not found
            // For example, you could throw an exception or return null
            throw new RuntimeException("Topic with ID " + id + " not found");
        }
    }

    public void addTopic(Topic topic) {
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic){
        // for(int i=0; i<topics.size(); i++) {
        //     Topic t = topics.get(i);
        //     if(t.getId().equals(id)){
        //         topics.set(i, topic);
        //         return;
        //     }
        // }
        //for update as well we can use save
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {
            Topic topic = topicOptional.get();
            topicRepository.delete(topic);
        } else {
            // Handle the case where the topic with the given ID doesn't exist
            // You can throw an exception or log a message
            throw new RuntimeException("Topic with ID " + id + " not found");
        }
    }
}
