/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Source code: https://github.com/jaxio/celerio/
 * Follow us on twitter: @jaxiosoft
 * This header can be customized in Celerio conf...
 * Template pack-angular:src/main/java/dto/support/PageRequestByExample.java.p.vm
 */
package com.incloud.hcp.service.support;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageRequestByExample<DTO> {
    private final int ROWS_DEFAULT = 1000;
    public DTO bean;
    public LazyLoadEvent pageRequest;

    public Pageable toPageable() {
        return pageRequest != null ? pageRequest.toPageable() : null;
    }

    public Pageable toPageable(Sort sortAvanzado) {
        return pageRequest != null ? pageRequest.toPageable(sortAvanzado) : null;
    }

    public void generarLazyDefecto(String sortField) {
        if (this.pageRequest == null) {
            this.pageRequest = new LazyLoadEvent();
            this.pageRequest.page = 0;
            this.pageRequest.size = ROWS_DEFAULT;
            this.pageRequest.sortField = sortField;
            this.pageRequest.sortOrder = 1;
        }
        else {
            if (StringUtils.isBlank(this.pageRequest.sortField)) {
                this.pageRequest.sortField = sortField;
                this.pageRequest.sortOrder = 1;
            }
            if (this.pageRequest.size == 0) {
                this.pageRequest.size = ROWS_DEFAULT;
            }
        }
    }

    public void generarLazyDefecto() {
        if (this.pageRequest == null) {
            this.pageRequest = new LazyLoadEvent();
            this.pageRequest.page = 0;
            this.pageRequest.size = ROWS_DEFAULT;
        }
        else {
            if (this.pageRequest.size == 0) {
                this.pageRequest.size = ROWS_DEFAULT;
            }
        }
    }


}