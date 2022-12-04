package com.internship.adb.beans.sense;

import com.internship.adb.beans.sense.component.Config;
import com.internship.adb.beans.sense.pojos.Imagination;
import com.internship.adb.beans.sense.pojos.Reality;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.time.LocalDate;
import java.util.Properties;

public class BeansTest {

    static final String DATE = "date";
    static final String JAVA_VERSION = "java-version";
    static final String PROGRAM_VERSION = "program-version";
    static final String RESOURCES_PATH = "./internship-adb/EX1-BEANS/src/main/resources/%s";
    static final String PROPERTIES_NAME = "custom.properties";
    static final String PROPERTIES = String.format(RESOURCES_PATH, PROPERTIES_NAME);

    public static void main(final String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        final Imagination imaginationBean = context.getBean(Imagination.class);
        final Reality realityBean = context.getBean(Reality.class);
        final Properties property = new Properties();

        System.out.println(Imagination.class.getSimpleName() + ": " + imaginationBean.getMessage());
        System.out.println(Reality.class.getSimpleName() + ": " + realityBean.getMessage());

        try (final OutputStream outputStream = new FileOutputStream(PROPERTIES)) {
            property.setProperty(DATE, LocalDate.now().toString());
            property.setProperty(JAVA_VERSION, System.getProperty("java.version"));
            property.setProperty(PROGRAM_VERSION, "1.0");
            property.store(outputStream, null);
        } catch (final IOException exc) {
            System.out.println(exc.getMessage());
        }

        try (final InputStream inputStream = new FileInputStream(PROPERTIES)) {
            property.load(inputStream);
            System.out.println("Current date: " + property.getProperty(DATE));
            System.out.println("Module java version: " + property.getProperty(JAVA_VERSION));
            System.out.println("Program version: " + property.getProperty(PROGRAM_VERSION));
        } catch (final FileNotFoundException e) {
            System.out.println("File has not been found.");
        } catch (final IOException e) {
            System.out.println(e.getMessage());
        }
    }
}