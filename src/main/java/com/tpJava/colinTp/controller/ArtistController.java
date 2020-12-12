package com.tpJava.colinTp.controller;

import com.tpJava.colinTp.model.Artist;
import com.tpJava.colinTp.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/artists")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    //find artist
    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Artist findById(@PathVariable(value = "id") Integer id){
        return artistService.findById(id);
    }

    //find artist by search bar
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
            params = "name")
    public List<Artist> findByName(@RequestParam("name") String name){
        return artistService.findByNameWord(name);
    }

    // delete artist
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteArtist(@PathVariable Integer id){
        artistService.deleteArtist(id);
    }

    //add artist
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Artist addArtist(@RequestBody Artist artist){
        return artistService.addArtist(artist);
    }

    //update artist (with put)
    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Artist updateArtist(@PathVariable Integer id, @RequestBody Artist artist){
        return artistService.updateArtiste(artist);
    }

    //list artists with pagination
    @RequestMapping(value ="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Artist> listArtists (@RequestParam("") Integer page, @RequestParam("") Integer size,
                                     @RequestParam("") String sortProperty, @RequestParam("") String sortDirection){
        return  artistService.listArtists(page, size, sortProperty, sortDirection);
    }


}
