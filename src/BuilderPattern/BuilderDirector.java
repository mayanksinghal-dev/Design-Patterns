package BuilderPattern;

/**
 * Builder with some predefined values for generic/common data
 */
class DirectorUser{
    public static User userWithoutGender(String name, int age, String email){
        return User.builder()
                .name(name)
                .email(email)
                .age(age)
                .build();
    }

    public static User maleUserWithNameAge(String name, int age){
        return User.builder()
                .name(name)
                .age(age)
                .gender("Male")
                .build();
    }
}
public class BuilderDirector {
    User user = DirectorUser.maleUserWithNameAge("Mayank",25);
}
