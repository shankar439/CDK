package com.Coherent.CDK.serviceImplementation;

import com.Coherent.CDK.dto.ProjectsDTO;
import com.Coherent.CDK.entity.Projects;
import com.Coherent.CDK.repository.ProjectsRepository;
import com.Coherent.CDK.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectsImplementation implements ProjectService {
    @Autowired
    private ProjectsRepository projectsRepository;

    @Override
    public String createProject(ProjectsDTO projectsDTO) {
        Projects projects = new Projects();
        projects.setName(projectsDTO.getName());
        projectsRepository.save(projects);
        return "Success";
    }

    @Override
    public List<Projects> listOfProject() {
        List<Projects> projects = projectsRepository.findAll();
        return projects;
    }
}
