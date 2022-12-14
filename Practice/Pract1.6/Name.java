
package pract1_6;

/**
 *
 * @author Ilia_Dukhov
 */
public class Name {
    private String name;
    private String surname; 
    private String secondname;

    public Name(String name){
        this.name = name;
    }
    public Name(String name, String surname){
        this(name);
        this.surname = surname;
    }
    public Name(String name, String surname, String secondname){
        if (name == null){
            this.name = "";
        }else{
            this.name = name;
        }
        if (surname == null){
            this.surname = "";
        }else{
            this.surname = surname;
        }
        if (secondname == null){
            this.secondname = "";
        }else{
            this.secondname = secondname;
        }
        
        if (this.name.isEmpty() && this.surname.isEmpty() && this.secondname.isEmpty()){
            throw new IllegalArgumentException();
        }
    }
   public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSecondname(String patronymic) {
        this.secondname = patronymic;
    }

    public String toString() {
        return String.format("%s %s %s", name, surname, secondname);
    }
    
}
