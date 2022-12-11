/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insastrasbourg.data;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author martin
 */
@Entity
@Table(name = "objet")
@NamedQueries({
    @NamedQuery(name = "Objet.findAll", query = "SELECT o FROM Objet o"),
    @NamedQuery(name = "Objet.findByObjetId", query = "SELECT o FROM Objet o WHERE o.objetId = :objetId"),
    @NamedQuery(name = "Objet.findByLibelle", query = "SELECT o FROM Objet o WHERE o.libelle = :libelle"),
    @NamedQuery(name = "Objet.findByDescription", query = "SELECT o FROM Objet o WHERE o.description = :description"),
    @NamedQuery(name = "Objet.findByDebutEnchere", query = "SELECT o FROM Objet o WHERE o.debutEnchere = :debutEnchere"),
    @NamedQuery(name = "Objet.findByFinEnchere", query = "SELECT o FROM Objet o WHERE o.finEnchere = :finEnchere"),
    @NamedQuery(name = "Objet.findByPrixInitial", query = "SELECT o FROM Objet o WHERE o.prixInitial = :prixInitial")})
public class Objet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "objet_id")
    private Integer objetId;
    @Basic(optional = false)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "debut_enchere")
    @Temporal(TemporalType.TIMESTAMP)
    private Date debutEnchere;
    @Basic(optional = false)
    @Column(name = "fin_enchere")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finEnchere;
    @Basic(optional = false)
    @Column(name = "prix_initial")
    private int prixInitial;
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "utilisateur_id")
    @ManyToOne
    private Utilisateur utilisateur;

    public Objet() {
    }

    public Objet(Integer objetId) {
        this.objetId = objetId;
    }

    public Objet(Integer objetId, String libelle, String description, Date debutEnchere, Date finEnchere, int prixInitial) {
        this.objetId = objetId;
        this.libelle = libelle;
        this.description = description;
        this.debutEnchere = debutEnchere;
        this.finEnchere = finEnchere;
        this.prixInitial = prixInitial;
    }

    public Integer getObjetId() {
        return objetId;
    }

    public void setObjetId(Integer objetId) {
        this.objetId = objetId;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDebutEnchere() {
        return debutEnchere;
    }

    public void setDebutEnchere(Date debutEnchere) {
        this.debutEnchere = debutEnchere;
    }

    public Date getFinEnchere() {
        return finEnchere;
    }

    public void setFinEnchere(Date finEnchere) {
        this.finEnchere = finEnchere;
    }

    public int getPrixInitial() {
        return prixInitial;
    }

    public void setPrixInitial(int prixInitial) {
        this.prixInitial = prixInitial;
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
        hash += (objetId != null ? objetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objet)) {
            return false;
        }
        Objet other = (Objet) object;
        if ((this.objetId == null && other.objetId != null) || (this.objetId != null && !this.objetId.equals(other.objetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.insastrasbourg.data.Objet[ objetId=" + objetId + " ]";
    }
    
}
