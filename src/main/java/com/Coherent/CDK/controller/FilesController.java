package com.Coherent.CDK.controller;

import com.Coherent.CDK.entity.Files;
import com.Coherent.CDK.repository.FilesRepository;
import com.Coherent.CDK.response.BaseResponse;
import com.Coherent.CDK.serviceImplementation.FilesImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cdk-logic-service/file")
public class FilesController {

    @Autowired
    private FilesRepository filesRepository;

    @Autowired
    private FilesImplementation filesImplementation;

    @PostMapping("/upload")
    public BaseResponse uploadFile(@RequestParam("file") MultipartFile file,
                                   @RequestParam String email) {
        Files originalName = filesImplementation.storeFiles(file,email);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(originalName);
        return baseResponse;
    }

    @GetMapping("/download/{originalName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String originalName, HttpServletRequest request) {

        Files files = filesImplementation.getFile(originalName);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(files.getGeneratedName()))
                .header(HttpHeaders.CONTENT_DISPOSITION,  "attachment; originalName=\"" + files.getOriginalName() + "\"")
                .body(new ByteArrayResource(files.getData()));
    }

    @DeleteMapping("/remove/{id}")
    public String deleteFile(@PathVariable Short id){
        filesImplementation.deleteFile(id);
        return  "Success";
    }

}