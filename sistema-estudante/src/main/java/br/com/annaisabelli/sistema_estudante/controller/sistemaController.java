package br.com.annaisabelli.sistema_estudante.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class sistemaController {

    // Endpoint 1: Informações do Sistema
    @GetMapping("/api/sistema/info")
    public String infoSistema() {
        return "sistema de cadastro de estudantes\n " + 
        "versão: 1.0\n " +
        "data/hora: " + LocalDateTime.now() + "\n " +
        "status: operacional";
        }
    // Endpoint 2: Listar Cursos Disponíveis
    @GetMapping("/api/cursos")
    public String listarCursos() {
        return """
            1 - Engenharia de Software
            2 - Ciência da Computação
            3 - Sistemas de Informação
            4 - Análise e Desenvolvimento de Sistemas
            5 - Engenharia da Computação
            """;
        }
    // Endpoint 3: Buscar Curso por ID
    @GetMapping("/api/cursos/{id}")
    public String buscarCursoPorId(@PathVariable int id) {
        switch (id) {
            case 1: return "Engenharia de Software";
            case 2: return "Ciência da Computação";
            case 3: return "Sistemas de Informação";
            case 4: return "Análise e Desenvolvimento de Sistemas";
            case 5: return "Engenharia da Computação";
            default: return "Curso não encontrado.";
            }
        }
    // Endpoint 4: Buscar Estudante por Matrícula
    @GetMapping("/api/estudantes/{matricula}")
    public String buscarEstudante(@PathVariable String matricula) {
        if (matricula.equals("2024001")) {
            return "Matrícula: 2024001\nNome: Anna Silva\nCurso: ADS\nSemestre: 3º";
        } else if (matricula.equals("2024002")) {
            return "Matrícula: 2024002\nNome: pedro Pereira\nCurso: Engenharia de Software\nSemestre: 5º";
        } else if (matricula.equals("2024003")) {
            return "Matrícula: 2024003\nNome: Luisa Costa\nCurso: Ciência da Computação\nSemestre: 1º";
        } else {
            return "Estudante não encontrado.";
        }
    }
    // Endpoint criativo: Buscar Estudantes por Curso
    @GetMapping("/api/estudantes/curso/{curso}")
    public String buscarPorCurso(@PathVariable String curso) {
        if (curso.equalsIgnoreCase("ADS")) {
            return "Anna Silva - 3º semestre";
        } else if (curso.equalsIgnoreCase("Engenharia de Software")) {
            return "pedro Pereira - 5º semestre";
        } else {
            return "Nenhum estudante encontrado para esse curso.";
        }
    }
}

