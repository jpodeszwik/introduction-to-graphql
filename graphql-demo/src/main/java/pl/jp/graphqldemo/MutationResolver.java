package pl.jp.graphqldemo;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class MutationResolver implements GraphQLMutationResolver {
    private final MemberRepository memberRepository;

    Member addMember(AddMemberCommand command) {
        return memberRepository.addMember(command.getName(), command.getTeamId());
    }
}
