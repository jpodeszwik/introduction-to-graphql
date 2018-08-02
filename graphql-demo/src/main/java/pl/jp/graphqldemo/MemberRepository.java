package pl.jp.graphqldemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.EmitterProcessor;

@Slf4j
@Repository
class MemberRepository {
    private final EmitterProcessor<Member> emitterProcessor;

    private List<Member> members = new ArrayList<>(List.of(
            new Member(1, "Magda", 2),
            new Member(2, "Grzesiek", 2),
            new Member(3, "Daniel", 3),
            new Member(4, "Kuba", 3),
            new Member(5, "Pawel", 2),
            new Member(6, "Dorian", 2),
            new Member(7, "Slawek", 2)
    ));

    MemberRepository(EmitterProcessor<Member> emitterProcessor) {
        this.emitterProcessor = emitterProcessor;
    }

    List<Member> membersForTeam(int teamId, int limit) {
        log.info("Fetching members for team " + teamId);
        return members.stream()
                .filter(member -> member.getTeamId() == teamId)
                .limit(limit)
                .collect(Collectors.toList());
    }

    Member addMember(String name, int teamId) {
        int newId = members.size() + 1;

        Member member = new Member(newId, name, teamId);

        members.add(member);

        emitterProcessor.onNext(member);

        return member;
    }
}
