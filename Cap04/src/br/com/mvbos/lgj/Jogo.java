package br.com.mvbos.lgj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

import javax.swing.*;

import br.com.mvbos.lgj.base.CenarioPadrao;
import br.com.mvbos.lgj.base.Jogador;
import br.com.mvbos.lgj.base.Texto;

public class Jogo extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;

	private static final int FPS = 1000 / 20;

	private static final int JANELA_ALTURA = 900;

	private static final int JANELA_LARGURA = 900;

	private JPanel tela;

	private Graphics2D g2d;

	private BufferedImage buffer;

	private CenarioPadrao cenario;

	public static File rankingArquivo;

	public static ArrayList<Jogador> ranking;

	public static final Texto textoPausa = new Texto(new Font("Ubuntu Mono", Font.PLAIN, 40));

	public enum Tecla {
		CIMA, BAIXO, ESQUERDA, DIREITA, BA, BB
	}

	public static boolean[] controleTecla = new boolean[Tecla.values().length];

	public static void liberaTeclas() {
		for (int i = 0; i < controleTecla.length; i++) {
			controleTecla[i] = false;
		}
	}

	private void setaTecla(int tecla, boolean pressionada) {
		switch (tecla) {
		case KeyEvent.VK_UP:
			controleTecla[Tecla.CIMA.ordinal()] = pressionada;
			break;
		case KeyEvent.VK_DOWN:
			controleTecla[Tecla.BAIXO.ordinal()] = pressionada;
			break;
		case KeyEvent.VK_LEFT:
			controleTecla[Tecla.ESQUERDA.ordinal()] = pressionada;
			break;
		case KeyEvent.VK_RIGHT:
			controleTecla[Tecla.DIREITA.ordinal()] = pressionada;
			break;

		case KeyEvent.VK_ESCAPE:
			controleTecla[Tecla.BB.ordinal()] = pressionada;
			break;

		case KeyEvent.VK_SPACE:
		case KeyEvent.VK_ENTER:
			controleTecla[Tecla.BA.ordinal()] = pressionada;
		}
	}

	public static int nivel;

	public static int velocidade;

	public static int pontuacao = 0;

	public static boolean pausado;

	public static boolean ganhou = false;

	public static boolean reiniciarJogo = false;

	public static boolean fimdejogo = false;

	public Jogo() {
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				setaTecla(e.getKeyCode(), false);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				setaTecla(e.getKeyCode(), true);
			}
		});

		buffer = new BufferedImage(JANELA_LARGURA, JANELA_ALTURA, BufferedImage.TYPE_INT_BGR);

		g2d = buffer.createGraphics();

		tela = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(buffer, 0, 0, null);
			}

			@Override
			public Dimension getPreferredSize() {
				return new Dimension(JANELA_LARGURA, JANELA_ALTURA);
			}

			@Override
			public Dimension getMinimumSize() {
				return getPreferredSize();
			}
		};

		getContentPane().add(tela);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();

		setVisible(true);
		tela.repaint();
	}

	public void carregarRanking() throws FileNotFoundException {
		rankingArquivo = new File("ranking.txt");
		ranking = new ArrayList<>();
		Scanner leitor = new Scanner(rankingArquivo);
		while(leitor.hasNextLine()) {
			String dados = leitor.nextLine();
			String[] split = dados.split("/");
			ranking.add(new Jogador(Integer.parseInt(split[0]), split[1]));
		}
		ranking.sort(new ComparaPontos());
	}

	public static class ComparaPontos implements Comparator<Jogador> {
		@Override
		public int compare(Jogador j1, Jogador j2){
			if (j1.getPontos() < j2.getPontos()) {
				return 1;
			} else if (j1.getPontos() > j2.getPontos()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public static void registrarRanking() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Seus pontos: " + pontuacao);
		System.out.println();
		String nomeJogador = JOptionPane.showInputDialog("Digite seu nome para guardar no ranking: ");
		System.out.println(nomeJogador);
		ranking.add(new Jogador(pontuacao, nomeJogador));
		try {
			FileWriter escreverRanking = new FileWriter("ranking.txt", true);
			escreverRanking.write(String.valueOf(pontuacao)+"/"+nomeJogador+"\n");
			escreverRanking.close();
		} catch (IOException e) {
			System.out.println("erro ao ler o arquivo no filewriter");
		}
		pontuacao = 0;
		fimdejogo = false;
		reiniciarJogo = true;
		ranking.sort(new ComparaPontos());
		System.out.println("Pressione ESC para voltar a tela inicial!");
	}

	public void carregarJogo() {
		cenario = new InicioCenario(tela.getWidth(), tela.getHeight());
		cenario.carregar();
	}

	public void iniciarJogo() {
		long prxAtualizacao = 0;

		while (true) {
			if (System.currentTimeMillis() >= prxAtualizacao) {
				g2d.setColor(Nivel.coresNiveis.get(Jogo.nivel));
				g2d.fillRect(0, 0, JANELA_LARGURA, JANELA_ALTURA);

				if (controleTecla[Tecla.BA.ordinal()]) {
					// Pressionou espaço ou enter
					if (cenario instanceof InicioCenario) {
						cenario.descarregar();

						cenario = null;

						if (Jogo.nivel < Nivel.niveis.length) {
							cenario = new JogoCenario(tela.getWidth(), tela.getHeight());
						} else {
							cenario = new JogoCenarioDoRusso(tela.getWidth(), tela.getHeight());
						}

						cenario.carregar();

					} else {
						Jogo.pausado = !Jogo.pausado;
					}

					liberaTeclas();

				} else if (controleTecla[Tecla.BB.ordinal()]) {
					// Pressionou ESQ
					if (!(cenario instanceof InicioCenario)) {
						cenario.descarregar();
						reiniciarJogo = true;
						cenario = null;
						cenario = new InicioCenario(tela.getWidth(), tela.getHeight());
						cenario.carregar();
					}

					liberaTeclas();

				}

				if (cenario == null) {
					g2d.setColor(Color.BLACK);
					g2d.drawString("Carregando...", 20, 20);
				} else {
					if (!Jogo.pausado)
						cenario.atualizar();

					cenario.desenhar(g2d);
				}

				tela.repaint();
				prxAtualizacao = System.currentTimeMillis() + FPS;

				if (ganhou) {
					Jogo.nivel++;
					if (Jogo.nivel > 3) {
						Jogo.nivel = 0;
						Jogo.velocidade++;
					}
					cenario.descarregar();
					cenario = null;
					cenario = new JogoCenario(tela.getWidth(), tela.getHeight());
					cenario.carregar();
					ganhou = false;
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Jogo jogo = new Jogo();
		jogo.carregarRanking();
		jogo.carregarJogo();
		jogo.iniciarJogo();
	}
}
