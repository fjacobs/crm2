package nl.argo360.crm.doa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Builder
@Entity
@Getter
@Setter
@ToString
@Table(name = "lots")
@NoArgsConstructor
@AllArgsConstructor
public class Lot {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "lot_id", nullable = false)
    private Integer id;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @OneToMany(
            mappedBy = "lot",
            cascade = CascadeType.ALL
    )
    private Set<Asset> assets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Lot lot = (Lot) o;
        return id != null && Objects.equals(id, lot.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
