package com.vote.springboot.repositories;


import com.vote.springboot.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VoteRepositories extends JpaRepository<Vote, Integer> {
    @Query(
            value = "select station, name, count(*) from votes group by station, name HAVING COUNT(*) > 1",
            nativeQuery = true
    )
    List<String> findAllDuplicateVotes();
}