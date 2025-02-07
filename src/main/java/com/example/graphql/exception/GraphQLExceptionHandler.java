package com.example.graphql.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class GraphQLExceptionHandler implements DataFetcherExceptionResolver {

    @Override
    public Mono<List<GraphQLError>> resolveException(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof ProductNotFoundException) {

            return Mono.just(List.of(
                    GraphqlErrorBuilder.newError()
                            .errorType(ErrorType.NOT_FOUND)
                            .message(ex.getMessage())
                            .build()
            ));
        } else {
            return Mono.just(List.of(
                    GraphqlErrorBuilder.newError()
                            .errorType(ErrorType.INTERNAL_ERROR)
                            .message("Unexpected error occurred: " + ex.getMessage())
                            .build()
            ));
        }
    }
}
