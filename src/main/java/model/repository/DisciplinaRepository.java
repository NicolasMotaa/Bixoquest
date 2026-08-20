package model.repository;

import model.entidades.Area;
import model.entidades.Professor;
import model.jogatina.Disciplina;
import model.jogatina.NivelPergunta;
import model.jogatina.Pergunta;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaRepository {
    private static final List<Disciplina> exatas = new ArrayList<>();
    private static final List<Disciplina> programacao = new ArrayList<>();
    private static final List<Disciplina> eletronica = new ArrayList<>();

    private static boolean inicializado = false;

    // Chamado uma vez pelo JogoService na inicialização do sistema
    public static void inicializar(Professor profExatas, Professor profProg, Professor profElet) {
        if (inicializado) return; // garante que não popula duas vezes

        // índice 0 = null em todas as listas (sem pré-requisito)
        exatas.add(null);
        exatas.add(new Disciplina("Pré-Cálculo", Area.EXATAS, 1, null, profExatas, false, List.of(
                // FÁCEIS
                new Pergunta("Quanto é 2 + 3?", List.of("4", "5", "6", "7"), 1, NivelPergunta.FACIL),
                new Pergunta("Qual é o valor de 5²?", List.of("10", "20", "25", "30"), 2, NivelPergunta.FACIL),
                new Pergunta("Quanto vale √16?", List.of("2", "4", "8", "16"), 1, NivelPergunta.FACIL),
                new Pergunta("Qual número é maior?", List.of("-5", "-2", "-8", "-10"), 1, NivelPergunta.FACIL),
                new Pergunta("Quanto é 15 ÷ 3?", List.of("3", "4", "5", "6"), 2, NivelPergunta.FACIL),
                // MÉDIAS
                new Pergunta("Quanto vale x em 2x + 4 = 10?", List.of("2", "3", "4", "5"), 1, NivelPergunta.MEDIO),
                new Pergunta("Qual é o domínio de √(x - 3)?", List.of("x > 3", "x ≥ 3", "x ≤ 3", "Todos os reais"), 1, NivelPergunta.MEDIO),
                new Pergunta("Quanto vale log₁₀(100)?", List.of("1", "2", "10", "100"), 1, NivelPergunta.MEDIO),
                new Pergunta("Qual é a inclinação da reta y = 4x + 1?", List.of("1", "4", "5", "-4"), 1, NivelPergunta.MEDIO),
                new Pergunta("Quanto vale (x+2)(x-2)?", List.of("x²+4", "x²-4", "x²-2", "2x²-4"), 1, NivelPergunta.MEDIO),
                // DIFÍCEIS
                new Pergunta("Qual é o domínio de 1/(x²-9)?", List.of("x ≠ ±3", "x > 3", "x ≥ -3", "Todos os reais"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Quanto vale log₂(128)?", List.of("6", "7", "8", "9"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Qual é a imagem de f(x)=x² em ℝ?", List.of("ℝ", "x ≥ 0", "y ≥ 0", "y ≤ 0"), 2, NivelPergunta.DIFICIL),
                new Pergunta("Qual matriz possui determinante igual a 1?", List.of("[[1,0],[0,1]]", "[[2,0],[0,2]]", "[[0,0],[0,0]]", "[[1,2],[2,4]]"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Qual é o grau do polinômio x⁷ + x³ - 1?", List.of("3", "5", "6", "7"), 3, NivelPergunta.DIFICIL)
        )
        ));
        exatas.add(new Disciplina("Cálculo 1", Area.EXATAS, 2, exatas.get(1), profExatas, false, List.of(
                // FÁCEIS
                new Pergunta("Qual é a derivada de x²?", List.of("x", "2x", "x²", "2"), 1, NivelPergunta.FACIL),
                new Pergunta("Quanto vale lim(x→2) x?", List.of("0", "1", "2", "∞"), 2, NivelPergunta.FACIL),
                new Pergunta("A derivada de uma constante é:", List.of("0", "1", "A constante", "Infinita"), 0, NivelPergunta.FACIL),
                new Pergunta("Qual é a derivada de 5x?", List.of("0", "1", "5", "5x"), 2, NivelPergunta.FACIL),
                new Pergunta("A derivada representa:", List.of("Área", "Inclinação da curva", "Volume", "Comprimento"), 1, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("Qual é a derivada de sen(x)?", List.of("cos(x)", "-cos(x)", "-sen(x)", "tan(x)"), 0, NivelPergunta.MEDIO),
                new Pergunta("Quanto vale lim(x→0) sen(x)/x?", List.of("0", "1", "∞", "-1"), 1, NivelPergunta.MEDIO),
                new Pergunta("A derivada de e^x é:", List.of("xe^(x-1)", "ln(x)", "e^x", "1"), 2, NivelPergunta.MEDIO),
                new Pergunta("Qual é a derivada de ln(x)?", List.of("ln(x)", "1/x", "x", "e^x"), 1, NivelPergunta.MEDIO),
                new Pergunta("Qual regra deriva x²·sen(x)?", List.of("Cadeia", "Produto", "Quociente", "L'Hôpital"), 1, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("Qual é a derivada de x^x?", List.of("x^(x-1)", "x·x^(x-1)", "x^x(ln(x)+1)", "ln(x)x^x"), 2, NivelPergunta.DIFICIL),
                new Pergunta("Se f'(x)=0 e há troca de sinal, existe um:", List.of("Ponto de sela", "Máximo ou mínimo local", "Assíntota", "Ponto de inflexão"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Qual hipótese NÃO é necessária no Teorema de Rolle?", List.of("Continuidade", "f(a)=f(b)", "Derivabilidade", "f crescente"), 3, NivelPergunta.DIFICIL),
                new Pergunta("Qual é lim(x→0) (e^x-1)/x?", List.of("0", "e", "1", "∞"), 2, NivelPergunta.DIFICIL),
                new Pergunta("Qual método resolve lim 0/0?", List.of("Gauss", "L'Hôpital", "Newton", "Jacobi"), 1, NivelPergunta.DIFICIL))));

        exatas.add(new Disciplina("Cálculo 2", Area.EXATAS, 3, exatas.get(2), profExatas, false, List.of(
                // FÁCEIS
                new Pergunta("∫2x dx =", List.of("x²+C", "2+C", "x+C", "2x+C"), 0, NivelPergunta.FACIL),
                new Pergunta("A integral representa principalmente:", List.of("Área", "Inclinação", "Velocidade", "Raiz"), 0, NivelPergunta.FACIL),
                new Pergunta("∫5 dx =", List.of("5", "5x+C", "x+C", "25+C"), 1, NivelPergunta.FACIL),
                new Pergunta("A derivada da integral devolve:", List.of("Outra integral", "A função", "Zero", "Uma constante"), 1, NivelPergunta.FACIL),
                new Pergunta("∫0 dx =", List.of("0", "1", "x", "C"), 0, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("∫cos(x) dx =", List.of("sen(x)+C", "-sen(x)+C", "cos(x)+C", "-cos(x)+C"), 0, NivelPergunta.MEDIO),
                new Pergunta("∫1/x dx =", List.of("1/2x²", "ln|x|+C", "e^x+C", "x+C"), 1, NivelPergunta.MEDIO),
                new Pergunta("Qual técnica usa u e dv?", List.of("Substituição", "Frações parciais", "Integração por partes", "L'Hôpital"), 2, NivelPergunta.MEDIO),
                new Pergunta("∫e^x dx =", List.of("xe^x", "e^x+C", "ln(x)", "1"), 1, NivelPergunta.MEDIO),
                new Pergunta("Volume por discos é obtido por:", List.of("Integrais", "Limites", "Derivadas", "Matrizes"), 0, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("∫e^(-x²) dx possui:", List.of("Primitiva elementar", "Primitiva racional", "Não possui primitiva elementar", "Resultado igual a zero"), 2, NivelPergunta.DIFICIL),
                new Pergunta("Qual série converge?", List.of("Σ1/n", "Σ1/√n", "Σ1/n²", "Σ1"), 2, NivelPergunta.DIFICIL),
                new Pergunta("A série harmônica:", List.of("Converge", "Diverge", "Vale π", "Vale 1"), 1, NivelPergunta.DIFICIL),
                new Pergunta("∫ln(x) dx exige:", List.of("L'Hôpital", "Integração por partes", "Substituição trig.", "Frações parciais"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Qual teste usa lim sup da raiz n-ésima?", List.of("Razão", "Integral", "Raiz", "Comparação"), 2, NivelPergunta.DIFICIL)
        )));

        exatas.add(new Disciplina("Física", Area.EXATAS, 4, exatas.get(3), profExatas, false, List.of(
                // FÁCEIS
                new Pergunta("Unidade de força no SI:", List.of("Joule", "Newton", "Watt", "Pascal"), 1, NivelPergunta.FACIL),
                new Pergunta("A gravidade aproxima-se de:", List.of("9,8 m/s²", "3 m/s²", "15 m/s²", "1 m/s²"), 0, NivelPergunta.FACIL),
                new Pergunta("Qual grandeza mede a rapidez?", List.of("Velocidade", "Força", "Energia", "Potência"), 0, NivelPergunta.FACIL),
                new Pergunta("Energia é medida em:", List.of("Newton", "Joule", "Volt", "Ampère"), 1, NivelPergunta.FACIL),
                new Pergunta("F = ma é a:", List.of("1ª Lei", "2ª Lei", "3ª Lei", "Lei de Ohm"), 1, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("Potência é:", List.of("Energia × tempo", "Energia/tempo", "Força/tempo", "Massa × velocidade"), 1, NivelPergunta.MEDIO),
                new Pergunta("A unidade de potência é:", List.of("Newton", "Joule", "Watt", "Tesla"), 2, NivelPergunta.MEDIO),
                new Pergunta("Energia cinética é:", List.of("mv", "mv²", "mv²/2", "m²v"), 2, NivelPergunta.MEDIO),
                new Pergunta("Um projétil sem resistência do ar possui:", List.of("MRU", "Trajetória parabólica", "Movimento circular", "Movimento harmônico"), 1, NivelPergunta.MEDIO),
                new Pergunta("Impulso corresponde à variação de:", List.of("Energia", "Quantidade de movimento", "Velocidade", "Potência"), 1, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("Qual equação descreve um oscilador harmônico simples?", List.of("F=ma", "x''+ω²x=0", "E=mc²", "V=RI"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Qual partícula medeia a interação eletromagnética?", List.of("Glúon", "Fóton", "Bóson W", "Gráviton"), 1, NivelPergunta.DIFICIL),
                new Pergunta("A equação de Schrödinger pertence à:", List.of("Relatividade", "Termodinâmica", "Mecânica Quântica", "Óptica"), 2, NivelPergunta.DIFICIL),
                new Pergunta("Em Relatividade, nada supera:", List.of("Som", "Gravidade", "Luz no vácuo", "Campo elétrico"), 2, NivelPergunta.DIFICIL),
                new Pergunta("A equação de Maxwell prevê:", List.of("Ondas eletromagnéticas", "Buracos negros", "Radioatividade", "Fissão nuclear"), 0, NivelPergunta.DIFICIL)
        )));

        exatas.add(new Disciplina("Equações Diferenciais", Area.EXATAS, 5, exatas.get(4), profExatas, false, List.of(
                // FÁCEIS
                new Pergunta("Uma EDO envolve:", List.of("Uma variável independente", "Duas integrais", "Matrizes", "Vetores"), 0, NivelPergunta.FACIL),
                new Pergunta("dy/dx representa:", List.of("Integral", "Derivada", "Limite", "Somatório"), 1, NivelPergunta.FACIL),
                new Pergunta("y'=ky descreve:", List.of("Crescimento exponencial", "Movimento circular", "MRU", "Queda livre"), 0, NivelPergunta.FACIL),
                new Pergunta("A ordem de y''+y=0 é:", List.of("1", "2", "3", "0"), 1, NivelPergunta.FACIL),
                new Pergunta("Condição inicial serve para:", List.of("Escolher a solução", "Calcular derivada", "Eliminar integrais", "Encontrar domínio"), 0, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("Qual método resolve EDO separável?", List.of("Separação de variáveis", "Gauss", "Newton-Raphson", "Simplex"), 0, NivelPergunta.MEDIO),
                new Pergunta("A solução de y'=y é:", List.of("ln(x)", "Ce^x", "x²", "sen(x)"), 1, NivelPergunta.MEDIO),
                new Pergunta("y''+y=0 possui solução:", List.of("Ae^x", "Asen(x)+Bcos(x)", "Ax+B", "ln(x)"), 1, NivelPergunta.MEDIO),
                new Pergunta("EDOs lineares usam fator:", List.of("Angular", "Integrante", "Escalar", "Jacobiano"), 1, NivelPergunta.MEDIO),
                new Pergunta("A equação logística modela:", List.of("Circuitos", "Populações", "Óptica", "Matrizes"), 1, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("A transformada de Laplace converte EDOs em:", List.of("Integrais", "Equações algébricas", "Matrizes ortogonais", "Polinômios de Taylor"), 1, NivelPergunta.DIFICIL),
                new Pergunta("A solução de y''+λy=0 depende de:", List.of("λ", "Apenas y", "Apenas x", "π"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Problemas de Sturm-Liouville envolvem:", List.of("Autovalores", "Grafos", "Probabilidade", "Interpolação"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Método de Frobenius é usado em:", List.of("Pontos singulares", "Integração numérica", "Derivação implícita", "Transformadas Z"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Qual método aproxima numericamente EDOs?", List.of("Euler", "Gauss-Jordan", "Simplex", "Jacobi"), 0, NivelPergunta.DIFICIL)
        )));

        programacao.add(null);
        programacao.add(new Disciplina("Algoritmos 1", Area.PROGRAMACAO, 1, null, profProg, true, List.of(
                // FÁCEIS
                new Pergunta("Qual estrutura repete comandos?", List.of("if", "for", "break", "return"), 1, NivelPergunta.FACIL),
                new Pergunta("Qual comando imprime na tela em Java?", List.of("System.out.println()", "print()", "echo()", "printf()"), 0, NivelPergunta.FACIL),
                new Pergunta("Qual estrutura toma decisões?", List.of("for", "while", "if", "do"), 2, NivelPergunta.FACIL),
                new Pergunta("Qual operador representa igualdade?", List.of("=", "==", "!=", "<>"), 1, NivelPergunta.FACIL),
                new Pergunta("Uma variável armazena:", List.of("Código", "Dados", "Métodos", "Classes"), 1, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("Qual estrutura executa enquanto a condição for verdadeira?", List.of("if", "switch", "while", "break"), 2, NivelPergunta.MEDIO),
                new Pergunta("Um algoritmo deve ser:", List.of("Infinito", "Finito", "Aleatório", "Recursivo"), 1, NivelPergunta.MEDIO),
                new Pergunta("Qual estrutura escolhe entre vários casos?", List.of("switch", "for", "while", "continue"), 0, NivelPergunta.MEDIO),
                new Pergunta("Qual é a saída de 5 % 2?", List.of("2", "2.5", "1", "0"), 2, NivelPergunta.MEDIO),
                new Pergunta("Recursão é:", List.of("Um vetor", "Uma função que chama a si mesma", "Um loop infinito", "Uma variável"), 1, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("A complexidade da busca binária é:", List.of("O(n)", "O(log n)", "O(n²)", "O(1)"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Qual problema NÃO é decidível?", List.of("Parada", "Ordenação", "Busca", "Soma"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Merge Sort possui complexidade média:", List.of("O(n)", "O(n log n)", "O(n²)", "O(log n)"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Qual paradigma usa dividir para conquistar?", List.of("Greedy", "Backtracking", "Divide and Conquer", "Dinâmico"), 2, NivelPergunta.DIFICIL),
                new Pergunta("Qual estrutura é usada na DFS?", List.of("Fila", "Pilha", "Heap", "Hash"), 1, NivelPergunta.DIFICIL)
        )));

        programacao.add(new Disciplina("Estruturas de Dados", Area.PROGRAMACAO, 2, programacao.get(1), profProg, false, List.of(
                // FÁCEIS
                new Pergunta("Uma pilha segue o princípio:", List.of("FIFO", "LIFO", "LRU", "Árvore"), 1, NivelPergunta.FACIL),
                new Pergunta("Uma fila segue o princípio:", List.of("FIFO", "LIFO", "Hash", "Heap"), 0, NivelPergunta.FACIL),
                new Pergunta("Qual estrutura armazena pares chave-valor?", List.of("Lista", "HashMap", "Pilha", "Fila"), 1, NivelPergunta.FACIL),
                new Pergunta("Uma lista ligada possui:", List.of("Nós", "Colunas", "Blocos", "Classes"), 0, NivelPergunta.FACIL),
                new Pergunta("Qual estrutura representa hierarquias?", List.of("Fila", "Árvore", "Pilha", "Vetor"), 1, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("A inserção em pilha ocorre no:", List.of("Topo", "Fim", "Início", "Centro"), 0, NivelPergunta.MEDIO),
                new Pergunta("A busca em árvore binária balanceada é:", List.of("O(n)", "O(log n)", "O(n²)", "O(1)"), 1, NivelPergunta.MEDIO),
                new Pergunta("Heap é usada em:", List.of("Busca binária", "Fila de prioridade", "Hash", "Recursão"), 1, NivelPergunta.MEDIO),
                new Pergunta("Qual percurso visita raiz, esquerda e direita?", List.of("Pré-ordem", "Em ordem", "Pós-ordem", "Largura"), 0, NivelPergunta.MEDIO),
                new Pergunta("Hashing busca reduzir:", List.of("Memória", "Colisões", "Complexidade", "Classes"), 1, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("Uma árvore AVL mantém:", List.of("Balanceamento", "Ordenação aleatória", "Hash", "Heap"), 0, NivelPergunta.DIFICIL),
                new Pergunta("A altura de uma Red-Black Tree é:", List.of("O(n²)", "O(log n)", "O(1)", "O(n)"), 1, NivelPergunta.DIFICIL),
                new Pergunta("B-Trees são usadas principalmente em:", List.of("Compiladores", "Bancos de dados", "Sockets", "Threads"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Qual estrutura implementa Dijkstra eficientemente?", List.of("Heap", "Fila", "Lista", "Pilha"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Union-Find resolve problemas de:", List.of("Componentes conexas", "Ordenação", "Hash", "Compressão"), 0, NivelPergunta.DIFICIL)
        )));

        programacao.add(new Disciplina("Java", Area.PROGRAMACAO, 3, programacao.get(2), profProg, true, List.of(
                // FÁCEIS
                new Pergunta("Java é uma linguagem:", List.of("Compilada e interpretada", "Apenas interpretada", "Apenas compilada", "Assembly"), 0, NivelPergunta.FACIL),
                new Pergunta("Herança usa a palavra:", List.of("implements", "extends", "inherit", "super"), 1, NivelPergunta.FACIL),
                new Pergunta("Objetos são instâncias de:", List.of("Métodos", "Classes", "Interfaces", "Pacotes"), 1, NivelPergunta.FACIL),
                new Pergunta("Qual palavra cria um objeto?", List.of("class", "this", "new", "static"), 2, NivelPergunta.FACIL),
                new Pergunta("Qual método inicia um programa Java?", List.of("run()", "start()", "main()", "init()"), 2, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("Polimorfismo permite:", List.of("Herança múltipla", "Objetos assumirem diferentes formas", "Criar threads", "Compilar mais rápido"), 1, NivelPergunta.MEDIO),
                new Pergunta("Interfaces utilizam:", List.of("implements", "extends", "inherits", "instanceof"), 0, NivelPergunta.MEDIO),
                new Pergunta("Qual coleção não aceita elementos duplicados?", List.of("List", "Set", "Queue", "ArrayList"), 1, NivelPergunta.MEDIO),
                new Pergunta("Exceções verificadas herdam de:", List.of("Throwable", "Object", "Exception", "RuntimeException"), 2, NivelPergunta.MEDIO),
                new Pergunta("Encapsulamento usa principalmente:", List.of("Getters e Setters", "Loops", "Threads", "Enums"), 0, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("Qual coletor de lixo é padrão no Java moderno?", List.of("Serial", "G1", "CMS", "Epsilon"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Generics sofrem:", List.of("Type Erasure", "Reflection", "Boxing", "Casting"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Qual interface base da Stream API é:", List.of("Iterable", "Collection", "Stream", "Sequence"), 2, NivelPergunta.DIFICIL),
                new Pergunta("O modificador volatile garante:", List.of("Visibilidade entre threads", "Imutabilidade", "Serialização", "Polimorfismo"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Reflection permite:", List.of("Inspecionar classes em tempo de execução", "Compilar código", "Executar SQL", "Criar sockets"), 0, NivelPergunta.DIFICIL)
        )));

        programacao.add(new Disciplina("Banco de Dados", Area.PROGRAMACAO, 4, programacao.get(3), profProg, false, List.of(
                // FÁCEIS
                new Pergunta("SQL significa:", List.of("Structured Query Language", "Simple Query Language", "Standard Queue Language", "System Query Language"), 0, NivelPergunta.FACIL),
                new Pergunta("SELECT é usado para:", List.of("Inserir", "Consultar", "Excluir", "Atualizar"), 1, NivelPergunta.FACIL),
                new Pergunta("Qual comando insere dados?", List.of("INSERT", "UPDATE", "SELECT", "DELETE"), 0, NivelPergunta.FACIL),
                new Pergunta("Uma tabela é formada por:", List.of("Linhas e colunas", "Métodos", "Classes", "Objetos"), 0, NivelPergunta.FACIL),
                new Pergunta("DELETE remove:", List.of("Colunas", "Registros", "Índices", "Tabelas"), 1, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("A chave primária deve ser:", List.of("Duplicada", "Única", "Opcional", "Texto"), 1, NivelPergunta.MEDIO),
                new Pergunta("JOIN serve para:", List.of("Ordenar", "Relacionar tabelas", "Excluir dados", "Criar índices"), 1, NivelPergunta.MEDIO),
                new Pergunta("Qual forma normal elimina dependências parciais?", List.of("1FN", "2FN", "3FN", "BCNF"), 1, NivelPergunta.MEDIO),
                new Pergunta("UPDATE faz:", List.of("Consulta", "Atualização", "Remoção", "Ordenação"), 1, NivelPergunta.MEDIO),
                new Pergunta("Índices servem para:", List.of("Economizar RAM", "Acelerar consultas", "Criptografar dados", "Reduzir tabelas"), 1, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("ACID refere-se a:", List.of("Transações", "Consultas", "Índices", "Triggers"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Qual isolamento evita dirty reads?", List.of("Read Uncommitted", "Read Committed", "Serializable", "Snapshot"), 1, NivelPergunta.DIFICIL),
                new Pergunta("B+ Trees são usadas para:", List.of("Ordenação", "Indexação", "Hash", "Compressão"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Deadlock ocorre quando:", List.of("Há espera circular", "Falta memória", "Há índice duplicado", "Tabela vazia"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Qual linguagem define o esquema?", List.of("DDL", "DML", "DCL", "TCL"), 0, NivelPergunta.DIFICIL)
        )));

        programacao.add(new Disciplina("Engenharia de Software", Area.PROGRAMACAO, 5, programacao.get(4), profProg, true, List.of(
                // FÁCEIS
                new Pergunta("UML significa:", List.of("Unified Modeling Language", "Universal Model Language", "Unified Machine Language", "Universal Machine Logic"), 0, NivelPergunta.FACIL),
                new Pergunta("Qual metodologia usa Sprints?", List.of("Cascata", "Scrum", "XP", "Kanban"), 1, NivelPergunta.FACIL),
                new Pergunta("Um requisito funcional descreve:", List.of("O que o sistema faz", "O hardware", "O banco", "A linguagem"), 0, NivelPergunta.FACIL),
                new Pergunta("Caso de uso representa:", List.of("Interação com o sistema", "Código-fonte", "Banco de dados", "Servidor"), 0, NivelPergunta.FACIL),
                new Pergunta("Quem representa o usuário na UML?", List.of("Classe", "Ator", "Objeto", "Interface"), 1, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("SOLID possui quantos princípios?", List.of("3", "5", "6", "7"), 1, NivelPergunta.MEDIO),
                new Pergunta("MVC separa:", List.of("Modelo, Visão e Controle", "Método, Variável e Classe", "Módulo, Vetor e Código", "Modelo, View e Compilador"), 0, NivelPergunta.MEDIO),
                new Pergunta("Git é um sistema de:", List.of("Banco de dados", "Controle de versão", "IDE", "Compilação"), 1, NivelPergunta.MEDIO),
                new Pergunta("Testes unitários verificam:", List.of("O sistema inteiro", "Pequenas unidades", "Banco de dados", "Rede"), 1, NivelPergunta.MEDIO),
                new Pergunta("Diagrama de classes mostra:", List.of("Estrutura do sistema", "Fluxo de telas", "Cronograma", "Banco de dados"), 0, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("DDD significa:", List.of("Domain-Driven Design", "Data-Driven Development", "Domain Data Diagram", "Design Data Domain"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Qual padrão cria famílias de objetos?", List.of("Factory Method", "Abstract Factory", "Singleton", "Adapter"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Inversão de Dependência pertence ao:", List.of("GoF", "SOLID", "GRASP", "XP"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Qual padrão desacopla publicador e assinantes?", List.of("Observer", "Decorator", "Strategy", "Facade"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Clean Architecture foi popularizada por:", List.of("Martin Fowler", "Robert C. Martin", "Gamma", "Kent Beck"), 1, NivelPergunta.DIFICIL)
        )));

        eletronica.add(null);
        eletronica.add(new Disciplina("Introdução à Eletrônica", Area.ELETRONICA, 1, null, profElet, false, List.of(
                // FÁCEIS
                new Pergunta("A unidade da corrente elétrica é:", List.of("Volt", "Ampère", "Ohm", "Watt"), 1, NivelPergunta.FACIL),
                new Pergunta("Qual componente limita corrente?", List.of("Capacitor", "Resistor", "Diodo", "LED"), 1, NivelPergunta.FACIL),
                new Pergunta("A tensão é medida em:", List.of("Volt", "Ampère", "Ohm", "Farad"), 0, NivelPergunta.FACIL),
                new Pergunta("Um LED é um:", List.of("Resistor", "Capacitor", "Diodo", "Transistor"), 2, NivelPergunta.FACIL),
                new Pergunta("A Lei de Ohm é:", List.of("V=RI", "P=VI", "I²R", "Q=CV"), 0, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("A unidade de resistência é:", List.of("Volt", "Ampère", "Ohm", "Henry"), 2, NivelPergunta.MEDIO),
                new Pergunta("Um capacitor armazena:", List.of("Corrente", "Carga elétrica", "Potência", "Resistência"), 1, NivelPergunta.MEDIO),
                new Pergunta("Um diodo conduz em:", List.of("Ambos os sentidos", "Sentido direto", "Nunca", "Somente em CA"), 1, NivelPergunta.MEDIO),
                new Pergunta("A potência elétrica é:", List.of("V/I", "V×I", "I/R", "R²"), 1, NivelPergunta.MEDIO),
                new Pergunta("Um transistor pode atuar como:", List.of("Chave", "Resistor", "Capacitor", "Indutor"), 0, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("MOSFET significa:", List.of("Metal Oxide Semiconductor Field Effect Transistor", "Multiple Output Semiconductor", "Magnetic Operational Switch", "Metal Output Signal Filter"), 0, NivelPergunta.DIFICIL),
                new Pergunta("A impedância é representada por:", List.of("R", "Z", "X", "Y"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Um amplificador operacional ideal possui ganho:", List.of("Zero", "Unitário", "Infinito", "10"), 2, NivelPergunta.DIFICIL),
                new Pergunta("A unidade da capacitância é:", List.of("Henry", "Tesla", "Farad", "Siemens"), 2, NivelPergunta.DIFICIL),
                new Pergunta("Qual componente armazena energia em campo magnético?", List.of("Capacitor", "Resistor", "Indutor", "Diodo"), 2, NivelPergunta.DIFICIL)
        )));

        eletronica.add(new Disciplina("Circuitos Digitais", Area.ELETRONICA, 2, eletronica.get(1), profElet, true, List.of(
                // FÁCEIS
                new Pergunta("O sistema binário possui quantos símbolos?", List.of("2", "8", "10", "16"), 0, NivelPergunta.FACIL),
                new Pergunta("Qual porta representa E lógico?", List.of("OR", "AND", "NOT", "XOR"), 1, NivelPergunta.FACIL),
                new Pergunta("Qual porta inverte um sinal?", List.of("AND", "OR", "NOT", "NAND"), 2, NivelPergunta.FACIL),
                new Pergunta("Em binário, 101 representa:", List.of("4", "5", "6", "7"), 1, NivelPergunta.FACIL),
                new Pergunta("Qual porta produz 1 quando entradas são diferentes?", List.of("AND", "OR", "XOR", "NOR"), 2, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("Flip-Flop armazena:", List.of("1 bit", "1 byte", "8 bits", "16 bits"), 0, NivelPergunta.MEDIO),
                new Pergunta("NAND é considerada:", List.of("Porta universal", "Memória", "Registrador", "Clock"), 0, NivelPergunta.MEDIO),
                new Pergunta("Um multiplexador faz:", List.of("Seleciona entradas", "Amplifica sinal", "Conta pulsos", "Converte tensão"), 0, NivelPergunta.MEDIO),
                new Pergunta("Um decoder converte:", List.of("Código em saídas", "Analógico em digital", "Corrente em tensão", "Clock em pulso"), 0, NivelPergunta.MEDIO),
                new Pergunta("Clock sincroniza:", List.of("Circuitos sequenciais", "Circuitos analógicos", "Fontes", "Resistores"), 0, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("Mapa de Karnaugh serve para:", List.of("Simplificar expressões booleanas", "Resolver EDOs", "Calcular corrente", "Projetar PCBs"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Um registrador é formado por:", List.of("Flip-Flops", "Resistores", "Capacitores", "Diodos"), 0, NivelPergunta.DIFICIL),
                new Pergunta("FPGA significa:", List.of("Field Programmable Gate Array", "Fast Processing Graphic Array", "Fixed Programmable Gate Architecture", "Functional Processor Grid Array"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Latch difere de Flip-Flop por ser:", List.of("Sensível ao nível", "Mais rápido", "Analógico", "Combinacional"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Qual porta sozinha implementa qualquer circuito?", List.of("AND", "OR", "NAND", "XOR"), 2, NivelPergunta.DIFICIL)
        )));

        eletronica.add(new Disciplina("Sistemas Operacionais", Area.ELETRONICA, 3, eletronica.get(2), profElet, false, List.of(
                // FÁCEIS
                new Pergunta("O sistema operacional gerencia:", List.of("Hardware e software", "Apenas internet", "Somente memória", "Planilhas"), 0, NivelPergunta.FACIL),
                new Pergunta("Qual SO é de código aberto?", List.of("Windows", "Linux", "MS-DOS", "macOS"), 1, NivelPergunta.FACIL),
                new Pergunta("Um processo é:", List.of("Programa em execução", "Arquivo", "Driver", "Kernel"), 0, NivelPergunta.FACIL),
                new Pergunta("RAM é memória:", List.of("Volátil", "Permanente", "Óptica", "Virtual"), 0, NivelPergunta.FACIL),
                new Pergunta("Escalonador decide:", List.of("Qual processo executa", "Qual HD usar", "Qual linguagem usar", "Qual usuário entra"), 0, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("Deadlock ocorre quando:", List.of("Há espera circular", "Falta energia", "Acaba a RAM", "CPU aquece"), 0, NivelPergunta.MEDIO),
                new Pergunta("Memória virtual utiliza:", List.of("Disco", "GPU", "BIOS", "Cache"), 0, NivelPergunta.MEDIO),
                new Pergunta("Kernel é:", List.of("Núcleo do SO", "Compilador", "Editor", "Driver"), 0, NivelPergunta.MEDIO),
                new Pergunta("Round Robin é um algoritmo de:", List.of("Escalonamento", "Ordenação", "Compressão", "Criptografia"), 0, NivelPergunta.MEDIO),
                new Pergunta("Thread é:", List.of("Fluxo de execução", "Arquivo", "Processador", "Sistema de arquivos"), 0, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("Qual algoritmo substitui páginas pela menos usada recentemente?", List.of("FIFO", "LRU", "Round Robin", "Best Fit"), 1, NivelPergunta.DIFICIL),
                new Pergunta("Starvation significa:", List.of("Inanição de processos", "Falta de memória", "Travamento físico", "Erro de compilação"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Mutex é usado para:", List.of("Exclusão mútua", "Escalonamento", "Paginação", "Virtualização"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Um semáforo controla:", List.of("Acesso concorrente", "Clock", "Cache", "Barramento"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Copy-on-Write otimiza:", List.of("Fork de processos", "Compilação", "Rede", "Banco de dados"), 0, NivelPergunta.DIFICIL)
        )));

        eletronica.add(new Disciplina("Sistemas Digitais", Area.ELETRONICA, 4, eletronica.get(3), profElet, true, List.of(
                // FÁCEIS
                new Pergunta("Um bit pode assumir:", List.of("2 valores", "8 valores", "10 valores", "16 valores"), 0, NivelPergunta.FACIL),
                new Pergunta("8 bits formam um:", List.of("Byte", "Nibble", "Word", "Clock"), 0, NivelPergunta.FACIL),
                new Pergunta("CPU significa:", List.of("Central Processing Unit", "Computer Power Unit", "Central Program Unit", "Core Process Utility"), 0, NivelPergunta.FACIL),
                new Pergunta("O barramento de dados transporta:", List.of("Dados", "Energia", "Calor", "Clock"), 0, NivelPergunta.FACIL),
                new Pergunta("ROM é memória:", List.of("Somente leitura", "Volátil", "Cache", "Virtual"), 0, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("ULA significa:", List.of("Unidade Lógica e Aritmética", "Unidade Linear Analógica", "Ultra Logic Array", "Universal Logic Adapter"), 0, NivelPergunta.MEDIO),
                new Pergunta("Pipeline aumenta:", List.of("Desempenho", "Consumo", "Temperatura", "Memória"), 0, NivelPergunta.MEDIO),
                new Pergunta("Cache reduz:", List.of("Tempo de acesso", "Tamanho do HD", "Clock", "Consumo da GPU"), 0, NivelPergunta.MEDIO),
                new Pergunta("Registradores ficam:", List.of("Dentro da CPU", "No HD", "Na RAM", "Na BIOS"), 0, NivelPergunta.MEDIO),
                new Pergunta("Clock é medido em:", List.of("Hertz", "Volts", "Watts", "Ohms"), 0, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("Arquitetura Harvard possui:", List.of("Memórias separadas", "Dois processadores", "Dois clocks", "Cache unificada"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Arquitetura RISC caracteriza-se por:", List.of("Instruções simples", "Instruções complexas", "Sem registradores", "Clock variável"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Hazard em pipeline é:", List.of("Conflito de execução", "Falha elétrica", "Erro de memória RAM", "Ruído"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Branch Prediction busca:", List.of("Reduzir desvios", "Economizar energia", "Aumentar RAM", "Controlar cache"), 0, NivelPergunta.DIFICIL),
                new Pergunta("CISC significa:", List.of("Complex Instruction Set Computer", "Central Integrated System Controller", "Compact Instruction System Core", "Computer Integrated Signal Controller"), 0, NivelPergunta.DIFICIL)
        )));

        eletronica.add(new Disciplina("Sinais e Sistemas", Area.ELETRONICA, 5, eletronica.get(4), profElet, false, List.of(
                // FÁCEIS
                new Pergunta("Um sinal pode variar no:", List.of("Tempo", "Espaço apenas", "Temperatura", "Peso"), 0, NivelPergunta.FACIL),
                new Pergunta("A frequência é medida em:", List.of("Hertz", "Volt", "Ohm", "Farad"), 0, NivelPergunta.FACIL),
                new Pergunta("Período é o inverso da:", List.of("Amplitude", "Frequência", "Fase", "Potência"), 1, NivelPergunta.FACIL),
                new Pergunta("Uma senoide é um sinal:", List.of("Periódico", "Aleatório", "Digital", "Constante"), 0, NivelPergunta.FACIL),
                new Pergunta("Amplitude representa:", List.of("Valor máximo", "Frequência", "Período", "Fase"), 0, NivelPergunta.FACIL),

                // MÉDIAS
                new Pergunta("A Transformada de Fourier converte para o domínio:", List.of("Frequência", "Tempo", "Espaço", "Potência"), 0, NivelPergunta.MEDIO),
                new Pergunta("Um sistema LTI é:", List.of("Linear e Invariante no Tempo", "Lógico e Temporal", "Linear e Integrável", "Limitado e Temporal"), 0, NivelPergunta.MEDIO),
                new Pergunta("Convolução relaciona:", List.of("Entrada e saída", "Corrente e tensão", "CPU e RAM", "Clock e cache"), 0, NivelPergunta.MEDIO),
                new Pergunta("A resposta ao impulso caracteriza:", List.of("O sistema", "O sinal", "A frequência", "A potência"), 0, NivelPergunta.MEDIO),
                new Pergunta("Filtro passa-baixa atenua:", List.of("Altas frequências", "Baixas frequências", "Corrente", "Tensão"), 0, NivelPergunta.MEDIO),

                // DIFÍCEIS
                new Pergunta("A Transformada Z é usada para sistemas:", List.of("Discretos", "Contínuos", "Analógicos", "Lineares apenas"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Critério de Nyquist está relacionado à:", List.of("Amostragem", "Potência", "Corrente", "Resistência"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Um sistema BIBO estável possui:", List.of("Saída limitada para entrada limitada", "Energia infinita", "Resposta nula", "Frequência constante"), 0, NivelPergunta.DIFICIL),
                new Pergunta("A Transformada de Laplace utiliza a variável:", List.of("s", "z", "x", "ω"), 0, NivelPergunta.DIFICIL),
                new Pergunta("Aliasing ocorre por:", List.of("Subamostragem", "Ruído", "Quantização", "Atenuação"), 0, NivelPergunta.DIFICIL)
        )));

        inicializado = true;
    }

    public static List<Disciplina> buscarPorArea(Area area) {
        return switch (area) {
            case EXATAS -> new ArrayList<>(exatas);
            case PROGRAMACAO -> new ArrayList<>(programacao);
            case ELETRONICA -> new ArrayList<>(eletronica);
        };
    }

    // Retorna a disciplina do semestre X da área Y (semestre começa em 1)
    public static Disciplina buscarPorSemestre(Area area, int semestre) {
        List<Disciplina> lista = buscarPorArea(area);
        if (semestre < 1 || semestre >= lista.size()) return null;
        return lista.get(semestre); // índice = semestre, já que índice 0 é null
    }
}
