
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    public void salvar(Pessoa pessoa) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(pessoa.nome + ".txt"));
            bw.write(pessoa.nome + "@" + pessoa.telefone + "@" + pessoa.genero + "@" + pessoa.whatsApp + "@" + pessoa.profissao 
                     + "@" + pessoa.obervacoes);
            bw.close();
        } catch(Exception e){}
    }
    public String[] consultar(String nome) {
        String linha;
        String vetor[] = new String [6];
        try {
            BufferedReader br = new BufferedReader(new FileReader(nome+ ".txt"));
            while((linha=br.readLine()) != null) {
                vetor = linha.split("@");
            }
            br.close();
        } catch (Exception e) {}
        return vetor;
    }
}