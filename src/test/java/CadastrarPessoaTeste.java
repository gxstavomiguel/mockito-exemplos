import com.desafio.ApiDosCorreios;
import com.desafio.CadastrarPessoa;
import com.desafio.DadosLocalizacao;
import com.desafio.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro(){

        DadosLocalizacao dadosLocalizacao = new  DadosLocalizacao("MG", "patos", "rua 2", "apto", "centro");
        Mockito.when(apiDosCorreios.buscarDadosComBaseNoCep("8882321")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Gustavo", "322413", LocalDate.now(), "8882321");

        assertEquals("Gustavo", pessoa.getNome());
        assertEquals("322413", pessoa.getDocumento());
        assertEquals("MG", pessoa.getEndereco());
        assertEquals("Apto", pessoa.getEndereco().getComplemento());

    }

}
