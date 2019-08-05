package com.dragonfly.whatshouldi.service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragonfly.whatshouldi.dynamodb.model.User;
import com.dragonfly.whatshouldi.dynamodb.repository.UserInfoRepository;

@Service
public class PreferenceSearchService {

    @Autowired
    private UserInfoRepository userRepository;

    public Map<String, Integer> fetchUserPreference(String userName) {

        Optional<User> user = userRepository.read(userName);

        Map<String, Integer> sortedFrequencyMap = null;
            Map<String, Integer> frequencyMap = user.get().getFrequency();
            sortedFrequencyMap = sortFrequencyMap(frequencyMap);

        return sortedFrequencyMap;

    }

    private Map<String, Integer> sortFrequencyMap(Map<String, Integer> frequencyMap) {
        return frequencyMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

}
