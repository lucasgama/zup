package robo_marte;

public class robo {
	
	//variaves
	public static final Integer N = 1;
	public static final Integer E = 2;
	public static final Integer S = 3;
	public static final Integer W = 4;
	Integer x = 0;
	Integer y = 0;
	Integer xMax = 0;
	Integer yMax = 0;
	Integer posicao = N;
	//definindo limites das coordenadas
	public void setMax(Integer xMax, Integer yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
	}
	//definindo inicio das coordenadas
	public void setPosicao(Integer x, Integer y, Integer posicao) {
		this.x = x;
		this.y = y;
		this.posicao = posicao;
	}
	//definindo direções para o output
	public void printPosicao() {
		char dir = 'N';
		if (posicao == 1) {
			dir = 'N';
		} else if (posicao == 2) {
			dir = 'E';
		} else if (posicao == 3) {
			dir = 'S';
		} else if (posicao == 4) {
			dir = 'W';
		}
		System.out.println(x+ " " +y+ " " +dir);
	}
	//leitura das strings de comandos
	public void process(String commands) {
		for (int id = 0; id < commands.length(); id++) {
			process(commands.charAt(id));
		}
	}
	//definindo os parametros de entrada
	private void process(Character command) {
		if (command.equals('L')) {
			turnLeft();
		} else if (command.equals('R')) {
			turnRight();
		} else if (command.equals('M')) {
			andar();
		} else {
			throw new IllegalArgumentException("Use apenas as letras 'L' para indicar esquerda, 'R' para indicar a direita e 'M' para se mover para frente");
		}
	}
	//movimentação 90 graus à esquerda
	private void turnLeft() {
		posicao = (posicao - 1) < N ? W : posicao - 1;
	}
	//movimentação 90 graus à direita
	private void turnRight() {
		posicao = (posicao + 1) > W ? N : posicao + 1;
	}
	// incrementes e decrementes para mover o robo nas 4 direções
	private void andar() {
		if (posicao == N) {
			if (y < yMax){
				this.y++;
			} else {
				throw new IllegalArgumentException("O robo esta no limite norte do plato");
			}			
		} else if (posicao == E) {
			if (x < xMax){
				this.x++;
			} else {
				throw new IllegalArgumentException("O robo esta no limite leste do plato");
			}
		} else if (posicao == S) {
			if (y > 0){
				this.y--;
			} else {
				throw new IllegalArgumentException("O robo esta no limite sul do plato");
			}
		} else if (posicao == W) {
			if (x > 0){
				this.x--;
			} else {
				throw new IllegalArgumentException("O robo esta no limite oeste do plato");
			}
		}
	}
	// entrada de dados para os testes
	public static void main(String args[]) {
		robo robo = new robo();
		robo.setMax(5, 5); // Limite do plato superior-direito (inferior-esquerdo sendo 0,0)
		robo.setPosicao(1, 2, N); // Posição inicial do primeiro robo
		robo.process("LMLMLMLMM"); // movimentação do robo
		robo.printPosicao(); // prints 1 3 N
		robo.setPosicao(3, 3, E); // Posição inicial do segundo robo
		robo.process("MMRMMRMRRM"); // movimentação do robo
		robo.printPosicao(); // prints 5 1 E
	}
}
