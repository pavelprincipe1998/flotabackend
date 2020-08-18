package com.incloud.hcp.bean.custom;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DescargaServicioSap implements Serializable {
    private static final long serialVersionUID = 1L;
    private String ebeln;
    private String ekorg;
    private String lifnr;
    private String ernam;
    private String firmaa1;
    private String firmaa2;
    private String firmaa3;
    private String firmaa4;
    private String firmab1;
    private String firmab2;
    private String firmab3;
    private String firmab4;
    private String waers;
    private String vigdes;
    private String vighas;
    private String tipdoc;
    private String bedat;
    private String cldoc;
    private String werks;
    private String name1;
    private String pedido_version;
    private String zterm;
    private String ebelp;
    private String txz01;
    private String fecent;
    private String precio;
    private String knttp;
    private String lgort;
    private String matkl;
    private String wgbez;
    private String packno;
    private String introw;
    private String extrow;
    private String srvpos;
    private String descri;
    private String unimed;
    private String canreq;
    private String canent;
    private String precio2;
    private String sakto;
    private String kostl;
    private String posid;
    private String aufnr;
    private String cabtx;
    private String zplazo;
    private String pretp;
    private String codBienServicio;
    private String tipo;
    private String textoAdicional;
    //private String ernam;
    private String smtpAddr;
    private String zkate;
    private String monto;
    private String tnotasAclaratorias;
    private String tlugarPago;
    private String tformaPago;
    private String tdocParticulares;
    private String tconcepto;
    private String idText;
    private String tdLine;
    private String nameText;
    private String burks;
    //private String introw;

    //private String knttp;
    //private String sakto;
    //private String kostl;
    //private String posid;
    //private String aufnr;
    //private String zplazo;
    /*
    public String getEbeln() {
        return ebeln;
    }

    public void setEbeln(String ebeln) {
        this.ebeln = ebeln;
    }

    public String getEkorg() {
        return ekorg;
    }

    public void setEkorg(String ekorg) {
        this.ekorg = ekorg;
    }

    public String getLifnr() {
        return lifnr;
    }

    public void setLifnr(String lifnr) {
        this.lifnr = lifnr;
    }

    public String getErnam() {
        return ernam;
    }

    public void setErnam(String ernam) {
        this.ernam = ernam;
    }

    public String getFirmaa1() {
        return firmaa1;
    }

    public void setFirmaa1(String firmaa1) {
        this.firmaa1 = firmaa1;
    }

    public String getFirmaa2() {
        return firmaa2;
    }

    public void setFirmaa2(String firmaa2) {
        this.firmaa2 = firmaa2;
    }

    public String getFirmaa3() {
        return firmaa3;
    }

    public void setFirmaa3(String firmaa3) {
        this.firmaa3 = firmaa3;
    }

    public String getFirmaa4() {
        return firmaa4;
    }

    public void setFirmaa4(String firmaa4) {
        this.firmaa4 = firmaa4;
    }

    public String getFirmab1() {
        return firmab1;
    }

    public void setFirmab1(String firmab1) {
        this.firmab1 = firmab1;
    }

    public String getFirmab2() {
        return firmab2;
    }

    public void setFirmab2(String firmab2) {
        this.firmab2 = firmab2;
    }

    public String getFirmab3() {
        return firmab3;
    }

    public void setFirmab3(String firmab3) {
        this.firmab3 = firmab3;
    }

    public String getFirmab4() {
        return firmab4;
    }

    public void setFirmab4(String firmab4) {
        this.firmab4 = firmab4;
    }

    public String getWaers() {
        return waers;
    }

    public void setWaers(String waers) {
        this.waers = waers;
    }

    public String getVigdes() {
        return vigdes;
    }

    public void setVigdes(String vigdes) {
        this.vigdes = vigdes;
    }

    public String getVighas() {
        return vighas;
    }

    public void setVighas(String vighas) {
        this.vighas = vighas;
    }

    public String getTipdoc() {
        return tipdoc;
    }

    public void setTipdoc(String tipdoc) {
        this.tipdoc = tipdoc;
    }

    public String getBedat() {
        return bedat;
    }

    public void setBedat(String bedat) {
        this.bedat = bedat;
    }

    public String getCldoc() {
        return cldoc;
    }

    public void setCldoc(String cldoc) {
        this.cldoc = cldoc;
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getPedido_version() {
        return pedido_version;
    }

    public void setPedido_version(String pedido_version) {
        this.pedido_version = pedido_version;
    }

    public String getZterm() {
        return zterm;
    }

    public void setZterm(String zterm) {
        this.zterm = zterm;
    }

    public String getEbelp() {
        return ebelp;
    }

    public void setEbelp(String ebelp) {
        this.ebelp = ebelp;
    }

    public String getTxz01() {
        return txz01;
    }

    public void setTxz01(String txz01) {
        this.txz01 = txz01;
    }

    public String getFecent() {
        return fecent;
    }

    public void setFecent(String fecent) {
        this.fecent = fecent;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getKnttp() {
        return knttp;
    }

    public void setKnttp(String knttp) {
        this.knttp = knttp;
    }

    public String getLgort() {
        return lgort;
    }

    public void setLgort(String lgort) {
        this.lgort = lgort;
    }

    public String getMatkl() {
        return matkl;
    }

    public void setMatkl(String matkl) {
        this.matkl = matkl;
    }

    public String getWgbez() {
        return wgbez;
    }

    public void setWgbez(String wgbez) {
        this.wgbez = wgbez;
    }

    public String getPackno() {
        return packno;
    }

    public void setPackno(String packno) {
        this.packno = packno;
    }

    public String getIntrow() {
        return introw;
    }

    public void setIntrow(String introw) {
        this.introw = introw;
    }

    public String getExtrow() {
        return extrow;
    }

    public void setExtrow(String extrow) {
        this.extrow = extrow;
    }

    public String getSrvpos() {
        return srvpos;
    }

    public void setSrvpos(String srvpos) {
        this.srvpos = srvpos;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getUnimed() {
        return unimed;
    }

    public void setUnimed(String unimed) {
        this.unimed = unimed;
    }

    public String getCanreq() {
        return canreq;
    }

    public void setCanreq(String canreq) {
        this.canreq = canreq;
    }

    public String getCanent() {
        return canent;
    }

    public void setCanent(String canent) {
        this.canent = canent;
    }

    public String getPrecio2() {
        return precio2;
    }

    public void setPrecio2(String precio2) {
        this.precio2 = precio2;
    }

    public String getSakto() {
        return sakto;
    }

    public void setSakto(String sakto) {
        this.sakto = sakto;
    }

    public String getKostl() {
        return kostl;
    }

    public void setKostl(String kostl) {
        this.kostl = kostl;
    }

    public String getPosid() {
        return posid;
    }

    public void setPosid(String posid) {
        this.posid = posid;
    }

    public String getAufnr() {
        return aufnr;
    }

    public void setAufnr(String aufnr) {
        this.aufnr = aufnr;
    }

    public String getCabtx() {
        return cabtx;
    }

    public void setCabtx(String cabtx) {
        this.cabtx = cabtx;
    }

    public String getZplazo() {
        return zplazo;
    }

    public void setZplazo(String zplazo) {
        this.zplazo = zplazo;
    }

    public String getPretp() {
        return pretp;
    }

    public void setPretp(String pretp) {
        this.pretp = pretp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DescargaServicioSap)) return false;
        DescargaServicioSap that = (DescargaServicioSap) o;
        return getEbeln().equals(that.getEbeln()) &&
                getEkorg().equals(that.getEkorg()) &&
                getLifnr().equals(that.getLifnr()) &&
                getErnam().equals(that.getErnam()) &&
                getFirmaa1().equals(that.getFirmaa1()) &&
                getFirmaa2().equals(that.getFirmaa2()) &&
                getFirmaa3().equals(that.getFirmaa3()) &&
                getFirmaa4().equals(that.getFirmaa4()) &&
                getFirmab1().equals(that.getFirmab1()) &&
                getFirmab2().equals(that.getFirmab2()) &&
                getFirmab3().equals(that.getFirmab3()) &&
                getFirmab4().equals(that.getFirmab4()) &&
                getWaers().equals(that.getWaers()) &&
                getVigdes().equals(that.getVigdes()) &&
                getVighas().equals(that.getVighas()) &&
                getTipdoc().equals(that.getTipdoc()) &&
                getBedat().equals(that.getBedat()) &&
                getCldoc().equals(that.getCldoc()) &&
                getWerks().equals(that.getWerks()) &&
                getName1().equals(that.getName1()) &&
                getPedido_version().equals(that.getPedido_version()) &&
                getZterm().equals(that.getZterm()) &&
                getEbelp().equals(that.getEbelp()) &&
                getTxz01().equals(that.getTxz01()) &&
                getFecent().equals(that.getFecent()) &&
                getPrecio().equals(that.getPrecio()) &&
                getKnttp().equals(that.getKnttp()) &&
                getLgort().equals(that.getLgort()) &&
                getMatkl().equals(that.getMatkl()) &&
                getWgbez().equals(that.getWgbez()) &&
                getPackno().equals(that.getPackno()) &&
                getIntrow().equals(that.getIntrow()) &&
                getExtrow().equals(that.getExtrow()) &&
                getSrvpos().equals(that.getSrvpos()) &&
                getDescri().equals(that.getDescri()) &&
                getUnimed().equals(that.getUnimed()) &&
                getCanreq().equals(that.getCanreq()) &&
                getCanent().equals(that.getCanent()) &&
                getPrecio2().equals(that.getPrecio2()) &&
                getSakto().equals(that.getSakto()) &&
                getKostl().equals(that.getKostl()) &&
                getPosid().equals(that.getPosid()) &&
                getAufnr().equals(that.getAufnr()) &&
                getCabtx().equals(that.getCabtx()) &&
                getZplazo().equals(that.getZplazo()) &&
                getPretp().equals(that.getPretp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEbeln(), getEkorg(), getLifnr(), getErnam(), getFirmaa1(), getFirmaa2(), getFirmaa3(), getFirmaa4(), getFirmab1(), getFirmab2(), getFirmab3(), getFirmab4(), getWaers(), getVigdes(), getVighas(), getTipdoc(), getBedat(), getCldoc(), getWerks(), getName1(), getPedido_version(), getZterm(), getEbelp(), getTxz01(), getFecent(), getPrecio(), getKnttp(), getLgort(), getMatkl(), getWgbez(), getPackno(), getIntrow(), getExtrow(), getSrvpos(), getDescri(), getUnimed(), getCanreq(), getCanent(), getPrecio2(), getSakto(), getKostl(), getPosid(), getAufnr(), getCabtx(), getZplazo(), getPretp());
    }

    @Override
    public String toString() {
        return "DescargaServicioSap{" +
                "ebeln='" + ebeln + '\'' +
                ", ekorg='" + ekorg + '\'' +
                ", lifnr='" + lifnr + '\'' +
                ", ernam='" + ernam + '\'' +
                ", firmaa1='" + firmaa1 + '\'' +
                ", firmaa2='" + firmaa2 + '\'' +
                ", firmaa3='" + firmaa3 + '\'' +
                ", firmaa4='" + firmaa4 + '\'' +
                ", firmab1='" + firmab1 + '\'' +
                ", firmab2='" + firmab2 + '\'' +
                ", firmab3='" + firmab3 + '\'' +
                ", firmab4='" + firmab4 + '\'' +
                ", waers='" + waers + '\'' +
                ", vigdes='" + vigdes + '\'' +
                ", vighas='" + vighas + '\'' +
                ", tipdoc='" + tipdoc + '\'' +
                ", bedat='" + bedat + '\'' +
                ", cldoc='" + cldoc + '\'' +
                ", werks='" + werks + '\'' +
                ", name1='" + name1 + '\'' +
                ", pedido_version='" + pedido_version + '\'' +
                ", zterm='" + zterm + '\'' +
                ", ebelp='" + ebelp + '\'' +
                ", txz01='" + txz01 + '\'' +
                ", fecent='" + fecent + '\'' +
                ", precio='" + precio + '\'' +
                ", knttp='" + knttp + '\'' +
                ", lgort='" + lgort + '\'' +
                ", matkl='" + matkl + '\'' +
                ", wgbez='" + wgbez + '\'' +
                ", packno='" + packno + '\'' +
                ", introw='" + introw + '\'' +
                ", extrow='" + extrow + '\'' +
                ", srvpos='" + srvpos + '\'' +
                ", descri='" + descri + '\'' +
                ", unimed='" + unimed + '\'' +
                ", canreq='" + canreq + '\'' +
                ", canent='" + canent + '\'' +
                ", precio2='" + precio2 + '\'' +
                ", sakto='" + sakto + '\'' +
                ", kostl='" + kostl + '\'' +
                ", posid='" + posid + '\'' +
                ", aufnr='" + aufnr + '\'' +
                ", cabtx='" + cabtx + '\'' +
                ", zplazo='" + zplazo + '\'' +
                ", pretp='" + pretp + '\'' +
                '}';
    }*/
}
