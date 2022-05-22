package UserInterface;

import enums.Discipline;
import member.Competitive;
import member.Member;
import member.Motionist;
import other.Team;
import record.RecordTraining;

import java.util.Scanner;

import java.util.ArrayList;

public class UI {
  
  public static void invalidInputMessage() {
    System.out.println(Color.TEXT_RED + "Invalid input" + Color.TEXT_RESET);
  }
  
  public static void printMainMenu() {
    System.out.print("""
        
        MAIN MENU:
        - Cashier Menu                      -> 1
        - Trainer Menu                      -> 2
        - Formand Menu                      -> 3
        - Exit                              -> Enter
        SELECT:\040""");
  }
  
  public static String receiveStringInput() { // todo maybe make real nice
    String input;
    Scanner scanner = new Scanner(System.in);
    input = scanner.nextLine();
    if (input == "") {
      return "";
    }
    String output = input.substring(0, 1).toUpperCase() + input.substring(1);
    return output;
  }
  
  public static void printMembers(ArrayList<Member> members) {
    // William 2005-05-18 con:1000,00 res:0,00 COMPETITIVE crawl,
    // William 2007-05-18 con:1000,00 res:0,00 MOTIONIST
    for (Member member : members) {
      printMember(member);
    }
  }
  
  public static void printMember(Member member) {
    System.out.printf("%-15s %s, con:%7s, res:%7s, %7s, %s, ",
        member.getName(),
        member.getBirthday(),
        member.getContingent(),
        member.getRestance(),
        member.getMembershipStatus(),
        member.getAgeGroup());
    if (member instanceof Motionist) System.out.println("MOTIONIST");
    if (member instanceof Competitive) System.out.println("COMPETITIVE " + ((Competitive) member).getDisciplines());
  }
  
  public static void printCompetitors(ArrayList<Competitive> competitors) {
    for (Competitive competitive : competitors) {
      printCompetitive(competitive);
    }
  }
  
  public static void printCompetitive(Competitive competitive) {
    System.out.printf("%-15s %s, con:%7s, res:%7s, %7s, %s, ",
        competitive.getName(),
        competitive.getBirthday(),
        competitive.getContingent(),
        competitive.getRestance(),
        competitive.getMembershipStatus(),
        competitive.getAgeGroup());
    System.out.println("COMPETITIVE " + ((Competitive) competitive).getDisciplines());
  }
  
  public static void printMotionist(Motionist motionist) {
    System.out.printf("%-15s %s, con:%7s, res:%7s, %7s, %s\n",
        motionist.getName(),
        motionist.getBirthday(),
        motionist.getContingent(),
        motionist.getRestance(),
        motionist.getMembershipStatus(),
        motionist.getAgeGroup());
  }
  
  public static void printMotionists(ArrayList<Motionist> motionists) {
    for (Motionist motionist : motionists) {
      printMotionist(motionist);
    }
  }
  
  
  public static void printTopFiveDiscipline(Discipline discipline, Team team) {
    ArrayList<RecordTraining> records = team.topFiveForDiscipline(discipline);
    
    // heading
    System.out.printf("%s - %s\n",team.getAgeGroup().getString(), discipline.getString());
    System.out.printf("%-15s  %-5s  %s\n", "NAME", "TIME (sec)", "DATE");
    
    // elements
    for (RecordTraining record : records) {
      System.out.println(String.format("%-15s  %-10s  %s", record.getName(), record.getTimeInSeconds(), record.getDate()));
    }
  }
}
