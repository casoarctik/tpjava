package com.tpJava.colinTp.repository;

import com.tpJava.colinTp.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

    @Query(value = "SELECT * FROM artist WHERE artist.name LIKE CONCAT ('%',:name,'%')", nativeQuery = true)
    List<Artist> findByNameWord(@Param("name")String name);

    Artist findByName(String name);

}
