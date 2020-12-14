package com.tpJava.colinTp.controller;

import com.tpJava.colinTp.model.Album;
import com.tpJava.colinTp.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/albums")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    //delete album
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable Integer id){
        albumService.deleteAlbum(id);
    }

    //add album
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Album addAlbum(@RequestBody Album album){
        return albumService.addAlbum(album);
    }


}
