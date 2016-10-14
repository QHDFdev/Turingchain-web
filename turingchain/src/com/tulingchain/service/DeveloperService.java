package com.tulingchain.service;

import com.tulingchain.model.Developer;

import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */
public interface DeveloperService {
//    int add(Developer developer);
//    void delete(int id);
//    List<Developer> listAllDevelopers();
//    Developer queryLogin(Developer developer);
    public int save(Developer developer);
    public void delete(int id);
    public List<Developer> listAllDeveloper();
    public Developer queryLogin(Developer developer);
}
