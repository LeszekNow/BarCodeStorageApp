package com.leszeknowinski.BarCodeStorageApp.models;

import com.leszeknowinski.BarCodeStorageApp.models.forms.BarCodeForm;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "bar_code")
public class BarCodeEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "bar_code")
    private String barCode;
    @Column(name = "company_name")
    private String productCompany;
    @Column(name = "product_name")
    private String productName;
    private int weight;

    public BarCodeEntity(){}

    public BarCodeEntity(BarCodeForm barCodeForm){
        setProductName(barCodeForm.getProductName());
        setProductCompany(barCodeForm.getCompanyName());
        setBarCode(barCodeForm.getBarCode());
        setWeight(barCodeForm.getWeight());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarCodeEntity that = (BarCodeEntity) o;
        return id == that.id &&
                weight == that.weight &&
                Objects.equals(barCode, that.barCode) &&
                Objects.equals(productCompany, that.productCompany) &&
                Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, barCode, productCompany, productName, weight);
    }

    @Override
    public String toString() {
        return "BarCodeEntity{" +
                "id=" + id +
                ", barCode='" + barCode + '\'' +
                ", productCompany='" + productCompany + '\'' +
                ", productName='" + productName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
