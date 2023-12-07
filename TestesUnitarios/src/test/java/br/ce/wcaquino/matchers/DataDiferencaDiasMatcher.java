package br.ce.wcaquino.matchers;

import br.ce.wcaquino.utils.DataUtils;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataDiferencaDiasMatcher extends TypeSafeMatcher<Date> {

    private Integer quantidadeDias;

    public DataDiferencaDiasMatcher(Integer quantidadeDias){
        this.quantidadeDias = quantidadeDias;
    }

    @Override
    protected boolean matchesSafely(Date data) {
        return DataUtils.isMesmaData(data, DataUtils.obterDataComDiferencaDias(quantidadeDias));
    }

    public void describeTo(Description description) {
        Date dataEsperada = DataUtils.obterDataComDiferencaDias(quantidadeDias);
        DateFormat formatador = new SimpleDateFormat("dd/MM/YYYY");
        description.appendText(formatador.format(dataEsperada));
    }
}
