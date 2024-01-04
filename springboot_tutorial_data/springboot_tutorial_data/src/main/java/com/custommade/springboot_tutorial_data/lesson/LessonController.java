package com.custommade.springboot_tutorial_data.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.custommade.springboot_tutorial_data.course.Course;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;
    
    @GetMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessons( @PathVariable String courseId ) {
        return lessonService.getAllLessons(courseId);
    }

    @PostMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
        lesson.setCourse(new Course(courseId, "", "", topicId));
        lessonService.addLesson(lesson);
    }

    @GetMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public Lesson getLesson(@PathVariable String id) {
        return lessonService.getLesson(id);
    }

    @PutMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void updateLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId, @PathVariable String id) {
        lessonService.updateLesson(lesson);
    }

    @DeleteMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}") 
    public void deleteLesson(@PathVariable String id) {
        lessonService.deleteLesson(id);
    }
}