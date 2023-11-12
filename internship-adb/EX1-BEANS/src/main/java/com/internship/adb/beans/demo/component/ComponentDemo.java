package com.internship.adb.beans.demo.component;

import com.internship.adb.beans.demo.pojos.Imagination;
import com.internship.adb.beans.demo.pojos.Reality;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ComponentDemo {

    @Bean
    public Imagination imagination() {
        return new Imagination();
    }

    @Bean
    public Reality reality() {
        return new Reality();
    }
}