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

        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());

        String path = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/cdk-logic-service/file/download/").
                path(originalFileName).toUriString();

        try {
            if (originalFileName.contains("..")) {
                throw new FileStorageException("Sorry! originalFilename contains invalid path sequence " + originalFileName);
            }
            Files files =  new Files();
            files.setPath(path);
            files.setOriginalFileName(originalFileName);
            files.setGeneratedFileName(file.getContentType());
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
            //throw  "Could not store file";
            throw new FileStorageException("Could not store file " + originalFileName + ". Please try again!", ex);
        }
    }

    @Override
    public Files getFile(String originalFileName) {
        try {
            return filesRepository.findByOriginalFileName(originalFileName)
                    .orElseThrow(() -> new FileNotFoundException("File not found with id " + originalFileName));
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
