

package microservices;


import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import demo.dao.TeamDao;
import demo.domain.Player;
import demo.domain.Team;


@EntityScan("demo.domain")
@SpringBootApplication
@EnableJpaRepositories(basePackages = { "demo.dao" })
public class MicroservicesBootApplication extends SpringBootServletInitializer {

    @Autowired
    TeamDao teamDao;

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

        Team team = new Team("Peanuts", "California", players);
        teamDao.save(team);
    }
}
