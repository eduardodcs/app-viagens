package br.com.appviagens.util;

import androidx.annotation.NonNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    @NonNull
    public static String periodoEmTexto(int dias) {
        LocalDate dataIda = LocalDate.now();
        LocalDate dataVolta = dataIda.plusDays(dias);
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern(DIA_E_MES);
        String dataIdaFormatada = formatoBrasileiro.format(dataIda);
        String dataVoltaFormatada = formatoBrasileiro.format(dataVolta);
        int anoVolta = dataVolta.getYear();
        String dataFormatadaDaViagem = dataIdaFormatada + " - " + dataVoltaFormatada + " de " + anoVolta;
        return dataFormatadaDaViagem;
    }
}
