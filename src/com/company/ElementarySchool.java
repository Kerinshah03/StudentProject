package com.company;

public class ElementarySchool extends AbstractSchool{
    static double tempFees;
    @Override
    public Double chargefees(Student student) {
        int percentage = 30;
        GradeType grade = GradeType.valueOf(student.getGrade());
        System.out.println(grade);
        double fees = 100 * 1.5;
        switch (grade)
        {
            case FIRST_GRADE:
                return fees;
            case SECOND_GRADE:
                return fees * 1.3;
            case THIRD_GRADE:
                return fees * 1.3 * 1.3;
            case FOURTH_GRADE:
                return fees * 1.3 * 1.3 * 1.3;
            case FIFTH_GRADE:
                return fees * 1.3 * 1.3 * 1.3 * 1.3;
            default:
                throw new IllegalArgumentException("Grade not Found");
        }
    }
}
