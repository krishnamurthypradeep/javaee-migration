package com.myapp.api;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Example JPA entity.
 *
 * To use it, get access to a JPA EntityManager via injection.
 *
 * {@code
 *     @Inject
 *     EntityManager em;
 *
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         em.persist(entity1);
 *
 *         List<MyEntity> entities = em.createQuery("from MyEntity", MyEntity.class).getResultList();
 *     }
 * }
 */
@Entity
@Table(name = "newproducts")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PRODUCT_ID")
    public Integer id;

    @Column(name="PRODUCT_NAME")
    public String productName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) && productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", productName='").append(productName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
