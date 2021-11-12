package com.Coherent.CDK.serviceImplementation;

import com.Coherent.CDK.entity.Files;
import com.Coherent.CDK.exception.FileNotFoundException;
import com.Coherent.CDK.exception.FileStorageException;
import com.Coherent.CDK.repository.FilesRepository;
import com.Coherent.CDK.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@Service
public class FilesImplementation implements FilesService {

    @Autowired
    private FilesRepository filesRepository;

    @Override
    public Files storeFiles(MultipartFile file,String email) {

        String originalName = StringUtils.cleanPath(file.getOriginalFilename());

        String path = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/cdk-logic-service/file/download/").
                path(originalName).toUriString();

        try {
            if (originalName.contains("..")) {
                throw new FileStorageException("Sorry! originalFilename contains invalid path sequence " + originalName);
            }
            Files files =  new Files();
            files.setPath(path);
            files.setOriginalName(originalName);
            files.setGeneratedName(file.getContentType());
            files.setData(file.getBytes());

           // String email = .getEmail();
            int position = email.indexOf("@");
            String name = email.substring(0, position);
            String username = name.substring(0, 1).toUpperCase() + name.substring(1,position);
            files.setCreatedBy(username);
            files.setModifiedBy(username);

            filesRepository.save(files);
            return files;
        }
        catch (IOException ex) {
            throw new FileStorageException("Could not store file " + originalName + ". Please try again!", ex);
        }
    }

    @Override
    public Files getFile(String originalName) {
        try {
            return filesRepository.findByOriginalName(originalName)
                    .orElseThrow(() -> new FileNotFoundException("File not found with id " + originalName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  Files  deleteFile (Short id){
        Files files = new Files();
        filesRepository.deleteById(id);
        return files;
    }
}