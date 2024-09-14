package by.clevertec.util;

import by.clevertec.model.Flower;

public class FlowerUtil {
    private static final double waterCostPerCubicMeter = 1.39;

    public static double getFlowerCost(Flower flower) {
        double waterConsumptionPerYear = flower.getWaterConsumptionPerDay() * 365;
        double waterConsumptionForFiveYears = waterConsumptionPerYear * 5;
        double waterCostForFiveYears = waterConsumptionForFiveYears * waterCostPerCubicMeter;

        return flower.getPrice() + waterCostForFiveYears;
    }
}
