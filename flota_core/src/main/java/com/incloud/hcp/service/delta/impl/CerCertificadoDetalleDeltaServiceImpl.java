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

import com.incloud.hcp.domain.*;
import com.incloud.hcp.enums.NotaPedidoTipoPosicionEnum;
import com.incloud.hcp.repository.CerDocumentoAdjuntoRepository;
import com.incloud.hcp.service._framework.cmis.CmisService;
import com.incloud.hcp.service.delta.AppParametriaDeltaService;
import com.incloud.hcp.service.delta.CerCertificadoDetalleDeltaService;
import com.incloud.hcp.service.dto.CerCertificadoDetalleDto;
import com.incloud.hcp.service.dto.CerCertificadoDetalleImputacionModificarDto;
import com.incloud.hcp.service.impl.CerCertificadoDetalleServiceImpl;
import com.incloud.hcp.service.support.PageRequestByExample;
import com.incloud.hcp.utils.Constants;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A simple DTO Facility for CerCertificadoDetalle.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CerCertificadoDetalleDeltaServiceImpl extends CerCertificadoDetalleServiceImpl implements CerCertificadoDetalleDeltaService {

    @Autowired
    private CmisService cmisService;

    @Autowired
    private CerDocumentoAdjuntoRepository cerDocumentoAdjuntoRepository;

    @Autowired
    private AppParametriaDeltaService appParametriaDeltaService;

    /**************************/
    /* Metodos Personalizados */
    /**************************/
    public CerCertificadoDetalleImputacionModificarDto saveImputacionAdjuntos(CerCertificadoDetalleImputacionModificarDto bean) throws Exception {
        if (this.appParametriaDeltaService.devuelveApagarCertificado()) {
            throw new Exception(Constants.MENSAJE_SISTEMA_APAGADO);
        }

        List<CerCertificadoDetalleDto> cerCertificadoDetalleDtoList = bean.getCerCertificadoDetalleDtoList();
        for (CerCertificadoDetalleDto beanDetalle : cerCertificadoDetalleDtoList) {
            CerCertificadoDetalle cerCertificadoDetalle = beanDetalle.getCerCertificadoDetalle();
            this.cerCertificadoDetalleDeltaRepository.save(cerCertificadoDetalle);
        }
        List<CerDocumentoAdjunto> cerDocumentoAdjuntoList = bean.getCerDocumentoAdjuntoList();
        if (cerDocumentoAdjuntoList != null && cerDocumentoAdjuntoList.size() > 0) {
            this.cerDocumentoAdjuntoRepository.saveAll(cerDocumentoAdjuntoList);
        }
        return bean;
    }

    public List<CerCertificadoDetalleDto> findByDetalle(Integer cerCertificadoId ) throws Exception {

        Optional<CerCertificado> optionalCerCertificado = this.cerCertificadoDeltaRepository.findById(cerCertificadoId);
        if (!optionalCerCertificado.isPresent()) {
            throw new Exception("No se encontró Certificado con ID: " + cerCertificadoId);
        }
        CerCertificado cerCertificado = optionalCerCertificado.get();


        CerNotaPedido cerNotaPedido = cerCertificado.getCerNotaPedido();
        List<CerNotaPedidoDetalle> cerNotaPedidoDetallePosicionList =
                this.cerNotaPedidoDetalleDeltaRepository.findByDetalleSoloPosiciones(cerNotaPedido.getId());
        List<CerCertificadoDetalleDto> listaFinal = new ArrayList<CerCertificadoDetalleDto>();

        if (cerNotaPedidoDetallePosicionList != null && cerNotaPedidoDetallePosicionList.size() > 0) {
            for (CerNotaPedidoDetalle bean : cerNotaPedidoDetallePosicionList) {
                CerCertificadoDetalleDto beanPosicionDto = new CerCertificadoDetalleDto();
                beanPosicionDto.setTipoPosicion(NotaPedidoTipoPosicionEnum.POSICION.getEstado());
                beanPosicionDto.setCerNotaPedidoDetalle(bean);

                CerCertificadoDetalle cerCertificadoDetalle =
                        this.cerCertificadoDetalleDeltaRepository.
                                getByCerCertificadoAndCerNotaPedidoDetalle(cerCertificado, bean);
                beanPosicionDto.setCerCertificadoDetalle(cerCertificadoDetalle);
                if (Optional.ofNullable(cerCertificadoDetalle).isPresent()) {
                    listaFinal.add(beanPosicionDto);
                }
                else {
                    List<CerNotaPedidoDetalle> hijosLista =
                            this.cerCertificadoDetalleDeltaRepository.
                                    findByCerCertificadoAndCerNotaPedidoDetallePadre(cerCertificado.getId(), bean.getId());
                    if (hijosLista != null && hijosLista.size() > 0) {
                        listaFinal.add(beanPosicionDto);
                    }
                }

                List<CerNotaPedidoDetalle> subPosicionList = this.cerNotaPedidoDetalleDeltaRepository.
                        findByDetalleSubPosicion(cerNotaPedido.getId(), bean.getId());
                if (subPosicionList != null && subPosicionList.size() > 0) {
                    for (CerNotaPedidoDetalle beanSubposicion : subPosicionList) {
                        CerCertificadoDetalle cerCertificadoDetalleSub =
                                this.cerCertificadoDetalleDeltaRepository.
                                        getByCerCertificadoAndCerNotaPedidoDetalle(cerCertificado, beanSubposicion);
                        if (Optional.ofNullable(cerCertificadoDetalleSub).isPresent()) {
                            CerCertificadoDetalleDto beanSubPosicionDto = new CerCertificadoDetalleDto();
                            beanSubPosicionDto.setTipoPosicion(NotaPedidoTipoPosicionEnum.SUBPOSICION.getEstado());
                            beanSubPosicionDto.setCerNotaPedidoDetalle(beanSubposicion);
                            beanSubPosicionDto.setCerCertificadoDetalle(cerCertificadoDetalleSub);
                            listaFinal.add(beanSubPosicionDto);
                        }
                    }
                }
            }
        }
        return listaFinal;
    }

    /***********************/
    /* Metodos de Busqueda */
    /***********************/

    protected Sort setFindAll(Sort sort) {
        sort = Sort.by(
                new Sort.Order(Sort.Direction.ASC, "cerCertificado.id"),
                new Sort.Order(Sort.Direction.ASC, "cerNotaPedidoDetalle.id"),
                new Sort.Order(Sort.Direction.ASC, "subpackno")
        );
        return sort;
    }

    protected Sort setFind(CerCertificadoDetalle req, ExampleMatcher matcher, Example<CerCertificadoDetalle> example, Sort sort) {
        sort = Sort.by(
                new Sort.Order(Sort.Direction.ASC, "cerCertificado.id"),
                new Sort.Order(Sort.Direction.ASC, "cerNotaPedidoDetalle.id"),
                new Sort.Order(Sort.Direction.ASC, "subpackno")
        );
        return sort;
    }

    protected void setFindPaginated(PageRequestByExample<CerCertificadoDetalle> req, ExampleMatcher matcher, Example<CerCertificadoDetalle> example) {
        return;
    }

    /****************/
    /* METODOS CRUD */
    /****************/

    protected String setValidacionesPrevias(CerCertificadoDetalle bean) throws Exception {
        String mensaje = "";
        return mensaje;
    }

    protected CerCertificadoDetalle setCreate(CerCertificadoDetalle bean) throws Exception {
        return bean;
    }

    protected void setSave(CerCertificadoDetalle dto) throws Exception {
        return;
    }

    protected void setDelete(Integer id) throws Exception {

    }

    protected void setDeleteAll() throws Exception {

    }

    /************************/
    /* METODOS CRUD Masivos */
    /************************/

    protected CerCertificadoDetalle setUploadExcel(Cell currentCell, CerCertificadoDetalle cerCertificadoDetalle, int contador) throws Exception {
        cerCertificadoDetalle = super.setUploadExcel(currentCell, cerCertificadoDetalle, contador);
        return cerCertificadoDetalle;
    }

    protected String setSaveMasivo(CerCertificadoDetalle dto) throws Exception {
        return "";
    }

    protected List<CerCertificadoDetalle> setBeforeDeleteMasivo(List<CerCertificadoDetalle> listaDto) throws Exception {
        return listaDto;
    }

    protected void setAfterDeleteMasivo() throws Exception {
        return;
    }

    /*****************************/
    /* Metodos que generan Excel */
    /*****************************/

    protected void setDownloadExcelItem(CerCertificadoDetalle bean, HSSFRow dataRow) {

    }

    protected void setDownloadExcel(HSSFSheet sheet) {

    }

    /*****************/
    /* Otros Metodos */
    /*****************/

    protected String setGraphDescripcionByMtrUnidadMedida(MtrUnidadMedida mtrUnidadMedida) {
        return mtrUnidadMedida.getId().toString();
    }

    protected String setGraphPieChartTituloByMtrUnidadMedida() {
        return "MtrUnidadMedida";
    }

    protected String setGraphBarChartTituloByMtrUnidadMedida() {
        return "MtrUnidadMedida";
    }

    protected String setGraphDescripcionByCerCertificado(CerCertificado cerCertificado) {
        return cerCertificado.getId().toString();
    }

    protected String setGraphPieChartTituloByCerCertificado() {
        return "CerCertificado";
    }

    protected String setGraphBarChartTituloByCerCertificado() {
        return "CerCertificado";
    }

}