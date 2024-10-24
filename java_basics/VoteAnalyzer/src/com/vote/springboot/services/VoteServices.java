package com.vote.springboot.services;

import com.vote.springboot.dto.VoteDto;
import com.vote.springboot.entity.DuplicationVote;
import com.vote.springboot.entity.Vote;
import com.vote.springboot.repositories.VoteRepositories;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RequiredArgsConstructor
@Slf4j
@Service
public class VoteServices extends DefaultHandler implements CRUDServices<VoteDto> {

    @Autowired
    private final VoteRepositories voteRepositories;

    private final Collection<Vote> voteList = new HashSet<>();

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd");

    private String name = null;
    private String station = null;
    private Date birthDay = null;
    private Date time = null;
    private boolean isOk = false;



    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        VoteDto voteDto = new VoteDto();
        if (qName.equals("voter")) {
            name = attributes.getValue("name");
            try {
                birthDay = DATE_FORMAT.parse(attributes.getValue("birthDay"));
            } catch (ParseException e) {
                birthDay = null;
            }
            isOk = false;
        }

        if (qName.equals("visit")) {
            station = attributes.getValue("station");
            try {
                time = DATE_FORMAT.parse(attributes.getValue("time"));
            } catch (ParseException e) {
                time = null;
            }
            isOk = true;
        }

        voteDto.setName(name);
        voteDto.setBirthDay(birthDay);
        voteDto.setStation(station);
        voteDto.setTime(time);
        if (isOk) {
            voteList.add(mapToEntity(voteDto));
        }
    }


    @Override
    public VoteDto getById(Integer id) {
        log.info("Get by ID: " + id);
        return mapToDto(voteRepositories.findById(id).orElseThrow());
    }

    @Override
    public Collection<VoteDto> getAll() {
        log.info("Get all");
        return voteRepositories.findAll()
                .stream()
                .map(VoteServices::mapToDto)
                .toList();
    }

    public Collection<DuplicationVote> getAllDubVote() {
        log.info("Get all");
        Collection<DuplicationVote> duplicationVotesColl = new HashSet<>();
        DuplicationVote duplicationVote;
        List<String> voteDubList = voteRepositories.findAllDuplicateVotes();

        for (String vote : voteDubList) {
            String[] voteInfo = vote.split(",");
            duplicationVote = new DuplicationVote();
            duplicationVote.setStation(voteInfo[0]);
            duplicationVote.setName(voteInfo[1]);
            duplicationVote.setCount(Integer.valueOf(voteInfo[2]));
            duplicationVotesColl.add(duplicationVote);
        }

        return duplicationVotesColl;
    }

    @Override
    public void create(VoteDto item) {
        log.info("Create");
        Vote vote = mapToEntity(item);
        voteRepositories.save(vote);
    }

    @Override
    public void parseListInDataBase() {
        log.info("Parse list in data base");
        voteRepositories.saveAll(voteList);
    }


    @Override
    public void update(Integer id, VoteDto item) {
        log.info("Update");
        Vote vote = mapToEntity(item);
        voteRepositories.save(vote);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete " + id);
        voteRepositories.deleteById(id);
    }

    public Collection<DuplicationVote> findAllDuplicateVotesInDataBase() {
        Collection<DuplicationVote> duplicationVoteCollection = new HashSet<>();
        log.info("Find all duplicate votes");
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String user = "postgres";
        String pass = "admin";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT station, name, COUNT(name) FROM public.votes GROUP BY station, name HAVING COUNT(name) > 1");

            while (resultSet.next()) {
                DuplicationVote duplicationVote = new DuplicationVote();
                String name = resultSet.getString("name");
                String station = resultSet.getString("station");
                Integer count = Integer.valueOf(resultSet.getString("count"));
                duplicationVote.setName(name);
                duplicationVote.setStation(station);
                duplicationVote.setCount(count);
                System.out.println("name: " + name +
                        " - station: " + station +
                        " - count: " + count
                );
                duplicationVoteCollection.add(duplicationVote);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return duplicationVoteCollection;
    }

    public static VoteDto mapToDto(Vote vote) {
        VoteDto voteDto = new VoteDto();
        voteDto.setId(vote.getId());
        voteDto.setName(vote.getName());
        voteDto.setBirthDay(vote.getBirthDay());
        voteDto.setTime(vote.getTime());
        voteDto.setStation(vote.getStation());
        return voteDto;
    }

    public static Vote mapToEntity(VoteDto voteDto) {
        Vote vote = new Vote();
        vote.setId(voteDto.getId());
        vote.setName(voteDto.getName());
        vote.setBirthDay(voteDto.getBirthDay());
        vote.setTime(voteDto.getTime());
        vote.setStation(voteDto.getStation());
        return vote;
    }

    public void parsesFileInList() throws ParserConfigurationException, SAXException, IOException {
        String fileName = "Performance/VoteAnalyzer/res/data-1572M.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(fileName), this);
    }
}