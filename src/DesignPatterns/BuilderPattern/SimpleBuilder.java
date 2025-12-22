package DesignPatterns.BuilderPattern;

/**
 * While creating object with alot of parameters, we basically encounter below complications:
 *  - Immutability with setter and getters
 *  - Constructor overloading due to enormous number of variables to be set during object creation
 *  - Inconsistent data because might be some data is important for object creation but user did not provide that
 *  - Scattered validations to validate inconsistent data.
 *
 *  Builder patterns provide a builder class to build an object when there's enormous number of variables to be provided for object creation. Also it makes the object
 *  creation more maintainable and readable.
 */
class User {
    private final String name;
    private final String email;
    private final int age;
    private final String gender;

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.gender = builder.gender;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String email;
        private int age;
        private String gender;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public User build() {
            if (age < 0) {
                throw new IllegalStateException("Age cannot be negative");
            }
            if (email == null || !email.contains("@")) {
                throw new IllegalStateException("Invalid email");
            }
            return new User(this);
        }

    }
}

public class SimpleBuilder {
    public static void main(String[] args) {
        User user = User.builder()
                .name("Mayank")
                .age(24)
                .email("mayank@gmail.com")
                .gender("Male")
                .build();
    }
}