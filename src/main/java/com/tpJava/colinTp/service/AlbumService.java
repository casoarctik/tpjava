package com.tpJava.colinTp.service;

import com.tpJava.colinTp.model.Album;
import com.tpJava.colinTp.repository.AlbumRepository;
import com.tpJava.colinTp.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ArtistRepository artistRepository;

    //delete album
    public void deleteAlbum(Integer id) {
        albumRepository.deleteById(id);
    }

    //add album
    public Album addAlbum(Album album){
        if (albumRepository.findByTitle(album.getTitle()) != null){
            throw new EntityExistsException("Cet album existe déjà");
        }
        if (artistRepository.findByName(album.getArtist().getName()) == null){
            throw new EntityNotFoundException("Cet artiste n'existe pas");
        }
        return albumRepository.save(album);
    }

}
