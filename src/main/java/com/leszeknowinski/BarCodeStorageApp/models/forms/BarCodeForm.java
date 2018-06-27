package com.leszeknowinski.BarCodeStorageApp.models.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class BarCodeForm {
    @Size(min = 13, max = 13)
    private String barCode;
    @Max(25)
    private String companyName;
    @Max(25)
    private String productName;
    private int weight;

    public BarCodeForm(){}

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
}
