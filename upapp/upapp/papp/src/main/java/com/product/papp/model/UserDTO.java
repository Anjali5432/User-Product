package com.product.papp.model;
public class UserDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int pid; // Assuming this is the product ID associated with the user

  
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    
    public UserDTO() {
    }

   
    public UserDTO(long id, String firstName, String lastName, String email, int age, int pid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "User DTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", age=" + age + ", pid=" + pid + "]";
    }
}