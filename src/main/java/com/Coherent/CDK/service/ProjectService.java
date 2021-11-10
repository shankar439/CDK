package com.Coherent.CDK.service;

import com.Coherent.CDK.dto.ProjectsDTO;
import com.Coherent.CDK.entity.Projects;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProjectService {

    String createProject(ProjectsDTO projectsDTO);

    List<Projects> listOfProject();
}
