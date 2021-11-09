package com.Coherent.CDK.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

    @Builder.Default
    private int statusCode = 200;

    @Builder.Default
    private String statusMessage = "SUCCESS";

    private T data;
}
