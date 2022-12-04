package com.internship.adb.busses.configuration;

import com.internship.adb.busses.model.BusModel;
import com.internship.adb.busses.service.BusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class DatabaseInitializer {

    private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);
    private static final int RECORDS_NUMBER = 10;

    @Bean
    public CommandLineRunner addSomeRecords(/*@Autowired*/ BusService busService) {
        StringBuilder stringBuilder = new StringBuilder("\n");
        List<BusModel> bussesModel = new LinkedList<>();
        return args -> {
            for (int i = 1; i <= RECORDS_NUMBER; i++) {
                BusModel busModel = BusModel.randomBus(String.valueOf(i));
                bussesModel.add(busModel);
                stringBuilder.append("\n")
                        .append("Creating random generated Bus no. ")
                        .append(i)
                        .append(":")
                        .append("\n")
                        .append(busModel);
                log.info("{}", stringBuilder);
                stringBuilder.setLength(0);
                stringBuilder.trimToSize();
            }
            busService.addBusses(bussesModel);
            log.info("{}", "Busses has been successfully added.");
        };
    }
}