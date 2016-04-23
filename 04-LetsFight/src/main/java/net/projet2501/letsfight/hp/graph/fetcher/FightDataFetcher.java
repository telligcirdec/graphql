/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projet2501.letsfight.hp.graph.fetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import net.projet2501.letsfight.hp.dao.FightRepository;
import net.projet2501.letsfight.hp.dao.HpPeopleRepository;
import net.projet2501.letsfight.hp.model.Fight;
import net.projet2501.letsfight.hp.model.HpPeople;
import net.projet2501.swapigraphql.api.model.People;
import net.projet2501.swapigraphql.graph.fetcher.SWAPIObjectDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author telligcirdec
 */
@Component
public class FightDataFetcher {

    @Autowired
    private FightRepository fightRepository;

    @Autowired
    private HpPeopleRepository hpPeopleRepository;

    @Autowired
    private SWAPIObjectDataFetcher objectDataFetcher;

    public DataFetcher idDataFetcher() {
        return (DataFetchingEnvironment dfe) -> {
            Long id = dfe.getArgument("id");
            return fightRepository.findOne(id);
        };
    }

    public DataFetcher fetchHpPeople() {
        return (DataFetchingEnvironment dfe) -> {
            Fight fight = Fight.class.cast(dfe.getSource());
            return fight.getHpPeople();
        };
    }

    public DataFetcher fetchSwPeople() {
        return (DataFetchingEnvironment dfe) -> {
            Fight fight = Fight.class.cast(dfe.getSource());
            String swapiUid = fight.getSwapiUid();
            return People.class.cast(objectDataFetcher.getSwapiObjectByUid(swapiUid));
        };
    }

    public DataFetcher fight() {
        return (DataFetchingEnvironment dfe) -> {
            Long hpId = Long.valueOf(dfe.getArgument("hpId").toString());
            String swapiId = dfe.getArgument("swapiId");
            Boolean winner = dfe.getArgument("winner");

            Fight fight = new Fight();
            fight.setWinner(false);
            if ((winner == null && Math.random() > 0.2) || Boolean.TRUE.equals(winner)) {
                fight.setWinner(true);
            }
            HpPeople hpPeople = hpPeopleRepository.findOne(hpId);
            if (hpPeople != null) {
                fight.setHpPeople(hpPeople);
                fight.setSwapiUid(swapiId);
                return fightRepository.save(fight);
            }
            return null;
        };
    }

}
