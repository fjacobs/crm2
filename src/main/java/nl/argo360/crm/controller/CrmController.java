package nl.argo360.crm.controller;

import nl.argo360.crm.doa.Account;
import nl.argo360.crm.repo.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CrmController {

    AccountRepository crmRepository;

    Logger log = LoggerFactory.getLogger(CrmController.class);

    public CrmController(AccountRepository crmRepository) {
        this.crmRepository = crmRepository;
    }

    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccounts() {
        return crmRepository.findAll();
    }


    @GetMapping("/getAccount")
    public Account getAccount(String accountName) {
        log.info("getAccount called with argument: {}", accountName);
        if (!crmRepository.findById(accountName).isPresent()) {
            log.info("Did not find {} in repository.............", accountName);
        } else {
            return crmRepository.findById(accountName).get();
        }

        return Account.builder().companyName("NOT FOUND").build();
    }

}
