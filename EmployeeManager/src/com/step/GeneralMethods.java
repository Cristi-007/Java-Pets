package com.step;

import com.step.enums.Gender;

import java.io.IOException;
import java.util.Scanner;

public class GeneralMethods {
    Scanner input = new Scanner(System.in);



    public void winCLS() {
        ProcessBuilder cls = new ProcessBuilder("cmd", "/c", "cls");

        try {
            cls.inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error execution cls");
        }
    }



    public char charInput() {
        Character letter = Character.toUpperCase(input.next().charAt(0));
        input.nextLine();

        return letter;
    }



    public String stringInput() {

        System.out.print("Select: ");
        String data = input.nextLine();
        return data;
    }




    public int intInput() {

        System.out.print("Select: ");
        int data = input.nextInt();
        input.nextLine();

        return data;
    }




    public void employeeDataShow(Employee[] mainData) {
        winCLS();
        System.out.println("\t\t\t\t\t\t\t\t\t EMPLOYEE DATA\n");
        System.out.println("\t\tName and Surname" + "\t\t\tGENDER " + "\t\t\t\t\tIDNP " + "\t\t\t\t\t\t   Address" + "\t\t\t\t\t\t   Function" + "\t\t\t\t\tSalary");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int i=0; i< mainData.length; i++) {
            System.out.println("|\t\t" + mainData[i].getName() + " " + mainData[i].getSurname() + " \t\t |  \t" + mainData[i].getGender() + " \t\t |  \t" + mainData[i].getIDNP() + "\t\t  |  \t" + mainData[i].getAdress() +
                    "\t  |  \t" + mainData[i].getFunction() + "\t  |  \t" + mainData[i].getSalary() + "\t\t|");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        }

    }




    public Employee[] employeeDataRegister(Employee[] mainData) {

        Employee[] newEmployee = new Employee[mainData.length+1];
        Character gender;

        if (mainData.length == 0) {

            for (int i = 0; i < newEmployee.length; i++) {

                newEmployee[i] = new Employee();

                System.out.println("Name: ");
                newEmployee[i].setName(input.nextLine().toUpperCase());

                System.out.println("Surname: ");
                newEmployee[i].setSurname(input.nextLine().toUpperCase());

                System.out.println("Choose gender: [M]ale or [F]emale: ");
                gender = charInput();
                if(gender.equals('M')) { newEmployee[i].setGender(Gender.MALE); }
                else if(gender.equals('F')) { newEmployee[i].setGender(Gender.FEMALE); }

                System.out.println("IDNP: ");
                newEmployee[i].setIDNP(input.nextLine());

                System.out.println("Address: ");
                newEmployee[i].setAdress(input.nextLine().toUpperCase());

                System.out.println("Position: ");
                newEmployee[i].setFunction(input.nextLine().toUpperCase());

                System.out.println("Salary: ");
                newEmployee[i].setSalary(input.nextInt());
                input.nextLine();
            }
        } else {

            for (int i = 0; i < newEmployee.length; i++) {

                if (i < mainData.length) {
                    newEmployee[i] = mainData[i];
                } else {
                    newEmployee[i] = new Employee();

                    System.out.println("Name: ");
                    newEmployee[i].setName(input.nextLine().toUpperCase());

                    System.out.println("Surname: ");
                    newEmployee[i].setSurname(input.nextLine().toUpperCase());

                    System.out.println("Choose gender: [M]ale or [F]emale: ");
                    gender = charInput();
                    if(gender.equals('M')) { newEmployee[i].setGender(Gender.MALE); }
                    else if(gender.equals('F')) { newEmployee[i].setGender(Gender.FEMALE); }

                    System.out.println("IDNP: ");
                    newEmployee[i].setIDNP(input.nextLine().toUpperCase());

                    System.out.println("Address: ");
                    newEmployee[i].setAdress(input.nextLine().toUpperCase());

                    System.out.println("Position: ");
                    newEmployee[i].setFunction(input.nextLine().toUpperCase());

                    System.out.println("Salary: ");
                    newEmployee[i].setSalary(input.nextInt());
                    input.nextLine();

                }
            }
        }

        return newEmployee;
    }



    public Employee[] employeeDataUpdate(Employee[] mainData, String IDNP) {

        for(int i=0; i< mainData.length; i++) {
            String newData = "";

            if (mainData[i].getIDNP().equalsIgnoreCase(IDNP)) {

                System.out.println("Insert new data. If you don't want do update a category, live it blank (press Enter). ");

                System.out.println("Old Data: " + mainData[i].getName() + " | " + "New Name: ");
                newData = input.nextLine().toUpperCase();
                if (!newData.equalsIgnoreCase("")) { mainData[i].setName(newData); newData = ""; }

                System.out.println("Old Data: " + mainData[i].getSurname() + " | " + "New Surname: ");
                newData = input.nextLine().toUpperCase();
                if (!newData.equalsIgnoreCase("")) { mainData[i].setSurname(newData); newData = ""; }

                System.out.println("Old Data: " + mainData[i].getGender() + " | " + "Select new Gender: [M]ale or [F]emale: ");
                Character gender = charInput();
                if(gender.equals('M')) {  mainData[i].setGender(Gender.MALE); }
                else if(gender.equals('F')) {  mainData[i].setGender(Gender.FEMALE); }

                System.out.println("Old Data: " + mainData[i].getAdress() + " | " + "New Address: ");
                newData = input.nextLine().toUpperCase();
                if (!newData.equalsIgnoreCase("")) { mainData[i].setAdress(newData); newData = ""; }

                System.out.println("Old Data: " + mainData[i].getFunction() + " | " + "New Position: ");
                newData = input.nextLine().toUpperCase();
                if (!newData.equalsIgnoreCase("")) { mainData[i].setFunction(newData); newData = ""; }

                System.out.println("Old Data: " + mainData[i].getSalary() + " | " + "New Salary: ");
                int newSalary = 0;
                newSalary = input.nextInt();
                input.nextLine();
                if (newSalary != 0) { mainData[i].setSalary(newSalary); }
            }
        }

        return mainData;
    }



    public Employee[] employeeDataRemove(Employee[] mainData, String IDNP) {
        Employee[] removedEmployee = new Employee[mainData.length - 1];

        for (int i=0, j=0; i<mainData.length; i++) {
            if (!mainData[i].getIDNP().equalsIgnoreCase(IDNP)) {
                removedEmployee[j] = new Employee();
                removedEmployee[j] = mainData[i];
                j++;
            } else continue;
        }
        return removedEmployee;
    }




    public void employeeSearch(Employee[] mainData, int searchType, String searchData) {
        boolean noData = true;
        switch (searchType) {
            case 1:
                for(int i=0; i<mainData.length; i++) {

                    if(mainData[i].getIDNP().equalsIgnoreCase(searchData)) {
                        System.out.println("Employee Name: " + mainData[i].getName());
                        System.out.println("Employee Surname: " + mainData[i].getSurname());
                        System.out.println("Employee IDNP: " + mainData[i].getIDNP());
                        System.out.println("Employee Address: " + mainData[i].getAdress());
                        System.out.println("Employee Function: " + mainData[i].getFunction());
                        System.out.println("Employee Salary: " + mainData[i].getSalary());
                        noData = false;
                    }
                }
                if(noData) { System.out.println("There is no data with IDNP: " + searchData); }
                break;

            case 2:
                for(int i=0; i<mainData.length; i++) {

                    if(mainData[i].getName().equalsIgnoreCase(searchData)) {
                        System.out.println("Employee Name: " + mainData[i].getName());
                        System.out.println("Employee Surname: " + mainData[i].getSurname());
                        System.out.println("Employee IDNP: " + mainData[i].getIDNP());
                        System.out.println("Employee Address: " + mainData[i].getAdress());
                        System.out.println("Employee Function: " + mainData[i].getFunction());
                        System.out.println("Employee Salary: " + mainData[i].getSalary());
                        noData = false;
                    }
                }
                if(noData) { System.out.println("There is no data with Name: " + searchData); }
                break;

            case 3:
                for(int i=0; i<mainData.length; i++) {

                    if(mainData[i].getSurname().equalsIgnoreCase(searchData)) {
                        System.out.println("Employee Name: " + mainData[i].getName());
                        System.out.println("Employee Surname: " + mainData[i].getSurname());
                        System.out.println("Employee IDNP: " + mainData[i].getIDNP());
                        System.out.println("Employee Address: " + mainData[i].getAdress());
                        System.out.println("Employee Function: " + mainData[i].getFunction());
                        System.out.println("Employee Salary: " + mainData[i].getSalary());
                        noData = false;
                    }
                }
                 if(noData) { System.out.println("There is no data with Surname: " + searchData); }
                break;

            case 4:
                for(int i=0; i<mainData.length; i++) {

                    if(mainData[i].getAdress().equalsIgnoreCase(searchData)) {
                        System.out.println("Employee Name: " + mainData[i].getName());
                        System.out.println("Employee Surname: " + mainData[i].getSurname());
                        System.out.println("Employee IDNP: " + mainData[i].getIDNP());
                        System.out.println("Employee Address: " + mainData[i].getAdress());
                        System.out.println("Employee Function: " + mainData[i].getFunction());
                        System.out.println("Employee Salary: " + mainData[i].getSalary());
                        noData = false;
                    }
                }
                if(noData) { System.out.println("There is no data with Address: " + searchData); }
                break;
        }

    }

}
