package com.step;

public class Menu {
    int selector;
    GeneralMethods general = new GeneralMethods();

    public int mainMenu() {
        general.winCLS();
        System.out.println("\t\t\tMENU\n");
        System.out.println("\t1. Employee Management");
        System.out.println("\t2. Search Employee");
        System.out.println("\t3. View all employees");
        System.out.println("\t4.   EXIT\n");
        while (true)
        {
            selector = general.intInput();
            if (selector==1 || selector==2 || selector==3 || selector==4) break;
        }
        switch (selector) {
            case 1: return employeeManagement();
            case 2: return employeeSearch();
            case 3: return 14;
            case 4: return 999;
        }
        return 0;
    }


    public int employeeManagement() {
        general.winCLS();
        System.out.println("\t\t\t EMPLOYEE MANAGEMENT\n");
        System.out.println("\t1. Add new employee");
        System.out.println("\t2. Update data for employee");
        System.out.println("\t3. Delete employee data");
        System.out.println("\t4.   BACK\n");
        while (true)
        {
            selector = general.intInput();
            if (selector==1 || selector==2 || selector==3 || selector==4) break;
        }
        switch (selector) {
            case 1: return 11;
            case 2: return 12;
            case 3: return 13;
            case 4: return 99;
        }
     return 0;
    }


    public int employeeSearch() {
        general.winCLS();
        System.out.println("\t\t\t SEARCH\n");
        System.out.println("\t1. ... by IDNP");
        System.out.println("\t2. ... by Name");
        System.out.println("\t3. ... by Surname");
        System.out.println("\t4. ... by Address");
        System.out.println("\t5.   BACK\n");
        while (true)
        {
            selector = general.intInput();
            if (selector==1 || selector==2 || selector==3 || selector==4 || selector==5) break;
        }
        switch (selector) {
            case 1: return 21;
            case 2: return 22;
            case 3: return 23;
            case 4: return 24;
            case 5: return 99;
        }
        return 0;
    }


}
