package com.internship.adb.beans.cooling.systems.configuration;

import com.internship.adb.beans.cooling.systems.template.AirConditioning;
import com.internship.adb.beans.cooling.systems.template.CoolingSystem;
import com.internship.adb.beans.cooling.systems.template.Fridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Random;

@Configuration
public class ConfigurationDemo {

    @Bean
    @Primary
    public CoolingSystem fridge() {
        return new Fridge();
    }

    @Bean
    public boolean booleanBean() {
        return 0 == new Random().nextInt(2);
    }

    @Bean("airConditioning")
    public CoolingSystem airConditioning() {
        /*
        * Since it is a Configuration class, getRandomBooleanBean() will not be called like a pure JAVA code.
        * It will be returned as a Bean once retrieved from the Spring context.
        * */
        return new AirConditioning(booleanBean());
    }

    @Bean("airConditioningAlt")
    public CoolingSystem airConditioningAlt(/*@Autowired*/ boolean isMobile) {
        return new AirConditioning(isMobile);
    }
}