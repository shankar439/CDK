package com.Coherent.CDK.controller;

import com.Coherent.CDK.dto.ProjectsDTO;
import com.Coherent.CDK.entity.Projects;
import com.Coherent.CDK.response.BaseResponse;
import com.Coherent.CDK.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cdk-logic-service/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public BaseResponse createProject(@RequestBody ProjectsDTO projectsDTO) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(projectService.createProject(projectsDTO));
//        projectService.createProject(projectsDTO);
        return baseResponse;
    }

    @GetMapping("/List")
    public BaseResponse<List<Projects>> listOfProject() {
        BaseResponse<List<Projects>> baseResponse = null;
        baseResponse = BaseResponse.<List<Projects>>builder().data(projectService.listOfProject()).build();
        return baseResponse;
    }
}
