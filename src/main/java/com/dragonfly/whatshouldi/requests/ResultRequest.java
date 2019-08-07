package com.dragonfly.whatshouldi.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResultRequest {
    List<String> results;
    List<String> tags;
}
