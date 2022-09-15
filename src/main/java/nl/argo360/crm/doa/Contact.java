package nl.argo360.crm.doa;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "title")
    private String title;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private Type type;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "contacts")
    private Set<Account> account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Contact contact = (Contact) o;
        return id != null && Objects.equals(id, contact.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public enum Type {ONSITE, BILLING, SALES, CERTIFICATE, OTHER, UNIVERSAL}

}
