package br.com.mockito.business;

import br.com.mockito.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CourseBusinessMockTest {

    CourseService mockService;
    CourseBusiness business;

    @BeforeEach
    void setup() {

        // Given
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {

        // When
        var filteredCourses = business.retriveCoursesRelatedToSpring("Leandro");

        // Then
        assertEquals(4, filteredCourses.size());
    }

}