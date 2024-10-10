package com.example.GithubApi.controller;

import com.example.GithubApi.module.Github;
import com.example.GithubApi.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GithubController {
    @Autowired
    private GithubService git;

    @GetMapping("/repos/{username}")
    public List<Github> getInfo(@PathVariable String username){
        try{
            return git.getInfo(username);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("fail");
        }
    }
}
