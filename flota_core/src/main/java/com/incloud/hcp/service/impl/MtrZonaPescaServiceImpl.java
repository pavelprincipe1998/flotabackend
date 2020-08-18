/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/dto/EntityDTOService.java.e.vm
 */
package com.incloud.hcp.service.impl;

import com.incloud.hcp.common.enums.AppParametriaLabelEnum;
import com.incloud.hcp.common.enums.AppParametriaModuloEnum;
import com.incloud.hcp.common.excel.ExcelDefault;
import com.incloud.hcp.domain.AppParametria;
import com.incloud.hcp.domain.MtrZonaPesca;
import com.incloud.hcp.domain.MtrZonaPesca_;
import com.incloud.hcp.domain.response.MtrZonaPescaResponse;
import com.incloud.hcp.exception.ServiceException;
import com.incloud.hcp.repository.delta.AppParametriaDeltaRepository;
import com.incloud.hcp.repository.delta.MtrZonaPescaDeltaRepository;
import com.incloud.hcp.service.MtrZonaPescaService;
import com.incloud.hcp.service._framework.bean.BeanCargaMasivoDTO;
import com.incloud.hcp.service._framework.bean.BeanListaMasivoDTO;
import com.incloud.hcp.service._framework.impl.JPACustomServiceImpl;
import com.incloud.hcp.service.requireNew.MtrZonaPescaRequireNewService;
import com.incloud.hcp.service.support.PageRequestByExample;
import com.incloud.hcp.utils.Constants;
import com.incloud.hcp.utils.PredicateUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A simple DTO Facility for MtrZonaPesca.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public abstract class MtrZonaPescaServiceImpl extends JPACustomServiceImpl<MtrZonaPescaResponse, MtrZonaPesca, Integer> implements MtrZonaPescaService {

    protected final String NAME_SHEET = "MtrZonaPesca";
    protected final String CONFIG_TITLE = "com/incloud/hcp/excel/MtrZonaPescaExcel.xml";
    private final Integer REGISTROS_COLOR = 10;

    @Autowired
    protected AppParametriaDeltaRepository appParametriaDeltaRepository;

    @Autowired
    protected MtrZonaPescaDeltaRepository mtrZonaPescaDeltaRepository;

    @Autowired
    protected MtrZonaPescaRequireNewService mtrZonaPescaRequireNewService;

    /*****************************/
    /* Metodos de Busqueda       */
    /*****************************/

    protected final ExampleMatcher setAbstractFind(ExampleMatcher matcher) {
        matcher = ExampleMatcher.matching() //
                .withMatcher(MtrZonaPesca_.nombre.getName(), match -> match.ignoreCase().startsWith());
        return matcher;
    }

    protected abstract Sort setFindAll(Sort sort);

    protected abstract Sort setFind(MtrZonaPesca req, ExampleMatcher matcher, Example<MtrZonaPesca> example, Sort sort);

    protected abstract void setFindPaginated(PageRequestByExample<MtrZonaPesca> req, ExampleMatcher matcher, Example<MtrZonaPesca> example);

    protected final MtrZonaPesca setObtenerBeanResponse(MtrZonaPescaResponse bean) {
        return bean.getBean();
    }

    protected final Class<MtrZonaPesca> setObtenerClassBean() {
        return MtrZonaPesca.class;
    }

    protected List<Predicate> setAbstractPredicate(MtrZonaPescaResponse bean, CriteriaBuilder cb, Root<MtrZonaPesca> root) {
        List<Predicate> predicates = new ArrayList<>();
        MtrZonaPesca entity = bean.getBean();
        /* Obtener condiciones */
        PredicateUtils.addPredicates(predicates, bean.getIdCondicion(), "id", entity.getId(), cb, root);
        PredicateUtils.addPredicates(predicates, bean.getNombreCondicion(), "nombre", entity.getNombre(), cb, root);
        /* Obtener valores de Lista */
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "id", bean.getIdList(), cb, root);
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "nombre", bean.getNombreList(), cb, root);
        return predicates;
    }

    /****************/
    /* METODOS CRUD */
    /****************/

    protected final String validacionesPrevias(MtrZonaPesca bean) throws Exception {
        String mensaje = "";
        if (!Optional.of(bean.getNombre()).isPresent()) {
            String msg = this.messageSource.getMessage("message.mtrZonaPesca.nombre.requerido", null, LocaleContextHolder.getLocale());
            mensaje += "* " + msg + "<br/>";
        }
        String msg = this.setValidacionesPrevias(bean);
        if (StringUtils.isNotBlank(msg)) {
            mensaje += "* " + msg + "<br/>";
        }
        return mensaje;
    }

    protected String setValidacionesPrevias(MtrZonaPesca bean) throws Exception {
        String mensaje = "";
        return mensaje;
    }

    protected String validacionesPreviasCreate(MtrZonaPesca bean) throws Exception {
        String msg = null;
        MtrZonaPesca validar = null;
        return msg;
    }

    protected String validacionesPreviasSave(MtrZonaPesca bean) throws Exception {
        String msg = null;
        MtrZonaPesca validar = null;
        return msg;
    }

    protected MtrZonaPesca completarDatosBean(MtrZonaPesca bean) throws Exception {
        BigDecimal data = new BigDecimal(0.00);
        bean = this.setCompletarDatosBean(bean);
        return bean;
    }

    protected MtrZonaPesca setCompletarDatosBean(MtrZonaPesca bean) throws Exception {
        return bean;
    }

    protected final MtrZonaPesca setAbstractCreate(MtrZonaPesca dto) throws Exception {
        MtrZonaPesca bean = new MtrZonaPesca();
        bean = (MtrZonaPesca) BeanUtils.cloneBean(dto);
        return bean;
    }

    /************************/
    /* METODOS CRUD Masivos */
    /************************/

    protected MtrZonaPesca setUploadExcel(Cell currentCell, MtrZonaPesca mtrZonaPesca, int contador) throws Exception {
        Double valorDouble = new Double(0);
        BigDecimal valorDecimal = new BigDecimal(0);
        Boolean valorBoolean = new Boolean(true);
        String valorCadena = "";
        switch (contador) {
        case 1:
            try {
                valorCadena = currentCell.getStringCellValue();
                if (valorCadena.length() > 100) {
                    throw new ServiceException("Valor Campo nombre contiene mas de 100 caracter(es)");
                }
                mtrZonaPesca.setNombre(valorCadena);
            } catch (Exception e) {
                throw new ServiceException("Valor Campo nombre está en formato incorrecto");
            }
            break;
        default:
            break;
        }
        return mtrZonaPesca;
    }

    protected AppParametria setObtenerRegistroConfiguracionUploadExcel() {
        AppParametria appParametriaData = this.appParametriaDeltaRepository.getByModuloAndLabelAndStatus(AppParametriaModuloEnum.CARGA_EXCEL.getEstado(),
                AppParametriaLabelEnum.INICIO_REGISTRO_DATA.getEstado(), Constants.ESTADO_ACTIVO);
        return appParametriaData;
    }

    protected MtrZonaPesca setInicializarBeanUpdateExcel() {
        MtrZonaPesca bean = new MtrZonaPesca();
        bean.setId(null);
        return bean;
    }

    protected final Integer setObtenerId(MtrZonaPesca bean) {
        return bean.getId();
    }

    /************************/
    /* Instancia de Bean    */
    /************************/

    protected final MtrZonaPesca createInstance() {
        MtrZonaPesca mtrZonaPesca = new MtrZonaPesca();
        return mtrZonaPesca;
    }

    protected final BeanCargaMasivoDTO<MtrZonaPesca> createInstanceMasivoDTO() {
        BeanCargaMasivoDTO<MtrZonaPesca> beanCargaMasivoDTO = new BeanCargaMasivoDTO<MtrZonaPesca>();
        return beanCargaMasivoDTO;

    }

    protected final BeanListaMasivoDTO<BeanCargaMasivoDTO<MtrZonaPesca>> createInstanceListaMasivoDTO() {
        BeanListaMasivoDTO<BeanCargaMasivoDTO<MtrZonaPesca>> beanCargaMasivoDTOBeanListaMasivoDTO = new BeanListaMasivoDTO<BeanCargaMasivoDTO<MtrZonaPesca>>();
        return beanCargaMasivoDTOBeanListaMasivoDTO;
    }

    /*****************************/
    /* Metodos que generan Excel */
    /*****************************/

    protected String devuelveNombreSheet() {
        return this.NAME_SHEET;
    }

    protected String devuelveListaHeaderExcelXML() {
        return this.CONFIG_TITLE;
    }

    protected int setAbstractDownloadExcel(MtrZonaPesca bean, HSSFRow dataRow) {
        int contador = 0;
        ExcelDefault.setValueCell(bean.getId(), dataRow.createCell(contador));
        contador++;
        ExcelDefault.setValueCell(bean.getNombre(), dataRow.createCell(contador));
        contador++;
        return contador;
    }

    protected int setAbstractDownloadExcelSXLSX(MtrZonaPesca bean, Row dataRow, List<CellStyle> cellStyleList) {
        int contador = 0;
        ExcelDefault.setValueCell(bean.getId(), dataRow.createCell(contador), "I", cellStyleList);
        contador++;
        ExcelDefault.setValueCell(bean.getNombre(), dataRow.createCell(contador), "S", cellStyleList);
        contador++;
        return contador;
    }

    protected String setAbstractGenerateInsertExcelSXLSX(MtrZonaPesca bean) {
        String fechaS = "";
        String sqlInsert = "INSERT INTO MTR_ZONA_PESCA(";
        sqlInsert = sqlInsert + "MTR_ZONA_PESCA_ID" + ", ";
        sqlInsert = sqlInsert + "NOMBRE" + ")";
        sqlInsert = sqlInsert + " VALUES (";
        sqlInsert = sqlInsert + bean.getId() + ", ";
        if (StringUtils.isBlank(bean.getNombre())) {
            sqlInsert = sqlInsert + "null";
        } else {
            sqlInsert = sqlInsert + "'" + bean.getNombre() + "'";
        }
        sqlInsert = sqlInsert + " );";
        return sqlInsert;
    }

    /*****************/
    /* Otros Metodos */
    /*****************/

}
