/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deadline.ShopMarketMVC.Model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o"),
    @NamedQuery(name = "Order.findByOrderID", query = "SELECT o FROM Order o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "Order.findByDate", query = "SELECT o FROM Order o WHERE o.date = :date"),
    @NamedQuery(name = "Order.findByTotal", query = "SELECT o FROM Order o WHERE o.total = :total")})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrderID")
    private Integer orderID;
    @Basic(optional = false)
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "Total")
    private float total;
    @Basic(optional = false)
    @Lob
    @Column(name = "Note")
    private String note;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customer;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "order")
    private List<OrderDetail> orderdetailList;

    public Order() {
    }

    public Order(Integer orderID) {
        this.orderID = orderID;
    }

    public Order(Integer orderID, Date date, float total, String note) {
        this.orderID = orderID;
        this.date = date;
        this.total = total;
        this.note = note;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setDate(Calendar date) {
        this.date = date.getTime();
    }
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Customers getCustomerID() {
        return customer;
    }

    public void setCustomerID(Customers customerID) {
        this.customer = customerID;
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
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Order1[ orderID=" + orderID + " ]";
    }
    
}
