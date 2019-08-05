package com.dragonfly.whatshouldi.dynamodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AWSAccountAccessModel {
    private String accessKeyId;
    private String secretAccessKey;
}
