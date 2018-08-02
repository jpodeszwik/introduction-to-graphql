package pl.jp.graphqldemo;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.EmitterProcessor;

@SpringBootApplication
public class GraphqlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlDemoApplication.class, args);
    }

    @Bean
    GraphQLSchema graphQLSchema(List<GraphQLResolver<?>> graphQLResolvers) {
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(graphQLResolvers)
                .build()
                .makeExecutableSchema();
    }

    @Bean
    EmitterProcessor<Member> membersEmitterProcessor() {
        return EmitterProcessor.create();
    }
}
