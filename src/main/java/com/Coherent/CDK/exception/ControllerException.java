package com.Coherent.CDK.exception;

import lombok.*;

import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ControllerException extends RuntimeException {

    private static final long serialVersionUID= 1L;
    private int errorCode;
    private String errorMsg;

    public ControllerException(int errorCode,String errorMsg){
        super();
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
    }
}