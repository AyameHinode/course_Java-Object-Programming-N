package br.ce.wcaquino.builders;

import br.ce.wcaquino.entidades.Usuario;

public class UsuarioBuilder {

    private Usuario usuario;

    private UsuarioBuilder(){}

    public static UsuarioBuilder criandoUsuarioFake(){
        UsuarioBuilder fake = new UsuarioBuilder();
        fake.usuario = new Usuario();
        fake.usuario.setNome("Usuario fake");
        return fake;
    }

    public UsuarioBuilder comNome(String nome){
        usuario.setNome(nome);
        return this;
    }

    public Usuario agora(){
        return usuario;
    }

}
