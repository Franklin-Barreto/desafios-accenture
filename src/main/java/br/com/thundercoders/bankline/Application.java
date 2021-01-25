package br.com.thundercoders.bankline;
import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.UsuarioEntity;
import repository.UsuarioRepository;
import service.UsuarioService;

public class Application {
    public static void main(String[] args) throws IllegalAccessException {

        System.out.println("Oiee");

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setLogin("Guirilima");
        usuarioEntity.setNome("Guilherme");
        usuarioEntity.setCpf("3434344");
        usuarioEntity.setSenha("1234");

        UsuarioRepository repository = new UsuarioRepository();
        repository.incluir(usuarioEntity);

        //Buscando usuario pelo login
        usuarioEntity = new UsuarioEntity();
        usuarioEntity = repository.buscar(1);

        //Alterando Dados do Usuario
        usuarioEntity.setNome("NOVO NOME");
        repository.alterar(usuarioEntity);


        //2 - PARTE DO TESTE
        UsuarioEntity usuarioEntity2 = new UsuarioEntity();
        usuarioEntity.setLogin("Guirilima2");
        usuarioEntity.setNome("Guilherme2");
        usuarioEntity.setCpf("34343");
        usuarioEntity.setSenha("4321");

        ///////////////////////
        UsuarioService service = new UsuarioService();
        service.incluir(usuarioEntity);





        ///// TESTE COM CONTA
        usuarioEntity = new UsuarioEntity();
        usuarioEntity.setLogin("Guirilima2");
        usuarioEntity.setNome("Guilherme2");
        usuarioEntity.setCpf("34343");
        usuarioEntity.setSenha("4321");

        Conta conta = usuarioEntity.getConta();
        conta.setNumeroConta("232323");
        conta.setSaldo(11.1);

        service.incluir(usuarioEntity);
    }
}
