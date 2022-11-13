/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.domain.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ttomescu
 */
@Entity
@Table(name = "cities")
@NamedQueries({
    @NamedQuery(name = "Cities.findAll", query = "SELECT c FROM Cities c"),
    @NamedQuery(name = "Cities.findByCityid", query = "SELECT c FROM Cities c WHERE c.cityid = :cityid"),
    @NamedQuery(name = "Cities.findByName", query = "SELECT c FROM Cities c WHERE c.name = :name")})
public class CityBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cityid")
    private Integer cityid;
    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityid")
    private Collection<TeamBean> teamsCollection;

    public CityBean() {
    }

    public CityBean(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<TeamBean> getTeamsCollection() {
        return teamsCollection;
    }

    public void setTeamsCollection(Collection<TeamBean> teamsCollection) {
        this.teamsCollection = teamsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityid != null ? cityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityBean)) {
            return false;
        }
        CityBean other = (CityBean) object;
        if ((this.cityid == null && other.cityid != null) || (this.cityid != null && !this.cityid.equals(other.cityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.lab1.domain.entities.Cities[ cityid=" + cityid + " ]";
    }

}
