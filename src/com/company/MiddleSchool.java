package com.company;

public class MiddleSchool extends AbstractSchool{
    @Override
    public Double chargefees(Student student) {
        GradeType grade = GradeType.valueOf(student.getGrade());
        System.out.println(grade);

        double fees = 100 * 1.75;
        switch (grade)
        {
            case SIXTH_GRADE:
                return fees;
            case SEVENTH_GRADE:
                return fees * 1.35;
            case EIGHTH_GRADE:
                return fees * 1.35 * 1.35;
            default:
                throw new IllegalArgumentException("Grade not Found");
        }


    }
}
