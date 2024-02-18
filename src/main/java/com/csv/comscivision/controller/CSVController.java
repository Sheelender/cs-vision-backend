package com.csv.comscivision.controller;

import com.csv.comscivision.entity.Users;
import com.csv.comscivision.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class CSVController
{
    @Autowired
    CSVService csvService;

    @PostMapping("/createUserDetail")
    public String createUserDetail(@RequestBody Users users) throws InterruptedException, ExecutionException
    {
        return csvService.createUserDetail(users);
    }
    @GetMapping("/getUserDetail")
    public List<Users>  getUserDetail() throws ExecutionException, InterruptedException{
        return csvService.getUserDetail() ;
    }


}
