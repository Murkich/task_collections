package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

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

        animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparing(Animal::getAge))
                .skip(14)
                .limit(7)
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

        persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> {
                    int age = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
                    return age >= 18 && age <= 27;
                })
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }

    public static void task13() {
        List<House> houses = Util.getHouses();

        houses.stream()
                .flatMap(house -> house.getPersonList().stream()
                .map(person -> new AbstractMap.SimpleEntry<>(house.getBuildingType(), person)))
                .sorted(Comparator.<AbstractMap.SimpleEntry<String, Person>, Boolean>comparing(entry -> entry.getKey().equals("Hospital")).reversed()
                        .thenComparing(entry -> {
                            Person person = entry.getValue();
                            int age = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
                            return age >= 65 || age < 18;
                        }).reversed())
                .limit(500)
                .map(AbstractMap.SimpleEntry::getValue)
                .forEach(System.out::println);
    }

    public static void task14() {
        List<Car> cars = Util.getCars();

        final double[] totalRevenue = {0};

        cars.stream()
                .collect(Collectors.groupingBy(CarUtil::carTypeLogistic)).entrySet().stream()
                .filter(entry -> !entry.getKey().equals("Else"))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().
                                mapToDouble(car -> car.getMass() / 1000.0).sum() * 7.14
                ))
                .forEach((country, cost) -> {
                    System.out.printf("Стоимость для %s: %.2f$\n", country, cost);

                    totalRevenue[0] += cost;
                });

        System.out.printf("Общие расходы логистической компании: %.2f$\n", totalRevenue[0]);
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();

        double totalCost = flowers.stream().sorted(Comparator.comparing(Flower::getOrigin).reversed()
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Comparator.comparingDouble(Flower::getWaterConsumptionPerDay).reversed()))
                .filter(flower -> flower.getCommonName().compareToIgnoreCase("C") >= 0 &&
                        flower.getCommonName().compareToIgnoreCase("S") < 0)
                .filter(flower -> flower.isShadePreferred() &&
                        flower.getFlowerVaseMaterial().stream().anyMatch(material ->
                                material.equalsIgnoreCase("glass") ||
                                        material.equalsIgnoreCase("aluminum") ||
                                        material.equalsIgnoreCase("steel")))
                .mapToDouble(FlowerUtil::getFlowerCost)
                .sum();

        System.out.printf("Общая стоимость всех выбранных растений: %.2f$\n", totalCost);
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
        
        students.stream()
                .filter(student -> student.getAge() < 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .forEach(student -> System.out.println(student.getSurname() + ", возраст: " + student.getAge()));
    }

    public static void task17() {
        List<Student> students = Util.getStudents();

        students.stream()
                .map(Student::getGroup)
                .distinct()
                .forEach(System.out::println);
    }

    public static void task18() {
        List<Student> students = Util.getStudents();

        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingInt(Student::getAge)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.printf("Факультет: %s Средний возраст: %.2f\n", entry.getKey(), entry.getValue()));
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        System.out.println("Введите группу: ");
        Scanner scanner = new Scanner(System.in);
        String groupName = scanner.nextLine();

        students.stream()
                .filter(student -> student.getGroup().equals(groupName))
                .filter(student -> examinations.stream()
                        .anyMatch(exam -> exam.getStudentId() == student.getId() && exam.getExam3() > 4))
                .forEach(student -> System.out.println(
                        "Студент: " + student.getSurname() + ", группа: " + student.getGroup()));

        scanner.close();
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        Map<String, Double> averageExam1ByFaculty = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingInt(student ->
                                examinations.stream()
                                        .filter(exam -> exam.getStudentId() == student.getId())
                                        .findFirst()
                                        .map(Examination::getExam1)
                                        .orElse(0))));

        Optional<Map.Entry<String, Double>> maxFaculty = averageExam1ByFaculty.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if (maxFaculty.isPresent()) {
            System.out.printf("Факультет с максимальной средней оценкой по первому экзамену: %s Средняя оценка: %.2f",
                    maxFaculty.get().getKey(), maxFaculty.get().getValue());
        } else {
            System.out.println("Данные не найдены.");
        }
    }

    public static void task21() {
        List<Student> students = Util.getStudents();

        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroup,
                        Collectors.counting()))
                .forEach((group, count) ->
                System.out.println("Группа: " + group + ", Количество студентов: " + count));
    }

    public static void task22() {
        List<Student> students = Util.getStudents();

        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.minBy(Comparator.comparingInt(Student::getAge)) // Определяем минимальный возраст
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry ->
                        entry.getValue().map(Student::getAge).orElse(0)))
                .forEach((faculty, minAge) ->
                System.out.println("Факультет: " + faculty + " Минимальный возраст: " + minAge));
    }
}
