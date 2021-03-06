package br.com.mvbos.lgj;

import java.awt.*;
import java.util.HashMap;

public class Nivel {
	//18 por 18

	public static HashMap<Integer, Color> coresNiveis;
	static {
		coresNiveis = new HashMap();
		coresNiveis.put(0, Color.BLACK);
		coresNiveis.put(1, Color.blue);
		coresNiveis.put(2, Color.DARK_GRAY);
		coresNiveis.put(3, Color.PINK);
	}
	public static HashMap<Integer, Color> coresCobrinha;
	static {
		coresCobrinha = new HashMap();
		coresCobrinha.put(0, Color.DARK_GRAY);
		coresCobrinha.put(1, Color.pink);
		coresCobrinha.put(2, Color.ORANGE);
		coresCobrinha.put(3, Color.BLUE);
	}
	public static HashMap<Integer, int[]> posCobrinha;
	static {
		int[] arr1 = new int[]{850, 700};
		int[] arr2 = new int[]{450, 600};
		int[] arr3 = new int[]{200, 300};
		int[] arr4 = new int[]{850, 200};
		posCobrinha = new HashMap();
		posCobrinha.put(0, arr1);
		posCobrinha.put(1, arr2);
		posCobrinha.put(2, arr3);
		posCobrinha.put(3, arr4);
	}


	public static char[][][] niveis = {
			{ 		{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' } },
			{ 		{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }},
			{		{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }} ,
			{		{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', '0', '0', '0', '0', '0', '0', '0', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', ' ', ' ', ' ', ' ', ' ', '0', '0', '0', '0', '0', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', '0', '0', '0', '0', '0', '0', '0', '0', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }}
	};
}
