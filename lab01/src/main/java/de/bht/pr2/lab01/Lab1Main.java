package de.bht.pr2.lab01;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class.
 */
public class Lab1Main {

  public static void main(String[] args) {
    // Daten fuer Studierenden als Strings
    List<String> data = new ArrayList<String>();
    data.add("Anna Alt,70001,Medieninformatik,250");
    data.add("Bob Berg,70002,Technische Informatik,312");
    data.add("Carla Castor,70003,Druck- und Medientechnik,312");
    data.add("Daniel Dorf,70004,Screen Based Media,312");
    data.add("Florian Fein,70005,Technische Informatik,312");
    data.add("Greta Graf,7-00-06,Medieninformatik,312"); // Falsche Matrikelnummer
    data.add("Horst Heinz,70008,Screen Based Media,312");
    data.add("Ingrid Insel,70009,Musik und Tanz,312"); // Falscher Studiengang
    data.add("Jan Jung,70010,Druck- und Medientechnik,312");
    data.add("Katrin Keller,70011,Medieninformatik,312");
    data.add("Leon Lied,70.012,Screen Based Media,312"); // Falsche Matrikelnummer
    data.add("Melanie Mauer,70013,Technische Informatik,312");
    data.add("Nick Nuss,70014,Medieninformatik,312");
    data.add("Olivia Oper,70015,Druck- und Medientechnik,312");
    data.add("Peter Preis,70016,Screen Based Media,312");
    data.add("Queeny Quadrat,70017,Screen Based Media,312");
    data.add("Rafael Raum,70018,Druck- und Medientechnik,200"); // Zu wenig bezahlt
    data.add("Sara Sauer,70019,Technische Informatik,312");
    data.add("Thomas Tanne,70020,Medieninformatik,312");
    data.add("Ute Ulrich,70021,Screen Based Media,312");
    data.add("Vera Vesper,70022,Medieninformatik,312");
    data.add("Walter Welt,70023,Medieninformatik"); // Zu wenig Daten
    data.add(",,"); // Zu wenig Daten
    data.add("Xena Xylophon,70024,Screen Based Media,312");
    data.add("Yannik Yoga,70025,Druck- und Medientechnik,312");
    data.add("Zoe Zoo,70026,Technische Informatik,312");

    // Create a list of Student-Objects
    List<Student> students = new ArrayList<Student>();

    // Parse each line ...
    for (String datenZeile : data) {
        // ... and try to create a Student object
        try {
          Student student = new Student(datenZeile);
          students.add(student);
          System.out.println("Erfolg: " + student);
        } catch (StudentParseException | RegistrationNumberException | WrongCourseOfStudiesException | NotPaidTuitionFeeException e) {
            System.out.println(e);
            e.printStackTrace(); //alternativ System.out
        }

    }

    // Print all students which could be parsed
    System.out.println((char) 10 + "List of Student objects:" ); // \n
    for (Student student : students) {
      System.out.println(student);
    }
  }
}
