

package org.springframework.microservicesboot;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Team;


@RestController
public class WhateverIWant {

    private Team team;


    @RequestMapping("/hi")
    public Team hiThere() {

        return team;
    }

}
