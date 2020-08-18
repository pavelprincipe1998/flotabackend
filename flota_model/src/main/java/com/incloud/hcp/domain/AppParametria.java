/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/domain/Entity.java.e.vm
 */
package com.incloud.hcp.domain;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.logging.Logger;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "app_parametria")
//@Audited
//@AuditTable("_audi_APP_PARAMETRIA")
public class AppParametria extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(AppParametria.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private String description;
    private String label;
    private String modulo;
    private String status;
    private String value1;
    private String value2;
    private String value3;

    @Override
    public String entityClassName() {
        return AppParametria.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "parametria_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_app_parametria")
    @Id
    @SequenceGenerator(name = "seq_app_parametria", sequenceName = "seq_app_parametria", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public AppParametria id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [description] ------------------------

    @Size(max = 100, message = "{message.appParametria.description.sizeMax} {max} {message.caracter}")
    @Column(name = "description", length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppParametria description(String description) {
        setDescription(description);
        return this;
    }
    // -- [label] ------------------------

    @Size(max = 100, message = "{message.appParametria.label.sizeMax} {max} {message.caracter}")
    @Column(name = "label", length = 100)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public AppParametria label(String label) {
        setLabel(label);
        return this;
    }
    // -- [modulo] ------------------------

    @Size(max = 30, message = "{message.appParametria.modulo.sizeMax} {max} {message.caracter}")
    @Column(name = "modulo", length = 30)
    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public AppParametria modulo(String modulo) {
        setModulo(modulo);
        return this;
    }
    // -- [status] ------------------------

    @Size(max = 255, message = "{message.appParametria.status.sizeMax} {max} {message.caracter}")
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AppParametria status(String status) {
        setStatus(status);
        return this;
    }
    // -- [value1] ------------------------

    @Size(max = 255, message = "{message.appParametria.value1.sizeMax} {max} {message.caracter}")
    @Column(name = "value_1")
    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public AppParametria value1(String value1) {
        setValue1(value1);
        return this;
    }
    // -- [value2] ------------------------

    @Size(max = 255, message = "{message.appParametria.value2.sizeMax} {max} {message.caracter}")
    @Column(name = "value_2")
    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public AppParametria value2(String value2) {
        setValue2(value2);
        return this;
    }
    // -- [value3] ------------------------

    @Size(max = 255, message = "{message.appParametria.value3.sizeMax} {max} {message.caracter}")
    @Column(name = "value_3")
    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public AppParametria value3(String value3) {
        setValue3(value3);
        return this;
    }

    /**
     * Apply the default values.
     */
    public AppParametria withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof AppParametria && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this AppParametria instance.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("description", getDescription()) //
                .add("label", getLabel()) //
                .add("modulo", getModulo()) //
                .add("status", getStatus()) //
                .add("value1", getValue1()) //
                .add("value2", getValue2()) //
                .add("value3", getValue3()) //
                .toString();
    }
}
