package com.Coherent.CDK.repository;

import com.Coherent.CDK.entity.Datas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasRepository extends JpaRepository<Datas,Short> {
}
