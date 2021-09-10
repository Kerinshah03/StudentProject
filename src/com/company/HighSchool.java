package com.company;

public class HighSchool extends AbstractSchool{

    @Override
    public Double chargefees(Student student) {
        GradeType grade = GradeType.valueOf(student.getGrade());
        System.out.println(grade);
        double fees = 100 * 2;
        switch (grade)
        {
            case NINTH_GRADE:
                return fees;
            case TENTH_GRADE:
                return fees * 1.45;
            case ELEVENTH_GRADE:
                return fees * 1.45 * 1.45;
            case TWELFTH_GRADE:
                return fees * 1.45 * 1.45 * 1.45;
            default:
                throw new IllegalArgumentException("Grade not Found");
        }

    }
}
