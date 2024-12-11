package com.micro.user.service.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name="userTable")
public class User {
    @Id
    private String userId;
    private String userName;
    private String userEmail;
    private String aboutUser;
    @Transient
    //private List<Rating> ratingList; this results in null
    private List<Rating> ratingList=new ArrayList<>();
}
