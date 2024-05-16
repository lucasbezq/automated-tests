package br.com.ezequiel.business;

import br.com.ezequiel.service.CourseService;
import br.com.ezequiel.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseBusinessStubTest {

    @Test
    void testCoursesRelatedToSpring_When_UsingAStub() {
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        var filteredCourses = business.retrieveCursesRelatedToSpring("Lucas");

        assertEquals(4, filteredCourses.size());
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAFooBarStudent() {
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        var filteredCourses = business.retrieveCursesRelatedToSpring("Foo Bar");

        assertEquals(0, filteredCourses.size());
    }
}
