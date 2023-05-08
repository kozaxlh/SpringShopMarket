/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deadline.ShopMarketMVC.Model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "vegetable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vegetable.findAll", query = "SELECT v FROM Vegetable v"),
    @NamedQuery(name = "Vegetable.findByVegetableID", query = "SELECT v FROM Vegetable v WHERE v.vegetableID = :vegetableID"),
    @NamedQuery(name = "Vegetable.findByCatagoryID", query = "SELECT v FROM Vegetable v WHERE v.catagoryID = :catagoryID"),
    @NamedQuery(name = "Vegetable.findByVegetableName", query = "SELECT v FROM Vegetable v WHERE v.vegetableName = :vegetableName"),
    @NamedQuery(name = "Vegetable.findByUnit", query = "SELECT v FROM Vegetable v WHERE v.unit = :unit"),
    @NamedQuery(name = "Vegetable.findByAmount", query = "SELECT v FROM Vegetable v WHERE v.amount = :amount"),
    @NamedQuery(name = "Vegetable.findByImage", query = "SELECT v FROM Vegetable v WHERE v.image = :image"),
    @NamedQuery(name = "Vegetable.findByPrice", query = "SELECT v FROM Vegetable v WHERE v.price = :price")})
public class Vegetable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VegetableID")
    private Integer vegetableID;
    
    @Basic(optional = false)
    @Column(name = "CatagoryID")
    private Integer catagoryID;
    
    @Basic(optional = false)
    @Column(name = "VegetableName")
    private String vegetableName;
    
    @Basic(optional = false)
    @Column(name = "Unit")
    private String unit;
    
    @Basic(optional = false)
    @Column(name = "Amount")
    private Integer amount;
    
    @Basic(optional = false)
    @Column(name = "Image")
    private String image;
    
    @Basic(optional = false)
    @Column(name = "Price")
    private Float price;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CatagoryID" , insertable=false, updatable=false)
    private Category category;
    
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "vegetable")
    private List<OrderDetail> orderdetailList;

    public Vegetable() {
    }

    public Vegetable(Integer vegetableID) {
        this.vegetableID = vegetableID;
    }

    public Vegetable(Integer vegetableID, int catagoryID, String vegetableName, String unit, int amount, String image, float price) {
        this.vegetableID = vegetableID;
        this.catagoryID = catagoryID;
        this.vegetableName = vegetableName;
        this.unit = unit;
        this.amount = amount;
        this.image = image;
        this.price = price;
    }

    public Integer getVegetableID() {
        return vegetableID;
    }

    public void setVegetableID(Integer vegetableID) {
        this.vegetableID = vegetableID;
    }

    public int getCatagoryID() {
        return catagoryID;
    }

    public void setCatagoryID(int catagoryID) {
        this.catagoryID = catagoryID;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @XmlTransient
    public List<OrderDetail> getOrderdetailList() {
        return orderdetailList;
    }

    public void setOrderdetailList(List<OrderDetail> orderdetailList) {
        this.orderdetailList = orderdetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vegetableID != null ? vegetableID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vegetable)) {
            return false;
        }
        Vegetable other = (Vegetable) object;
        if ((this.vegetableID == null && other.vegetableID != null) || (this.vegetableID != null && !this.vegetableID.equals(other.vegetableID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Vegetable[ vegetableID=" + vegetableID + " ]";
    }
    
}
