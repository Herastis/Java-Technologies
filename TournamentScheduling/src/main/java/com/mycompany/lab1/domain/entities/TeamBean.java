/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.domain.entities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIInput;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ttomescu
 */
@Named(value = "teamBean")
@SessionScoped
@Entity
@Table(name = "teams")
@NamedQueries({
    @NamedQuery(name = "Teams.findAll", query = "SELECT t FROM Teams t"),
    @NamedQuery(name = "Teams.findByFoundingdate", query = "SELECT t FROM Teams t WHERE t.foundingdate = :foundingdate"),
    @NamedQuery(name = "Teams.findByName", query = "SELECT t FROM Teams t WHERE t.name = :name"),
    @NamedQuery(name = "Teams.findById", query = "SELECT t FROM Teams t WHERE t.id = :id")})
public class TeamBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "foundingdate")
    @Temporal(TemporalType.DATE)
    private Date foundingdate;
    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "cityid", referencedColumnName = "cityid")
    @ManyToOne(optional = false)
    private CityBean cityid;

    public TeamBean() {
    }

    public TeamBean(Integer id) {
        this.id = id;
    }

    public Date getFoundingdate() {
        return foundingdate;
    }

    public void setFoundingdate(Date foundingdate) {
        this.foundingdate = foundingdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CityBean getCityid() {
        return cityid;
    }

    public void setCityid(CityBean cityid) {
        this.cityid = cityid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamBean)) {
            return false;
        }
        TeamBean other = (TeamBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.mycompany.lab1.domain.entities.Teams[ id=" + id + " ]";
//    }
    public UIInput getNameComponent() {
        return nameComponent;
    }

    public void setNameComponent(UIInput nameComponent) {
        this.nameComponent = nameComponent;
    }

    public UIInput getDateComponent() {
        return dateComponent;
    }

    public void setDateComponent(UIInput dateComponent) {
        this.dateComponent = dateComponent;
    }

    public UIInput getCityComponent() {
        return cityComponent;
    }

    public void setCityComponent(UIInput cityComponent) {
        this.cityComponent = cityComponent;
    }

    public ArrayList<TeamInfo> getList() {
        return list;
    }

    public void setList(ArrayList<TeamInfo> list) {
        this.list = list;
    }

    private UIInput nameComponent;
    private UIInput dateComponent;
    private UIInput cityComponent;

    private ArrayList<TeamInfo> list = new ArrayList<>();

    public void setTeamsInfoAll(ArrayList teamsInfoAll) {
        this.list = teamsInfoAll;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TeamBean{");
        sb.append("teamsInfoAll=").append(list);
        sb.append('}');
        return sb.toString();
    }

    public List getTeamsInfoAll() {
        return list;
    }

    @PostConstruct
    public void init() {
        System.out.println("asdksafksdaf");
        teamsService();
    }

    @Resource(name = "poolResource")
    DataSource ds;

    public void teamsService() {
        try {
            Connection con = ds.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from teams");
            while (rs.next()) {
                System.out.println(rs.getString(1));
                TeamInfo team = new TeamInfo(rs.getString(1), rs.getString(2),
                        rs.getString(3));
                list.add(team);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void nameComponentMethod() {
        nameComponent.setRendered(false);
    }

    public void dateComponentMethod() {
        dateComponent.setRendered(false);
    }

    public void cityComponenttMethod() {
        cityComponent.setRendered(false);
    }
}
