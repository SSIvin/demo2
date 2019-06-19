package com.example.demo.domain.dic;


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
    private Long id;

    @Column(name = "name", length = 50)
    private String name;


    public place_job(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
