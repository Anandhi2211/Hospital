import main.java.com.solvd.hospital.patient.Patient;
import main.java.com.solvd.hospital.personalInfomation.PersonalInfomation;

import java.util.Scanner;
import java.util.UUID;

public class Hospital {



    public static void main(String[] args) {

starting:
    System.out.println("Welcome to Hospital Portal!");



        System.out.println("New Patient -- option 1");
        System.out.println("Existing Patient -- option 2");
        System.out.println("Exit Portal -- option 3");

        System.out.println("Please Enter your option");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();



        if(option == 1 || option ==2)
        {
            switch (option)
            {
                case 1:
                    System.out.println("Inside option 1");
                    PersonalInfomation personalInfo = new PersonalInfomation();
                    Patient patient = new Patient(UUID.randomUUID().toString());
                    System.out.println("Enter your first name:");
                    personalInfo.setFistName(in.nextLine());
                    System.out.println("Enter your last name:");
                    personalInfo.setLastName(in.nextLine());
                   /* System.out.println("Enter your gender:");
                    personalInfo.setGender(in.nextLine());
                    System.out.println("Enter your age:");
                    personalInfo.setAge(in.nextInt());
                    System.out.println("Enter your address:");
                    personalInfo.setAddress(in.nextLine());
                    System.out.println("Enter your state:");
                    personalInfo.setState(in.nextLine());
                    System.out.println("Enter your city:");
                    personalInfo.setCity(in.nextLine());
                    System.out.println("Enter your country:");
                    personalInfo.setCountry(in.nextLine());
                    System.out.println("Enter your contact number:");
                    personalInfo.setContactNumber(in.nextLine());
                    System.out.println("Enter your email address:");
                    personalInfo.setEmailAddress(in.nextLine());*/



                    //String uniqueID = UUID.randomUUID().toString();
                    //System.out.println(uniqueID);


                    break;

                case 2:
                    System.out.println("Please Enter your option2" + personalInfo.getFistName());

                    break;
            }
        }
        else
        {
            System.out.println("Invalid Input");
            System.out.println("Please Enter either 1 or 2");
        }
       /* System.out.println("Continue Y/N");
        String answer = in.nextLine();
        if(answer.equals(Y))
        {
            goto starting
        }*/


    }
}