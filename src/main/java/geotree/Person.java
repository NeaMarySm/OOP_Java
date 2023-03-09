package geotree;

import java.time.LocalDateTime;

public class Person {
    private String firstName;
    private String lastName;
    private int birthYear;
    private Gender gender;

    public Person(String firstName, String lastName, int birthYear, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Gender getGender() {
        return gender;
    }
    public int getAge(){
        return LocalDateTime.now().getYear()-birthYear;
    }

    @Override
    public String toString() {
        return String.format("\n%s %s, %s, age: %d", firstName, lastName, gender, getAge());
    }
    public boolean equals(Person person){
        return firstName.equals(person.getFirstName()) && lastName.equals(person.getLastName()) && person.getBirthYear() == birthYear;
    }

}
