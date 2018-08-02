package pl.jp.graphqldemo;

import com.coxautodev.graphql.tools.GraphQLResolver;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class TeamResolver implements GraphQLResolver<Team> {
    private final MemberRepository memberRepository;

    List<Member> members(Team team, int limit) {
        return memberRepository.membersForTeam(team.getId(), limit);
    }
}
