package pl.jp.graphqldemo;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import lombok.AllArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.EmitterProcessor;

@AllArgsConstructor
@Component
class SubscriptionResolver implements GraphQLSubscriptionResolver {
    private EmitterProcessor<Member> memberEmitterProcessor;

    Publisher<Member> memberCreated(int teamId) {
        return memberEmitterProcessor.filter(member -> member.getTeamId() == teamId);
    }
}
