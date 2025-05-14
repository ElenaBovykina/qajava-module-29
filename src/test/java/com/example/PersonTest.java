package com.example;
//import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class PersonTest {

    @DataProvider(name = "PersonAge")
    Object[][] dataProvider() {
        return new Object[][] {
                {13, true},
                {18, true},
                {12, false},
                {19, true},
                {5, false},
                {0, false},
                {20, false},
                {-1, false}
        };
    }

    @Test(dataProvider = "PersonAge")
    void Teenager(int age, boolean expected) {
        boolean result = Person.isTeenager(age);
        if (result == expected) {
            System.out.println("✅ Персона в возрасте " + age + " проверена корректно. Ожидалось: " + expected);
        } else {
            System.out.println("❌ Возраст " + age + ": ожидалось " + expected + ", но метод вернул " + result);
            if (age < 0) {
                assertEquals(result, expected, "Возраст не может быть отрицательным");
            } else if (age < 13) {
                assertEquals(result, expected, "Возраст младше 13, не должен считаться подростком." );
            } else if (age > 19) {
                assertEquals(result, expected, "Возраст старше 19, не должен считаться подростком.");
            } else if (age >= 13 && age <= 19) {
                assertEquals(result, expected, "Возраст с 13 по 19 лет, должен считаться подростком.");
            }
        }
    }
}
