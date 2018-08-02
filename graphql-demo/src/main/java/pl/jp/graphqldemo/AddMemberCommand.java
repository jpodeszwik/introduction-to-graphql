package pl.jp.graphqldemo;

import lombok.Value;

@Value
class AddMemberCommand {
    private String name;
    private int teamId;
}
