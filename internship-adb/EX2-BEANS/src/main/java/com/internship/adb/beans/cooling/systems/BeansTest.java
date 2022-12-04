package com.internship.adb.beans.cooling.systems;

import com.internship.adb.beans.cooling.systems.template.AirConditioning;
import com.internship.adb.beans.cooling.systems.template.CoolingSystem;
import com.internship.adb.beans.cooling.systems.template.Fridge;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeansTest {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BeansTest.class, args);
		CoolingSystem coolingSystem = context.getBean(CoolingSystem.class);
		final String dashes = "----";
		Fridge fridge = coolingSystem instanceof Fridge ? ((Fridge) coolingSystem) : null;
		AirConditioning airConditioning = context.getBean(AirConditioning.class);

		// since fridge is a primary bean it is not a null reference
		if(fridge != null) {
			System.out.println("\n" + dashes + fridge.getClass().getSimpleName() + " Bean " + dashes);
			fridge.turnOn();
			System.out.print("Is fridge on? ");
			getAnswer(fridge.isOn());
			fridge.changeTemperature(Fridge.getMinDegreeLimit() - 1);
			fridge.changeTemperature(Fridge.getMaxDegreeLimit());
			fridge.setToFreezingMode(true);
			System.out.print("Is freezing mode on? ");
			getAnswer(fridge.isInFreezingMode());
			System.out.println("Temperature is set on " + fridge.getDegrees() + " degrees Celsius.");
			fridge.turnOff();
		}

		System.out.println("\n" + dashes + airConditioning.getClass().getSimpleName() + " Bean " + dashes);
		airConditioning.turnOn();
		System.out.print("Is air conditioning mobile? ");
		getAnswer(airConditioning.isMobile());
		airConditioning.changeTemperature(AirConditioning.getMaxDegreeLimit()+1);
		airConditioning.changeTemperature(AirConditioning.getMinDegreeLimit());
		airConditioning.setToExtraCoolingMode();
		System.out.print("Is extra-cooling mode on? ");
		getAnswer(airConditioning.isInExtraCoolingMode());
		airConditioning.setToBasicCoolingMode();
		System.out.print("Has basic-cooling mode been activated? ");
		getAnswer(airConditioning.isInBasicCoolingMode());
		System.out.println("Temperature is set on " + airConditioning.getDegrees() + " degrees Celsius.");
		airConditioning.turnOff();
		System.out.print("Is air conditioning off? ");
		getAnswer(airConditioning.isOff());
	}

	private static void getAnswer(boolean condition) {
		if(condition) {
			System.out.println("Yes.");
		} else System.out.println("No.");
	}
}