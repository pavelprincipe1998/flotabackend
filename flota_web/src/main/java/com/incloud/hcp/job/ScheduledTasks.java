package com.incloud.hcp.job;


import com.incloud.hcp.repository.delta.AppParametriaDeltaRepository;
import com.incloud.hcp.service.delta.CerNotaPedidoDeltaService;
import com.incloud.hcp.service.delta.SapRfcDeltaService;
import com.incloud.hcp.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    private CerNotaPedidoDeltaService cerNotaPedidoDeltaService;

    @Autowired
    private AppParametriaDeltaRepository appParametriaDeltaRepository;

    @Autowired
    private SapRfcDeltaService sapRfcDeltaService;

    @Scheduled(cron = "0 5 * * * ?")
    public void scheduleActualizarNPNoVigentes() {
        logger.error("Cron Task scheduleActualizarNPNoVigentes :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        try {
            this.cerNotaPedidoDeltaService.actualizarNoVigente();
        }
        catch (Exception e) {
            logger.error("Cron Task Fin JOB scheduleActualizarNPNoVigentes ERROR: " + Utils.obtieneMensajeErrorException(e));
        }
    }

   /* @Scheduled(cron = "0 00 00 * * ?")
    public void scheduleSincronizarDiarioNotaPedido() {
        logger.error("Cron Task liberacion nota de pedido scheduleSincronizarDiaria :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

        //java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd");
        AppParametria paramFechaInicial = this.appParametriaDeltaRepository.obtenerParametroPorModuloYLabel("Fecha_Consulta", "Fecha Inicio");
        AppParametria paramFechaFinal = this.appParametriaDeltaRepository.obtenerParametroPorModuloYLabel("Fecha_Consulta", "Fecha Fin");



        try {
            List<RangeSap> listaFecha = new ArrayList<RangeSap>();
            RangeSap range = new RangeSap();

            range.setSign("I");
            range.setOption("BT");
            range.setLow(paramFechaInicial.getValue1());
            range.setHigh(paramFechaFinal.getValue1());

            listaFecha.add(range);
            this.sapRfcDeltaService.integrarNotaPedido(null, listaFecha);

        }
        catch (Exception e) {
            logger.error("Cron Task Fin JOB liberacion nota de pedido scheduleSincronizarDiaria ERROR: " + Utils.obtieneMensajeErrorException(e));
        }
        logger.error("Cron Task Fin JOB liberacion nota de pedido scheduleSincronizarDiaria");
    }

    @Scheduled(fixedRate = 360000)
    public void scheduleSincronizarDiarioNotaPedido2() {
        logger.error("Cron Task liberacion nota de pedido cada 5 minutos scheduleSincronizarDiaria :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd");
        //AppParametria paramFechaInicial = this.appParametriaDeltaRepository.obtenerParametroPorModuloYLabel("Fecha_Consulta", "Fecha Inicio");
        //AppParametria paramFechaFinal = this.appParametriaDeltaRepository.obtenerParametroPorModuloYLabel("Fecha_Consulta", "Fecha Fin");
        Date dateAyer = new Date();
        Date dateManiana = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(dateAyer);
        c.add(Calendar.DATE, -1);
        dateAyer = c.getTime();

        c.setTime(dateManiana);
        c.add(Calendar.DATE, 1);
        dateManiana = c.getTime();


        try {
            List<RangeSap> listaFecha = new ArrayList<RangeSap>();
            RangeSap range = new RangeSap();

            range.setSign("I");
            range.setOption("BT");
            range.setLow(format.format(dateAyer));
            range.setHigh(format.format(dateManiana));

            listaFecha.add(range);
            this.sapRfcDeltaService.integrarNotaPedido(null, listaFecha);

        }
        catch (Exception e) {
            logger.error("Cron Task Fin JOB liberacion nota de pedido cada 5 minutos scheduleSincronizarDiaria ERROR: " + Utils.obtieneMensajeErrorException(e));
        }
        logger.error("Cron Task Fin JOB liberacion nota de pedido cada 5 minutos scheduleSincronizarDiaria");
    }*/

    @Scheduled(fixedRate = 900000)
    public void scheduleSincronizarMateriales() {
        logger.error("Cron Task scheduleSincronizarMateriales 15 minutos scheduleSincronizarDiaria :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd");
        //AppParametria paramFechaInicial = this.appParametriaDeltaRepository.obtenerParametroPorModuloYLabel("Fecha_Consulta", "Fecha Inicio");
        //AppParametria paramFechaFinal = this.appParametriaDeltaRepository.obtenerParametroPorModuloYLabel("Fecha_Consulta", "Fecha Fin");
        Date dateAyer = new Date();
        Date dateManiana = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(dateAyer);
        c.add(Calendar.DATE, -1);
        dateAyer = c.getTime();

        c.setTime(dateManiana);
        c.add(Calendar.DATE, 1);
        dateManiana = c.getTime();


        try {
            //Lis<RangeSap> listaFecha = new ArrayList<RangeSap>();
            //RangeSap range = new RangeSap();

            //range.setSign("I");
            //range.setOption("BT");
            //range.setLow(format.format(dateAyer));
            //range.setHigh(format.format(dateManiana));

            //listaFecha.add(range);
            this.sapRfcDeltaService.integrarMateriales(format.format(dateAyer), format.format(dateManiana));

        }
        catch (Exception e) {
            logger.error("Cron Task scheduleSincronizarMateriales cada 6 minutos scheduleSincronizarDiaria ERROR: " + Utils.obtieneMensajeErrorException(e));
        }
        logger.error("Cron Task Fin JOB scheduleSincronizarMateriales cada 6 minutos scheduleSincronizarDiaria");
    }

    @Scheduled(fixedRate = 900000)
    public void scheduleSincronizarListaServicio() {
        logger.error("Cron Task scheduleSincronizarListaServicio 15 minutos scheduleSincronizarDiaria :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd");
        //AppParametria paramFechaInicial = this.appParametriaDeltaRepository.obtenerParametroPorModuloYLabel("Fecha_Consulta", "Fecha Inicio");
        //AppParametria paramFechaFinal = this.appParametriaDeltaRepository.obtenerParametroPorModuloYLabel("Fecha_Consulta", "Fecha Fin");
        Date dateAyer = new Date();
        Date dateManiana = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(dateAyer);
        c.add(Calendar.DATE, -1);
        dateAyer = c.getTime();

        c.setTime(dateManiana);
        c.add(Calendar.DATE, 1);
        dateManiana = c.getTime();


        try {
            //Lis<RangeSap> listaFecha = new ArrayList<RangeSap>();
            //RangeSap range = new RangeSap();

            //range.setSign("I");
            //range.setOption("BT");
            //range.setLow(format.format(dateAyer));
            //range.setHigh(format.format(dateManiana));

            //listaFecha.add(range);
            this.sapRfcDeltaService.integrarServicios(format.format(dateAyer), format.format(dateManiana));

        }
        catch (Exception e) {
            logger.error("Cron Task scheduleSincronizarListaServicio cada 6 minutos scheduleSincronizarDiaria ERROR: " + Utils.obtieneMensajeErrorException(e));
        }
        logger.error("Cron Task Fin JOB scheduleSincronizarListaServicio cada 6 minutos scheduleSincronizarDiaria");
    }


}