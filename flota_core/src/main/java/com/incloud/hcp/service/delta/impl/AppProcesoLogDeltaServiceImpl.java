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

import com.incloud.hcp.domain.AppProcesoLog;
import com.incloud.hcp.service.delta.AppProcesoLogDeltaService;
import com.incloud.hcp.service.impl.AppProcesoLogServiceImpl;
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

import java.util.List;

/**
 * A simple DTO Facility for AppProcesoLog.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AppProcesoLogDeltaServiceImpl extends AppProcesoLogServiceImpl implements AppProcesoLogDeltaService {

    /**************************/
    /* Metodos Personalizados */
    /**************************/

    /***********************/
    /* Metodos de Busqueda */
    /***********************/

    protected Sort setFindAll(Sort sort) {
        sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "descripcionEstadoEjecucion"));
        return sort;
    }

    protected Sort setFind(AppProcesoLog req, ExampleMatcher matcher, Example<AppProcesoLog> example, Sort sort) {
        sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "descripcionEstadoEjecucion"));
        return sort;
    }

    protected void setFindPaginated(PageRequestByExample<AppProcesoLog> req, ExampleMatcher matcher, Example<AppProcesoLog> example) {
        return;
    }

    /****************/
    /* METODOS CRUD */
    /****************/

    protected String setValidacionesPrevias(AppProcesoLog bean) throws Exception {
        String mensaje = "";
        return mensaje;
    }

    protected AppProcesoLog setCreate(AppProcesoLog bean) throws Exception {
        return bean;
    }

    protected void setSave(AppProcesoLog dto) throws Exception {
        return;
    }

    protected void setDelete(Integer id) throws Exception {

    }

    protected void setDeleteAll() throws Exception {

    }

    /************************/
    /* METODOS CRUD Masivos */
    /************************/

    protected AppProcesoLog setUploadExcel(Cell currentCell, AppProcesoLog appProcesoLog, int contador) throws Exception {
        appProcesoLog = super.setUploadExcel(currentCell, appProcesoLog, contador);
        return appProcesoLog;
    }

    protected String setSaveMasivo(AppProcesoLog dto) throws Exception {
        return "";
    }

    protected List<AppProcesoLog> setBeforeDeleteMasivo(List<AppProcesoLog> listaDto) throws Exception {
        return listaDto;
    }

    protected void setAfterDeleteMasivo() throws Exception {
        return;
    }

    /*****************************/
    /* Metodos que generan Excel */
    /*****************************/

    protected void setDownloadExcelItem(AppProcesoLog bean, HSSFRow dataRow) {

    }

    protected void setDownloadExcel(HSSFSheet sheet) {

    }

    /*****************/
    /* Otros Metodos */
    /*****************/

}
