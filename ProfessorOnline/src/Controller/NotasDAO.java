package Controller;

import Model.Aluno;
import Model.Notas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class NotasDAO extends ExecuteSQL {
    
    public NotasDAO(Connection cont) {
        super(cont);
    }
    public String Inserir_Aluno(Aluno a){
        
        String sql = "INSERT INTO aluno VALUES (0,?,?)";
        
        try{
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1,a.getNomeAluno());
            ps.setString(2,a.getTurma());
        
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso";
            }else{
                return "Erro ao Inserir";
            }
            
        }catch(Exception e){
            return e.getMessage();
        }
    }
    public String Inserir_Notas(Notas n,Aluno a){
        
        String sql = "INSERT INTO notas VALUES (0,?,?,?,?,?)";
        
        try{
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1,a.getIdAluno());
            ps.setString(2,a.getTurma());
            ps.setString(3,n.getNotas());
            ps.setFloat(4,n.getMedia());
            ps.setString(5,n.getSituacao());
        
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso";
            }else{
                return "Erro ao Inserir";
            }
            
        }catch(Exception e){
            return e.getMessage();
        }
    }
    
     public List<Aluno> ConsultaCodigoAluno(String nome){
        String sql = "SELECT idAluno FROM aluno where nomeAluno = '"+nome+"'";
        List<Aluno> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluno a = new Aluno();
                    a.setIdAluno(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
            
        }catch(Exception ex){
            return null;
            
        }
    
    }
     
    public List<Notas> ListarNotas(){
        String sql = "SELECT turma,notas,media,situacao,idAluno FROM notas";
        List<Notas> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Notas a = new Notas();
                    a.setTurma(rs.getString(1));
                    a.setNotas(rs.getString(2));
                    a.setMedia(rs.getFloat(3));
                    a.setSituacao(rs.getString(4));
                    a.setIdAluno(rs.getInt(5));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        }catch(Exception ex){
            return null;
        }
    }
    public List<Aluno> ConsultaNomeAluno(int id){
        String sql = "SELECT nomeAluno FROM aluno where idAluno = '"+id+"'";
        List<Aluno> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluno a = new Aluno();
                    a.setNomeAluno(rs.getString(1));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
            
        }catch(Exception ex){
            return null;
            
        }
    
    }
    public List<Aluno> PesquisarNomeAluno(String nome){
        String sql = "SELECT idAluno,nomeAluno,turma FROM aluno WHERE nomeAluno = '"+nome+"'";
        List<Aluno> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluno a = new Aluno();
                    a.setIdAluno(rs.getInt(1));
                    a.setNomeAluno(rs.getString(2));
                    a.setTurma(rs.getString(3));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        }catch(Exception ex){
            return null;
        }
    }
    public List<Aluno> PesquisarTurmaAluno(String turma){
        String sql = "SELECT * FROM aluno WHERE turma  LIKE '"+turma+"%'";
        List<Aluno> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluno a = new Aluno();
                    a.setIdAluno(rs.getInt(1));
                    a.setNomeAluno(rs.getString(2));
                    a.setTurma(rs.getString(3));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        }catch(Exception ex){
            return null;
        }
    }
    public List<Notas> PesquisarIdAluno(int id){
        String sql = "SELECT turma,notas,media,situacao FROM notas WHERE idAluno = '"+id+"'";
        List<Notas> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Notas a = new Notas();
                    a.setTurma(rs.getString(1));
                    a.setNotas(rs.getString(2));
                    a.setMedia(rs.getFloat(3));
                    a.setSituacao(rs.getString(4));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        }catch(Exception ex){
            return null;
        }
    }
    public List<Notas> ListarComboNotas(){
        String sql = "SELECT turma FROM notas order by turma";
        List<Notas> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Notas a = new Notas();
                    a.setTurma(rs.getString(1));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
            
        }catch(Exception ex){
            return null;
            
        }
    
    }
    
    public List<Aluno> ListarComboAluno(){
        String sql = "SELECT nomeAluno FROM aluno order by nomeAluno";
        List<Aluno> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluno a = new Aluno();
                    a.setNomeAluno(rs.getString(1));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
            
        }catch(Exception ex){
            return null;
            
        }
    
    }
    
    public String Atualiza_Aluno(Aluno n,String nomeE){
        String sql = "UPDATE aluno SET nomeAluno = ?,turma = ? WHERE nomeAluno = ?";
        
        try{
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1,n.getNomeAluno());
            ps.setString(2,n.getTurma());
            ps.setString(3,nomeE);
        
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso";
            }else{
                return "Erro ao Inserir";
            }
            
        }catch(Exception e){
            return e.getMessage();
        }
    }
    public String Atualiza_Notas(Notas n){
        
        String sql = "UPDATE notas SET turma = ?,notas = ?,media = ?,situacao = ? WHERE idAluno = ?";
        
        try{
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1,n.getTurma());
            ps.setString(2,n.getNotas());
            ps.setFloat(3,n.getMedia());
            ps.setString(4,n.getSituacao());
            ps.setInt(5, n.getIdAluno());
            
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso";
            }else{
                return "Erro ao Inserir";
            }
            
        }catch(Exception e){
            return e.getMessage();
        }
    }
   public String Excluir_Aluno(Aluno a ){
        
        String sql = "DELETE FROM aluno WHERE nomeAluno = ?";
        
        try{
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNomeAluno());
            
            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso";
            }else{
                return "Erro ao Excluir";
            }
        }catch(Exception ex){
                return ex.getMessage();
        }
    }
   public String Excluir_Notas(int id ){
        
        String sql = "DELETE FROM notas WHERE idAluno = ?";
        
        try{
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, id);
            
            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso";
            }else{
                return "Erro ao Excluir";
            }
        }catch(Exception ex){
                return ex.getMessage();
        }
    }
}
