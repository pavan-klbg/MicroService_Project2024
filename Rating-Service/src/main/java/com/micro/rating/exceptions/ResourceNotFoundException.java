package com.micro.rating.exceptions;

public class ResourceNotFoundException extends RuntimeException{
public ResourceNotFoundException(){
    super();
}
public ResourceNotFoundException(String msg){
    super(msg);
}
}
