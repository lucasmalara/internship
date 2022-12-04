package com.internship.adb.beans.cooling.systems.configuration;

import com.internship.adb.beans.cooling.systems.template.AirConditioning;
import com.internship.adb.beans.cooling.systems.template.CoolingSystem;
import com.internship.adb.beans.cooling.systems.template.Fridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Random;

@Configuration
public class Config {

    @Bean
    @Primary
    public CoolingSystem getFridgeBean() {
        return new Fridge();
    }

    @Bean
    public boolean getRandomBooleanBean() {
        return 0 == new Random().nextInt(2);
    }

    @Bean
    public CoolingSystem getAirConditioningBean() {
        return new AirConditioning(getRandomBooleanBean());
    }
}