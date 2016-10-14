package com.tulingchain.service.impl;

import com.tulingchain.mapper.DeveloperMapper;
import com.tulingchain.model.Developer;
import com.tulingchain.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    @Autowired
    DeveloperMapper developerMapper;

    @Override
    public int save(Developer developer) {
        int re=developerMapper.add(developer);
        return re;
    }

    @Override
    public void delete(int id) {
        developerMapper.delete(id);
    }

    @Override
    public List<Developer> listAllDeveloper() {
        List<Developer> list=developerMapper.listAllDevelopers();
        return list;
    }


    @Override
    public Developer queryLogin(Developer developer) {
        Developer re=developerMapper.queryLogin(developer);
        return re;
    }
}
