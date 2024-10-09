package configs;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {
    public static final Faker faker = new Faker(new Locale("en-US"));

    public static String FullName() {
        return faker.name().fullName();
    }
    public static String Email() {
        return faker.bothify("????##@gmail.com");
    }
    public static String CurrentAddress() {
        return faker.address().fullAddress();
    }
    public static String PermanentAddress() {
        return faker.address().secondaryAddress();
    }
}
