/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.domain.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ttomescu
 */
@Entity
@Table(name = "matches")
@NamedQueries({
    @NamedQuery(name = "Matches.findAll", query = "SELECT m FROM Matches m"),
    @NamedQuery(name = "Matches.findByWeek", query = "SELECT m FROM Matches m WHERE m.week = :week"),
    @NamedQuery(name = "Matches.findByPeriod", query = "SELECT m FROM Matches m WHERE m.period = :period"),
    @NamedQuery(name = "Matches.findById", query = "SELECT m FROM Matches m WHERE m.id = :id"),
    //check period in week
    @NamedQuery(name = "Matches.checkPeriodInWeek", query = "SELECT m FROM Matches m WHERE m.week = :week and m.period = :period")})
public class MatchBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "week")
    private int week;
    @Column(name = "period")
    private Integer period;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "team1", referencedColumnName = "id")
    @ManyToOne
    private Integer firstTeamId;
    @JoinColumn(name = "team2", referencedColumnName = "id")
    @ManyToOne
    private Integer secondTeamId;

    public MatchBean() {
    }

    public MatchBean(Integer id) {
        this.id = id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeam1() {
        return firstTeamId;
    }

    public void setTeam1(Integer team1) {
        this.firstTeamId = team1;
    }

    public Integer getTeam2() {
        return secondTeamId;
    }

    public void setTeam2(Integer team2) {
        this.secondTeamId = team2;
    }

    public void save(Integer id, int week, int period, Integer team1, Integer team2) throws Exception {
        this.id = id;
        this.week = week;
        this.period = period;
        this.firstTeamId = team1;
        this.secondTeamId = team2;
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
        if (!(object instanceof MatchBean)) {
            return false;
        }
        MatchBean other = (MatchBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.lab1.domain.entities.Matches[ id=" + id + " ]";
    }

}
