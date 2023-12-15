package br.ce.wcaquino.servicos;

import br.ce.wcaquino.builders.FilmeBuilder;
import br.ce.wcaquino.builders.LocacaoBuilder;
import br.ce.wcaquino.builders.UsuarioBuilder;
import br.ce.wcaquino.daos.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static br.ce.wcaquino.matchers.MatchersProprios.hoje;
import static br.ce.wcaquino.matchers.MatchersProprios.hojeComDiferencaDias;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)  //Power Mock prepare
@PrepareForTest({LocacaoService.class})  //Power Mock prepare
@PowerMockIgnore("jdk.internal.reflect.*")
public class LocacaoServiceTest_PowerMockito {

    //@InjectMocks
    private LocacaoService locacaoService;
    //@Mock
    private LocacaoDAO locacaoDAO;
    //@Mock
    private SPCService spcService;
    //@Mock
    private EmailService emailService;


    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Rule
    public ExpectedException exceptionExpected = ExpectedException.none();

    @Before
    public void setup() {
        locacaoService = new LocacaoService();
        locacaoDAO = Mockito.mock(LocacaoDAO.class);
        locacaoService.setLocacaoDAO(locacaoDAO);
        spcService = Mockito.mock(SPCService.class);
        locacaoService.setSpcService(spcService);
        emailService = Mockito.mock(EmailService.class);
        locacaoService.setEmailService(emailService);

        locacaoService = PowerMockito.spy(locacaoService);
    }

    @Test
    public void deveAlugarFilmeComSucesso() throws Exception {
        //cenario
        Usuario user = UsuarioBuilder.criandoUsuarioFake().agora();
        List<Filme> filmes = Arrays.asList(FilmeBuilder.criandoUmFilme().filmeComValorLocacao(5.0).agora());

        //PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(DataUtils.obterData(8, 12, 2023));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 28);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.set(Calendar.YEAR, 2017);
        PowerMockito.mockStatic(Calendar.class);
        PowerMockito.when(Calendar.getInstance()).thenReturn(calendar);

        //acao
        Locacao locacao = locacaoService.alugarFilme(user, filmes);

        //verificacao
        errorCollector.checkThat((locacao.getValor()), CoreMatchers.is(CoreMatchers.equalTo(5.00)));
        //errorCollector.checkThat(
                //DataUtils.isMesmaData(locacao.getDataLocacao(),
                        //new Date()), CoreMatchers.is(true));
        //errorCollector.checkThat(
                //DataUtils.isMesmaData(locacao.getDataRetorno(),
                        //DataUtils.obterDataComDiferencaDias(1)), CoreMatchers.is(true));
        errorCollector.checkThat(locacao.getDataRetorno(), hojeComDiferencaDias(1));
        errorCollector.checkThat(locacao.getDataLocacao(), hoje());
        errorCollector.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(),
                DataUtils.obterData(9,12,2023)),
                CoreMatchers.is(true));
        errorCollector.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(),
                DataUtils.obterData(8,12,2023)),
                CoreMatchers.is(true));
    }

    /*@Test
    public void deveDevolverNaSegundaAoAlugarNoSabado() throws Exception {
        //Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY)); //Executara o teste apenas sabado

        //cenario
        Usuario usuario = UsuarioBuilder.criandoUsuarioFake().agora();
        List<Filme> filmes = Arrays.asList(FilmeBuilder.criandoUmFilme().agora());

        //PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(DataUtils.obterData(9, 12, 2023));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 29);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.set(Calendar.YEAR, 2017);
        PowerMockito.mockStatic(Calendar.class);
        PowerMockito.when(Calendar.getInstance()).thenReturn(calendar);

        //acao
        Locacao retorno = locacaoService.alugarFilme(usuario, filmes);

        //verificacao
        boolean segunda = DataUtils.verificarDiaSemana(retorno.getDataRetorno(), Calendar.MONDAY);
        Assert.assertTrue(segunda);

//        Assert.assertThat(retorno.getDataRetorno(), new DiaSemanaMatcher(Calendar.MONDAY));
//        Assert.assertThat(retorno.getDataRetorno(), caiEm(Calendar.MONDAY));
        //Assert.assertThat(retorno.getDataRetorno(), caiEmUmaSegunda());
        //PowerMockito.verifyNew(Date.class, Mockito.times(2)).withNoArguments();
        PowerMockito.verifyStatic(Mockito.times(2));
        Calendar.getInstance();
    }*/

    @Test
    public void deveAlugarFilmeSemCalcularValor() throws Exception {
        //cenario
        Usuario usuario = UsuarioBuilder.criandoUsuarioFake().agora();
        List<Filme> filmes = Arrays.asList(FilmeBuilder.criandoUmFilme().agora());

        //PowerMockito.doReturn(10.0).when(locacaoService,"calcularValorLocacao",filmes);

        //acao
        Locacao locacao = locacaoService.alugarFilme(usuario, filmes);

        //verificacao
        Assert.assertThat(locacao.getValor(), CoreMatchers.is(10.0));
        PowerMockito.verifyPrivate(locacaoService).invoke("calcularValorLocacao",filmes);
    }

    @Test
    public void deveCalcularValorLocacao() throws Exception {
        //cenario
        List<Filme> filmes = Arrays.asList(FilmeBuilder.criandoUmFilme().agora());

        //acao
        Double valor = (Double) Whitebox.invokeMethod(locacaoService, "calcularValorLocacao", filmes);

        //verificacao
        Assert.assertThat(valor, CoreMatchers.is(10.0));

    }

}