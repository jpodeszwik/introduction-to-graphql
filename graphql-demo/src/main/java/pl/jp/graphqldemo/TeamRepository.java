package pl.jp.graphqldemo;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
class TeamRepository {

    private final List<Team> teams = List.of(
            new Team(1, ".Net"),
            new Team(2, "Core Java"),
            new Team(3, "Gino")
    );

    Optional<Team> findById(int id) {
        return teams.stream()
                .filter(team -> team.getId() == id)
                .findAny();
    }
}
