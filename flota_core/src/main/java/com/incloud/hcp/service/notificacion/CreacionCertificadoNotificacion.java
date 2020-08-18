package com.incloud.hcp.service.notificacion;

import com.incloud.hcp._security.UserSession;
import com.incloud.hcp.domain.CerCertificado;
import com.incloud.hcp.domain.MtrAprobador;
import com.incloud.hcp.domain.MtrProveedor;
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
public class CreacionCertificadoNotificacion extends NotificarMail {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String TEMPLATE = "webapps/cogaiproviderbackend/WEB-INF/classes/templates/TemplateCertificado.html";
    private final String ASUNTO = "IProvider - Generación Certificado";

    public void enviar(MailSetting mailSetting, UserSession user, String Destinatario, CerCertificado certificado) throws IOException {
        logger.error("Ingresando CreacionCertificadoNotificacion enviar 0");
        logger.error("Ingresando CreacionCertificadoNotificacion enviar 1 mailSetting: " + mailSetting.toString());
        Charset.forName("UTF-8").newEncoder();

        String template = new String(Files.readAllBytes(Paths.get(TEMPLATE)));
        String content = new String(template.getBytes("UTF-8"));
        String RealName = user.getFirstName() + " " + user.getLastName();
        logger.error("Ingresando CreacionCertificadoNotificacion enviar 1a mailSetting: " + mailSetting.toString());

        //if is \r \n| \n to code HTML
        RealName = RealName.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        //if is \r \n| \n to code HTML
        String concepto = (certificado.getConcepto() != null ? certificado.getConcepto() : "").replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        logger.error("Ingresando CreacionCertificadoNotificacion enviar 2");
        Map<String, String> variables = new HashMap<>();
        variables.put("usuarioPublicacionName", (RealName != null ? RealName : ""));
        variables.put("codigocertificado", certificado.getCodigoCertificado() != null ? certificado.getCodigoCertificado() : "");
        variables.put("concepto", concepto);
        variables.put("monto", (String.valueOf(certificado.getMontoTotal() != null ? certificado.getMontoTotal() : "")));
        variables.put("notapedidonumero", certificado.getCerNotaPedido().getCodigoNotaPedidoSap() != null ? certificado.getCerNotaPedido().getCodigoNotaPedidoSap() : "");
        logger.error("Ingresando CreacionCertificadoNotificacion enviar - variables: " + variables.toString());

        content = variables.
                keySet().stream().
                reduce(content,
                        (acc, e) -> acc.replaceAll("\\$\\{" + e + "\\}",
                                variables.get(e)));
        logger.error("Ingresando CreacionCertificadoNotificacion enviar - content: " + content.toString());

        Mail mail = new Mail();
        mail.setMailSetting(mailSetting);
        try {
            mail.enviar(Destinatario, null, ASUNTO, content);
            logger.error("Ingresando CreacionCertificadoNotificacion enviar ok");
        } catch (Exception ex) {
            logger.error("Error al enviar notificación al administrador ", ex);
            ex.printStackTrace();
        }

        logger.error("Ingresando CreacionCertificadoNotificacion FIN");

    }

