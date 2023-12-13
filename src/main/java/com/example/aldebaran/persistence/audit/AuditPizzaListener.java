package com.example.aldebaran.persistence.audit;

import com.example.aldebaran.persistence.entity.PizzaEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;

public class AuditPizzaListener {

    @PostLoad
    public void postLoad(PizzaEntity pizza){
        System.out.println(pizza.toString());
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(PizzaEntity pizza){
        System.out.println(pizza.toString());
    }

    @PreRemove
    public void onPreDelete(PizzaEntity pizza){
        System.out.println(pizza.toString());
    }
}
