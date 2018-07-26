package com.hojak90.springbootsamplefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    public GitHubClient gitHubClient;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/{owner}/{repo}")
    @ResponseBody
    public List<Contributor> contributors(@PathVariable String owner, @PathVariable String repo) {
        return gitHubClient.contributors(owner, repo);
    }
}
