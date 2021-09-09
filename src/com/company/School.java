package com.company;

public interface School {

    Student admitStudent(Student student) throws ClassFullException;
    Double chargefees(Student student);

}
