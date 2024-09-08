package by.clevertec.util;

import by.clevertec.model.Car;

public class CarUtil {
    public static String carTypeLogistic(Car car) {
        return car.getCarMake().equals("Jaguar") || car.getColor().equals("White") ? "Turkmenistan" :
                car.getMass() <= 1500 &&
                        (car.getCarMake().equals("BMW")
                                || car.getCarMake().equals("Lexus")
                                || car.getCarMake().equals("Chrysler")
                                || car.getCarMake().equals("Toyota")) ? "Uzbekistan" :
                car.getColor().equals("Black") && car.getMass() >= 4000 &&
                        (car.getCarMake().equals("GMC")
                                || car.getCarMake().equals("Dodge")) ? "Kazakhstan" :
                car.getReleaseYear() <= 1982
                        || car.getCarMake().equals("Civic")
                        || car.getCarMake().equals("Cherokee") ? "Kirghistan" :
                (!car.getColor().equals("Yellow")
                        && !car.getColor().equals("Red")
                        && !car.getColor().equals("Green")
                        && !car.getColor().equals("Blue"))
                        || car.getPrice() >= 40000 ? "Russia" :
                car.getVin().contains("59") ? "Mongolia" : "Else";
    }
}
