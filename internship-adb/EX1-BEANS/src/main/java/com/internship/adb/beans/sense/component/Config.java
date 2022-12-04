package com.internship.adb.beans.sense.component;

import com.internship.adb.beans.sense.pojos.Imagination;
import com.internship.adb.beans.sense.pojos.Reality;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Bean
    public Imagination getImaginationBean() {
        return new Imagination();
    }

    @Bean
    public Reality getRealityBean() {
        return new Reality();
    }
}