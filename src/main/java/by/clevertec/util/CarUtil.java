package by.clevertec.util;

import by.clevertec.model.Car;

import java.util.Arrays;

public class CarUtil {
    public static String carTypeLogistic(Car car) {
        return carTurkmenistanType(car) ? "Turkmenistan" :
                carUzbekistanType(car) ? "Uzbekistan" :
                        carKazakhstanType(car) ? "Kazakhstan" :
                                carKirghistanType(car) ? "Kirghistan" :
                                        carRussiaType(car) ? "Russia" :
                                                carMongoliaType(car) ? "Mongolia" : "Else";
    }

    private static boolean carTurkmenistanType(Car car) {
        return car.getCarMake().equals("Jaguar") || car.getColor().equals("White");
    }

    private static boolean carUzbekistanType(Car car) {
        return car.getMass() <= 1500 &&
                (car.getCarMake().equals("BMW") ||
                        car.getCarMake().equals("Lexus") ||
                        car.getCarMake().equals("Chrysler") ||
                        car.getCarMake().equals("Toyota"));
    }

    private static boolean carKazakhstanType(Car car) {
        return (car.getColor().equals("Black") && car.getMass() > 4000) ||
                car.getCarMake().equals("GMC") ||
                car.getCarMake().equals("Dodge");
    }

    private static boolean carKirghistanType(Car car) {
        return car.getReleaseYear() < 1982 ||
                car.getCarMake().equals("Civic") ||
                car.getCarMake().equals("Cherokee");
    }

    private static boolean carRussiaType(Car car) {
        return !Arrays.asList("Yellow", "Red", "Green", "Blue").contains(car.getColor()) ||
                car.getPrice() > 40000;
    }

    private static boolean carMongoliaType(Car car) {
        return car.getVin().contains("59");
    }
}
