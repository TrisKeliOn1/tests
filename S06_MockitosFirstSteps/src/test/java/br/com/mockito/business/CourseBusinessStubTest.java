package br.com.mockito.business;

import br.com.mockito.service.CourseService;
import br.com.mockito.stubs.CourseServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseBusinessStubTest {

    @Test
    void testCoursesRelatedToSpring_When_UsingAStub() {
        // Given
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        // When
        var filteredCourses = business.retriveCoursesRelatedToSpring("Leandro");

        // Then
        assertEquals(4, filteredCourses.size());
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAFooBarStudent() {
        // Given
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        // When
        var filteredCourses = business.retriveCoursesRelatedToSpring("Foo Bar");

        // Then
        assertEquals(0, filteredCourses.size());
    }
}