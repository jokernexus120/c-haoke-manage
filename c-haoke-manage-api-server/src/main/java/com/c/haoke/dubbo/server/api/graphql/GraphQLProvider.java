package com.c.haoke.dubbo.server.api.graphql;

import com.c.haoke.dubbo.server.api.service.HouseResourcesService;
import com.c.haoke.dubbo.server.pojo.HouseResources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;
import java.util.function.UnaryOperator;

@Component
public class GraphQLProvider {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Autowired
    private List<MyDataFetcher> dataFetcherList;

    private GraphQL graphQL;



    @PostConstruct
    private void  init () throws Exception{
        File file = ResourceUtils.getFile("classpath:haoke.graphqls");

        GraphQLSchema graphQLSchema = null;
        this.graphQL = GraphQL.newGraphQL(buildGraphQLSchema(file)).build();

    }

    private GraphQLSchema buildGraphQLSchema(File file){
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(file);

        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeRegistry, getWiring());

        return graphQLSchema;
    }

    private RuntimeWiring getWiring(){


        RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
                .type("HaokeQuery", builder ->
                        {

                            for (MyDataFetcher myDataFetcher : dataFetcherList) {
                                builder.dataFetcher(myDataFetcher.fieldName(),
                                        environment -> myDataFetcher.dataFetcher(environment));
                            }
                            return builder;
                        }
                        /*builder.dataFetcher("houseResources", environment -> {
                            Long id = environment.getArgument("id");
                            HouseResources houseResources = this.houseResourcesService.selectHouseResourcesById(id);
                            return houseResources;
                        })*/
                )
                .build();

        return wiring;
    }

    @Bean
    public GraphQL graphQL(){
        return this.graphQL;
    }
}
