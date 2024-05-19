package com.springbootstarter.course;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

    //standard way to create topicID
    //public List<String> findByTopicName(String name)
    public List<Course> findByTopicId(String topicId);
} 
 