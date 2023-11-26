package br.ce.wcaquino.builders;

import br.ce.wcaquino.entidades.Filme;

public class FilmeBuilder {

    private Filme filme;

    private FilmeBuilder(){}

    public static FilmeBuilder criandoUmFilme(){
        FilmeBuilder filmeFake = new FilmeBuilder();
        filmeFake.filme = new Filme();
        filmeFake.filme.setEstoque(2);
        filmeFake.filme.setNome("Filme aleatorio");
        filmeFake.filme.setPrecoLocacao(10.00);
        return filmeFake;
    }

    public Filme agora(){
        return filme;
    }

    public FilmeBuilder semEstoque(){
        filme.setEstoque(0);
        return this;
    }

    public FilmeBuilder filmeComValorLocacao(Double valor){
        filme.setPrecoLocacao(valor);
        return this;
    }

}
