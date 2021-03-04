package com.microservice.commandesservice.web.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.microservice.commandesservice.dao.CommandeDao;
import com.microservice.commandesservice.model.Commande;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(description = "API pour les opérations CRUD sur les commandes.")
public class CommandeController {
    @Autowired
    private CommandeDao commandeDao;
    private static final Logger logger = LoggerFactory.getLogger(CommandeController.class);
    @Autowired
    private HttpServletRequest requestContext;
    //**GET**
    //Liste tout les commandes
    //----> http://localhost:9090/Commandes
    @ApiOperation(value = "Récupère tous les commandes en stock!")
    @RequestMapping(value="/Commandes", method= RequestMethod.GET)
    public MappingJacksonValue listeCommandes()
    {
        List<Commande> commandes = commandeDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
        MappingJacksonValue commandesFiltres = new MappingJacksonValue( commandes );
        commandesFiltres .setFilters( listDeNosFiltres );
        logger .info("Début d'appel au service Commandes pour la requête : " +
                requestContext.getHeader("req-id"));
        return commandesFiltres ;
    }
}
