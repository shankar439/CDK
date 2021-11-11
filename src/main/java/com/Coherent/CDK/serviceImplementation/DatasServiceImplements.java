package com.Coherent.CDK.serviceImplementation;

import com.Coherent.CDK.dto.DatasDTO;
import com.Coherent.CDK.entity.Datass;
import com.Coherent.CDK.entity.Files;
import com.Coherent.CDK.entity.Projects;
import com.Coherent.CDK.exception.ControllerException;
import com.Coherent.CDK.repository.DatasRepository;
import com.Coherent.CDK.repository.FilesRepository;
import com.Coherent.CDK.repository.ProjectsRepository;
import com.Coherent.CDK.service.DatasInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class DatasServiceImplements implements DatasInterface {

    @Autowired
    private DatasRepository datasRepository;

    @Autowired
    private FilesRepository filesRepository;

    @Autowired
    private ProjectsRepository projectsRepository;

    @Override
    public List<Datass> getAllDatas() {
        List<Datass> datass = datasRepository.findAll();
        return datass;
    }

    @Override
    public Optional<Datass> SearchByName(String name) {
        Optional<Datass> datasses=datasRepository.findByName(name);
        if (datasses.isPresent() && datasses.get().getDeleteFlag()==0){
            return datasses;
        }else {
            throw new  ControllerException("404","The data is not available!!");
        }

    }

    @Override
    public String createDatas(DatasDTO datasDTO) {

        try {

        Datass datass = new Datass();
        datass.setName(datasDTO.getName());
            String email = datasDTO.getEmail();
            int position = email.indexOf("@");
            String name = email.substring(0, position);
            String username = name.substring(0, 1).toUpperCase() + name.substring(1);
            datass.setCreatedBy(username);
            datass.setModifiedBy(username);
        datass.setDetails(datasDTO.getDetails());
        Optional<Files> files =filesRepository.findById(datasDTO.getFilesId());
        if(files.isPresent()){
            datass.setFilesId(files.get());
        }

        Optional<Projects> projects=projectsRepository.findById(datasDTO.getProjectsId());
            if (projects.isPresent()){
                datass.setProjectsId(projects.get());

            }
            else
            {
                throw new RuntimeException("error");
            }

        /*Datass datass1 = datass;
        datasDTO.getProjectsId().forEach(projectsDTO -> {
            Projects projects = projectsRepository.findById(projectsDTO.getId()).orElse(null);
            datass1.setProjectsId(projects);

        });*/

            datasRepository.save(datass);
            return "Success";
        }catch (NoSuchElementException e){
            throw new ControllerException("404","OOPS!! Something went wrong");
        }
    }


}