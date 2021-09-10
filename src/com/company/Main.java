package com.company;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    static School preSchool = new PreSchool();
    static School elementarySchool = new ElementarySchool();
    static School middleSchool = new MiddleSchool();
    static School highSchool = new HighSchool();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("*********************************************" +
                "\nWelcome to the School admission App !!! press X to exit \n" +
                "*********************************************");

        while (true) {

            // Taking Name of student if not match Condition, it will ask again
            System.out.println("Enter the name of the student :    (no less than 3 chars and no more than 50 chars)\n");
            String name = getStringInput();
            checkExit(name);
            do {
                if (name.length() < 3 || name.length() > 50) {
                    System.out.println(name.length());
                    System.out.print(" name should be >=3 characters or less than <=50\n");
                    name = getStringInput();
                    checkExit(name);
                }else {
                    break;
                }
            }while (true);

            // Taking Birth Date of student if not match Condition, it will ask again
            System.out.println("Date of Birth of the student: ( mm/dd/yyyy ) In This Format");
            String dateOfBirth = getStringInput();
            checkExit(dateOfBirth);
            int age;
            do{
                age = findAge(dateOfBirth);
                System.out.println(age);
                if (age < 4 || age > 17) {
                    System.out.println("No Schools Available\n");
                    dateOfBirth = getStringInput();
                    checkExit(dateOfBirth);
                }
                else
                {
                    break;
                }
            }while (true);

            // Finding Grade for the Student
            GradeType gradeType = null;
            try {
                gradeType = determineGradeBasedOnAge(age);
            } catch (AgeNotCorrectException e) {
                e.getMessage();
            }finally {
                System.out.println(gradeType);
            }


            //Finding Class Type for the Student
            SchoolType schoolType = null;
            schoolType = getSchoolTypeBasedOnGradetype(gradeType);
            String grade = String.valueOf(gradeType);
            Student student = new Student(name,age,grade);

            // Finding School Object
            School school = getSchoolObject(schoolType);
            try {
                school.admitStudent(student);
            } catch (ClassFullException e) {
                System.out.println("Sorry Class for grade " + grade + "is full try another student");
            }

            //Find out Fees as per Grade Type of Student
            double fees = school.chargefees(student);
            System.out.println("Fees charged for the student is  : " + fees);
        }

    }

    private static void checkExit(String check) {
        if(check.equalsIgnoreCase("x"))
        {
            System.out.println("Exiting School Admissions App.");
            exit(0);
        }
    }

    private static School getSchoolObject(SchoolType schoolType) {
        switch (schoolType) {
            case PRE_SCHOOL:
                return preSchool;
            case ELEMENTARY_SCHOOL:
                return elementarySchool;
            case MIDDLE_SCHOOL:
                return middleSchool;
            case HIGH_SCHOOL:
                return highSchool;
            default:
                throw new IllegalArgumentException("Wrong School Type");
        }
    }

    private static SchoolType getSchoolTypeBasedOnGradetype(GradeType gradeType) {
        System.out.println("Determining School Level based on grade !!!");
        switch (gradeType)
        {
            case JK_GRADE:
            case SK_GRADE:
                return SchoolType.PRE_SCHOOL;
            case FIRST_GRADE:
            case SECOND_GRADE:
            case THIRD_GRADE:
            case FOURTH_GRADE:
            case FIFTH_GRADE:
                return  SchoolType.ELEMENTARY_SCHOOL;
            case SIXTH_GRADE:
            case SEVENTH_GRADE:
            case EIGHTH_GRADE:
                return SchoolType.MIDDLE_SCHOOL;
            case NINTH_GRADE:
            case TENTH_GRADE:
            case ELEVENTH_GRADE:
            case TWELFTH_GRADE:
                return SchoolType.HIGH_SCHOOL;
            default:
                throw new IllegalArgumentException("Not a Valid GradeType");
        }
    }

    private static int findAge(String dateOfBirth) {

        LocalDate localDate = LocalDate.now();
        int localYear = localDate.getYear();

        int birthYear = Integer.parseInt(dateOfBirth.substring(6,10));
        return localYear - birthYear;
    }


    private static String getStringInput() {
        return scanner.nextLine();
    }

    private static GradeType determineGradeBasedOnAge(int age) throws AgeNotCorrectException {
        System.out.println("Determining Grade Type based on age of the student !!!");
        switch (age)
        {
            case 4:
                return GradeType.JK_GRADE;
            case 5:
                return GradeType.SK_GRADE;
            case 6:
                return GradeType.FIRST_GRADE;
            case 7:
                return GradeType.SECOND_GRADE;
            case 8:
                return GradeType.THIRD_GRADE;
            case 9:
                return GradeType.FOURTH_GRADE;
            case 10:
                return GradeType.FIFTH_GRADE;
            case 11:
                return GradeType.SIXTH_GRADE;
            case 12:
                return GradeType.SEVENTH_GRADE;
            case 13:
                return GradeType.EIGHTH_GRADE;
            case 14:
                return GradeType.NINTH_GRADE;
            case 15:
                return GradeType.TENTH_GRADE;
            case 16:
                return GradeType.ELEVENTH_GRADE;
            case 17:
                return GradeType.TWELFTH_GRADE;
            default:
                throw new AgeNotCorrectException("age Should be between 4 and 17");
        }
    }

}

