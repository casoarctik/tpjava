package com.tpJava.colinTp.service;

import com.tpJava.colinTp.model.Album;
import com.tpJava.colinTp.model.Artist;
import com.tpJava.colinTp.repository.AlbumRepository;
import com.tpJava.colinTp.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    AlbumRepository albumRepository;

    //display an artist
    public Artist findById(Integer id){
        Optional<Artist> artist = artistRepository.findById(id);
        if (artist.isEmpty()){
            throw new EntityNotFoundException("Aucun artiste ne correspond (identifiant inconnu)");
        }
        return artist.get();
    }

    //find artist in search bar
    public List<Artist> findByNameWord(String name){
        List<Artist> artistList = artistRepository.findByNameWord(name);
        if (artistList.isEmpty()){
            throw new EntityNotFoundException("La recherche n'a donné aucun résultat");
        }
        return artistList;
    }


    //delete artist
    public void deleteArtist(Integer id){
        List<Album> albumList = albumRepository.findByArtistId(id);
        if (artistRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException("Echec de l'annulation, l'artiste est introuvable");
        }
        //delete albums of the artist to delete
        if (albumList.isEmpty()){
            throw new EntityNotFoundException("l'artiste n'a pas d'albums à supprimer");
        }else{
            for (Album album : albumList){
                albumRepository.deleteById(album.getId());
            }
        }
        artistRepository.deleteById(id);
    }

    //add artist
    public Artist addArtist(Artist artist){
        if (artistRepository.findByName(artist.getName()) != null){
            throw new EntityExistsException("Cet artiste est déjà renseigné");
        }
        return artistRepository.save(artist);
    }

    //update artist
    public Artist updateArtiste(Artist artist){
        if (artistRepository.findById(artist.getId()).isEmpty()){
            throw new EntityNotFoundException("Echec de la modification, cet artiste est introuvable");
        }
        return artistRepository.save(artist);
    }

    //list artist (pagination)
    public Page<Artist> listArtists(Integer page, Integer size, String sortProperty, String sortDirection){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortProperty);
       return artistRepository.findAll(pageRequest);
    }


}
