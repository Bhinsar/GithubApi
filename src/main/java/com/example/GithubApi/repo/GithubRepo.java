package com.example.GithubApi.repo;

import com.example.GithubApi.module.Github;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GithubRepo extends JpaRepository<Github,Integer> {
}
