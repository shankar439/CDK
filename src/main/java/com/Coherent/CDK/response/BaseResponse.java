package com.Coherent.CDK.response;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class BaseResponse<T> {

    private int statusCode = 200;

    private String statusMessage = "SUCCESS";

    private T data;
}
