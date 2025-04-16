/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    Service s = new Service();
    Scanner sc = new Scanner(System.in);
    int wybor;
    boolean petla = true;
    while (petla) {
      System.out.println("1.Dodaj studenta");
      System.out.println("2.Wypisz studentow");
      System.out.println("3.Wyjscie");
      System.out.println("");
      wybor = sc.nextInt();
      sc.nextLine();
      switch (wybor) {
        case 1:
          System.out.println("Podaj imie:");

          String imie = sc.nextLine();
          System.out.println("Podaj wiek:");
          int wiek = sc.nextInt();

          Student nowystudent = new Student(imie, wiek);
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
          petla = false;
          System.exit(0);
          break;
      }
    }

  }

}