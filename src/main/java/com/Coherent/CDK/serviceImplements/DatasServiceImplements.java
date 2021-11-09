package com.Coherent.CDK.serviceImplements;

import com.Coherent.CDK.dto.DatasDTO;
import com.Coherent.CDK.entity.Datass;
import com.Coherent.CDK.entity.Files;
import com.Coherent.CDK.entity.Projects;
import com.Coherent.CDK.repository.DatasRepository;
import com.Coherent.CDK.repository.FilesRepository;
import com.Coherent.CDK.repository.ProjectsRepository;
import com.Coherent.CDK.service.DatasInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DatasServiceImplements implements DatasInterface {

    @Autowired
    private DatasRepository datasRepository;

    @Autowired
    private FilesRepository filesRepository;

    private ProjectsRepository projectsRepository;

    @Override
    public List<Datass> getAllDatas() {
        List<Datass> datass = datasRepository.findAll();
        return datass;
    }

    @Override
    public List<Datass> SearchByName(String name) {
        List<Datass> datasses=datasRepository.findByName(name);
        return datasses;
    }

    @Override
    public String createDatas(DatasDTO datasDTO) {
        Datass datass = new Datass();
        datass.setName(datasDTO.getName());
        datass.setDetails(datasDTO.getDetails());

        Files files=filesRepository.findById(datasDTO.getFilesId()).orElse(null);
        datass.setFilesId(files);

       /* Datass datass1 = datass;
        datasDTO.getProjectsId().forEach(projectsDTO -> {
            Projects projects = projectsRepository.findById(projectsDTO.getId()).orElse(null);
            datass1.setProjectsId(projects);

        });*/
        datasRepository.save(datass);
        return "Success";
    }


}
