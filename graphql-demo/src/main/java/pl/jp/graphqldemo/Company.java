package pl.jp.graphqldemo;

import lombok.Value;

@Value
class Company {
    private String name;
    private Address address;
}
