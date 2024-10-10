package com.example.GithubApi.service;

import com.example.GithubApi.module.Github;
import com.example.GithubApi.repo.GithubRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GithubService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GithubRepo repo;
    private final String url="https://api.github.com/";
    public List<Github> getInfo(String username) throws JsonProcessingException {
        String githubUrl = url+"users/"+username+"/repos";
        System.out.println(githubUrl);
        String response = restTemplate.getForObject(githubUrl,String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonArray = objectMapper.readTree(response);

        for(JsonNode repoObject : jsonArray){
            String repoName = repoObject.get("name").asText();
            String repoUrl = repoObject.get("html_url").asText();

            Github repositoryInfo = new Github(username, repoName, repoUrl);
            repo.save(repositoryInfo);
        }
        return repo.findAll();
    }
}
