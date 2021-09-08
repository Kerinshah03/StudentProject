package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractSchool implements School{

    Map<String, List<Student>> gradeToStudentsMap = new HashMap<>();

    @Override
    public Student admitStudent(String name, int age, String grade) {
        return null;
    }
}
