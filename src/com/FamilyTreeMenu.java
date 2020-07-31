/**
 *
 */
package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;

import com.bean.Person;

/**
 * @author 502617154
 *
 */
public class FamilyTreeMenu {
    
    private final static Scanner scanner = new Scanner(System.in);
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        final List<Person> personList = new ArrayList<>();
        while (true) {
            System.out.println("Options: exit, create, show, show-all, link");
            final String opt = read().toLowerCase();
            if ("exit".equals(opt)) {
                break;
            } else if ("create".equals(opt)) {
                final Person persion = new Person();
                System.out.print("Name:\t");
                persion.getPersinalDetails().setName(read());
                personList.add(persion);
            } else if ("show".equals(opt)) {
                System.out.print("Whos data need to see :\t");
                final String personID = read();
                final Person selectedPerson = getPersonByID(personList, personID);
                if (selectedPerson == null) {
                    System.out.println("Wrong ID selected :(");
                }
                {
                    try {
                        final ObjectMapper objectMapper = new ObjectMapper();
                        final String jsonString =
                                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(selectedPerson);
                        System.out.println(jsonString);
                    } catch (final IOException e) {
                        System.err.println("Error:" + e.getMessage());
                    }
                }
            } else if ("show-all".equals(opt)) {
                for (final Person person : personList) {
                    final ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        final String jsonString =
                                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
                        System.out.println(jsonString);
                    } catch (final IOException e) {
                        System.err.println("Error:" + e.getMessage());
                    }
                }
            } else if ("link".equals(opt)) {
                System.out.print("Who need to update:\t");
                final String personID = read();
                if (!personID.isEmpty()) {
                    final Person selectedPerson = getPersonByID(personList, personID);
                    if (selectedPerson == null) {
                        System.out.println("Wrong ID selected :(");
                    } else {
                        System.out.print("what relation need to update (father/mother):\t");
                        final String relation = read().toLowerCase();
                        if (relation.isEmpty()) {
                            System.out.println("Wrong Relation selected :(");
                        } else if ("father".equals(relation)) {
                            System.out.print("what is father ID:\t");
                            final String fatherID = read();
                            final Person father = getPersonByID(personList, fatherID);
                            if (father == null) {
                                System.out.println("Not able to find the father by given ID(" + fatherID + ") :(");
                            } else {
                                selectedPerson.getRelationships().setFather(father);
                            }
                        } else if ("mother".equals(relation)) {
                            System.out.print("what is mother ID:\t");
                            final String motherID = read();
                            final Person mother = getPersonByID(personList, motherID);
                            if (mother == null) {
                                System.out.println("Not able to find the mother by given ID(" + motherID + ") :(");
                            } else {
                                selectedPerson.getRelationships().setMother(mother);
                            }
                        }
                    }
                }
            } else {
                System.out.println("Wrong Option :(");
            }
            System.out.println("==============================\n");
        }
    }
    
    private static Person getPersonByID(List<Person> personList, String personID) {
        Person selectedPerson = null;
        for (final Person person : personList) {
            if (person.getId().toString().equals(personID)) {
                selectedPerson = person;
                break;
            }
        }
        return selectedPerson;
    }
    
    private static String read() {
        final String inputString = scanner.nextLine();
        if (inputString == null) {
            return "";
        }
        return inputString;
    }
    
    @Override
    protected void finalize() throws Throwable {
        scanner.close();
        super.finalize();
    }
}
