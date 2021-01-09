package com.example.brand.domain;

import com.example.persistence.VersionedEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "tbl_brand")
public class Brand extends VersionedEntity {

    @Column(name = "name", nullable = false)
    private String name;

    public Brand(String name) {
        this.name = name;
    }

    public Brand() {
    }
}
