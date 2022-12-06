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

    @Bean("airConditioning")
    public CoolingSystem getAirConditioningBean() {
        /*
        * Since it is a Configuration class getRandomBooleanBean() will not be called like a pure JAVA code.
        * It will be returned as a Bean once retrieved from the Spring context.
        * */
        return new AirConditioning(getRandomBooleanBean());
    }

    @Bean("airConditioningAlt")
    public CoolingSystem getAirConditioningBeanAlt(/*@Autowired*/ boolean isMobile) {
        return new AirConditioning(isMobile);
    }
}