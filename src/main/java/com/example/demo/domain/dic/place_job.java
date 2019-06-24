package com.example.demo.domain.dic;


import com.example.demo.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "place_job")
@Data
@NoArgsConstructor
@ToString(of = {"id"})
public class place_job {

    @Id
    @Column(name = "id")
    @JsonView(Views.Id.class)
    private Long id;

    @Column(name = "name", length = 50)
    @JsonView(Views.IdName.class)
    private String name;


    public place_job(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
