

package demo.domain;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class Team {

    String name;
    String location;
    String mascotte;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teamId")
    Set<Player> players;

    public Team() {
    }

    public Team(String name, String location, Set<Player> players) {
        super();
        this.name = name;
        this.location = location;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMascotte() {
        return mascotte;
    }

    public void setMascotte(String mascotte) {
        this.mascotte = mascotte;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

}
