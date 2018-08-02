package pl.jp.graphqldemo;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class QueryResolver implements GraphQLQueryResolver {
    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    String hello(String name) {
        return "Hello, " + name + "!";
    }

    Company company() {
        return new Company("Yameo", new Address("Piastowska 11", "Gdansk"));
    }

    Optional<Team> team(int id) {
        return teamRepository.findById(id);
    }
}
