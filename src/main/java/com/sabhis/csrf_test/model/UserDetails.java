/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabhis.csrf_test.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sabhis231
 */
@Entity
@Table(name = "user_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDetails.findAll", query = "SELECT u FROM UserDetails u"),
    @NamedQuery(name = "UserDetails.findByUName", query = "SELECT u FROM UserDetails u WHERE u.uName = :uName"),
    @NamedQuery(name = "UserDetails.findByUId", query = "SELECT u FROM UserDetails u WHERE u.uId = :uId"),
    @NamedQuery(name = "UserDetails.findByUCollegename", query = "SELECT u FROM UserDetails u WHERE u.uCollegename = :uCollegename"),
    @NamedQuery(name = "UserDetails.findByCity", query = "SELECT u FROM UserDetails u WHERE u.city = :city"),
    @NamedQuery(name = "UserDetails.findByState", query = "SELECT u FROM UserDetails u WHERE u.state = :state")})
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "u_name")
    private String uName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "u_id")
    private Integer uId;
    @Size(max = 45)
    @Column(name = "u_collegename")
    private String uCollegename;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "state")
    private String state;

    public UserDetails() {
    }

    public UserDetails(Integer uId) {
        this.uId = uId;
    }

    public UserDetails(Integer uId, String uName) {
        this.uId = uId;
        this.uName = uName;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUCollegename() {
        return uCollegename;
    }

    public void setUCollegename(String uCollegename) {
        this.uCollegename = uCollegename;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDetails)) {
            return false;
        }
        UserDetails other = (UserDetails) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sabhis.csrf_test.model.UserDetails[ uId=" + uId + " ]";
    }
    
}
