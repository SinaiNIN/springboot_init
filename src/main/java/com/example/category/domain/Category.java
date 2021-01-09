package com.example.category.domain;

import com.example.persistence.VersionedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Table(name = "tbl_category")
@Setter
@Getter
@AllArgsConstructor
@Entity
public class Category extends VersionedEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @JoinColumn(name = "parent_id")
    private Integer parentId;

    public Category() {
    }
}
