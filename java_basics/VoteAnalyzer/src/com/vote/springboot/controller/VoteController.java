package com.vote.springboot.controller;

import com.vote.springboot.entity.DuplicationVote;
import com.vote.springboot.services.VoteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Collection;

@RequestMapping(path = "/path")
@RestController
@RequiredArgsConstructor
public class VoteController {
    private final VoteServices voteServices;

    @PostMapping(path = "/parseInList")
    public ResponseEntity<?> parseFileInList() throws ParserConfigurationException, IOException, SAXException {
        voteServices.parsesFileInList();
        return ResponseEntity.status(HttpStatus.CREATED).body("File Parse in List");
    }

    @PostMapping(path = "/parseInDataBase")
    public ResponseEntity<?> parseListInDataBase() {
        voteServices.parseListInDataBase();
        return ResponseEntity.status(HttpStatus.CREATED).body("File Parse in Data Base");
    }

    @GetMapping(path = "/getAllDuplicateVotesInDataBase")
    public ResponseEntity<Collection<DuplicationVote>> findAllDuplicateVotesInDataBase(){
        Collection<DuplicationVote> allDuplicateVotes = voteServices.findAllDuplicateVotesInDataBase();
        if (allDuplicateVotes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allDuplicateVotes);
        }
        return ResponseEntity.ok(allDuplicateVotes);
    }

    @GetMapping(path = "/get")
    public ResponseEntity<Collection<DuplicationVote>> findAllDuplicateVotes() {
        Collection<DuplicationVote> allDubVote = voteServices.getAllDubVote();
        if (allDubVote.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allDubVote);
        }
        return ResponseEntity.ok(allDubVote);
    }
}