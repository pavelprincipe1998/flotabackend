/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/dto/EntitydeltaDTOService.java.e.vm
 */
package com.incloud.hcp.service.delta.impl;

import com.incloud.hcp.domain.MtrEmbarcacion;
import com.incloud.hcp.domain.response.MtrEmbarcacionResponse;
import com.incloud.hcp.service.delta.MtrEmbarcacionDeltaService;
import com.incloud.hcp.service.impl.MtrEmbarcacionServiceImpl;
import com.incloud.hcp.service.support.PageRequestByExample;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * A simple DTO Facility for MtrEmbarcacion.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class MtrEmbarcacionDeltaServiceImpl extends MtrEmbarcacionServiceImpl implements MtrEmbarcacionDeltaService {

    /**************************/
    /* Metodos Personalizados */
    /**************************/

    /***********************/
    /* Metodos de Busqueda */
    /***********************/

    protected Sort setFindAll(Sort sort) {
        sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "nombre"));
        return sort;
    }

    protected Sort setFind(MtrEmbarcacion req, ExampleMatcher matcher, Example<MtrEmbarcacion> example, Sort sort) {
        sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "nombre"));
        return sort;
    }

    protected void setFindPaginated(PageRequestByExample<MtrEmbarcacion> req, ExampleMatcher matcher, Example<MtrEmbarcacion> example) {
        return;
    }

    protected List<Predicate> setAdicionalDeltaPredicate(List<Predicate> predicates, MtrEmbarcacionResponse bean, CriteriaBuilder cb,
            CriteriaQuery<MtrEmbarcacion> query, Root<MtrEmbarcacion> root) throws Exception {

        MtrEmbarcacion entity = bean.getBean();
        //Ejemplo
        /*
        if (Optional.ofNullable(entity.get<VariableManytoOne>()).isPresent()) {
            Join<MtrEmbarcacion, <ClaseManytoOne>> from<ClaseManytoOne> = countRoot.join("<variableManytoOne>", JoinType.INNER);
        
            if (Optional.ofNullable(entity.get<VariableManytoOne>().get<Atributo>()).isPresent()) {
                Join<MtrEmbarcacion, <ClaseManytoOne>> from<ClaseManytoOne> = countRoot.join("<variableManytoOne>", JoinType.INNER);
                Predicate thirdCondition = cb.equal(from<ClaseManytoOne>.get("<Atributo>"), entity.get<ClaseManytoOne>().get<Atributo>());
                predicates.add(thirdCondition);
            }
            
        }
        query.orderBy(cb.desc(root.get("<campo entity>")));
        */
        return predicates;
    }

    protected Root<MtrEmbarcacion> setAdicionalDeltaTotalPredicate(MtrEmbarcacionResponse bean, Root<MtrEmbarcacion> countRoot) throws Exception {
        MtrEmbarcacion entity = bean.getBean();
        //Ejemplo
        /*
        if (Optional.ofNullable(entity.get<VariableManytoOne>()).isPresent()) {
            if (Optional.ofNullable(entity.get<VariableManytoOne>()).isPresent()) {
                Join<MtrEmbarcacion, <ClaseManytoOne>> from<ClaseManytoOne> = countRoot.join("<variableManytoOne>", JoinType.INNER);
            }
        }
        */
        return countRoot;
    }

    /****************/
    /* METODOS CRUD */
    /****************/

    protected String setValidacionesPrevias(MtrEmbarcacion bean) throws Exception {
        String mensaje = "";
        return mensaje;
    }

    protected MtrEmbarcacion setCreate(MtrEmbarcacion bean) throws Exception {
        return bean;
    }

    protected void setSave(MtrEmbarcacion dto) throws Exception {
        return;
    }

    protected void setDelete(Integer id) throws Exception {

    }

    protected void setDeleteAll() throws Exception {

    }

    /************************/
    /* METODOS CRUD Masivos */
    /************************/

    protected MtrEmbarcacion setUploadExcel(Cell currentCell, MtrEmbarcacion mtrEmbarcacion, int contador) throws Exception {
        mtrEmbarcacion = super.setUploadExcel(currentCell, mtrEmbarcacion, contador);
        return mtrEmbarcacion;
    }

    protected String setSaveMasivo(MtrEmbarcacion dto) throws Exception {
        return "";
    }

    protected List<MtrEmbarcacion> setBeforeDeleteMasivo(List<MtrEmbarcacion> listaDto) throws Exception {
        return listaDto;
    }

    protected void setAfterDeleteMasivo() throws Exception {
        return;
    }

    /*****************************/
    /* Metodos que generan Excel */
    /*****************************/

    protected void setDownloadExcelItem(MtrEmbarcacion bean, HSSFRow dataRow) {

    }

    protected void setDownloadExcel(HSSFSheet sheet) {

    }

    /*****************/
    /* Otros Metodos */
    /*****************/

}
