package nl.argo360.crm.config;


import nl.argo360.crm.doa.Account;
import nl.argo360.crm.repo.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalTime;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AccountRepository repository) {
        return args -> {
            repository.save(Account.builder().companyName("Equinix").build());
        };
    }
}


//            log.info("Preloading " + repository.save(new Flight("B101", Flight.LOCATION.AMS, Flight.LOCATION.BOM, LocalTime.of(12, 0), LocalTime.of(19, 30), new BigDecimal(750))));
//                    repository.save(new Flight("C101", Flight.LOCATION.AMS, Flight.LOCATION.BLR, LocalTime.of(13, 0), LocalTime.of(18, 30), new BigDecimal(800)));
//                    repository.save(new Flight("D101", Flight.LOCATION.AMS, Flight.LOCATION.MAA, LocalTime.of(9, 0), LocalTime.of(15, 0), new BigDecimal(600)));
//                    repository.save(new Flight("E101", Flight.LOCATION.MAA, Flight.LOCATION.BOM, LocalTime.of(16, 0), LocalTime.of(17, 30), new BigDecimal(100)));
//                    repository.save(new Flight("F101", Flight.LOCATION.BOM, Flight.LOCATION.DEL, LocalTime.of(20, 30), LocalTime.of(21, 30), new BigDecimal(80)));
//                    repository.save(new Flight("G101", Flight.LOCATION.BOM, Flight.LOCATION.DEL, LocalTime.of(18, 0), LocalTime.of(19, 30), new BigDecimal(100)));
//                    repository.save(new Flight("A201", Flight.LOCATION.LHR, Flight.LOCATION.DEL, LocalTime.of(11, 30), LocalTime.of(17, 0), new BigDecimal(600)));
//                    repository.save(new Flight("B201", Flight.LOCATION.LHR, Flight.LOCATION.BOM, LocalTime.of(12, 35), LocalTime.of(19, 30), new BigDecimal(750)));
//                    repository.save(new Flight("C201", Flight.LOCATION.LHR, Flight.LOCATION.BLR, LocalTime.of(13, 45), LocalTime.of(18, 30), new BigDecimal(800)));
//                    repository.save(new Flight("D201", Flight.LOCATION.LHR, Flight.LOCATION.MAA, LocalTime.of(9, 0), LocalTime.of(15, 0), new BigDecimal(600)));
//                    repository.save(new Flight("E201", Flight.LOCATION.DEL, Flight.LOCATION.BOM, LocalTime.of(18, 45), LocalTime.of(20, 15), new BigDecimal(100)));
//                    repository.save(new Flight("F201", Flight.LOCATION.BOM, Flight.LOCATION.DEL, LocalTime.of(21, 15), LocalTime.of(22, 30), new BigDecimal(80)));
//                    repository.save(new Flight("G01", Flight.LOCATION.BOM, Flight.LOCATION.DEL, LocalTime.of(20, 20), LocalTime.of(22, 30), new BigDecimal(100)));
