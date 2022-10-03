/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mng;

import data.HospitalMng;
import tools.MyTool;

/**
 *
 * @author NhiLamHet
 */
public class HospitalProgram {

    public static void main(String[] args) {
        Menu mainMenu = new Menu("Hospital Management");

        mainMenu.addNewOption("1. Add information");
        mainMenu.addNewOption("2. Search information");
        mainMenu.addNewOption("3. Remove information");
        mainMenu.addNewOption("4. Update information");
        mainMenu.addNewOption("5. Show information");
        mainMenu.addNewOption("6. Write to file");
        mainMenu.addNewOption("7. Others-Quit");

        Menu subMenu1 = new Menu("Add information: ");
        subMenu1.addNewOption("1. Add a department");
        subMenu1.addNewOption("2. Add a doctor");
        subMenu1.addNewOption("3. Add a patient");
        subMenu1.addNewOption("4. Add a examination");
        subMenu1.addNewOption("5. Return  main menu");

        Menu subMenu2 = new Menu("Search information");
        subMenu2.addNewOption("1. Search a department by id");
        subMenu2.addNewOption("2. Search a doctor by id");
        subMenu2.addNewOption("3. Search a patient by id");
        subMenu2.addNewOption("4. Search a examination by id");
        subMenu2.addNewOption("5. Return  main menu");

        Menu subMenu3 = new Menu("Remove information");
        subMenu3.addNewOption("1. Remove a department");
        subMenu3.addNewOption("2. Remove a doctor");
        subMenu3.addNewOption("3. Remove a patient");
        subMenu3.addNewOption("4. Remove a examination");
        subMenu3.addNewOption("5. Return  main menu");

        Menu subMenu4 = new Menu("Update information");
        subMenu4.addNewOption("1. Update a department");
        subMenu4.addNewOption("2. Update a doctor");
        subMenu4.addNewOption("3. Update a patient");
        subMenu4.addNewOption("4. Update a examination");
        subMenu4.addNewOption("5. Return main menu");

        Menu subMenu5 = new Menu("Show information");
        subMenu5.addNewOption("1. Show department list");
        subMenu5.addNewOption("2. Show doctor list");
        subMenu5.addNewOption("3. Show patient list");
        subMenu5.addNewOption("4. Show examination list");
        subMenu5.addNewOption("5. Return main menu");

        int choice = 0;
        int sChoice = 0;
        HospitalMng hospitalMng = new HospitalMng();
        do {
            mainMenu.printMenu();
            choice = mainMenu.getChoice();
            boolean askReturn = false;
            switch (choice) {
                case 1:

                    do {
                        subMenu1.printMenu();
                        sChoice = subMenu1.getChoice();
                        switch (sChoice) {
                            case 1:
                                hospitalMng.addDepartment();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 2:
                                hospitalMng.addDoctor();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 3:
                                hospitalMng.addPatient();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 4:
                                hospitalMng.addExaminaton();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 5:
                                askReturn = false;
                                break;
                        }

                    } while (askReturn);
                    break;
                case 2:
                    do {
                        subMenu2.printMenu();
                        sChoice = subMenu2.getChoice();
                        switch (sChoice) {
                            case 1:
                                hospitalMng.searchDepartment();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 2:
                                hospitalMng.searchDoctor();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);

                                break;
                            case 3:
                                hospitalMng.searchPatient();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 4:
                                hospitalMng.searchExamination();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 5:
                                askReturn = false;
                                break;
                        }
                    } while (askReturn);
                    break;
                case 3:
                    do {
                        subMenu3.printMenu();
                        sChoice = subMenu3.getChoice();
                        switch (sChoice) {
                            case 1:
                                hospitalMng.removeDepartment();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 2:
                                hospitalMng.removeDoctor();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 3:
                                hospitalMng.removePatient();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 4:
                                hospitalMng.removeExamination();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 5:
                                askReturn = false;
                                break;
                        }
                    } while (askReturn);
                    break;
                case 4:
                    do {
                        subMenu4.printMenu();
                        sChoice = subMenu4.getChoice();
                        switch (sChoice) {
                            case 1:
                                hospitalMng.updateDepartment();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 2:
                                hospitalMng.updateDoctor();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 3:
                                hospitalMng.updatePatient();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 4:
                                hospitalMng.updateExamination();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 5:
                                askReturn = false;
                                break;
                        }
                    } while (askReturn);
                    break;
                case 5:
                    do {
                        subMenu5.printMenu();
                        sChoice = subMenu5.getChoice();
                        switch (sChoice) {
                            case 1:
                                hospitalMng.showDeptInfor();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 2:
                                hospitalMng.showDoctorInfor();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 3:
                                hospitalMng.showPatientInfor();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 4:
                                hospitalMng.showExaminationInFor();
                                askReturn = MyTool.getBoolean("\nCountinue(Y/N)?\nEnter: ", "Please enter Y or N", false);
                                break;
                            case 5:
                                askReturn = false;
                                break;
                        }
                    } while (askReturn);
                    break;
                case 6:
                    hospitalMng.saveData();
                    break;
            }

        } while (choice != 7);

    }
}
