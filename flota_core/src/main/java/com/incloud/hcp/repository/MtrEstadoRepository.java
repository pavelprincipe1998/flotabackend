/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/repository/EntityRepository.java.e.vm
 */
package com.incloud.hcp.repository;

import com.incloud.hcp.domain.MtrEstado;
import com.incloud.hcp.domain.MtrEstado_;
import com.incloud.hcp.repository._framework.JPACustomRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface MtrEstadoRepository extends JPACustomRepository<MtrEstado, Integer> {

    default List<MtrEstado> findCompletePaginated(String query, int maxResults) {
        MtrEstado probe = new MtrEstado();
        //probe.setNombre(query);
        probe.setNombre(null);
        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(MtrEstado_.nombre.getName(), match -> match.ignoreCase().startsWith());

        Page<MtrEstado> page = this.findAll(Example.of(probe, matcher), PageRequest.of(0, maxResults));
        return page.getContent();
    }

}
