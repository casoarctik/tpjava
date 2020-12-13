package com.tpJava.colinTp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "album")
public class Album {

    //attribut
    @ManyToOne
    @JoinColumn(name = "artistId")
    private Artist artist;

    //album id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    //album title
    String title;

    // auto-generated constructor
    public Album(String title) {
        this.title = title;
    }

    public Album(Artist artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    public Album() {
    }

    //auto-generated getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
