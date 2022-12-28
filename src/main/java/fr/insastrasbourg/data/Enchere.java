/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insastrasbourg.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author martin
 */
@Entity
@Table(name = "enchere")
@NamedQueries({
    @NamedQuery(name = "Enchere.findAll", query = "SELECT e FROM Enchere e"),
    @NamedQuery(name = "Enchere.findByEnchereId", query = "SELECT e FROM Enchere e WHERE e.enchereId = :enchereId"),
    @NamedQuery(name = "Enchere.findByPrix", query = "SELECT e FROM Enchere e WHERE e.prix = :prix")})
public class Enchere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enchere_id")
    private Integer enchereId;
    @Column(name = "prix")
    private Integer prix;
    
    @JoinColumn(name = "objet_id", referencedColumnName = "objet_id")
    @ManyToOne
    private Objet objet;
    
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "utilisateur_id")
    @ManyToOne
    private Utilisateur utilisateur;

    public Enchere() {
    }

    public Enchere(Integer enchereId) {
        this.enchereId = enchereId;
    }

    public Integer getEnchereId() {
        return enchereId;
    }

    public void setEnchereId(Integer enchereId) {
        this.enchereId = enchereId;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Objet getObjet() {
        return objet;
    }

    public void setObjet(Objet objet) {
        this.objet = objet;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enchereId != null ? enchereId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enchere)) {
            return false;
        }
        Enchere other = (Enchere) object;
        if ((this.enchereId == null && other.enchereId != null) || (this.enchereId != null && !this.enchereId.equals(other.enchereId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.insastrasbourg.data.Enchere[ enchereId=" + enchereId + " ]";
    }
    
}
