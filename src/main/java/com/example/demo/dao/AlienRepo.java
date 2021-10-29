package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

import java.util.List;

//jpa repository has more features as of crud

public interface AlienRepo extends JpaRepository<Alien,Integer>
{
    List<Alien> findByTech(String tech);
    
    List<Alien> findByAidGreaterThan(int aid);
}
