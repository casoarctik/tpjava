package com.tpJava.colinTp.repository;

import com.tpJava.colinTp.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    Album findByTitle(String title);

    List<Album> findByArtistId(Integer id);
}
