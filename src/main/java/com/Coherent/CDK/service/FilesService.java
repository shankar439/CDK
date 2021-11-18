package com.Coherent.CDK.service;

import com.Coherent.CDK.entity.Files;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FilesService {

    Files deleteFile(Short id);

    Files storeFiles(MultipartFile file,String email);

    Files getFile(String originalFileName);
}