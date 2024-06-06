package com.example.rating.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity(name = "rating")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rating {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "user_Id")
    String userId;
    @Column(name = "description")
    String description;
    @Column(name = "rating")
    int rating;

}
