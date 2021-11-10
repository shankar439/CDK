package com.Coherent.CDK.repository;

import com.Coherent.CDK.entity.Datass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatasRepository extends JpaRepository<Datass,Short> {

   // @Query(value = "SELECT * from Datass ds WHERE delete_flag = 0 ORDER BY name",nativeQuery = true)
    List<Datass> findByName(String name);
}