package de.bht.pr2.lab02.part1;


import static org.junit.jupiter.api.Assertions.*;

import de.bht.pr2.lab02.part2.BubbleSort;
import de.bht.pr2.lab02.part2.InsertionSort;
import de.bht.pr2.lab02.part2.QuickSort;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MyTest {


  @Test
  @Order(1)
  void testValidsConstructor() {
    List<String> valids = new ArrayList<String>();
    valids.add("Bob Berg,70002,Technische Informatik,312");
    valids.add("Carla Castor,70003,Druck- und Medientechnik,312");
    valids.add("Daniel Dorf,70004,Screen Based Media,312");
    valids.add("Florian Fein,70005,Technische Informatik,312");
    valids.add("Horst Heinz,70008,Screen Based Media,312");
    valids.add("Jan Jung,70010,Druck- und Medientechnik,312");
    valids.add("Katrin Keller,70011,Medieninformatik,312");
    valids.add("Melanie Mauer,70013,Technische Informatik,312");
    valids.add("Nick Nuss,70014,Medieninformatik,312");
    valids.add("Olivia Oper,70015,Druck- und Medientechnik,312");
    valids.add("Peter Preis,70016,Screen Based Media,312");
    valids.add("Queeny Quadrat,70017,Screen Based Media,312");
    valids.add("Sara Sauer,70019,Technische Informatik,312");
    valids.add("Thomas Tanne,70020,Medieninformatik,312");
    valids.add("Ute Ulrich,70021,Screen Based Media,312");
    valids.add("Vera Vesper,70022,Medieninformatik,312");
    valids.add("Xena Xylophon,70024,Screen Based Media,312");
    valids.add("Yannik Yoga,70025,Druck- und Medientechnik,312");
    valids.add("Zoe Zoo,70026,Technische Informatik,312");
    assertDoesNotThrow(()-> studentsFromList(valids));
  }
  @Test
  @Order(2)
  void testInvalidsConstructor() {
    String parseEx = ",,";
    String parseEx1 = "Walter Welt,70023,Medieninformatik";
    String tuitionFeeEx = "Rafael Raum,70018,Druck- und Medientechnik,200";
    String tuitionFeeEx1 = "Anna Alt,70001,Medieninformatik,250";
    String regNumEx = "Leon Lied,70.012,Screen Based Media,312";
    String regNumEx1 = "Greta Graf,7-00-06,Medieninformatik,312";
    String wrongStudEx = "Ingrid Insel,70009,Musik und Tanz,312";
    assertAll(
            () -> assertThrows(StudentParseException.class, () -> new Student(parseEx)),
            () -> assertThrows(StudentParseException.class, () -> new Student(parseEx1)),
            () -> assertThrows(NotPaidTuitionFeeException.class, () -> new Student(tuitionFeeEx)),
            () -> assertThrows(NotPaidTuitionFeeException.class, () -> new Student(tuitionFeeEx1)),
            () -> assertThrows(RegistrationNumberException.class, () -> new Student(regNumEx)),
            () -> assertThrows(RegistrationNumberException.class, () -> new Student(regNumEx1)),
            () -> assertThrows(WrongCourseOfStudiesException.class, () -> new Student(wrongStudEx))
    );
  }
  @Test
  @Order(3)
  void testSortAlgorithm() {
    int[] originalArray = {5, 7, 12, 21, 34, 2};
    int[] sortedArray = {2, 5, 7, 12, 21, 34};
    int[] sortedArrayBubble = BubbleSort.sort(Arrays.copyOf(originalArray, originalArray.length));
    int[] sortedArrayInsertion = InsertionSort.sort(Arrays.copyOf(originalArray, originalArray.length));
    int[] sortedArrayQuick = QuickSort.sort(Arrays.copyOf(originalArray, originalArray.length));


    assertAll("Comparing sortedArray to different sorting Algorithms: ",
            () -> assertArrayEquals(sortedArray, sortedArrayBubble),
            () -> assertArrayEquals(sortedArray, sortedArrayInsertion),
            () -> assertArrayEquals(sortedArray, sortedArrayQuick)
    );

  }
  private void studentsFromList(List<String> list) {
    for(String s : list) {
      new Student(s);
    }
  }
}

