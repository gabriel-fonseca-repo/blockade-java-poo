package br.com.mvbos.lgj;

import java.awt.*;

import br.com.mvbos.lgj.base.CenarioPadrao;
import br.com.mvbos.lgj.base.Menu;
import br.com.mvbos.lgj.base.Texto;
import br.com.mvbos.lgj.base.Util;

public class InicioCenario extends CenarioPadrao {

	public InicioCenario(int largura, int altura) {
		super(largura, altura);
	}

	private Menu menuJogo;

	private Menu menuVelInicial;

	private Texto texto = new Texto(new Font("Ubuntu Mono", Font.PLAIN, 16));

	@Override
	public void carregar() {

		menuJogo = new Menu("Fase");
		
		String[] opcoes = new String[Nivel.niveis.length + 1];
		
		for (int i = 0; i < opcoes.length; i++) {
			opcoes[i] = "Nível " + i;
		}
		
		opcoes[opcoes.length - 1] = "Do Russo";

		menuJogo.addOpcoes(opcoes);

		menuVelInicial = new Menu("Vel.");
		menuVelInicial.addOpcoes("Normal", "Rápido", "Lento");

		Util.centraliza(menuJogo, largura, altura);
		Util.centraliza(menuVelInicial, largura, altura);

		menuVelInicial.setPy(menuJogo.getPy() + menuJogo.getAltura());

		menuJogo.setAtivo(true);
		menuJogo.setSelecionado(true);
		menuVelInicial.setAtivo(true);
	}

	@Override
	public void descarregar() {
		Jogo.nivel = menuJogo.getOpcaoId();

		switch (menuVelInicial.getOpcaoId()) {
		case 0:
			Jogo.velocidade = 8;
			break;
		case 1:
			Jogo.velocidade = 8;
			break;
		case 2:
			Jogo.velocidade = 8;
		}
	}

	@Override
	public void atualizar() {
		if (Jogo.controleTecla[Jogo.Tecla.CIMA.ordinal()] || Jogo.controleTecla[Jogo.Tecla.BAIXO.ordinal()]) {
			if (menuJogo.isSelecionado()) {
				menuJogo.setSelecionado(false);
				menuVelInicial.setSelecionado(true);
			} else {
				menuJogo.setSelecionado(true);
				menuVelInicial.setSelecionado(false);
			}

		} else if (Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()] || Jogo.controleTecla[Jogo.Tecla.DIREITA.ordinal()]) {
			menuJogo.setTrocaOpcao(Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()]);
			menuVelInicial.setTrocaOpcao(Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()]);
		}

		Jogo.liberaTeclas();

	}

	@Override
	public void desenhar(Graphics2D g) {
		menuJogo.desenha(g);
		menuVelInicial.desenha(g);
		int difAltura = 30;
		Util.centraliza(texto, largura, altura);
		for (int i = 0; i < Jogo.ranking.size(); i++) {
			texto.desenha(g, String.valueOf(Jogo.ranking.get(i).pontos) + " " + Jogo.ranking.get(i).nome, menuVelInicial.getPx(), menuVelInicial.getAltura()+menuVelInicial.getPy()+difAltura);
			difAltura+=30;
		}
	}
}
