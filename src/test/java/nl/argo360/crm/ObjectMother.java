package nl.argo360.crm;

import nl.argo360.crm.doa.*;

import java.util.List;
import java.util.Set;

public class ObjectMother {

    public static List<Account> twoAccountsWithFourContacts() {
        Contact contact1 = Contact.builder()
                .title("Project Manager Infrastructure Services")
                .type(Contact.Type.ONSITE)
                .firstName("John")
                .lastName("Doe")
                .email("email@test.nl")
                .phone("31609876543")
                .build();

        Contact contact2 = Contact.builder()
                .title("Account Manager")
                .type(Contact.Type.SALES)
                .firstName("Mary")
                .lastName("Jane")
                .email("mary@yahoo.nl")
                .phone("0355240985")
                .build();

        Contact contact3 = Contact.builder()
                .title("Title 3")
                .type(Contact.Type.BILLING)
                .firstName("FirstName3")
                .lastName("LastName3")
                .email("email3@test3.nl")
                .phone("316333333333")
                .build();

        Contact contact4 = Contact.builder()
                .title("Title 4")
                .type(Contact.Type.CERTIFICATE)
                .firstName("FirstName3")
                .lastName("LastName3")
                .email("email3@test3.nl")
                .phone("316333333333")
                .build();


        Account account1 = Account.builder()
                .companyName("Equinix")
                .accountType(Account.ACCOUNT_TYPE.ALL)
                .phone("+31612345678")
                .owner("Victor Jansma")
                .website("https://www.equinix.nl")
                .contacts(Set.of(contact2, contact1))
                .build();

        Location location1 = Location.builder()
                .name("Vestiging Rotterdam")
                .country("The Netherlands")
                .city("Rotterdam")
                .address("Weena 664")
                .postalCode("3012 CN")
                .phone("010 - 742 17 54 ")
                .build();

        Account account2 = Account.builder()
                .companyName("Coolblue")
                .accountType(Account.ACCOUNT_TYPE.ALL)
                .phone("+31698888888")
                .owner("Dylan Klein")
                .website("https://www.coolblue.nl")
                .contacts(Set.of(contact3, contact4))
                .locations(Set.of(location1))
                .build();

        Lot lot = Lot.builder().id(11231).build();

        Asset asset1 = Asset.builder()
                .id(555555)
                .mfg("Dell")
                .clazz("Laptop")
                .grade("A")
                .partNumber("Latitude e5400")
                .partNumber("XAZUUU")
                .serial("3242332321")
                .build();


        Asset asset2 = Asset.builder()
                .id(666666)
                .mfg("HP")
                .clazz("Laptop")
                .grade("A")
                .partNumber("Rox")
                .partNumber("#fSKJJAS")
                .build();
        lot.setAssets(Set.of(asset1, asset2));

        account2.setLots(Set.of(lot));
        account2.setLocations(Set.of(location1));

        return List.of(account1, account2);
    }



}
