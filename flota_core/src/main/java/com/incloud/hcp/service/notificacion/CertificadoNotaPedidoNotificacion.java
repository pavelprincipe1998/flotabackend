package com.incloud.hcp.service.notificacion;

import com.incloud.hcp.domain.CerNotaPedido;
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
import java.util.Optional;

@Component
public class CertificadoNotaPedidoNotificacion extends NotificarMail {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String TEMPLATE1 = "webapps/cogaiproviderbackend/WEB-INF/classes/templates/TemplateCertificadoNotaPedidoNotificacionAprobado.html";
    private final String TEMPLATE2 = "webapps/cogaiproviderbackend/WEB-INF/classes/templates/TemplateCertificadoNotaPedidoNotificacionDenegado.html";



    private final String ASUNTO = "IProvider - Nota de Pedido";

    public void enviar(MailSetting mailSetting, MtrProveedor proveedor, String destino, String concepto, CerNotaPedido cerNotaPedido, int nplantilla, int nrealName) throws IOException {

        Charset.forName("UTF-8").newEncoder();

        String TEMPLATE = TEMPLATE1;
        if (nplantilla == 2) TEMPLATE = TEMPLATE2;

        String template = new String(Files.readAllBytes(Paths.get(TEMPLATE)));
        String content = new String(template.getBytes("UTF-8"));
        String realName = "";

        if (nrealName == 2)
            realName = proveedor.getRazonSocial();
        else {
            realName = cerNotaPedido.getNombreCompletoCompra();
            if (!Optional.ofNullable(realName).isPresent()) {
                realName = cerNotaPedido.getEmailUserCompra();
            }
            if (!Optional.ofNullable(realName).isPresent()) {
                realName = cerNotaPedido.getUserCompra();
            }
        }

        //if is \r \n| \n to code HTML
        if (Optional.ofNullable(realName).isPresent())
            realName = realName.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        else
            realName = "";

        concepto = concepto.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");

        Map<String, String> variables = new HashMap<>();
        variables.put("usuarioPublicacionName", realName);
        variables.put("codigopedido", (cerNotaPedido.getCodigoNotaPedidoSap() != null ? cerNotaPedido.getCodigoNotaPedidoSap() : ""));
        variables.put("concepto", concepto);
        variables.put("proveedor", proveedor.getRazonSocial());

        content = variables.
                keySet().stream().
                reduce(content,
                        (acc, e) -> acc.replaceAll("\\$\\{" + e + "\\}",
                                variables.get(e)));

        Mail mail = new Mail();
        mail.setMailSetting(mailSetting);
        try {
            mail.enviar(destino, null, ASUNTO, content);
        } catch (EmailException ex) {
            logger.error("Error al enviar notificación al administrador ", ex);
        }

    }

    public void enviarFirma(
            MailSetting mailSetting,
            MtrProveedor proveedor,
            String destino,
            String concepto,
            CerNotaPedido cerNotaPedido,
            int nplantilla,
            String realName) throws IOException {

        Charset.forName("UTF-8").newEncoder();

        String TEMPLATE = TEMPLATE1;
        if (nplantilla == 2) TEMPLATE = TEMPLATE2;

        String template = new String(Files.readAllBytes(Paths.get(TEMPLATE)));
        String content = new String(template.getBytes("UTF-8"));


        //if is \r \n| \n to code HTML
        if (Optional.ofNullable(realName).isPresent())
            realName = realName.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        else
            realName = "";

        concepto = concepto.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");

        Map<String, String> variables = new HashMap<>();
        variables.put("usuarioPublicacionName", realName);
        variables.put("codigopedido", (cerNotaPedido.getCodigoNotaPedidoSap() != null ? cerNotaPedido.getCodigoNotaPedidoSap() : ""));
        variables.put("concepto", concepto);
        variables.put("proveedor", proveedor.getRazonSocial());

        content = variables.
                keySet().stream().
                reduce(content,
                        (acc, e) -> acc.replaceAll("\\$\\{" + e + "\\}",
                                variables.get(e)));

        Mail mail = new Mail();
        mail.setMailSetting(mailSetting);
        try {
            mail.enviar(destino, null, ASUNTO, content);
        } catch (EmailException ex) {
            logger.error("Error al enviar notificación al administrador ", ex);
        }

    }


}
