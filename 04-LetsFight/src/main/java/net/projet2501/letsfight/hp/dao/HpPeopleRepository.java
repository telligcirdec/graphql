package net.projet2501.letsfight.hp.dao;

import net.projet2501.letsfight.hp.model.HpPeople;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author telligcirdec
 */
@Repository
public interface HpPeopleRepository extends CrudRepository<HpPeople, Long> {
    
    HpPeople findByLastNameAndFirstName(String lastName, String firstName);
    
    @Transactional
    Long deleteById(Long id);
    
    @Transactional
    Long deleteByLastNameAndFirstName(String lastname, String firstName);
    
}
