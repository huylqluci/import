package com.example.orm;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sites")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "area")
    private Integer area;

    @Column(name = "image")
    private String image;

    @Column(name = "location")
    private String location;

    @Column(name = "logo")
    private String logo;

    @Column(name = "manager")
    private String manager;

    @Column(name = "name")
    private String name;

    @Column(name = "note")
    private String note;

    @Column(name = "pid")
    private Integer pid;

}