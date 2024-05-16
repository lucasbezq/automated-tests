package br.com.ezequiel.business;


import br.com.ezequiel.service.CourseService;

import java.util.ArrayList;
import java.util.List;

public class CourseBusiness {

    private CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }

    public List<String> retrieveCursesRelatedToSpring(String student) {
        var filteredCurses = new ArrayList<String>();
        if ("Foo Bar".equals(student)) return filteredCurses;
        var allCurses = service.retrieveCurses(student);

        for (String curse : allCurses) {
            if (curse.contains("Spring")) {
                filteredCurses.add(curse);
            }
        }

        return filteredCurses;
    }
}
