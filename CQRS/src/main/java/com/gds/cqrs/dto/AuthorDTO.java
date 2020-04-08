package com.gds.cqrs.dto;

import java.util.Objects;

/**
 * This is a DTO (Data Transfer Object) author, contains only useful information to be returned.
 */
public class AuthorDTO {

    private String name;
    private String email;
    private String username;

    /**
     * Constructor.
     *
     * @param name     name of the author
     * @param email    email of the author
     * @param username username of the author
     */
    public AuthorDTO(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public AuthorDTO() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthorDTO)) {
            return false;
        }
        AuthorDTO other = (AuthorDTO) obj;
        return username.equals(other.getUsername()) && email.equals(other.getEmail()) && name
                .equals(other.getName());

    }

}
