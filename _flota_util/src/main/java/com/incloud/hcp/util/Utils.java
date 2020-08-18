package com.incloud.hcp.util;

import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.Random;

public class Utils {

    public static int getRandomNumberInts(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }

    /**
     * Checks if is collection empty.
     *
     * @param collection the collection
     * @return true, if is collection empty
     */
    private static boolean isCollectionEmpty(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        return false;
    }


    public static String obtieneMensajeErrorException(Exception e) {
        String retorno = null;
        if (StringUtils.isNotBlank(e.getMessage()))
            return e.getMessage();
        if (StringUtils.isNotBlank(e.getLocalizedMessage()))
            return e.getLocalizedMessage();
        retorno = e.toString();
        return retorno;
    }

    public static String obtieneMensajeErrorExceptionDepurado(Exception e) {
        String error = obtieneMensajeErrorException(e);
//        if (StringUtils.isNotBlank(error)) {
//            int buscar = StringUtils.indexOf(error, "Exception:");
//            if (buscar > 0) {
//                error = StringUtils.right(error, buscar + 1);
//            }
//        }
        return error;
    }

    public static String obtenerSiguienteMesEjercicio(Integer ejercicio, String mes ) {
        Integer nMes = new Integer(mes);
        Integer nAnno = ejercicio;
        if (nMes.intValue() < 12) {
            nMes += 1;
        }
        else {
            nMes = 1;
            nAnno ++;
        }
        String mesProceso = StringUtils.leftPad(nMes.toString().trim(), 2, '0');
        String ejercicioProceso = nAnno.toString().trim();
        return mesProceso + "/" + ejercicioProceso;
    }





}