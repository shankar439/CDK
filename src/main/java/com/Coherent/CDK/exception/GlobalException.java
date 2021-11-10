package com.Coherent.CDK.exception;

import com.Coherent.CDK.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    private ResponseEntity unAuthoriseException(UnAuthoriseException e) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        baseResponse.setStatusMessage("UNAUTHORIZED");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(baseResponse);
    }

    @ExceptionHandler
    private ResponseEntity badRequestException(BadRequestException e) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        baseResponse.setStatusMessage("BAD_REQUEST");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(baseResponse);
    }

    @ExceptionHandler
    private ResponseEntity notFoundException(NotFoundException e) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        baseResponse.setStatusMessage("NOT_FOUND");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(baseResponse);
    }
}
