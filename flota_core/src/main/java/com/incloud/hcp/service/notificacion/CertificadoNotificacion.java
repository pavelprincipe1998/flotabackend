package com.incloud.hcp.service.notificacion;

import com.incloud.hcp._security.UserSession;
import com.incloud.hcp.domain.CerCertificado;
import com.incloud.hcp.domain.MtrAprobador;
import com.incloud.hcp.domain.MtrEstado;
import com.incloud.hcp.domain.MtrProveedor;
import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Component
public class CertificadoNotificacion extends NotificarMail {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Logger log = LoggerFactory.getLogger(CertificadoNotificacion.class);

    private final String TEMPLATE = "webapps/cogaiproviderbackend/WEB-INF/classes/templates/TemplateCertificadoNotificacion.html";
    private final String ASUNTO = "IProvider - Nota de Pedido";
    //fdfd
    private final String TEMPLATELIBERACION = "webapps/cogaiproviderbackend/WEB-INF/classes/templates/TemplateLiberacion.html";
    private final String ASUNTOLIBERACION = "Liberación Nota de Pedido";

    public void enviar(MailSetting mailSetting, MtrProveedor proveedor, UserSession user, MtrEstado estado, CerCertificado certificado, String destinatarios) throws IOException {

        Charset.forName("UTF-8").newEncoder();

        String template = new String(Files.readAllBytes(Paths.get(TEMPLATE)));
        String content = new String(template.getBytes("UTF-8"));
        String RealName = user.getFirstName() + " " + user.getLastName();

        //if is \r \n| \n to code HTML
        RealName = RealName.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        String Descripcion = (estado.getDescripcion() != null ? estado.getDescripcion() : "").replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");

        Map<String, String> variables = new HashMap<>();
        variables.put("usuarioPublicacionName", (RealName != null ? RealName : ""));
        variables.put("nombreProveedor", (proveedor.getRazonSocial() != null ? proveedor.getRazonSocial() : ""));
        variables.put("ruc", (proveedor.getRuc() != null ? proveedor.getRuc() : ""));
        variables.put("estado", Descripcion);
        variables.put("codigocertificado", (certificado.getCodigoCertificado() != null ? certificado.getCodigoCertificado() : ""));

        content = variables.
                keySet().stream().
                reduce(content,
                        (acc, e) -> acc.replaceAll("\\$\\{" + e + "\\}",
                                variables.get(e)));

        Mail mail = new Mail();
        mail.setMailSetting(mailSetting);
        try {
            mail.enviar(destinatarios, null, ASUNTO, content);
        } catch (EmailException ex) {
            logger.error("Error al enviar notificación al administrador ", ex);
        }

    }

    public void enviarFirma(MailSetting mailSetting, MtrProveedor proveedor, MtrAprobador mtrAprobador, MtrEstado estado, CerCertificado certificado) throws IOException {

        Charset.forName("UTF-8").newEncoder();

        String template = new String(Files.readAllBytes(Paths.get(TEMPLATE)));
        String content = new String(template.getBytes("UTF-8"));
        String realName = mtrAprobador.getNombre()  + " " + mtrAprobador.getApellidos();

        //if is \r \n| \n to code HTML
        realName = realName.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        String Descripcion = (estado.getDescripcion() != null ? estado.getDescripcion() : "").replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");

        Map<String, String> variables = new HashMap<>();
        variables.put("usuarioPublicacionName", (realName != null ? realName : ""));
        variables.put("nombreProveedor", (proveedor.getRazonSocial() != null ? proveedor.getRazonSocial() : ""));
        variables.put("ruc", (proveedor.getRuc() != null ? proveedor.getRuc() : ""));
        variables.put("estado", Descripcion);
        variables.put("codigocertificado", (certificado.getCodigoCertificado() != null ? certificado.getCodigoCertificado() : ""));

        content = variables.
                keySet().stream().
                reduce(content,
                        (acc, e) -> acc.replaceAll("\\$\\{" + e + "\\}",
                                variables.get(e)));

        Mail mail = new Mail();
        mail.setMailSetting(mailSetting);
        try {
            mail.enviar(mtrAprobador.getEmail(), null, ASUNTO, content);
        } catch (EmailException ex) {
            logger.error("Error al enviar notificación al administrador ", ex);
        }

    }


