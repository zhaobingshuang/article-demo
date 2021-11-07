package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class ApplicationRunnerTest implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        String[] sourceArgs = args.getSourceArgs();
        log.info("sourceArgs: {}", Arrays.toString(sourceArgs));

        List<String> nonOptionArgs = args.getNonOptionArgs();
        log.info("nonOptionArgs: " + nonOptionArgs);

        Set<String> optionNames = args.getOptionNames();
        for (String optionName : optionNames) {
            log.info("{}: {}", optionName, args.getOptionValues(optionName));
        }
    }
}