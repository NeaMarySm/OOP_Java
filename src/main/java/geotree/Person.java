package geotree;

import java.time.LocalDateTime;

public class Person implements Comparable<Person> {
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

    public int getAge() {
        return LocalDateTime.now().getYear() - birthYear;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, age: %d", firstName, lastName, gender, getAge());
    }
    @Override
    public int hashCode(){
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            return this.firstName.equals(((Person) obj).getFirstName())
                    && this.lastName.equals(((Person) obj).getLastName())
                    && this.birthYear == ((Person) obj).getBirthYear();
        }
    }

    @Override
    public int compareTo(Person o) {
        return this.birthYear - o.getBirthYear();
    }
}
