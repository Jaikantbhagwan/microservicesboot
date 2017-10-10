

package org.springframework.microservicesboot;


import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import demo.dao.TeamDao;
import demo.domain.Player;
import demo.domain.Team;


@SpringBootApplication
public class MicroservicesBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesBootApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(MicroservicesBootApplication.class);
    }

    @PostConstruct
    public void init() {
        Set<Player> players = new HashSet<>();

        players.add(new Player("Jaikant", "'pitcher"));
        players.add(new Player("Srikant", "'shortstop"));

        Team team = new Team("California", "Peanuts", players);
        teamDao.save(team);
    }

    @Autowired
    TeamDao teamDao;


}
