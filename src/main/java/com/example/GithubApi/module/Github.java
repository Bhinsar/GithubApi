package com.example.GithubApi.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Github {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Use Integer instead of int

    private String username;
    private String repoName;
    private String repoUrl;

    public Github() {
    }

    public Github(String username, String repoName, String repoUrl) {
        this.username = username;
        this.repoName = repoName;
        this.repoUrl = repoUrl;
    }
}
