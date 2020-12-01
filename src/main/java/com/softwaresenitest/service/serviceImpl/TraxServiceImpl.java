package com.softwaresenitest.service.serviceImpl;

import com.softwaresenitest.entity.Trax;
import com.softwaresenitest.repository.TraxRepository;
import com.softwaresenitest.service.TraxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraxServiceImpl implements TraxService {
    @Autowired
    TraxRepository userRepo;

    public void save(Trax trax) {
        userRepo.save(trax);
    }

    @Override
    public Trax findOneById(Long id) {
        return userRepo.findOneById(id);
    }

    @Override
    public List<Trax> findByType(String type) {
        return userRepo.findByType(type);
    }

    @Override
    public List<Trax> findByParentId(Long parentId) {
        return userRepo.findByParentId(parentId);
    }

}
