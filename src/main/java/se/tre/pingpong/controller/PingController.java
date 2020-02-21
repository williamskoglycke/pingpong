package se.tre.pingpong.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class PingController {

    @GetMapping(
            path = "/ping",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String ping() {
        log.info("ping called");
        return "pong";
    }

    @GetMapping(
            path = "/echo/{echo}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String echo(@PathVariable final String echo) {
        log.info("echo called with parameters");
        return echo;
    }

}
