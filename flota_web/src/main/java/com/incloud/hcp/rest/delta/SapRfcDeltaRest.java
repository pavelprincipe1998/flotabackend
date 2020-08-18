package com.incloud.hcp.rest.delta;

import com.incloud.hcp.bean.custom.*;
import com.incloud.hcp.rest.SapRfcRest;
import com.incloud.hcp.service.delta.CerHistorialDeltaService;
import com.incloud.hcp.service.delta.SapRfcDeltaService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/integrasap")
public class SapRfcDeltaRest extends SapRfcRest {
    private final Logger log = LoggerFactory.getLogger(SapRfcDeltaRest.class);

    @Autowired
    protected CerHistorialDeltaService cerHistorialDeltaService;

    @Autowired
    protected SapRfcDeltaService sapRfcDeltaService;

    @ApiOperation(value = "Integracion de ordenes de compra", produces = "application/json")
    @RequestMapping(value = "/integraOrdenCompra", method = RequestMethod.POST, headers = "Accept=application/json")
    ResponseEntity<List<DescargaServicioSap>> integraOrdenCompra(@RequestBody FiltroRangeDescarga filtroRangeDescarga)
             {

                 return Optional.of(this.sapRfcDeltaService.listaDescarga(filtroRangeDescarga.getListaRangeDoc(), filtroRangeDescarga.getListaRangeFecha()))
                         .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                         .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Detalle integracion de ordenes de compra", produces = "application/json")
    @RequestMapping(value = "/integraOrdenCompraDetalle", method = RequestMethod.POST, headers = "Accept=application/json")
    ResponseEntity<List<DescargaServicioSap>> integraOrdenCompraDetalle(@RequestBody FiltroRangeDescarga filtroRangeDescarga)
    {

        return Optional.of(this.sapRfcDeltaService.listaDescargaDetalle(filtroRangeDescarga.getListaRangeDoc(), filtroRangeDescarga.getListaRangeFecha()))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Servicio Creación Hes", produces = "application/json")
    @RequestMapping(value = "/creacionHes", method = RequestMethod.POST, headers = "Accept=application/json")
    ResponseEntity<List<RemitoOutSap>> creacionHes(@RequestBody FiltroCreacionHes filtroCreacionHes)
    {

        return Optional.of(this.sapRfcDeltaService.creacionHes(filtroCreacionHes.getListaIn()))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Servicio Creación Hes 2", produces = "application/json")
    @RequestMapping(value = "/crearHes", method = RequestMethod.POST, headers = "Accept=application/json")
    ResponseEntity<List<RemitoOutSap>> crearHes(@RequestBody FiltroCreacionHes filtroCreacionHes)
    {

        return Optional.of(this.sapRfcDeltaService.crearHes(filtroCreacionHes.getListaIn()))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }


    @ApiOperation(value = "Consulta Clase Documento", produces = "application/json")
    @RequestMapping(value = "/claseDoc", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<TextClaseDocSap>> getDetailsMaterial()   {

        return Optional.of(this.sapRfcDeltaService.listaClaseDocumentos())
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Lista Centro Sap", produces = "application/json")
    @RequestMapping(value = "/centroSap/{sociedad}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<CentroSap>> listaCentroSap(@PathVariable String sociedad)   {

        return Optional.of(this.sapRfcDeltaService.listaCentroSap(sociedad))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Lista Centro almacen Sap", produces = "application/json")
    @RequestMapping(value = "/centroAlmacenSap/{sociedad}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<CentroAlmacenSap>> listaCentroAlmacenSap(@PathVariable String sociedad)   {

        return Optional.of(this.sapRfcDeltaService.listaCentroAlmacen(sociedad))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        //sdsffhfghfghfghfh
    }

    @ApiOperation(value = "Integrar Unidad de medida", produces = "application/json")
    @RequestMapping(value = "/integra/unidadMedida", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<MensajeSap>> unidadMedia()   {

        return Optional.of(this.sapRfcDeltaService.integrarUnidadMedida())
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        //sdsffhfghfghfghfh
    }
    @ApiOperation(value = "Integrar Grupo de articulos", produces = "application/json")
    @RequestMapping(value = "/integra/grupoArticulo", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<MensajeSap>> grupoArticulo()   {

        return Optional.of(this.sapRfcDeltaService.integrarGrupoArticulos(null))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        //sdsffhfghfghfghfh
    }

    @ApiOperation(value = "Integracion de Materiales", produces = "application/json")
    @RequestMapping(value = "/integraMateriales", method = RequestMethod.POST, headers = "Accept=application/json")
    ResponseEntity<List<MensajeSap>> integraMateriales(@RequestBody FiltroIntegracion filtro)
    {

        return Optional.of(this.sapRfcDeltaService.integrarMateriales(filtro.getFechaInicio(), filtro.getFechaFin()))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Integracion de Servicios", produces = "application/json")
    @RequestMapping(value = "/integraServicios", method = RequestMethod.POST, headers = "Accept=application/json")
    ResponseEntity<List<MensajeSap>> integraServicios(@RequestBody FiltroIntegracion filtro)
    {

        return Optional.of(this.sapRfcDeltaService.integrarServicios(filtro.getFechaInicio(), filtro.getFechaFin()))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Integracion de Proveedores", produces = "application/json")
    @RequestMapping(value = "/integraProveedores", method = RequestMethod.POST, headers = "Accept=application/json")
    ResponseEntity<List<MensajeSap>> integraProveedores(@RequestBody FiltroIntegracion filtro)
    {

        return Optional.of(this.sapRfcDeltaService.integrarProveedor(filtro.getFechaInicio(), filtro.getFechaFin(), filtro.getLifnr()))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Integracion de aprobadores", produces = "application/json")
    @RequestMapping(value = "/aprobadores", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<MensajeSap> getAprobadores()   {

        return Optional.of(this.sapRfcDeltaService.integrarAprobadores())
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Integra textos de pedido", produces = "application/json")
    @RequestMapping(value = "/integraTextoPedido", method = RequestMethod.POST, headers = "Accept=application/json")
    ResponseEntity<List<DescargaServicioSap>> integraTextoPedido(@RequestBody FiltroRangeDescarga filtroRangeDescarga)
    {

        return Optional.of(this.sapRfcDeltaService.integraTextosPedido(filtroRangeDescarga.getListaRangeDoc(), filtroRangeDescarga.getListaRangeFecha()))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Integracion cuenta mayor", produces = "application/json")
    @RequestMapping(value = "/cuentaMayor", method = RequestMethod.POST, headers = "Accept=application/json")
    ResponseEntity<List<MensajeSap>> cuentaMayor(@RequestBody FiltroCuenta filtroCuenta)
    {

        return Optional.of(this.sapRfcDeltaService.integrarCuentaMayor(filtroCuenta.getRangoMenor(), filtroCuenta.getRangoMayor(), filtroCuenta.getCodigoSap()))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Inregracion cuenta de imputacion", produces = "application/json")
    @RequestMapping(value = "/cuentaImputacion", method = RequestMethod.POST, headers = "Accept=application/json")
    ResponseEntity<List<MensajeSap>> cuentaImputacion(@RequestBody FiltroCuenta filtroCuenta)
    {

        return Optional.of(this.sapRfcDeltaService.integrarCuentaImputacion(filtroCuenta.getRangoMenor(), filtroCuenta.getRangoMayor(), filtroCuenta.getTipoImputacion(), filtroCuenta.getCodigoSap()))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Actualiza nota de pedido Hana", produces = "application/json")
    @RequestMapping(value = "/actualizarPedidoHana", method = RequestMethod.POST, headers = "Accept=application/json")
    ResponseEntity<MensajeSap> actualizarPedidoHana(@RequestBody FiltroRangeDescarga filtroRangeDescarga)
    {

        return Optional.of(this.sapRfcDeltaService.integrarNotaPedido(filtroRangeDescarga.getListaRangeDoc(), filtroRangeDescarga.getListaRangeFecha()))
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

}
