package com.Project.employeeManagement.Exceptions;

public class EmptyDatabaseException extends RuntimeException{
    public EmptyDatabaseException(String message){
        super(message);
    }
}
