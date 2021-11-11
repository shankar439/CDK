package com.Coherent.CDK.repository;

import com.Coherent.CDK.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Short> {
    @Query(value = "SELECT * FROM projects WHERE deleted_flag= 0 ORDER BY name", nativeQuery = true)
    List<Projects> findAll();
}