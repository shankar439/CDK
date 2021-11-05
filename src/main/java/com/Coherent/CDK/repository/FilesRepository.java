package com.Coherent.CDK.repository;

import com.Coherent.CDK.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends JpaRepository<Files, Short> {
}
