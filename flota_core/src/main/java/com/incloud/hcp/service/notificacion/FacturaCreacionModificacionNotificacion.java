package com.incloud.hcp.service.notificacion;

import com.incloud.hcp.domain.FacFactura;
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
public class FacturaCreacionModificacionNotificacion {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String TEMPLATE1 = "webapps/cogaiproviderbackend/WEB-INF/classes/templates/TemplateFacturaGenerada.html";
    private final String TEMPLATE2 = "webapps/cogaiproviderbackend/WEB-INF/classes/templates/TemplateFacturaModificada.html";



    private final String ASUNTO = "IProvider - Factura";

    public void enviar(MailSetting mailSetting,
                       MtrProveedor proveedor,
                       String destino,
                       String concepto,
                       FacFactura facFactura,
                       int nplantilla,
                       int nrealName) throws IOException {

        Charset.forName("UTF-8").newEncoder();

        String TEMPLATE = TEMPLATE1;
        if (nplantilla == 2) TEMPLATE = TEMPLATE2;

        String template = new String(Files.readAllBytes(Paths.get(TEMPLATE)));
        String content = new String(template.getBytes("UTF-8"));
        String realName = "";
        realName = proveedor.getRazonSocial();


        //if is \r \n| \n to code HTML
        if (Optional.ofNullable(realName).isPresent())
            realName = realName.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        else
            realName = "";

        if (Optional.ofNullable(concepto).isPresent())
            concepto = concepto.replaceAll("(\\r\\n|\\n\\r|\\r|\\n)", "<br />");
        else
            concepto = "";

        Map<String, String> variables = new HashMap<>();
        variables.put("usuarioPublicacionName", realName);
        variables.put("codigoFactura", facFactura.getTipoFactura() + "-" + facFactura.getSerieFactura() + "-" + facFactura.getNumeroFactura());
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
