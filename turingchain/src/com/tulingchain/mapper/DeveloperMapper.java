package com.tulingchain.mapper;

import com.tulingchain.model.Developer;

import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */
public interface DeveloperMapper {
    int add(Developer developer);
    void delete(int id);
    List<Developer> listAllDevelopers();
    Developer queryLogin(Developer developer);
}
