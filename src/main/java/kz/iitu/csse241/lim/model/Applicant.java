package kz.iitu.csse241.lim.model;

public class Applicant {
    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;


    public Applicant(Long userId, String firstName, String lastName, String phone) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Applicant() {
        this.userId = Long.valueOf(-1);
        this.firstName = "";
        this.lastName = "";
        this.phone = "";
    }


    public Long getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }


    public void setUserId(Long userId) { this.userId = userId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhone(String phone) { this.phone = phone; }
}
