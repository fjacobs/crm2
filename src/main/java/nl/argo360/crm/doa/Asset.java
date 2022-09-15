package nl.argo360.crm.doa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@ToString
@Table(name = "assets")
@NoArgsConstructor
@AllArgsConstructor
public class Asset {

    private enum Status {ACTIVE, ON_HOLD, SOLD, SOLD_OFFSITE, TEAR_DOWN, UPGRADE}

    @Id
    @Column(name = "asset_id", nullable = false)
    private Integer id;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne
    private Lot lot;

    private Status status;
    private String clazz;
    private String serial;
    private String mfg;
    private String model;

    @Column(name = "part_number")
    private String partNumber;
    private String grade;
}
