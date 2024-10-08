package br.com.mockito;

import br.com.mockito.service.CourseService;

import java.util.ArrayList;
import java.util.List;

// CourseBusiness = SUT - System (Method) Under Test
public class CourseBusiness {

    //CourseService is a Dependency
    private CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }

    public List<String> retrieveCoursesRelatedToSpring(String student) {

        var filteredCourses = new ArrayList<String>();
        var allCourses = service.retrieveCourses(student);

        for (String course: allCourses) {
            if (course.contains("spring")) {
                filteredCourses.add(course);
            }
        }

        return filteredCourses;
    }
}
