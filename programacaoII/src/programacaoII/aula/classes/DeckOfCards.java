package programacaoII.aula.classes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//classe para representar um card de baralho
class Card{
	public static enum Face {Ace, Deuce, Three, Four, Five, Six,
		Seven, Eight, Nine, Ten, Jack, Queen, King};
	public static enum Suit {Clubs, Diamonds, Hearts, Spades};
	
	private final Face face;
	private final Suit suit;
	
	//construtor
	public Card(Face face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}
	
	//retorna a face da carta
	public Face getFace() {
		return face;
	}
	
	//retorna o naipe de card
	public Suit getSuit() {
		return suit;
	}
	//retorna a representação String de Card
	public String toString() {
		return String.format("%s of %s", face, suit);
	}
	
}//Fim da classe Card

//Declaração da Classe DeckOfCards
public class DeckOfCards {
	
	private List<Card> list;  //Declara List que armazenará Card's
	
	//Configura baralho de Card's e embaralha
	public DeckOfCards() {
		Card[] deck = new Card[52];
		int count = 0;	//Número de cartas
		
		//Preenche o baralho com os objetos Card's
		//A variável de tipo enum Suit suit vai iterar sobre o array contendo os valores da enum Suit, o mesmo para face
		for(Card.Suit suit : Card.Suit.values()) {
			for(Card.Face face : Card.Face.values()) {
				deck[count] = new Card(face, suit);
				count++;
			}
		}
		
		list = Arrays.asList(deck);	//Obtem list
		Collections.shuffle(list);	//Embaralha as cartas
		}	//Fim do construtor DeckOfCards
	
	//Gera saída de baralho
	public void printCards() {
		//Exibe 52 cartas em duas colunas
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("%-19s%s", list.get(i),
					((i + 1) % 4 == 0) ? "%n" : "");
		}
	}
	public static void main(String[] args) {
		
		DeckOfCards cards = new DeckOfCards();
		cards.printCards();
	}
}  //Fim da classe DeckOfCards

