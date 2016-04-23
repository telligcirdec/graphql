package net.projet2501.letsfight.hp.graph.fetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import net.projet2501.letsfight.hp.dao.HpPeopleRepository;
import net.projet2501.letsfight.hp.model.HpPeople;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author telligcirdec
 */
@Component
public class HpPeopleDataFetcher {

    @Autowired
    private HpPeopleRepository hpPeopleRepository;

    public DataFetcher uidDataFetcher() {
        return (DataFetchingEnvironment dfe) -> {
            String uid = dfe.getArgument("uid");
            String uidDecode = new String(Base64.getDecoder().decode(uid));
            String id = uidDecode.split("|")[0];
            return hpPeopleRepository.findOne(new Long(id));
        };
    }

    public DataFetcher idDataFetcher() {
        return (DataFetchingEnvironment dfe) -> {
            if (dfe.getArgument("id") != null) {
                Long id = Long.valueOf(dfe.getArgument("id").toString());
                return hpPeopleRepository.findOne(id);
            }
            return null;
        };
    }

    public DataFetcher generateUid() {
        return (DataFetchingEnvironment dfe) -> {
            if (HpPeople.class.isAssignableFrom(dfe.getSource().getClass())) {
                HpPeople hpPeople = HpPeople.class.cast(dfe.getSource());
                hpPeople.setUid(generateUid(hpPeople));
            }
            return null;
        };
    }

    public DataFetcher allHpPeople() {
        return (DataFetchingEnvironment dfe) -> {
            List<HpPeople> allPeople = new ArrayList<>();
            hpPeopleRepository.findAll().forEach((HpPeople hpPeople) -> {
                hpPeople.setUid(generateUid(hpPeople));
                allPeople.add(hpPeople);
            });
            return allPeople;
        };
    }

    public DataFetcher create() {
        return (DataFetchingEnvironment dfe) -> {
            String lastName = dfe.getArgument("lastName");
            String firstName = dfe.getArgument("firstName");
            HpPeople hpPeople = hpPeopleRepository.findByLastNameAndFirstName(lastName, firstName);
            if (hpPeople == null) {
                hpPeople = new HpPeople();
                hpPeople.setFirstName(firstName);
                hpPeople.setLastName(lastName);
                hpPeople = hpPeopleRepository.save(hpPeople);
            }
            return hpPeople;
        };
    }

    public DataFetcher delete() {
        return (DataFetchingEnvironment dfe) -> {
            if (dfe.getArgument("id") != null) {
                Long id = Long.valueOf(dfe.getArgument("id").toString());
                return hpPeopleRepository.deleteById(id);
            } else {
                String lastName = dfe.getArgument("lastName");
                String firstName = dfe.getArgument("firstName");
                if (StringUtils.isNotBlank(lastName) && StringUtils.isNotBlank(firstName)) {
                    return hpPeopleRepository.deleteByLastNameAndFirstName(lastName, firstName);
                }
            }
            return -1;
        };
    }

    private String generateUid(HpPeople hpPeople) {
        return Base64.getEncoder().encodeToString(
                (hpPeople.getId() + "|" + hpPeople.getFirstName() + "|" + hpPeople.getLastName()).getBytes());
    }

}
