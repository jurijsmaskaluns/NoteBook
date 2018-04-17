package javacourses;

import java.time.LocalDate;

public class Pet extends Record {
    private String name;
    private String species;
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        String strBirthday = Main.DATE_FORMATTER.format(birthday);
        return "Pet{" +
                "id= " + getId() +
                "name= '" + name + '\'' +
                ", species= '" + species + '\'' +
                ", birthday= " + strBirthday +
                '}';
    }

    @Override
    public void askUserData() {
        String name = Main.askString("Name: ");
        String species = Main.askString("Species: ");
        LocalDate birthday = Main.askDate("Enter birthday date");

        setBirthday(birthday);
        setName(name);
        setSpecies(species);
    }

    @Override
    public boolean contains(String part) {
        return false;
    }
}
