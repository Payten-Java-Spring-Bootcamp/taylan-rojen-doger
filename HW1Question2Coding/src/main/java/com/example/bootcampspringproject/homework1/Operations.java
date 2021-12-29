package com.example.bootcampspringproject.homework1;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operations {

    public <T> List<T> collectListMethod(List<T> list) { //Collect operation.
        return list.stream()
                .collect(Collectors.toList());
    }

    public <T> List<T> concatListMethod(List<T> list, List<T> list2) { //Concat operation.
        return Stream.of(list, list2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public <T> List<T> differenceListMethod(List<T> list, List<T> list2) { //Difference operation.
        return list.stream()
                .filter(differentObject -> !list2.contains(differentObject))
                .collect(Collectors.toList());
    }

    public <T> List<T> distinctListMethod(List<T> list) { //Distinct operation.
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public <T> List<T> dropListMethod(List<T> list) { //Drop operation. Also Slice operation. Also Take operation.
        return list.stream()
                .collect(Collectors.toList())
                .subList(1, 3);
    }

    public List<Student> filterListMethod(List<Student> list) { //Filter operation. Also Select operation.
        return list.stream()
                .filter(student -> student.getFirstName().equals("Ayşe"))
                .filter(student -> student.getNumber() == 1785)
                .collect(Collectors.toList());
    }

    public List<Character> flatMapMethod(List<String> list) { //Flat-map operation. Also Mapcat operation.
        return list.stream()
                .flatMap(str -> Stream.of(str.charAt(0)))
                .collect(Collectors.toList());
    }

    public List<String> flattenMethod(List<List<String>> list) { //Flatten operation.
        return list.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
    }

    public Optional<String> foldListMethod(List<String> list) { //Fold operation. Also Inject operation. Also Reduce operation.
        return list.stream()
                .reduce((string1, string2) -> string1.length() > string2.length() ? string1 : string2);
    }

    public <T> List<T> intersectionListMethod(List<T> list, List<T> list2) { //Intersection operation.
        return list.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
    }

    public List<Student> mapListMethod(List<Student> list) { //Map operation.
        return list.stream()
                .map(student -> new Student("Manilupated with map " + student.getFirstName(), student.getSurName(), student.getNumber(), student.getSchoolName()))
                .collect(Collectors.toList());
    }

    public List<Student> rejectListMethod(List<Student> list) { //Reject operation.
        return list.stream()
                .filter(student -> !(student.getFirstName().equals("Ayşe")))
                .filter(student -> student.getNumber() != 1785)
                .collect(Collectors.toList());
    }

    public <T> List<T> sortListMethod(List<T> list) { //Sort operation.
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public <T> List<T> unionListMethod(List<T> list, List<T> list2) { //Union operation.
        return Stream
                .concat(list.stream(), list2.stream())
                .collect(Collectors.toList());
    }
}