    public void enviarMail(MailSetting mailSetting, String realName, MtrProveedor proveedor, MtrEstado estado, CerCertificado certificado, String destinatarios) throws IOException {

        Charset.forName("UTF-8").newEncoder();
        log.error("enviarMail :: realName " +  realName);
        log.error("enviarMail :: destinatarios " +  destinatarios);
        String template = new String(Files.readAllBytes(Paths.get(TEMPLATE)));
        String content = new String(template.getBytes("UTF-8"));
        /*= mtrAprobador.getNombre() != null ? mtrAprobador.getNombre() : " ";
        realName = realName + mtrAprobador.getApellidos() != null ? mtrAprobador.getApellidos() : "";
        realName = realName.trim();*/


        //if is \r \n| \n to code HTML
        realName = realName.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        String Descripcion = (estado.getDescripcion() != null ? estado.getDescripcion() : "").replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");

        Map<String, String> variables = new HashMap<>();
        variables.put("usuarioPublicacionName", (realName != null ? realName : ""));
        variables.put("nombreProveedor", (proveedor.getRazonSocial() != null ? proveedor.getRazonSocial() : ""));
        log.error("enviarMail :: proveedor.getRazonSocial() " +  proveedor.getRazonSocial());
        variables.put("ruc", (proveedor.getRuc() != null ? proveedor.getRuc() : ""));
        log.error("enviarMail :: proveedor.getRuc() " +  proveedor.getRuc());
        variables.put("estado", Descripcion);
        log.error("enviarMail :: estado " +  Descripcion);
        variables.put("codigocertificado", (certificado.getCodigoCertificado() != null ? certificado.getCodigoCertificado() : ""));
        log.error("enviarMail :: certificado.getCodigoCertificado() " +  certificado.getCodigoCertificado());

        content = variables.
                keySet().stream().
                reduce(content,
                        (acc, e) -> acc.replaceAll("\\$\\{" + e + "\\}",
                                variables.get(e)));

        Mail mail = new Mail();
        mail.setMailSetting(mailSetting);
        try {
            mail.enviar(destinatarios, null, ASUNTO, content);
        } catch (EmailException ex) {
            logger.error("Error al enviar notificación al administrador ", ex);
        }

    }


    public void enviarMailLiberacion(MailSetting mailSetting, String nroPedido, String nombreProveedor, String destinatarios) throws IOException {

        Charset.forName("UTF-8").newEncoder();
        //log.error("enviarMail :: realName " +  realName);
        log.error("Inicio ---- enviarMailLoiberacion :: destinatarios " +  destinatarios);
        String template = new String(Files.readAllBytes(Paths.get(TEMPLATELIBERACION)));
        String content = new String(template.getBytes("UTF-8"));
        /*= mtrAprobador.getNombre() != null ? mtrAprobador.getNombre() : " ";
        realName = realName + mtrAprobador.getApellidos() != null ? mtrAprobador.getApellidos() : "";
        realName = realName.trim();*/


        //if is \r \n| \n to code HTML
        //realName = realName.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        //String Descripcion = (estado.getDescripcion() != null ? estado.getDescripcion() : "").replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");

        Map<String, String> variables = new HashMap<>();
        //variables.put("nombreProveedor", (realName != null ? realName : ""));
        variables.put("nombreProveedor", (nombreProveedor != null ? nombreProveedor: ""));
        log.error("enviarMailLoiberacion nombreProveedor ::" +  nombreProveedor);
        variables.put("nroPedido", (nroPedido != null ? nroPedido : ""));
        log.error("enviarMailLoiberacion nroPedido :: nroPedido " +  nroPedido);
        //variables.put("estado", Descripcion);
       // log.error("enviarMail :: estado " +  Descripcion);
        //variables.put("codigocertificado", (certificado.getCodigoCertificado() != null ? certificado.getCodigoCertificado() : ""));
        //log.error("enviarMail :: certificado.getCodigoCertificado() " +  certificado.getCodigoCertificado());

        content = variables.
                keySet().stream().
                reduce(content,
                        (acc, e) -> acc.replaceAll("\\$\\{" + e + "\\}",
                                variables.get(e)));

        Mail mail = new Mail();
        mail.setMailSetting(mailSetting);
        try {
            mail.enviar(destinatarios, null, ASUNTOLIBERACION, content);
        } catch (EmailException ex) {
            logger.error("Error al enviar notificación al enviarMailLoiberacion ", ex);
        }

        log.error("Fin ---- enviarMailLoiberacion :: destinatarios ");

    }

}
