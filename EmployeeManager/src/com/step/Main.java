package com.step;

public class Main {

    public static void main(String[] args) {

        GeneralMethods general = new GeneralMethods();
        Menu menu = new Menu();
        Employee[] mainEmployeeData = new Employee[0];
        int intSelector;
        Character charSelector;

        String randomData;

        while (true) {
            intSelector = menu.mainMenu();

            switch (intSelector) {
                case 11:
                    while (true) {
                        mainEmployeeData = general.employeeDataRegister(mainEmployeeData);
                        System.out.println("Add new user? ([Y]es/[N]o)");
                        charSelector = general.charInput();
                        if(charSelector.equals('N')) break;
                    }
                    break;

                case 12:
                    System.out.println("\t To update data for employee you need IDNP.\n Do you know it? [Y]es/[N]o: ");
                    charSelector = general.charInput();

                        if (charSelector.equals('Y')) {
                            System.out.println("\t Insert employee IDNP: ");
                            String idnp = general.stringInput();
                            general.winCLS();

                            for(int i=0; i < mainEmployeeData.length; i++) {
                                if(mainEmployeeData[i].getIDNP().equalsIgnoreCase(idnp)) {
                                    general.employeeDataUpdate(mainEmployeeData, idnp);
                                } else if(i == mainEmployeeData.length-1) System.out.println("Wrong IDNP!!");
                            }
                        }
                    break;

                case 13:
                    System.out.println("\t To remove data for employee you need IDNP.\n Do you know it? [Y]es/[N]o: ");
                    charSelector = general.charInput();

                        if (charSelector.equals('Y')) {
                            System.out.println("\t Insert employee IDNP: ");
                            String idnp = general.stringInput();
                            general.winCLS();

                            for(int i=0; i < mainEmployeeData.length; i++) {
                                if (mainEmployeeData[i].getIDNP().equalsIgnoreCase(idnp)) {
                                    mainEmployeeData = general.employeeDataRemove(mainEmployeeData,idnp);
                                } else if(i == mainEmployeeData.length-1) System.out.println("Wrong IDNP!!");
                            }
                        }
                    break;

                case 14:
                    general.employeeDataShow(mainEmployeeData);
                    break;

                case 21:
                    System.out.println("\t Insert employee IDNP: ");
                    randomData = general.stringInput();
                    general.winCLS();
                    general.employeeSearch(mainEmployeeData, 1, randomData);
                    break;

                case 22:
                    System.out.println("\t Insert employee Name: ");
                    randomData = general.stringInput();
                    general.winCLS();
                    general.employeeSearch(mainEmployeeData, 2, randomData);
                    break;

                case 23:
                    System.out.println("\t Insert employee Surname: ");
                    randomData = general.stringInput();
                    general.winCLS();
                    general.employeeSearch(mainEmployeeData, 3, randomData);
                    break;

                case 24:
                    System.out.println("\t Insert employee Address: ");
                    randomData = general.stringInput();
                    general.winCLS();
                    general.employeeSearch(mainEmployeeData, 4, randomData);
                    break;

                case 99:
                    break;

                case 999: return;
            }

        }

    }
}
