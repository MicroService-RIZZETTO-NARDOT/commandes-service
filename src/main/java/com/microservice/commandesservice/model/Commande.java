package com.microservice.commandesservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Commande {
    @Id
    private int id;
    private int idProduit;
    private int prix;
    private int quantité;
    private Date date;

    public Commande(){}

    public Commande(int id, int idProduit, int prix, int quantité, Date date) {
        this.id = id;
        this.idProduit = idProduit;
        this.prix = prix;
        this.quantité = quantité;
        this.date = date;
    }
@Override
public String toString(){
        return "Commande{" +
                "id=" + id +
                ", idProduit='" + idProduit + '\'' +
                ", prix=" + prix +
                ", date=" + date+
                '}';
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
