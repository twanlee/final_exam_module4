package finalexammodule4.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String cityName;
//    @ManyToOne
//    @JoinColumn(name = "country_id")
    private String country;
    private Long area;
    private Long population;
    private Long gdp;
    @NotEmpty
    private String description;

}
