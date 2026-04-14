package model.repository;

import model.entidades.*;
import model.locais.*;

import java.util.ArrayList;
import java.util.List;

public class MapaRepository {

    private static Biblioteca biblioteca;
    private static Cantina cantina;
    private static Colegiado colegiado;
    private static Laboratorio laboratorio;
    private static PontoDeOnibus pontoDeOnibus;
    private static PracaDoBorogodo pracaDoBorogodo;
    private static SalaDeAula salaDeAula;

    private static Maeli maeli;
    private static Professor profExatas;
    private static Professor profEletronica;
    private static Professor profProgramacao;
    private static Vendedor vendedor;
    private static Animal cachorro;
    private static Animal gato;
    private static Colega colegaSala;
    private static Colega colegaPraca;

    private static boolean inicializado = false;

    public static void inicializar() {
        if (inicializado) return;

        // 1. criar locais (sem NPCs ainda)
        biblioteca = new Biblioteca(new ArrayList<>());
        cantina = new Cantina(new ArrayList<>());
        colegiado = new Colegiado(new ArrayList<>());
        laboratorio = new Laboratorio(new ArrayList<>());
        pontoDeOnibus = new PontoDeOnibus(new ArrayList<>());
        pracaDoBorogodo = new PracaDoBorogodo(new ArrayList<>());
        salaDeAula = new SalaDeAula(new ArrayList<>());

        // 2. criar NPCs passando os locais
        maeli = new Maeli(colegiado);
        profExatas = new Professor("Gegê","Professor de exatas, certinho?", salaDeAula, Area.EXATAS);
        profEletronica = new Professor("Jonas", "Doscente do DTEC, não trema.", salaDeAula, Area.ELETRONICA);
        profProgramacao = new Professor("Ana Cláudia", "Uma mãe. Ensina a programar", salaDeAula, Area.PROGRAMACAO);
        vendedor = new Vendedor(cantina);
        cachorro = new Animal("Scooby","Cachorro gordinho", pracaDoBorogodo, Especie.CACHORRO);
        gato = new Animal("Florência", "Gatinha manhosa", salaDeAula,Especie.GATO);
        colegaSala = new Colega("Marcos", "Nerd de escore alto", salaDeAula);
        colegaPraca = new Colega("Gabriel", "Se importa mais com a diversão", pracaDoBorogodo);

        // 3. adicionar NPCs aos locais

        cantina.getNpcs().add(vendedor);
        colegiado.getNpcs().add(maeli);
        pracaDoBorogodo.getNpcs().add(cachorro);
        pracaDoBorogodo.getNpcs().add(colegaPraca);
        salaDeAula.getNpcs().add(profEletronica);
        salaDeAula.getNpcs().add(profExatas);
        salaDeAula.getNpcs().add(profProgramacao);
        salaDeAula.getNpcs().add(colegaSala);
        salaDeAula.getNpcs().add(gato);

        inicializado = true;
    }

    public static List<Local> getTodosLocais() {
        return List.of(biblioteca, cantina, colegiado, laboratorio,
                pontoDeOnibus, pracaDoBorogodo, salaDeAula);
    }

    public static Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public static Cantina getCantina() {
        return cantina;
    }

    public static Colegiado getColegiado() {
        return colegiado;
    }

    public static Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public static PontoDeOnibus getPontoDeOnibus() {
        return pontoDeOnibus;
    }

    public static PracaDoBorogodo getPracaDoBorogodo() {
        return pracaDoBorogodo;
    }

    public static SalaDeAula getSalaDeAula() {
        return salaDeAula;
    }

    public static Maeli getMaeli() {
        return maeli;
    }

    public static Professor getProfExatas() {
        return profExatas;
    }

    public static Professor getProfEletronica() {
        return profEletronica;
    }

    public static Professor getProfProgramacao() {
        return profProgramacao;
    }

    public static Vendedor getVendedor() {
        return vendedor;
    }

    public static Animal getCachorro() {
        return cachorro;
    }

    public static Animal getGato() {
        return gato;
    }

    public static Colega getColegaSala() {
        return colegaSala;
    }

    public static Colega getColegaPraca() {
        return colegaPraca;
    }
}
