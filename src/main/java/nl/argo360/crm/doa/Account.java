package nl.argo360.crm.doa;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Builder
@Entity
@Getter
@Setter
@ToString
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @Column(name = "company_name")
    @EqualsAndHashCode.Include
    private String companyName;

    @ColumnDefault("0")
    @Column(name = "account_type")
    private ACCOUNT_TYPE accountType;
    @Column()
    private String phone;
    @Column()
    private String website;
    @Column()
    private String owner;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ToString.Exclude
    private Set<Contact> contacts;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ToString.Exclude
    private Set<Location> locations;

    @OneToMany(
            mappedBy = "account",
            cascade = CascadeType.ALL
    )
    @ToString.Exclude
    private Set<Lot> lots;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return companyName != null && Objects.equals(companyName, account.companyName);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public enum ACCOUNT_TYPE {ALL, VENDOR, DOWNSTREAM, UPSTREAM}
}
