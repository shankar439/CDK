package com.Coherent.CDK.service;

import com.Coherent.CDK.dto.DatasDTO;
import com.Coherent.CDK.entity.Datass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DatasInterface {

    List<Datass> getAllDatas();

    List<Datass> SearchByName(String name);

    String createDatas(DatasDTO datasDTO);
}
