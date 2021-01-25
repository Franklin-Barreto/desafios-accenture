package test;

import controller.MessageServiceForTest;
import model.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.UsuarioService;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @DisplayName("Test MessageService.getCPF()") //E usada para fornecer um nome personalizado para a classe de teste e métodos de teste
    @Test   //no JUnit > 4 os métodos de teste são identificados com a anotação @Test
    void loginComprimentoCpfTest() {
        assertEquals(11, MessageServiceForTest.getCPF().getCpf().length());
    }

    @DisplayName("Test MessageService.getApelido()")
    @Test
    void loginComprimentoApelidoTest() {
        assertEquals(true, (MessageServiceForTest.getApelido().getNome().length() < 20));
    }


    //Exemplo em Aula
    @Test
    static void loginComprimentoTest() {
        Usuario usuario = new Usuario();
        usuario.setLogin("Guirilima");

        UsuarioService service = new UsuarioService();

        assertTrue(service.loginComprimento(usuario.getLogin()));
    }

    @Test
    void loginComprimentoInvalidoTest() {
        Usuario usuario = new Usuario();
        usuario.setLogin("Guirilimae3erwrereerere2233234ere");

        UsuarioService service = new UsuarioService();

        assertFalse(service.loginComprimento(usuario.getLogin()));
    }
}
