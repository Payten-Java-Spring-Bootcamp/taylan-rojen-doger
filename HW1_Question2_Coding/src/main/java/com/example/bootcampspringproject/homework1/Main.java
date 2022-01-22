package com.example.bootcampspringproject.homework1;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Map;

public class Main {
    private static final String barbaros = "Barbaros";
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Operations operations = new Operations();
        Student student1 = new Student("Ahmet", "Dogan", 1456, barbaros);
        Student student2 = new Student("Mehmet", "Yılmaz", 2335, "Pirireis");
        Student student3 = new Student("Ayşe", "Öztürk", 1785, "Atatürk");
        Student student4 = new Student("Fatma", "Şahin", 4941, barbaros);
        Student student5 = new Student("Ahmet", "Dogan", 1456, barbaros); //for distinct.
        Student student6 = new Student("Ayşe", "Öztürk", 1799, "Atatürk"); //for filter. numbers are different.
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);

        List<Student> collectList = operations.collectListMethod(studentList);
        logger.log(Level.INFO, "Collect List: " + collectList); //Collect operation.
        List<Student> concatList = operations.concatListMethod(collectList, studentList);
        logger.log(Level.INFO, "Concat List: " + concatList);  //Concat operation.
        List<Student> differenceList = operations.differenceListMethod(concatList, collectList);
        logger.log(Level.INFO, "Difference List: " + differenceList); //Difference operation.
        List<Student> distinctList = operations.distinctListMethod(collectList);
        logger.log(Level.INFO, "Distinct List: " + distinctList); //Distinct operation.
        List<Student> dropList = operations.dropListMethod(collectList);
        logger.log(Level.INFO, "Drop List: " + dropList); //Drop operation. Also Slice operation. Also Take operation.
        List<Student> filterList = operations.filterListMethod(collectList);
        logger.log(Level.INFO, "Filter List: " + filterList); //Filter operation. Also Select operation.
        List<String> list = Arrays.asList(student1.getFirstName(), student2.getFirstName(), student3.getFirstName(), student4.getFirstName(), student6.getFirstName());
        List<Character> flatMapList = operations.flatMapMethod(list);
        logger.log(Level.INFO, "Flat-map List: " + flatMapList); //Flat-map operation. Also Mapcat operation.
        List<List<String>> nestedList = Arrays.asList(list, list);
        List<String> flattenMap = operations.flattenMethod(nestedList);
        logger.log(Level.INFO, "Flatten-map List: " + flattenMap);  //Flat-map operation. Also Mapcat operation.
        List<String> interSectNameList = Arrays.asList(student1.getFirstName() + " " + student1.getSurName());
        List<String> list2 = Arrays.asList("Taylan Döğer", "Işıl Yılmaz", "Uğur Durmaz", student1.getFirstName() + " " + student1.getSurName());
        Optional<String> foldOptional = operations.foldListMethod(list2);
        logger.log(Level.INFO, "Fold List: " + foldOptional);  //Fold operation. Also Inject operation. Also Reduce operation.
        List<String> intersectList = operations.intersectionListMethod(interSectNameList, list2);
        logger.log(Level.INFO, "Intersect List: " + intersectList); //Intersection operation.
        List<Student> mapList = operations.mapListMethod(collectList);
        logger.log(Level.INFO, "Map List: " + mapList); //Map operation.
        List<Student> rejectList = operations.rejectListMethod(collectList);
        logger.log(Level.INFO, "Reject List: " + rejectList); //Reject operation.
        List<String> sortList = operations.sortListMethod(list2);
        logger.log(Level.INFO, "Sort List: " + sortList); //Sort operation.
        List<String> listForUnion = Arrays.asList(student1.getFirstName(), student2.getFirstName(), student3.getFirstName());
        List<String> unionList = operations.unionListMethod(listForUnion, list2);
        logger.log(Level.INFO, "Union List: " + unionList); //Union operation.
    }
}
