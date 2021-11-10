package com.Coherent.CDK.controller;

import com.Coherent.CDK.dto.DatasDTO;
import com.Coherent.CDK.entity.Datass;
import com.Coherent.CDK.response.BaseResponse;
import com.Coherent.CDK.service.DatasInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/cdk-logic-service/datas")
@RestController
public class DatasController {

    @Autowired
    private DatasInterface datasInterface;

    @PostMapping("/create")
    public BaseResponse create(@RequestBody DatasDTO datasDTO){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(datasInterface.createDatas(datasDTO));
        return baseResponse;
    }

    @GetMapping("/getAll/{datas}")
    public BaseResponse<List<Datass>> getAllDatas( ){
        BaseResponse<List<Datass>> baseResponse = null;
        baseResponse= BaseResponse.<List<Datass>>builder().data(datasInterface.getAllDatas()).build();
        return baseResponse;
    }

    @GetMapping("/{name}")
    public BaseResponse<List<Datass>> SearchByName(@PathVariable String name){
        BaseResponse<List<Datass>> baseResponse;
        baseResponse=BaseResponse.<List<Datass>>builder().data(datasInterface.SearchByName(name)).build();
        return baseResponse;
    }
}