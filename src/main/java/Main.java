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
      System.out.println("Podaj imie:");
      Scanner sc=new Scanner(System.in);
      String imie=sc.nextLine();
      System.out.println("Podaj wiek:");
      int wiek=sc.nextInt();

       Student nowystudent=new Student(imie,wiek);
    
    

    
    try {
      Service s = new Service();
      
      
      s.addStudent(nowystudent);

      var students = s.getStudents();
      for(Student current : students) {
        System.out.println(current.ToString());
      }
    } catch (IOException e) {

    }
  }
}