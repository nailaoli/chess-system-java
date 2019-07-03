package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public final class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	// Cria matriz booleana com valor "true" nas posi��es em que � poss�vel o movimento da pe�a
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		// Verificar acima
		p.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
			mat[p.getRow()][p.getColumn()] = true;
			if (isThereOpponentPiece(p) == true) {
				break;
			}
			p.setRow(p.getRow() - 1);
		}
		// Verificar esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
			mat[p.getRow()][p.getColumn()] = true;
			if (isThereOpponentPiece(p) == true) {
				break;
			}
			p.setColumn(p.getColumn() - 1);
		}
		// Verificar direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
			mat[p.getRow()][p.getColumn()] = true;
			if (isThereOpponentPiece(p) == true) {
				break;
			}
			p.setColumn(p.getColumn() + 1);
		}
		// Verificar abaixo
		p.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
			mat[p.getRow()][p.getColumn()] = true;
			if (isThereOpponentPiece(p) == true) {
				break;
			}
			p.setRow(p.getRow() + 1);
		}
		return mat;

	}
}
