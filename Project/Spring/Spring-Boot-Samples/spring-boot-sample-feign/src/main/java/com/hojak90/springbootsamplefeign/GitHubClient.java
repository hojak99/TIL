package com.hojak90.springbootsamplefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(url = "https://api.github.com", name = "GitHub")
interface GitHubClient {

    @RequestMapping(method = RequestMethod.GET, value = "/repos/{owner}/{repo}")
    String contributors(
            @RequestParam("owner") String owner,
            @RequestParam("repo") String repo);
}
