/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/rest/EntityResource.java.e.vm
 */
package com.incloud.hcp.rest;

import com.incloud.hcp.domain.MtrZonaPesca;
import com.incloud.hcp.domain.response.MtrZonaPescaResponse;
import com.incloud.hcp.repository.delta.MtrZonaPescaDeltaRepository;
import com.incloud.hcp.rest._framework.JPACustomRest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MtrZonaPescaRest extends JPACustomRest<MtrZonaPescaResponse, MtrZonaPesca, Integer> {

    @Autowired
    protected MtrZonaPescaDeltaRepository mtrZonaPescaDeltaRepository;

    protected String setObtenerNombreArchivoExcel() {
        return "MtrZonaPesca";
    }

    /************************/
    /* Instancia de Bean    */
    /************************/
    protected final MtrZonaPesca createInstance() {
        MtrZonaPesca mtrZonaPesca = new MtrZonaPesca();
        return mtrZonaPesca;
    }

    /*****************/
    /* Otros Metodos */
    /*****************/

}
