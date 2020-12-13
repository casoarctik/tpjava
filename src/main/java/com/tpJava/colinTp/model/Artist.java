package com.tpJava.colinTp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "artist")
@JsonIgnoreProperties("artist")
public class Artist {

    //attribut
    @OneToMany(mappedBy = "artist")
    //albums
    private List<Album> albums;

    //artist id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    //artist name
    @Column(name = "name")
    String name;


    // auto-generated constructor
    public Artist(List<Album> albums, String name) {
        this.albums = albums;
        this.name = name;
    }
    public Artist() {
    }

    //auto-generated getter and setter
    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
