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
import com.incloud.hcp.common.graph.GraphBarChart;
import com.incloud.hcp.common.graph.GraphBean;
import com.incloud.hcp.common.graph.GraphDataset;
import com.incloud.hcp.common.graph.GraphPieChart;
import com.incloud.hcp.domain.*;
import com.incloud.hcp.domain.response.MareaEventoResponse;
import com.incloud.hcp.exception.ServiceException;
import com.incloud.hcp.repository.delta.*;
import com.incloud.hcp.service.MareaEventoService;
import com.incloud.hcp.service._framework.bean.BeanCargaMasivoDTO;
import com.incloud.hcp.service._framework.bean.BeanListaMasivoDTO;
import com.incloud.hcp.service._framework.impl.JPACustomServiceImpl;
import com.incloud.hcp.service.delta.MtrEstadoDeltaService;
import com.incloud.hcp.service.delta.MtrTipoEventoDeltaService;
import com.incloud.hcp.service.delta.MtrZonaPescaDeltaService;
import com.incloud.hcp.service.requireNew.MareaEventoRequireNewService;
import com.incloud.hcp.service.support.PageRequestByExample;
import com.incloud.hcp.utils.Constants;
import com.incloud.hcp.utils.DateUtils;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * A simple DTO Facility for MareaEvento.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public abstract class MareaEventoServiceImpl extends JPACustomServiceImpl<MareaEventoResponse, MareaEvento, Integer> implements MareaEventoService {

    protected final String NAME_SHEET = "MareaEvento";
    protected final String CONFIG_TITLE = "com/incloud/hcp/excel/MareaEventoExcel.xml";
    private final Integer REGISTROS_COLOR = 10;

    @Autowired
    protected AppParametriaDeltaRepository appParametriaDeltaRepository;

    @Autowired
    protected MareaEventoDeltaRepository mareaEventoDeltaRepository;

    @Autowired
    protected MareaEventoRequireNewService mareaEventoRequireNewService;

    @Autowired
    protected MtrEstadoDeltaService mtrEstadoDeltaService;

    @Autowired
    protected MtrEstadoDeltaRepository mtrEstadoDeltaRepository;

    @Autowired
    protected MtrZonaPescaDeltaService mtrZonaPescaDeltaService;

    @Autowired
    protected MtrZonaPescaDeltaRepository mtrZonaPescaDeltaRepository;

    @Autowired
    protected MtrTipoEventoDeltaService mtrTipoEventoDeltaService;

    @Autowired
    protected MtrTipoEventoDeltaRepository mtrTipoEventoDeltaRepository;

    /*****************************/
    /* Metodos de Busqueda       */
    /*****************************/

    protected final ExampleMatcher setAbstractFind(ExampleMatcher matcher) {
        matcher = ExampleMatcher.matching() //
                .withMatcher(MareaEvento_.horaVento.getName(), match -> match.ignoreCase().startsWith());
        return matcher;
    }

    protected abstract Sort setFindAll(Sort sort);

    protected abstract Sort setFind(MareaEvento req, ExampleMatcher matcher, Example<MareaEvento> example, Sort sort);

    protected abstract void setFindPaginated(PageRequestByExample<MareaEvento> req, ExampleMatcher matcher, Example<MareaEvento> example);

    protected final MareaEvento setObtenerBeanResponse(MareaEventoResponse bean) {
        return bean.getBean();
    }

    protected final Class<MareaEvento> setObtenerClassBean() {
        return MareaEvento.class;
    }

    protected List<Predicate> setAbstractPredicate(MareaEventoResponse bean, CriteriaBuilder cb, Root<MareaEvento> root) {
        List<Predicate> predicates = new ArrayList<>();
        MareaEvento entity = bean.getBean();
        /* Obtener condiciones */
        PredicateUtils.addPredicates(predicates, bean.getIdCondicion(), "id", entity.getId(), cb, root);
        PredicateUtils.addPredicates(predicates, bean.getFechaEventoCondicion(), "fechaEvento", entity.getFechaEvento(), cb, root);
        PredicateUtils.addPredicates(predicates, bean.getHoraVentoCondicion(), "horaVento", entity.getHoraVento(), cb, root);
        PredicateUtils.addPredicates(predicates, bean.getStockCondicion(), "stock", entity.getStock(), cb, root);
        //PredicateUtils.addPredicates(predicates, bean.getMtrEstadoCondicion(), "mtrEstado", entity.getMtrEstado(), cb, root);
        //PredicateUtils.addPredicates(predicates, bean.getMtrZonaPescaCondicion(), "mtrZonaPesca", entity.getMtrZonaPesca(), cb, root);
        //PredicateUtils.addPredicates(predicates, bean.getMtrTipoEventoCondicion(), "mtrTipoEvento", entity.getMtrTipoEvento(), cb, root);
        /* Obtener valores de Lista */
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "id", bean.getIdList(), cb, root);
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "fechaEvento", bean.getFechaEventoList(), cb, root);
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "horaVento", bean.getHoraVentoList(), cb, root);
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "stock", bean.getStockList(), cb, root);
        //PredicateUtils.addPredicatesListValorBean(predicates, "mtrEstado", bean.getMtrEstadoList(), cb, root);
        //PredicateUtils.addPredicatesListValorBean(predicates, "mtrZonaPesca", bean.getMtrZonaPescaList(), cb, root);
        //PredicateUtils.addPredicatesListValorBean(predicates, "mtrTipoEvento", bean.getMtrTipoEventoList(), cb, root);
        return predicates;
    }

    /****************/
    /* METODOS CRUD */
    /****************/

    protected final String validacionesPrevias(MareaEvento bean) throws Exception {
        String mensaje = "";
        if (!Optional.of(bean.getFechaEvento()).isPresent()) {
            String msg = this.messageSource.getMessage("message.mareaEvento.fechaEvento.requerido", null, LocaleContextHolder.getLocale());
            mensaje += "* " + msg + "<br/>";
        }
        if (!Optional.of(bean.getHoraVento()).isPresent()) {
            String msg = this.messageSource.getMessage("message.mareaEvento.horaVento.requerido", null, LocaleContextHolder.getLocale());
            mensaje += "* " + msg + "<br/>";
        }
        String msg = this.setValidacionesPrevias(bean);
        if (StringUtils.isNotBlank(msg)) {
            mensaje += "* " + msg + "<br/>";
        }
        return mensaje;
    }

    protected String setValidacionesPrevias(MareaEvento bean) throws Exception {
        String mensaje = "";
        return mensaje;
    }

    protected String validacionesPreviasCreate(MareaEvento bean) throws Exception {
        String msg = null;
        MareaEvento validar = null;
        return msg;
    }

    protected String validacionesPreviasSave(MareaEvento bean) throws Exception {
        String msg = null;
        MareaEvento validar = null;
        return msg;
    }

    protected MareaEvento completarDatosBean(MareaEvento bean) throws Exception {
        BigDecimal data = new BigDecimal(0.00);
        if (Optional.ofNullable(bean.getStock()).isPresent()) {
            bean.setStock(bean.getStock().setScale(2, BigDecimal.ROUND_HALF_UP));
        }
        bean = this.setCompletarDatosBean(bean);
        return bean;
    }

    protected MareaEvento setCompletarDatosBean(MareaEvento bean) throws Exception {
        return bean;
    }

    protected final MareaEvento setAbstractCreate(MareaEvento dto) throws Exception {
        MareaEvento bean = new MareaEvento();
        bean = (MareaEvento) BeanUtils.cloneBean(dto);
        return bean;
    }

    /************************/
    /* METODOS CRUD Masivos */
    /************************/

    protected MareaEvento setUploadExcel(Cell currentCell, MareaEvento mareaEvento, int contador) throws Exception {
        Double valorDouble = new Double(0);
        BigDecimal valorDecimal = new BigDecimal(0);
        Boolean valorBoolean = new Boolean(true);
        String valorCadena = "";
        switch (contador) {
        case 1:
            try {
                valorCadena = currentCell.getStringCellValue();
                Date valorFechaD = DateUtils.convertStringToDate("dd/MM/yyyy", valorCadena);
                mareaEvento.setFechaEvento(valorFechaD);
            } catch (Exception ex) {
                throw new ServiceException("Valor Campo fechaEvento está en formato incorrecto");
            }
            break;
        case 2:
            try {
                valorCadena = currentCell.getStringCellValue();
                if (valorCadena.length() > 10) {
                    throw new ServiceException("Valor Campo horaVento contiene mas de 10 caracter(es)");
                }
                mareaEvento.setHoraVento(valorCadena);
            } catch (Exception e) {
                throw new ServiceException("Valor Campo horaVento está en formato incorrecto");
            }
            break;
        case 3:
            try {
                valorDecimal = new BigDecimal(currentCell.getNumericCellValue());
                mareaEvento.setStock(valorDecimal);
            } catch (Exception e) {
                throw new ServiceException("Valor Campo stock está en formato incorrecto");
            }
            break;
        default:
            break;
        }
        return mareaEvento;
    }

    protected AppParametria setObtenerRegistroConfiguracionUploadExcel() {
        AppParametria appParametriaData = this.appParametriaDeltaRepository.getByModuloAndLabelAndStatus(AppParametriaModuloEnum.CARGA_EXCEL.getEstado(),
                AppParametriaLabelEnum.INICIO_REGISTRO_DATA.getEstado(), Constants.ESTADO_ACTIVO);
        return appParametriaData;
    }

    protected MareaEvento setInicializarBeanUpdateExcel() {
        MareaEvento bean = new MareaEvento();
        bean.setId(null);
        return bean;
    }

    protected final Integer setObtenerId(MareaEvento bean) {
        return bean.getId();
    }

    /************************/
    /* Instancia de Bean    */
    /************************/

    protected final MareaEvento createInstance() {
        MareaEvento mareaEvento = new MareaEvento();
        return mareaEvento;
    }

    protected final BeanCargaMasivoDTO<MareaEvento> createInstanceMasivoDTO() {
        BeanCargaMasivoDTO<MareaEvento> beanCargaMasivoDTO = new BeanCargaMasivoDTO<MareaEvento>();
        return beanCargaMasivoDTO;

    }

    protected final BeanListaMasivoDTO<BeanCargaMasivoDTO<MareaEvento>> createInstanceListaMasivoDTO() {
        BeanListaMasivoDTO<BeanCargaMasivoDTO<MareaEvento>> beanCargaMasivoDTOBeanListaMasivoDTO = new BeanListaMasivoDTO<BeanCargaMasivoDTO<MareaEvento>>();
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

    protected int setAbstractDownloadExcel(MareaEvento bean, HSSFRow dataRow) {
        int contador = 0;
        ExcelDefault.setValueCell(bean.getId(), dataRow.createCell(contador));
        contador++;
        ExcelDefault.setValueCell(bean.getFechaEvento(), dataRow.createCell(contador));
        contador++;
        ExcelDefault.setValueCell(bean.getHoraVento(), dataRow.createCell(contador));
        contador++;
        ExcelDefault.setValueCell(bean.getStock(), dataRow.createCell(contador));
        contador++;
        return contador;
    }

    protected int setAbstractDownloadExcelSXLSX(MareaEvento bean, Row dataRow, List<CellStyle> cellStyleList) {
        int contador = 0;
        ExcelDefault.setValueCell(bean.getId(), dataRow.createCell(contador), "I", cellStyleList);
        contador++;
        ExcelDefault.setValueCell(bean.getFechaEvento(), dataRow.createCell(contador), "DT", cellStyleList);
        contador++;
        ExcelDefault.setValueCell(bean.getHoraVento(), dataRow.createCell(contador), "S", cellStyleList);
        contador++;
        ExcelDefault.setValueCell(bean.getStock(), dataRow.createCell(contador), "N", cellStyleList);
        contador++;
        return contador;
    }

    protected String setAbstractGenerateInsertExcelSXLSX(MareaEvento bean) {
        String fechaS = "";
        String sqlInsert = "INSERT INTO MAREA_EVENTO(";
        sqlInsert = sqlInsert + "MAREA_EVENTO_ID" + ", ";
        sqlInsert = sqlInsert + "FECHA_EVENTO" + ", ";
        sqlInsert = sqlInsert + "HORA_VENTO" + ", ";
        sqlInsert = sqlInsert + "STOCK" + ", ";
        sqlInsert = sqlInsert + "MTR_TIPO_EVENTO_ID" + ", ";
        sqlInsert = sqlInsert + "MTR_ZONA_PESCA_ID" + ", ";
        sqlInsert = sqlInsert + "MTR_ESTADO_ID" + ")";
        sqlInsert = sqlInsert + " VALUES (";
        sqlInsert = sqlInsert + bean.getId() + ", ";
        if (bean.getFechaEvento() != null) {
            fechaS = DateUtils.convertDateToString("dd/MM/yyyy HH:mm:ss", bean.getFechaEvento());
            sqlInsert = sqlInsert + "to_date('" + fechaS + "','dd/MM/yyyy HH:mm:ss')" + ", ";
        } else {
            sqlInsert = sqlInsert + "null" + ", ";
        }
        if (StringUtils.isBlank(bean.getHoraVento())) {
            sqlInsert = sqlInsert + "null" + ", ";
        } else {
            sqlInsert = sqlInsert + "'" + bean.getHoraVento() + "'" + ", ";
        }
        sqlInsert = sqlInsert + bean.getStock() + ", ";
        sqlInsert = sqlInsert + bean.getMtrEstado().getId() + ", ";
        sqlInsert = sqlInsert + bean.getMtrZonaPesca().getId() + ", ";
        sqlInsert = sqlInsert + bean.getMtrTipoEvento().getId();
        sqlInsert = sqlInsert + " );";
        return sqlInsert;
    }

    /*****************/
    /* Otros Metodos */
    /*****************/

    public Long countByMtrEstado(MtrEstado mtrEstado) {
        return this.mareaEventoDeltaRepository.countByMtrEstado(mtrEstado);
    }

    public GraphBean graphByMtrEstado() {
        List<MtrEstado> lista = this.mtrEstadoDeltaRepository.findAll();
        if (lista == null || lista.size() <= 0) {
            return null;
        }
        GraphBean graphBean = new GraphBean();

        /* Obteniendo Pie Chart */
        GraphPieChart graphPieChart = new GraphPieChart();
        GraphDataset graphDataset = new GraphDataset();
        GraphDataset[] listaGraphDataset = new GraphDataset[1];
        Long[] data = new Long[lista.size()];
        String[] labels = new String[lista.size()];
        String[] backgroundColor = new String[lista.size()];
        String[] hoverBackgroundColor = new String[lista.size()];
        String[] borderColor = new String[lista.size()];
        String[] hoverBorderColor = new String[lista.size()];
        int contador = 0;
        int contadorColor = 0;
        for (MtrEstado bean : lista) {
            Long valor = this.mareaEventoDeltaRepository.countByMtrEstado(bean);
            String descripcion = this.setGraphDescripcionByMtrEstado(bean);
            data[contador] = valor;
            labels[contador] = descripcion;
            backgroundColor[contador] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBackgroundColor[contador] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            borderColor[contador] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBorderColor[contador] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            contador++;
            contadorColor++;
            if (contadorColor >= REGISTROS_COLOR) {
                contadorColor = 1;
            }
        }
        String titulo = this.setGraphPieChartTituloByMtrEstado();
        graphDataset.setLabel(titulo);
        graphDataset.setData(data);
        graphDataset.setBackgroundColor(backgroundColor);
        graphDataset.setHoverBackgroundColor(hoverBackgroundColor);
        listaGraphDataset[0] = graphDataset;
        graphPieChart.setDatasets(listaGraphDataset);
        graphPieChart.setLabels(labels);
        graphBean.setPiechart(graphPieChart);

        GraphBarChart graphBarChart = new GraphBarChart();
        GraphDataset[] listaGraphDatasetBar = new GraphDataset[lista.size()];
        String[] labelsBar = new String[1];
        labelsBar[0] = this.setGraphBarChartTituloByMtrEstado();
        contador = 0;
        contadorColor = 0;
        for (MtrEstado bean : lista) {
            Long valor = this.mareaEventoDeltaRepository.countByMtrEstado(bean);
            String descripcion = this.setGraphDescripcionByMtrEstado(bean);
            GraphDataset graphDatasetBar = new GraphDataset();
            Long[] dataBar = new Long[1];

            String[] backgroundColorBar = new String[1];
            String[] hoverBackgroundColorBar = new String[1];
            String[] borderColorBar = new String[1];
            String[] hoverBorderColorBar = new String[1];

            dataBar[0] = valor;
            backgroundColorBar[0] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBackgroundColorBar[0] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            borderColorBar[0] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBorderColorBar[0] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];

            graphDatasetBar.setLabel(descripcion);
            graphDatasetBar.setData(dataBar);
            graphDatasetBar.setBackgroundColor(backgroundColorBar);
            graphDatasetBar.setHoverBackgroundColor(hoverBackgroundColorBar);
            graphDatasetBar.setBorderColor(borderColorBar);
            graphDatasetBar.setHoverBorderColor(hoverBorderColorBar);
            listaGraphDatasetBar[contador] = graphDatasetBar;

            contador++;
            contadorColor++;
            if (contadorColor >= REGISTROS_COLOR) {
                contadorColor = 1;
            }

        }
        graphBarChart.setDatasets(listaGraphDatasetBar);
        graphBarChart.setLabels(labelsBar);
        graphBean.setBarchart(graphBarChart);
        return graphBean;
    }

    protected String setGraphDescripcionByMtrEstado(MtrEstado mtrEstado) {
        return mtrEstado.getId().toString();
    }

    protected String setGraphPieChartTituloByMtrEstado() {
        return "MtrEstado";
    }

    protected String setGraphBarChartTituloByMtrEstado() {
        return "MtrEstado";
    }

    public Long countByMtrZonaPesca(MtrZonaPesca mtrZonaPesca) {
        return this.mareaEventoDeltaRepository.countByMtrZonaPesca(mtrZonaPesca);
    }

    public GraphBean graphByMtrZonaPesca() {
        List<MtrZonaPesca> lista = this.mtrZonaPescaDeltaRepository.findAll();
        if (lista == null || lista.size() <= 0) {
            return null;
        }
        GraphBean graphBean = new GraphBean();

        /* Obteniendo Pie Chart */
        GraphPieChart graphPieChart = new GraphPieChart();
        GraphDataset graphDataset = new GraphDataset();
        GraphDataset[] listaGraphDataset = new GraphDataset[1];
        Long[] data = new Long[lista.size()];
        String[] labels = new String[lista.size()];
        String[] backgroundColor = new String[lista.size()];
        String[] hoverBackgroundColor = new String[lista.size()];
        String[] borderColor = new String[lista.size()];
        String[] hoverBorderColor = new String[lista.size()];
        int contador = 0;
        int contadorColor = 0;
        for (MtrZonaPesca bean : lista) {
            Long valor = this.mareaEventoDeltaRepository.countByMtrZonaPesca(bean);
            String descripcion = this.setGraphDescripcionByMtrZonaPesca(bean);
            data[contador] = valor;
            labels[contador] = descripcion;
            backgroundColor[contador] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBackgroundColor[contador] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            borderColor[contador] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBorderColor[contador] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            contador++;
            contadorColor++;
            if (contadorColor >= REGISTROS_COLOR) {
                contadorColor = 1;
            }
        }
        String titulo = this.setGraphPieChartTituloByMtrZonaPesca();
        graphDataset.setLabel(titulo);
        graphDataset.setData(data);
        graphDataset.setBackgroundColor(backgroundColor);
        graphDataset.setHoverBackgroundColor(hoverBackgroundColor);
        listaGraphDataset[0] = graphDataset;
        graphPieChart.setDatasets(listaGraphDataset);
        graphPieChart.setLabels(labels);
        graphBean.setPiechart(graphPieChart);

        GraphBarChart graphBarChart = new GraphBarChart();
        GraphDataset[] listaGraphDatasetBar = new GraphDataset[lista.size()];
        String[] labelsBar = new String[1];
        labelsBar[0] = this.setGraphBarChartTituloByMtrZonaPesca();
        contador = 0;
        contadorColor = 0;
        for (MtrZonaPesca bean : lista) {
            Long valor = this.mareaEventoDeltaRepository.countByMtrZonaPesca(bean);
            String descripcion = this.setGraphDescripcionByMtrZonaPesca(bean);
            GraphDataset graphDatasetBar = new GraphDataset();
            Long[] dataBar = new Long[1];

            String[] backgroundColorBar = new String[1];
            String[] hoverBackgroundColorBar = new String[1];
            String[] borderColorBar = new String[1];
            String[] hoverBorderColorBar = new String[1];

            dataBar[0] = valor;
            backgroundColorBar[0] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBackgroundColorBar[0] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            borderColorBar[0] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBorderColorBar[0] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];

            graphDatasetBar.setLabel(descripcion);
            graphDatasetBar.setData(dataBar);
            graphDatasetBar.setBackgroundColor(backgroundColorBar);
            graphDatasetBar.setHoverBackgroundColor(hoverBackgroundColorBar);
            graphDatasetBar.setBorderColor(borderColorBar);
            graphDatasetBar.setHoverBorderColor(hoverBorderColorBar);
            listaGraphDatasetBar[contador] = graphDatasetBar;

            contador++;
            contadorColor++;
            if (contadorColor >= REGISTROS_COLOR) {
                contadorColor = 1;
            }

        }
        graphBarChart.setDatasets(listaGraphDatasetBar);
        graphBarChart.setLabels(labelsBar);
        graphBean.setBarchart(graphBarChart);
        return graphBean;
    }

    protected String setGraphDescripcionByMtrZonaPesca(MtrZonaPesca mtrZonaPesca) {
        return mtrZonaPesca.getId().toString();
    }

    protected String setGraphPieChartTituloByMtrZonaPesca() {
        return "MtrZonaPesca";
    }

    protected String setGraphBarChartTituloByMtrZonaPesca() {
        return "MtrZonaPesca";
    }

    public Long countByMtrTipoEvento(MtrTipoEvento mtrTipoEvento) {
        return this.mareaEventoDeltaRepository.countByMtrTipoEvento(mtrTipoEvento);
    }

    public GraphBean graphByMtrTipoEvento() {
        List<MtrTipoEvento> lista = this.mtrTipoEventoDeltaRepository.findAll();
        if (lista == null || lista.size() <= 0) {
            return null;
        }
        GraphBean graphBean = new GraphBean();

        /* Obteniendo Pie Chart */
        GraphPieChart graphPieChart = new GraphPieChart();
        GraphDataset graphDataset = new GraphDataset();
        GraphDataset[] listaGraphDataset = new GraphDataset[1];
        Long[] data = new Long[lista.size()];
        String[] labels = new String[lista.size()];
        String[] backgroundColor = new String[lista.size()];
        String[] hoverBackgroundColor = new String[lista.size()];
        String[] borderColor = new String[lista.size()];
        String[] hoverBorderColor = new String[lista.size()];
        int contador = 0;
        int contadorColor = 0;
        for (MtrTipoEvento bean : lista) {
            Long valor = this.mareaEventoDeltaRepository.countByMtrTipoEvento(bean);
            String descripcion = this.setGraphDescripcionByMtrTipoEvento(bean);
            data[contador] = valor;
            labels[contador] = descripcion;
            backgroundColor[contador] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBackgroundColor[contador] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            borderColor[contador] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBorderColor[contador] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            contador++;
            contadorColor++;
            if (contadorColor >= REGISTROS_COLOR) {
                contadorColor = 1;
            }
        }
        String titulo = this.setGraphPieChartTituloByMtrTipoEvento();
        graphDataset.setLabel(titulo);
        graphDataset.setData(data);
        graphDataset.setBackgroundColor(backgroundColor);
        graphDataset.setHoverBackgroundColor(hoverBackgroundColor);
        listaGraphDataset[0] = graphDataset;
        graphPieChart.setDatasets(listaGraphDataset);
        graphPieChart.setLabels(labels);
        graphBean.setPiechart(graphPieChart);

        GraphBarChart graphBarChart = new GraphBarChart();
        GraphDataset[] listaGraphDatasetBar = new GraphDataset[lista.size()];
        String[] labelsBar = new String[1];
        labelsBar[0] = this.setGraphBarChartTituloByMtrTipoEvento();
        contador = 0;
        contadorColor = 0;
        for (MtrTipoEvento bean : lista) {
            Long valor = this.mareaEventoDeltaRepository.countByMtrTipoEvento(bean);
            String descripcion = this.setGraphDescripcionByMtrTipoEvento(bean);
            GraphDataset graphDatasetBar = new GraphDataset();
            Long[] dataBar = new Long[1];

            String[] backgroundColorBar = new String[1];
            String[] hoverBackgroundColorBar = new String[1];
            String[] borderColorBar = new String[1];
            String[] hoverBorderColorBar = new String[1];

            dataBar[0] = valor;
            backgroundColorBar[0] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBackgroundColorBar[0] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            borderColorBar[0] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBorderColorBar[0] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];

            graphDatasetBar.setLabel(descripcion);
            graphDatasetBar.setData(dataBar);
            graphDatasetBar.setBackgroundColor(backgroundColorBar);
            graphDatasetBar.setHoverBackgroundColor(hoverBackgroundColorBar);
            graphDatasetBar.setBorderColor(borderColorBar);
            graphDatasetBar.setHoverBorderColor(hoverBorderColorBar);
            listaGraphDatasetBar[contador] = graphDatasetBar;

            contador++;
            contadorColor++;
            if (contadorColor >= REGISTROS_COLOR) {
                contadorColor = 1;
            }

        }
        graphBarChart.setDatasets(listaGraphDatasetBar);
        graphBarChart.setLabels(labelsBar);
        graphBean.setBarchart(graphBarChart);
        return graphBean;
    }

    protected String setGraphDescripcionByMtrTipoEvento(MtrTipoEvento mtrTipoEvento) {
        return mtrTipoEvento.getId().toString();
    }

    protected String setGraphPieChartTituloByMtrTipoEvento() {
        return "MtrTipoEvento";
    }

    protected String setGraphBarChartTituloByMtrTipoEvento() {
        return "MtrTipoEvento";
    }

}
