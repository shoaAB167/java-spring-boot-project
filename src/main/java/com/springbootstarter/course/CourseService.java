package com.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // private List<Course> courses =
    //      new ArrayList<>(Arrays.asList(
    //         new Course("spring","spring framework","spring framework description"),
    //         new Course("java","Core java","Core java description"),
    //         new Course("javascript","javascript","javascript description")
    //     ));

        //findAll() connecting database run a query to get all courses
        //convert those rows in course instances
    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId);
        return courses;
    }

    public Course getCourse(String id) {
        //return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            return optionalCourse.get();
        } else {
            // Handle the case where the course with the given id is not found
            // For example, you could throw an exception or return null
            throw new RuntimeException("Course with ID " + id + " not found");
        }
    }

    public void addCourse(Course course) {
        //courses.add(course);
        courseRepository.save(course);
    }

    public void updateCourse(Course course){
        // for(int i=0; i<courses.size(); i++) {
        //     Course t = courses.get(i);
        //     if(t.getId().equals(id)){
        //         courses.set(i, course);
        //         return;
        //     }
        // }
        //for update as well we can use save
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        //courses.removeIf(t -> t.getId().equals(id));
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            courseRepository.delete(course);
        } else {
            // Handle the case where the course with the given ID doesn't exist
            // You can throw an exception or log a message
            throw new RuntimeException("Course with ID " + id + " not found");
        }
    }
}
