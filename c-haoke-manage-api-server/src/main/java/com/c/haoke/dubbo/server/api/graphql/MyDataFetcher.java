package com.c.haoke.dubbo.server.api.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public interface MyDataFetcher {

    String fieldName();

    Object dataFetcher(DataFetchingEnvironment environment);
}
