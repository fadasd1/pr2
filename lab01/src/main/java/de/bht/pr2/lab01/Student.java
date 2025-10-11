package de.bht.pr2.lab01;
import java.util.Set;
import java.util.HashSet;
public class Student {
  static Set<String> studien = Set.of("Medieninformatik","Technische Informatik", "Druck- und Medientechnik", "Screen Based Media");
    //-------------------------------------------
  // Attribute
  private String name = "";

  // Matrikelnummer
  private int registrationNumber = 0;

  // Medieninformatik, Technische Informatik, Druck- und Medientechnik und Screen Based Media
  private String courseOfStudies = "";

  // Rückmeldegebühr
  public static final int TUITION_FEE = 312;

  /**
   * This contructor parses a comma-separated row describing a student object.
   *
   * @param dataRow a comma-separated row describing a student object
   */
  public Student(String dataRow) throws NotPaidTuitionFeeException, RegistrationNumberException, WrongCourseOfStudiesException, StudentParseException {
    String[] data = errorChecker(dataRow);
    this.name = data[0];
    this.registrationNumber = stringToInt(data[1]);
    this.courseOfStudies = data[2];
  }

  private static String[] errorChecker(String dataRow) throws StudentParseException, RegistrationNumberException, WrongCourseOfStudiesException, NotPaidTuitionFeeException {
    String[] data = dataRow.split(",");
    if(data.length != 4) throw new StudentParseException("Zeile im falsche Format: " + dataRow);
      else if(data[1].length() != 5) throw new RegistrationNumberException(data[0] + ": Matrikelnummer fehlerhaft: " + data[1]);
      else if(!studien.contains(data[2])) throw new WrongCourseOfStudiesException(data[0] + ": Unbekannter Studiengang: " + data[2]);
      else if(!data[3].equals("312")) throw new NotPaidTuitionFeeException(data[0] + " muss noch " + (TUITION_FEE - stringToInt(data[3]) + "€ zahlen."));
      return data;
  }

  private static int stringToInt(String s) {
    int result = 0;
    for(char c : s.toCharArray()) {
      c -= 48;
      result = result * 10 + c;
    }
    return result;
  }
  @Override
  public String toString() {
    return name + ", " + registrationNumber + ((char) 44) + ((char) 0b100000) + courseOfStudies;
  }
}

