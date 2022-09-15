package nl.argo360.crm.doa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@Table(name = "assets")
@NoArgsConstructor
@AllArgsConstructor
public class Asset {

    private enum Status {ACTIVE, ON_HOLD, SOLD, SOLD_OFFSITE, TEAR_DOWN, UPGRADE}

    @Id
    @Column(name = "asset_id", nullable = false)
    private Integer id;
    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    private Lot lot;
    private String status;
    private String clazz;

    private String serial;
    private String mfg;
    private String model;
    @Column(name = "part_number")
    private String partNumber;
    private String grade;

    private String channel;

    @Column(name = "upgrade_description")
    private String upgradeDescription;
    @Column(name = "audit_description")
    private String auditDescription;
    @Column(name = "functional_description")
    private String functionalDescription;
    @Column(name = "cosmetics_description")
    private String cosmeticsDescription;

    @Column(name = "on_shelf")
    private String onShelf;
    private String pallet;
    @Column(name = "warehouse")
    private String wareHouse;

    private String location;


    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", status=" + status +
                ", clazz='" + clazz + '\'' +
                ", mfg='" + mfg + '\'' +
                ", model='" + model + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
