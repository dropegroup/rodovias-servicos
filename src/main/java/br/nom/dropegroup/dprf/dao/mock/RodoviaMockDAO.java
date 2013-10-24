/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.nom.dropegroup.dprf.dao.mock;

import br.com.dropegroup.dprf.resource.Rodovia;
import br.nom.dropegroup.dprf.dao.RodoviaDAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 *
 * @author dailton.almeida
 */
@Repository
public class RodoviaMockDAO
    implements RodoviaDAO {

    /**
     * metodo auxiliar so para criar uma rodovia
     */
    private Rodovia buildRodovia(String code, String type) {
        Rodovia result = new Rodovia();
        result.setCode(code);
        result.setType(type);
        return result;
    }
    
    public List<Rodovia> findAll() {
        List<Rodovia> result = new ArrayList<Rodovia>();
        result.add(buildRodovia("BR-010", "A"));
        result.add(buildRodovia("BR-020", "B"));
        return result;
    }

    public Rodovia findByCode(String code) {
        Rodovia result;
        if ("BR-010".equals(code)) {
            result = buildRodovia("BR-010", "A");
        } else if ("BR-020".equals(code)) {
            result = buildRodovia("BR-020", "B");
        } else {
            // no mundo real melhor uma exception "NoDataFound"; acho que no spring tem algo assim ja previsto
            throw new RuntimeException("No Rodovia found with code " + code);
        }
        return result;
    }
    
}
