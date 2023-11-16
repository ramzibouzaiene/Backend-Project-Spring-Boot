package com.graduation.graProject.Offers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.graduation.graProject.User.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OFFERS")
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;
    private String link;
    @ManyToMany(mappedBy = "offersRelated")
    List<UserEntity> userRelated;
}
