import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Service s = new Service();
    Scanner sc = new Scanner(System.in);
    int wybor;
    boolean petla = true;
    while (petla) {
      System.out.println("1.Dodaj studenta");
      System.out.println("2.Wypisz studentow");
      System.out.println("3.Wyszukaj studenta po imieniu");
      System.out.println("4.Usun studenta");
      System.out.println("5.Wyjscie");
      wybor = sc.nextInt();

      switch (wybor) {
        case 1:

          System.out.println("Podaj imie:");
          sc.nextLine();
          String imie = sc.nextLine();

          System.out.println("Podaj wiek:");
          int wiek = sc.nextInt();
          sc.nextLine();

          System.out.println("Podaj nazwisko:");
          String nazwisko = sc.nextLine();

          int dzien;
          while (true) {
            System.out.println("Wprowadź dzień urodzenia :");
            dzien = sc.nextInt();
            if (dzien >= 1 && dzien <= 31) {
              break;
            } else {
              System.out.println("wprowadz poprawny dzien");
            }
          }
          sc.nextLine();
          String dzienurodzenia = Integer.toString(dzien);
          int miesiac;
          while (true) {
            System.out.println("Wprowadź miesiąc urodzenia:");
            miesiac = sc.nextInt();
            if (miesiac >= 1 && miesiac <= 12) {
              break;
            } else {
              System.out.println("Wprowadz poprawny miesiac");
            }
          }
          String miesiacurodzenia = Integer.toString(miesiac);
          System.out.println("Wprowadź rok urodzenia:");
          int rok = sc.nextInt();
          String rokurodzenia = Integer.toString(rok);

          String dataurodzenia = dzienurodzenia + "-" + miesiacurodzenia + "-" + rokurodzenia;

          Student nowystudent = new Student(imie, wiek, nazwisko, dataurodzenia);
          try {
            s.addStudent(nowystudent);
          } catch (IOException e) {
          }
          break;

        case 2:

          try {
            var students = s.getStudents();
            for (Student current : students) {
              System.out.println(current.ToString());
            }
          } catch (IOException e) {
          }
          break;

        case 3:

          try {
            var students = s.getStudents();
            sc.nextLine();
            System.out.println("Podaj imie:");
            String imie2 = sc.nextLine();
            Student student = s.findStudentByName(imie2);
            if (student != null) {
              System.out.println("Znaleziono studenta: " + student.ToString());
            }
          } catch (IOException e) {
          }
          break;

        case 4:

          System.out.println("Podaj imie studenta do usuniecia:");
          sc.nextLine();
          String imieusun = sc.nextLine();
          System.out.println("Podaj nazwisko studenta do usuniecia:");
          String nazwiskousun = sc.nextLine();

          try {

            var students = s.getStudents();
            boolean found = false;

            Iterator<Student> iterator = students.iterator();
            while (iterator.hasNext()) {
              Student student = iterator.next();
              if (student.GetName().equals(imieusun) && student.GetNazwisko().equals(nazwiskousun)) {
                iterator.remove();
                found = true;
                break;
              }
            }

            if (found) {

              FileWriter fw = new FileWriter("db.txt");
              for (Student student : students) {
                fw.write(student.ToString() + "\n");
              }
              fw.close();
              System.out.println("Student usuniety  ");
            } else {
              System.out.println("Nie znaleziono studenta o podany imieniu i nazwisku");
            }

          } catch (IOException e) {
            System.out.println("blad usuwania");
          }
          break;

        case 5:
          petla = false;
          System.exit(0);
          break;
      }
    }
  }
}
