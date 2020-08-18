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
import com.incloud.hcp.domain.MtrTipoPesca;
import com.incloud.hcp.domain.MtrTipoPesca_;
import com.incloud.hcp.domain.response.MtrTipoPescaResponse;
import com.incloud.hcp.exception.ServiceException;
import com.incloud.hcp.repository.delta.AppParametriaDeltaRepository;
import com.incloud.hcp.repository.delta.MtrTipoPescaDeltaRepository;
import com.incloud.hcp.service.MtrTipoPescaService;
import com.incloud.hcp.service._framework.bean.BeanCargaMasivoDTO;
import com.incloud.hcp.service._framework.bean.BeanListaMasivoDTO;
import com.incloud.hcp.service._framework.impl.JPACustomServiceImpl;
import com.incloud.hcp.service.requireNew.MtrTipoPescaRequireNewService;
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
 * A simple DTO Facility for MtrTipoPesca.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public abstract class MtrTipoPescaServiceImpl extends JPACustomServiceImpl<MtrTipoPescaResponse, MtrTipoPesca, Integer> implements MtrTipoPescaService {

    protected final String NAME_SHEET = "MtrTipoPesca";
    protected final String CONFIG_TITLE = "com/incloud/hcp/excel/MtrTipoPescaExcel.xml";
    private final Integer REGISTROS_COLOR = 10;

    @Autowired
    protected AppParametriaDeltaRepository appParametriaDeltaRepository;

    @Autowired
    protected MtrTipoPescaDeltaRepository mtrTipoPescaDeltaRepository;

    @Autowired
    protected MtrTipoPescaRequireNewService mtrTipoPescaRequireNewService;

    /*****************************/
    /* Metodos de Busqueda       */
    /*****************************/

    protected final ExampleMatcher setAbstractFind(ExampleMatcher matcher) {
        matcher = ExampleMatcher.matching() //
                .withMatcher(MtrTipoPesca_.nombre.getName(), match -> match.ignoreCase().startsWith())
                .withMatcher(MtrTipoPesca_.inubc.getName(), match -> match.ignoreCase().startsWith());
        return matcher;
    }

    protected abstract Sort setFindAll(Sort sort);

    protected abstract Sort setFind(MtrTipoPesca req, ExampleMatcher matcher, Example<MtrTipoPesca> example, Sort sort);

    protected abstract void setFindPaginated(PageRequestByExample<MtrTipoPesca> req, ExampleMatcher matcher, Example<MtrTipoPesca> example);

    protected final MtrTipoPesca setObtenerBeanResponse(MtrTipoPescaResponse bean) {
        return bean.getBean();
    }

    protected final Class<MtrTipoPesca> setObtenerClassBean() {
        return MtrTipoPesca.class;
    }

    protected List<Predicate> setAbstractPredicate(MtrTipoPescaResponse bean, CriteriaBuilder cb, Root<MtrTipoPesca> root) {
        List<Predicate> predicates = new ArrayList<>();
        MtrTipoPesca entity = bean.getBean();
        /* Obtener condiciones */
        PredicateUtils.addPredicates(predicates, bean.getIdCondicion(), "id", entity.getId(), cb, root);
        PredicateUtils.addPredicates(predicates, bean.getNombreCondicion(), "nombre", entity.getNombre(), cb, root);
        PredicateUtils.addPredicates(predicates, bean.getInubcCondicion(), "inubc", entity.getInubc(), cb, root);
        /* Obtener valores de Lista */
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "id", bean.getIdList(), cb, root);
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "nombre", bean.getNombreList(), cb, root);
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "inubc", bean.getInubcList(), cb, root);
        return predicates;
    }

    /****************/
    /* METODOS CRUD */
    /****************/

    protected final String validacionesPrevias(MtrTipoPesca bean) throws Exception {
        String mensaje = "";
        if (!Optional.of(bean.getNombre()).isPresent()) {
            String msg = this.messageSource.getMessage("message.mtrTipoPesca.nombre.requerido", null, LocaleContextHolder.getLocale());
            mensaje += "* " + msg + "<br/>";
        }
        String msg = this.setValidacionesPrevias(bean);
        if (StringUtils.isNotBlank(msg)) {
            mensaje += "* " + msg + "<br/>";
        }
        return mensaje;
    }

    protected String setValidacionesPrevias(MtrTipoPesca bean) throws Exception {
        String mensaje = "";
        return mensaje;
    }

    protected String validacionesPreviasCreate(MtrTipoPesca bean) throws Exception {
        String msg = null;
        MtrTipoPesca validar = null;
        return msg;
    }

    protected String validacionesPreviasSave(MtrTipoPesca bean) throws Exception {
        String msg = null;
        MtrTipoPesca validar = null;
        return msg;
    }

    protected MtrTipoPesca completarDatosBean(MtrTipoPesca bean) throws Exception {
        BigDecimal data = new BigDecimal(0.00);
        bean = this.setCompletarDatosBean(bean);
        return bean;
    }

    protected MtrTipoPesca setCompletarDatosBean(MtrTipoPesca bean) throws Exception {
        return bean;
    }

    protected final MtrTipoPesca setAbstractCreate(MtrTipoPesca dto) throws Exception {
        MtrTipoPesca bean = new MtrTipoPesca();
        bean = (MtrTipoPesca) BeanUtils.cloneBean(dto);
        return bean;
    }

    /************************/
    /* METODOS CRUD Masivos */
    /************************/

    protected MtrTipoPesca setUploadExcel(Cell currentCell, MtrTipoPesca mtrTipoPesca, int contador) throws Exception {
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
                mtrTipoPesca.setNombre(valorCadena);
            } catch (Exception e) {
                throw new ServiceException("Valor Campo nombre está en formato incorrecto");
            }
            break;
        case 2:
            try {
                valorCadena = currentCell.getStringCellValue();
                if (valorCadena.length() > 1) {
                    throw new ServiceException("Valor Campo inubc contiene mas de 1 caracter(es)");
                }
                mtrTipoPesca.setInubc(valorCadena);
            } catch (Exception e) {
                throw new ServiceException("Valor Campo inubc está en formato incorrecto");
            }
            break;
        default:
            break;
        }
        return mtrTipoPesca;
    }

    protected AppParametria setObtenerRegistroConfiguracionUploadExcel() {
        AppParametria appParametriaData = this.appParametriaDeltaRepository.getByModuloAndLabelAndStatus(AppParametriaModuloEnum.CARGA_EXCEL.getEstado(),
                AppParametriaLabelEnum.INICIO_REGISTRO_DATA.getEstado(), Constants.ESTADO_ACTIVO);
        return appParametriaData;
    }

    protected MtrTipoPesca setInicializarBeanUpdateExcel() {
        MtrTipoPesca bean = new MtrTipoPesca();
        bean.setId(null);
        return bean;
    }

    protected final Integer setObtenerId(MtrTipoPesca bean) {
        return bean.getId();
    }

    /************************/
    /* Instancia de Bean    */
    /************************/

    protected final MtrTipoPesca createInstance() {
        MtrTipoPesca mtrTipoPesca = new MtrTipoPesca();
        return mtrTipoPesca;
    }

    protected final BeanCargaMasivoDTO<MtrTipoPesca> createInstanceMasivoDTO() {
        BeanCargaMasivoDTO<MtrTipoPesca> beanCargaMasivoDTO = new BeanCargaMasivoDTO<MtrTipoPesca>();
        return beanCargaMasivoDTO;

    }

    protected final BeanListaMasivoDTO<BeanCargaMasivoDTO<MtrTipoPesca>> createInstanceListaMasivoDTO() {
        BeanListaMasivoDTO<BeanCargaMasivoDTO<MtrTipoPesca>> beanCargaMasivoDTOBeanListaMasivoDTO = new BeanListaMasivoDTO<BeanCargaMasivoDTO<MtrTipoPesca>>();
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

    protected int setAbstractDownloadExcel(MtrTipoPesca bean, HSSFRow dataRow) {
        int contador = 0;
        ExcelDefault.setValueCell(bean.getId(), dataRow.createCell(contador));
        contador++;
        ExcelDefault.setValueCell(bean.getNombre(), dataRow.createCell(contador));
        contador++;
        ExcelDefault.setValueCell(bean.getInubc(), dataRow.createCell(contador));
        contador++;
        return contador;
    }

    protected int setAbstractDownloadExcelSXLSX(MtrTipoPesca bean, Row dataRow, List<CellStyle> cellStyleList) {
        int contador = 0;
        ExcelDefault.setValueCell(bean.getId(), dataRow.createCell(contador), "I", cellStyleList);
        contador++;
        ExcelDefault.setValueCell(bean.getNombre(), dataRow.createCell(contador), "S", cellStyleList);
        contador++;
        ExcelDefault.setValueCell(bean.getInubc(), dataRow.createCell(contador), "S", cellStyleList);
        contador++;
        return contador;
    }

    protected String setAbstractGenerateInsertExcelSXLSX(MtrTipoPesca bean) {
        String fechaS = "";
        String sqlInsert = "INSERT INTO MTR_TIPO_PESCA(";
        sqlInsert = sqlInsert + "MTR_TIPO_PESCA_ID" + ", ";
        sqlInsert = sqlInsert + "NOMBRE" + ", ";
        sqlInsert = sqlInsert + "INUBC" + ")";
        sqlInsert = sqlInsert + " VALUES (";
        sqlInsert = sqlInsert + bean.getId() + ", ";
        if (StringUtils.isBlank(bean.getNombre())) {
            sqlInsert = sqlInsert + "null" + ", ";
        } else {
            sqlInsert = sqlInsert + "'" + bean.getNombre() + "'" + ", ";
        }
        if (StringUtils.isBlank(bean.getInubc())) {
            sqlInsert = sqlInsert + "null";
        } else {
            sqlInsert = sqlInsert + "'" + bean.getInubc() + "'";
        }
        sqlInsert = sqlInsert + " );";
        return sqlInsert;
    }

    /*****************/
    /* Otros Metodos */
    /*****************/

}