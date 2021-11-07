package com.example.heima.collectors;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.12
 */
public class ToMapTest {
    public static void main(String[] args) {
        List<User> users = query();
//        Map<Integer, String> userMap = users.stream()
//                .collect(Collectors.toMap(User::getId, User::getGirlfriend));

//        Map<Integer, String> userMap2 = users.stream()
//                .collect(HashMap::new, (map, user)-> map.put(user.getId(), user.getGirlfriend()), HashMap::putAll);
//
//        System.out.println(userMap2);

        Collector<User, Map<Integer, String>, Map<Integer, String>> collector = Collector.of(
                HashMap::new,
                (map, user)-> map.put(user.getId(), user.getGirlfriend()),
                (map1, map2) -> {
                    map1.putAll(map2);
                    return map1;
                },
                new Collector.Characteristics[]{}
        );


        Map<Integer, String> userMap2 = users.stream()
                .collect(collector);

        System.out.println(userMap2);

    }

    public static List<User> query() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, null));
        return list;
    }
}

@Data
class User {
    private final Integer id;
    private final String girlfriend;
}