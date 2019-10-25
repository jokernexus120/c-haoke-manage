package com.c.haoke.dubbo.server.api.controller;

import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/graphql")
@RestController
public class GraphQLController {


    @Autowired
    private GraphQL graphQL;

    @GetMapping
    @ResponseBody
    public Map<String,Object> query(@RequestParam("query") String query){

        return graphQL.execute(query).toSpecification();
    }
}
