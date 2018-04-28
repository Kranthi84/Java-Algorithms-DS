package com.kranthi.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob14_3 {


    public static void main(String[] args) {

        List<Name> namesList = new ArrayList<>();
        namesList.add(new Name("Ivan", "Bald"));
        namesList.add(new Name("Prat", "Bachali"));
        namesList.add(new Name("PeddiReddy", "Chinnakotla"));
        namesList.add(new Name("Medha", "Chinnakotla"));
        namesList.add(new Name("Medha", "Bachali"));
        namesList.add(new Name("Ivan", "Eliminate"));

        Collections.sort(namesList, Collections.reverseOrder());

        int result = 0;

        for (int first = 1; first < namesList.size(); ++first) {
            if (!namesList.get(first).firstName.equals(namesList.get(result).firstName)) {
                namesList.set(++result, namesList.get(first));
            }
        }
        namesList.subList(++result, namesList.size()).clear();

        for (Name name : namesList) {
            System.out.println(name);
        }
    }

    static class Name implements Comparable<Name> {


        String firstName, lastName;

        @Override
        public String toString() {
            return "Name{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public int compareTo(Name o) {

            int cFirst = o.firstName.compareTo(this.firstName);
            if (cFirst != 0) {
                return cFirst;
            }

            return o.lastName.compareTo(this.lastName);
        }
    }
}
