package com.example.item.domain;

import com.example.brand.domain.Brand;
import com.example.category.domain.Category;
import com.example.persistence.VersionedEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Where(clause = "status=true")
@Entity
@Table(name = "tbl_item")
public class Item extends VersionedEntity {

    @Column(name = "name", nullable = false)
    String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brandId;

    @Column(name = "general", nullable = false)
    private String general;

    @Column(name = "status")
    private Boolean status;

    public Item() {
    }
}
