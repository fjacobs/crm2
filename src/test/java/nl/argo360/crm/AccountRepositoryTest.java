package nl.argo360.crm;

import nl.argo360.crm.doa.*;
import nl.argo360.crm.repo.AccountRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class AccountRepositoryTest {
    @Autowired
    AccountRepository repository;

    @BeforeEach
    void init_database() {
        repository.save(ObjectMother.twoAccountsWithFourContacts().get(0));
        repository.save(ObjectMother.twoAccountsWithFourContacts().get(1));
    }

    @AfterEach
    void after_all() {
        repository.deleteAll();
    }

    @Test
    void account_test() {
        if (repository.findById("Equinix").isEmpty()) {
            fail("Account was not inserted in the database.....................");
        }

        var dbAccount = repository.findById("Equinix").get();

        assertThat(dbAccount.getCompanyName()).isEqualTo("Equinix");
        assertThat(dbAccount.getAccountType()).isEqualTo(Account.ACCOUNT_TYPE.ALL);
        assertThat(dbAccount.getPhone()).isEqualTo("+31612345678");
        assertThat(dbAccount.getOwner()).isEqualTo("Victor Jansma");
        assertThat(dbAccount.getWebsite()).isEqualTo("https://www.equinix.nl");
    }

    @Test
    void account_equinix_should_have_two_contacts() {
        if (repository.findById("Equinix").isEmpty()) {
            fail("DB Table account was expected to have a row named Equinix");
        }
        var dbAccount = repository.findById("Equinix").get();

        if (dbAccount.getContacts().size() != 2) {
            fail("DB table account.contact is expected to have two contacts");
        }

        Contact dbContact = dbAccount.getContacts().
                stream().filter(contact -> contact.getFirstName().equals("John")).findFirst().get();

        assertThat(dbContact.getTitle()).isEqualTo("Project Manager Infrastructure Services");
        assertThat(dbContact.getType()).isEqualTo(Contact.Type.ONSITE);
        assertThat(dbContact.getFirstName()).isEqualTo("John");
        assertThat(dbContact.getLastName()).isEqualTo("Doe");
        assertThat(dbContact.getEmail()).isEqualTo("email@test.nl");
        assertThat(dbContact.getPhone()).isEqualTo("31609876543");
    }

    @Test
    void account_coolblue_should_have_the_location_rotterdam() {
        if (repository.findById("Coolblue").isEmpty()) {
            fail("DB Table account was expected to have a row named Coolblue");
        }
        var dbAccount = repository.findById("Coolblue").get();

        if (dbAccount.getLocations().isEmpty()) {
            fail("DB Table account.locations is not expected to be empty");
        }
        var dbLocation1 = dbAccount.getLocations().stream().findFirst().get();
        assertThat(dbLocation1.getName()).isEqualTo("Vestiging Rotterdam");
        assertThat(dbLocation1.getCountry()).isEqualTo("The Netherlands");
        assertThat(dbLocation1.getCity()).isEqualTo("Rotterdam");
        assertThat(dbLocation1.getAddress()).isEqualTo("Weena 664");
        assertThat(dbLocation1.getPostalCode()).isEqualTo("3012 CN");
        assertThat(dbLocation1.getPhone()).isEqualTo("010 - 742 17 54 ");
    }

    @Test
    void account_coolblue_should_have_lot_11231() {
        if (repository.findById("Coolblue").isEmpty()) {
            fail("DB Table account was expected to have a row named Coolblue");
        }
        var dbAccount = repository.findById("Coolblue").get();

        if (dbAccount.getLots().isEmpty()) {
            fail("DB Table account.locations is not expected to be empty");
        }
        Lot lot = dbAccount.getLots().stream().findFirst().get();
        assertThat(lot.getId()).isEqualTo(11231);
    }

    @Test
    void account_coolblue_should_have_lot_11231_with_two_assets() {
        if (repository.findById("Coolblue").isEmpty()) {
            fail("DB Table 'account' was expected to have a row named 'Coolblue'");
        }
        var dbAccount = repository.findById("Coolblue").get();

        if (dbAccount.getLots().isEmpty()) {
            fail("DB Table 'account.locations' is not expected to be empty");
        }

        Lot lot = dbAccount.getLots().stream().findFirst().get();
        assertTrue(lot.getAssets().stream().anyMatch(asset -> asset.getId() == 555555));
        assertTrue(lot.getAssets().stream().anyMatch(asset -> asset.getId() == 666666));
    }
}

