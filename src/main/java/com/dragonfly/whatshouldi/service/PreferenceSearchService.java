package com.dragonfly.whatshouldi.service;

import java.util.LinkedHashMap;
import java.util.List;
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

//    public PreferenceSearchService (UserInfoRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    public Map<String, Integer> fetchUserPreference(String userName) {
        List<User> userList = userRepository.list();

        Optional<User> user = userRepository.read(userName);



        Map<String, Integer> sortedFrequencyMap = null;
            Map<String, Integer> frequencyMap = user.get().getFrequency();
            sortedFrequencyMap = sortFrequencyMap(frequencyMap);

        return sortedFrequencyMap;

    }

    private Map<String, Integer> sortFrequencyMap(Map<String, Integer> frequencyMap) {
        return frequencyMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

}
