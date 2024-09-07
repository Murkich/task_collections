package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static void task1() {
        List<Animal> animals = Util.getAnimals();

        List<Animal> youngAnimals = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparing(Animal::getAge))
                .toList();

        IntStream.range(0, youngAnimals.size())
                .boxed()
                .collect(Collectors.groupingBy(i -> i / 7))
                .getOrDefault(2, List.of())
                .stream()
                .map(youngAnimals::get)
                .forEach(System.out::println);
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .peek(animal -> {
                    if (animal.getGender().equals("Female")) {
                        animal.setBread(animal.getBread().toUpperCase());
                    }
                })
                .map(Animal::getBread)
                .forEach(System.out::println);
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .forEach(System.out::println);
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .map(animal -> 1)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();

        System.out.println("Есть хоть одно животное из Венгрии? " + animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> "Hungarian".equals(animal.getOrigin())));
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();

        System.out.println("Все ли животные только мужского или женского пола? " + animals.stream()
                .allMatch(animal -> "Male".equals(animal.getGender()) || "Female".equals(animal.getGender())));
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();

        System.out.println("Ни одно животное не имеет страну происхождения Oceania. Верно? " + animals.stream()
                .noneMatch(animal -> "Oceania".equals(animal.getGender())));
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .map(Animal::getAge)
                .limit(100)
                .reduce(Integer::max)
                .ifPresent(System.out::println);
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(chars -> chars.length)
                .reduce(Integer::min)
                .ifPresent(System.out::println);
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .map(Animal::getAge)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average()
                .ifPresent(System.out::println);
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
//        persons.stream() Продолжить ...
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
//        houses.stream() Продолжить ...
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
//        students.stream() Продолжить ...
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
