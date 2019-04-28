package OODEXE.BuilderPattern;

public class Driver {
    public static void main(String[] args) {
        User user = new User.UserBuilder("jay", "12345").setAddress("123").build();
        System.out.println(user);
    }
}