    public void enviarFirma(
            MailSetting mailSetting,
            MtrAprobador mtrAprobador,
            String Destinatario,
            CerCertificado certificado) throws IOException {
        logger.error("Ingresando CreacionCertificadoNotificacion enviar 0");
        logger.error("Ingresando CreacionCertificadoNotificacion enviar 1 mailSetting: " + mailSetting.toString());
        Charset.forName("UTF-8").newEncoder();

        String template = new String(Files.readAllBytes(Paths.get(TEMPLATE)));
        String content = new String(template.getBytes("UTF-8"));
        String RealName = mtrAprobador.getNombre() + " " + mtrAprobador.getApellidos();
        logger.error("Ingresando CreacionCertificadoNotificacion enviar 1a mailSetting: " + mailSetting.toString());

        //if is \r \n| \n to code HTML
        RealName = RealName.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        //if is \r \n| \n to code HTML
        String concepto = (certificado.getConcepto() != null ? certificado.getConcepto() : "").replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        logger.error("Ingresando CreacionCertificadoNotificacion enviar 2");
        Map<String, String> variables = new HashMap<>();
        variables.put("usuarioPublicacionName", (RealName != null ? RealName : ""));
        variables.put("codigocertificado", certificado.getCodigoCertificado() != null ? certificado.getCodigoCertificado() : "");
        variables.put("concepto", concepto);
        variables.put("monto", (String.valueOf(certificado.getMontoTotal() != null ? certificado.getMontoTotal() : "")));
        variables.put("notapedidonumero", certificado.getCerNotaPedido().getCodigoNotaPedidoSap() != null ? certificado.getCerNotaPedido().getCodigoNotaPedidoSap() : "");
        logger.error("Ingresando CreacionCertificadoNotificacion enviar - variables: " + variables.toString());

        content = variables.
                keySet().stream().
                reduce(content,
                        (acc, e) -> acc.replaceAll("\\$\\{" + e + "\\}",
                                variables.get(e)));
        logger.error("Ingresando CreacionCertificadoNotificacion enviar - content: " + content.toString());

        Mail mail = new Mail();
        mail.setMailSetting(mailSetting);
        try {
            mail.enviar(Destinatario, null, ASUNTO, content);
            logger.error("Ingresando CreacionCertificadoNotificacion enviar ok");
        } catch (Exception ex) {
            logger.error("Error al enviar notificación al administrador ", ex);
            ex.printStackTrace();
        }

        logger.error("Ingresando CreacionCertificadoNotificacion FIN");

    }

    public void enviarProveedor(
            MailSetting mailSetting,
            MtrProveedor mtrProveedor,
            String Destinatario,
            CerCertificado certificado) throws IOException {
        logger.error("Ingresando CreacionCertificadoNotificacion enviar 0");
        logger.error("Ingresando CreacionCertificadoNotificacion enviar 1 mailSetting: " + mailSetting.toString());
        Charset.forName("UTF-8").newEncoder();

        String template = new String(Files.readAllBytes(Paths.get(TEMPLATE)));
        String content = new String(template.getBytes("UTF-8"));
        String RealName = mtrProveedor.getRazonSocial();
        logger.error("Ingresando CreacionCertificadoNotificacion enviar 1a mailSetting: " + mailSetting.toString());

        //if is \r \n| \n to code HTML
        RealName = RealName.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        //if is \r \n| \n to code HTML
        String concepto = (certificado.getConcepto() != null ? certificado.getConcepto() : "").replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        logger.error("Ingresando CreacionCertificadoNotificacion enviar 2");
        Map<String, String> variables = new HashMap<>();
        variables.put("usuarioPublicacionName", (RealName != null ? RealName : ""));
        variables.put("codigocertificado", certificado.getCodigoCertificado() != null ? certificado.getCodigoCertificado() : "");
        variables.put("concepto", concepto);
        variables.put("monto", (String.valueOf(certificado.getMontoTotal() != null ? certificado.getMontoTotal() : "")));
        variables.put("notapedidonumero", certificado.getCerNotaPedido().getCodigoNotaPedidoSap() != null ? certificado.getCerNotaPedido().getCodigoNotaPedidoSap() : "");
        logger.error("Ingresando CreacionCertificadoNotificacion enviar - variables: " + variables.toString());

        content = variables.
                keySet().stream().
                reduce(content,
                        (acc, e) -> acc.replaceAll("\\$\\{" + e + "\\}",
                                variables.get(e)));
        logger.error("Ingresando CreacionCertificadoNotificacion enviar - content: " + content.toString());

        Mail mail = new Mail();
        mail.setMailSetting(mailSetting);
        try {
            mail.enviar(Destinatario, null, ASUNTO, content);
            logger.error("Ingresando CreacionCertificadoNotificacion enviar ok");
        } catch (Exception ex) {
            logger.error("Error al enviar notificación al administrador ", ex);
            ex.printStackTrace();
        }

        logger.error("Ingresando CreacionCertificadoNotificacion FIN");

    }

}
