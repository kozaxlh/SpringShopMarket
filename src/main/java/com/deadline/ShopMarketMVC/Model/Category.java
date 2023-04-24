/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deadline.ShopMarketMVC.Model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCatagoryID", query = "SELECT c FROM Category c WHERE c.catagoryID = :catagoryID"),
    @NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name"),
    @NamedQuery(name = "Category.findByDescription", query = "SELECT c FROM Category c WHERE c.description = :description")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CatagoryID")
    private Integer catagoryID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Vegetable> vegetable;

    public Category() {
    }

    public Category(Integer catagoryID) {
        this.catagoryID = catagoryID;
    }

    public Category(Integer catagoryID, String name) {
        this.catagoryID = catagoryID;
        this.name = name;
    }

    public Integer getCatagoryID() {
        return catagoryID;
    }

    public void setCatagoryID(Integer catagoryID) {
        this.catagoryID = catagoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Vegetable> getVegetable() {
        return vegetable;
    }

    public void setVegetable(List<Vegetable> vegetable) {
        this.vegetable = vegetable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catagoryID != null ? catagoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.catagoryID == null && other.catagoryID != null) || (this.catagoryID != null && !this.catagoryID.equals(other.catagoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Category[ catagoryID=" + catagoryID + " ]";
    }
    
}
