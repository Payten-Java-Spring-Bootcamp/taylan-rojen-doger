package com.example.bootcampspringproject.homework1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class OperationsTest {
    Operations operations = new Operations();
    @Test
    void collectListMethod() {
        List<String> list = new ArrayList<>();
        list.add("String1");
        list.add("String2");
        Assertions.assertEquals(List.of("String1", "String2"), operations.collectListMethod(list));
    }
    @Test
    void concatListMethod() {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("String1");
        list.add("String2");
        list2.add("ListItem");
        Assertions.assertEquals(List.of("String1", "String2", "ListItem"), operations.concatListMethod(list, list2));
    }

    @Test
    void differenceListMethod() {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("String1");
        list.add("String2");
        list2.add("String1");
        Assertions.assertEquals(List.of("String2"), operations.differenceListMethod(list, list2));
    }

    @Test
    void distinctListMethod() {
        List<String> list = new ArrayList<>();
        list.add("String1");
        list.add("String2");
        list.add("String1");
        list.add("String3");
        Assertions.assertEquals(List.of("String1", "String2", "String3"), operations.distinctListMethod(list));
    }

    @Test
    void dropListMethod() {
        List<String> list = new ArrayList<>();
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String4");
        list.add("String5");
        list.add("String6");
        Assertions.assertEquals(List.of("String2", "String3"), operations.dropListMethod(list));
    }

    @Test
    void filterListMethod() {
        List<Student> list = new ArrayList<>();
        Student student = new Student("Ayşe", "Öztürk", 1785, "Atatürk");
        list.add(student);
        Assertions.assertEquals(List.of(new Student("Ayşe", "Öztürk", 1785, "Atatürk")), operations.filterListMethod(list));
    }
//ALT
    @Test
    void flatMapMethod() {
        List<String> list = new ArrayList<>();
        list.add("String1");
        list.add("Btring2");
        list.add("String3");
        Assertions.assertEquals(List.of('S', 'B', 'S'), operations.flatMapMethod(list));
    }

    @Test
    void flattenMethod() {
        List<String> list = new ArrayList<>();
        list.add("String1");
        list.add("String3");
        List<String> list2 = new ArrayList<>();
        list2.add("newItem");
        list2.add("newItem2");
        List<List<String>> nestedList = Arrays.asList(list, list2);
        Assertions.assertEquals(List.of("String1", "String3", "newItem", "newItem2"), operations.flattenMethod(nestedList));
    }

    @Test
    void foldListMethod() {
        List<String> list = new ArrayList<>();
        list.add("LongString1");
        list.add("String2");
        Assertions.assertEquals(Optional.of("LongString1"), operations.foldListMethod(list));
    }

    @Test
    void intersectionListMethod() {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("String1");
        list.add("String2");
        list2.add("ListItem");
        list2.add("ListItem2");
        list2.add("String2");
        Assertions.assertEquals(List.of("String2"), operations.intersectionListMethod(list, list2));
    }

    @Test
    void mapListMethod() {
        List<Student> list = new ArrayList<>();
        Student student = new Student("Taylan", "Döğer", 1, "XYZ");
        list.add(student);
        Assertions.assertEquals(List.of(new Student("Manilupated with map " + student.getFirstName(), student.getSurName(), student.getNumber(), student.getSchoolName())), operations.mapListMethod(list));
    }

    @Test
    void rejectListMethod() {
        List<Student> list = new ArrayList<>();
        Student student = new Student("Ayşe", "Öztürk", 1785, "Atatürk");
        list.add(student);
        Assertions.assertNotEquals(List.of(new Student("Ayşe", "Öztürk", 1785, "Atatürk")), operations.rejectListMethod(list));
    }

    @Test
    void sortListMethod() {
        List<String> list = new ArrayList<>();
        list.add("String1");
        list.add("String7");
        list.add("String9");
        list.add("String2");
        Assertions.assertEquals(List.of("String1","String2","String7","String9"),operations.sortListMethod(list));
    }

    @Test
    void unionListMethod() {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("String1");
        list.add("String2");
        list2.add("ListItem");
        Assertions.assertEquals(List.of("String1","String2","ListItem"), operations.unionListMethod(list, list2));
    }
}