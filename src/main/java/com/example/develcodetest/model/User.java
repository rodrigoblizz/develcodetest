package com.example.develcodetest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "user_account")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private Date birthdate;

    @NotBlank
    private String photo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {   return name; }

    public void setName(String name) {  this.name = name;   }

    public Date getBirthdate() {    return birthdate;   }

    public void setBirthdate(Date birthdate) {  this.birthdate = birthdate; }

    public String getPhoto() {  return photo;   }

    public void setPhoto(String photo) {    this.photo = photo; }
}
