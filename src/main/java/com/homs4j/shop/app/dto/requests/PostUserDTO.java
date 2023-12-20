package com.homs4j.shop.app.dto.requests;

import com.homs4j.shop.app.models.User;

public class PostUserDTO {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String email;
    private final String password;

    private static PostUserDTO ofEntity(User user){
        return new Builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    private static User toEntity(PostUserDTO dto){
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUsername(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private PostUserDTO(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        userName = builder.userName;
        email = builder.email;
        password = builder.password;
    }


    public static final class Builder {
        private String firstName;
        private String lastName;
        private String userName;
        private String email;
        private String password;

        public Builder() {
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public PostUserDTO build() {
            return new PostUserDTO(this);
        }
    }
}
