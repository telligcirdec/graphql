/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projet2501.letsfight.hp.dao;

import net.projet2501.letsfight.hp.model.Fight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author telligcirdec
 */
@Repository
public interface FightRepository extends CrudRepository<Fight, Long>{
    
    
    
}
