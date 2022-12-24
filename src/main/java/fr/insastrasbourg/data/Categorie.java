/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insastrasbourg.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author martin
 */
@Entity
@Table(name = "categorie")
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findByCategorieId", query = "SELECT c FROM Categorie c WHERE c.categorieId = :categorieId"),
    @NamedQuery(name = "Categorie.findByCategorie", query = "SELECT c FROM Categorie c WHERE c.categorie = :categorie"),
    @NamedQuery(name = "Categorie.findBySousCategorie", query = "SELECT c FROM Categorie c WHERE c.sousCategorie = :sousCategorie"),
    // recherhce par categorie et sous categorie
    @NamedQuery(name = "Categorie.findByCategorieAndSousCategorie", query = "SELECT c FROM Categorie c WHERE c.categorie = :categorie and c.sousCategorie = :sousCategorie")
})
public class Categorie implements Serializable {

    @OneToMany(mappedBy = "categorie")
    private List<Objet> objetList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "categorie_id")
    private Integer categorieId;
    @Column(name = "categorie")
    private String categorie;
    @Column(name = "sous_categorie")
    private String sousCategorie;

    public Categorie() {
    }

    public Categorie(Integer categorieId) {
        this.categorieId = categorieId;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categorieId != null ? categorieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.categorieId == null && other.categorieId != null) || (this.categorieId != null && !this.categorieId.equals(other.categorieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.insastrasbourg.data.Categorie[ categorieId=" + categorieId + " ]";
    }

    public List<Objet> getObjetList() {
        return objetList;
    }

    public void setObjetList(List<Objet> objetList) {
        this.objetList = objetList;
    }
    
}
