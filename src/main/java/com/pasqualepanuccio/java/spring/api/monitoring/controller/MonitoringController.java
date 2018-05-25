package com.pasqualepanuccio.java.spring.api.monitoring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitoringController {

    private static final Logger log = LogManager.getLogger(MonitoringController.class);

    @RequestMapping(value = "/echo")
    public ResponseEntity<String> echo(@RequestBody String body, @RequestHeader HttpHeaders headers) {
        log.info("Received Request");
        log.info("HEADERS");
        headers.entrySet().forEach(a -> {
            log.info(a.getKey() + ":" + a.getValue());
        });

        log.info("BODY");
        log.info(body);

        return ResponseEntity.ok(body);
    }
}
