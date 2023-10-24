/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oocminihw3;




import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author castr
 */
public class OOCMiniHW3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //this is the list created to store the objects called Member
        List<Member> people = new ArrayList<>();
        
        //this is the map created to store the teams and your names
        Map<String, List<Member>> namedTeams;
        namedTeams = new LinkedHashMap<>();
        
        try {
            //the code above I create to read the data from csv file
            File file = new File("MOCK_DATA.csv");
            try (Scanner input = new Scanner(file)) {
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] section = line.split(",");
                    
                    //this part of the code is to make sure that have 4 fields on the line
                    if (section.length == 4) {
                        int id = Integer.parseInt(section[0]);
                        String firstName = section[1];
                        String lastName = section[2];
                        String email = section[3];
                        
                        //this code is the creation of the Member object and add on the list
                        people.add(new Member(id, firstName, lastName, email));
                    }
                }
            }
            
            //this code is to randomize the list of people
            Collections.shuffle(people);
            
            int numberOfTeams = 20;
            int sizeOfTeam = 5;
            
            //in this part of the code I created the teams and insert in the namedTeams Map 
            for (int i = 1; i <= numberOfTeams; i++) {
                String teamName = getTeamName(i);
                List<Member> teamMembers = new ArrayList<>();
                for (int j = 0; j < sizeOfTeam; j++) {
                    if (!people.isEmpty()) {
                        teamMembers.add(people.remove(0)); 
                    }
                }
                namedTeams.put(teamName, teamMembers);
            }
            
            //now the system will print out the names and the members of the teams
            namedTeams.forEach((teamName, members) -> {
                System.out.println(teamName + ":");
                for (Member member : members) {
                    System.out.println(member);
                }
                System.out.println();
            });

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

        //now from the teamNumber the system will generate the team names
        private static String getTeamName(int teamNumber) {
            if (teamNumber < 1 || teamNumber > 20) {
           
            }
        
        String[] numberWords = {
            "First", "Second", "Third", "Fourth", "Fifth",
            "Sixth", "Seventh", "Eighth", "Ninth", "Tenth",
            "Eleventh", "Twelfth", "Thirteenth", "Fourteenth", "Fifteenth",
            "Sixteenth", "Seventeenth", "Eighteenth", "Nineteenth", "Twentieth"
        };
        return numberWords[teamNumber - 1] + " Team";
    }
}
       
        
        

