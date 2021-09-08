package com.company;

import java.util.Scanner;

public class Main {

    School preSchool = new PreSchool();
    School elementarySchool = new ElementarySchool();
    School middleSchool = new MiddleSchool();
    School highSchool = new HighSchool();

    public static void main(String[] args) {

        System.out.println("*********************************************" +
                "\nWelcome to the School admission App !!! press X to exit \n" +
                "*********************************************");

        while (true) {

            // Taking Name of student if not match Condition it will ask again
            System.out.println("Enter the name of the student :    (no less than 3 chars and no more than 50 chars)\n");
            String name = getName();
            do {
                if (name.length() < 3 || name.length() > 50) {
                    System.out.println(name.length());
                    System.out.print(" name should be >=3 characters or less than <=50\n");
                    name = getName();
                }else {
                    break;
                }
            }while (true);

            // Taking Age of student if not match Condition it will ask again
            System.out.println("age of the student: ");
            int age = getAge();
            do{
                if (age < 4 || age >= 17) {
                    System.out.println("No Schools Available\n");
                    age = getAge();
                }
                else
                {
                    break;
                }
            }while (true);


            try {
                GradeType gradeType = determineGradeBasedOnAge(age);
            } catch (AgeNotCorrectException e) {
                e.getMessage();
            }


        }

    }



    private static int getAge() {
        Scanner scanner = new Scanner(System.in);
        int age;
        return age = scanner.nextInt();
    }

    private static String getName() {
        Scanner scanner = new Scanner(System.in);
        String name;
        return name = scanner.nextLine();
    }

    private static GradeType determineGradeBasedOnAge(int age) throws AgeNotCorrectException {

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

