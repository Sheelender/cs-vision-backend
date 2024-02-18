package com.csv.comscivision.service;

import com.csv.comscivision.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public interface CSVService
{
    public String createUserDetail(Users users) throws ExecutionException, InterruptedException;
    public List<Users> getUserDetail() throws ExecutionException, InterruptedException;
}
