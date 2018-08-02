package pl.jp.graphqldemo;

import lombok.Value;

@Value
class Member {
    private int id;
    private String name;
    private int teamId;
}
