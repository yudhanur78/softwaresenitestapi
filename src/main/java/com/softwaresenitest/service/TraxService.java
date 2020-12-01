package com.softwaresenitest.service;

import com.softwaresenitest.entity.Trax;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TraxService {
    void save(Trax trax);
    Trax findOneById(Long id);
    List<Trax> findByType(String type);
    List<Trax> findByParentId(Long parentId);
}
