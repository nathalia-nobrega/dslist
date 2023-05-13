package com.nathalia.dslist;

import com.nathalia.dslist.services.impl.GameListServiceImpl;
import com.nathalia.dslist.services.impl.GameServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DslistApplication {

    private static final Logger LOG = LoggerFactory.getLogger(DslistApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DslistApplication.class, args);
    }

    @Bean
    CommandLineRunner printGameList(GameListServiceImpl gameService) {
        return args -> {
            LOG.info("List: " + gameService.move(2L, 0, 3));

        };
    }

}
