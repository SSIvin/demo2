package com.example.demo.controller;

import com.example.demo.domain.dic.place_job;
import com.example.demo.repo.dicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api")
public class PlaceJobController {

    @Autowired
    private final dicRepo dicRepo;

    public PlaceJobController(dicRepo dicRepo) {
        this.dicRepo = dicRepo;
    }


    @GetMapping("/getAllPlaceJob")
    public ArrayList<place_job> PlaceJob2() {
//        ArrayList<place_job> placeJobs = new ArrayList<>();
//        placeJobs =
        System.out.println("getPlaceJob_getMapping");
        return (ArrayList<place_job>) dicRepo.findAll();
    }



}
