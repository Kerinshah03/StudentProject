package com.company;

public class PreSchool extends AbstractSchool{
    @Override
    public Double chargefees(Student student) {
        GradeType grade = GradeType.valueOf(student.getGrade());
        System.out.println(grade);
        double fees = 100 * 1.1;
        switch (grade)
        {
            case JK_GRADE:
                return fees;
            case SK_GRADE:
                return fees * 1.25;
            default:
                throw new IllegalArgumentException("Grade not Found");
        }

    }
}
