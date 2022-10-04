/*
package SmarterBot;


import SimpleBot.SimpleBotPlayer;
import model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import static com.badlogic.gdx.math.MathUtils.random;

public class SmarterBotPlayer extends SimpleBotPlayer {
    public SmarterBotPlayer(int playerNo) {
        super(playerNo);
    }

    // gets the highest scoring peice and places the point on board
    @Override
    public Move makeMove(Board board) {
        String [] Firstmove = {"P","W","U","F"};
        Random random = new Random();
        int i = random(0,3);
        if (super.isFirstMove) {
            super.isFirstMove = false;
            // Play gamepiece "F" at the starting location in default orientation
            return new Move(
                    this,
                    new Gamepiece(getGamepieceSet().get(Firstmove[i])),
                    Firstmove[i],
                    new Location(board.startLocations[getPlayerNo()]));
        }
        else {
            //Generating positions by applying moves
            //  to a copy of the current board:
            //Board possibleBoard = new Board(board);
            //possibleBoard.m
            // akeMove(move);
            return getPlayerMoves(this, board).get(0);
        }
    }
    @Override
    public ArrayList<Move> getPlayerMoves(Player player, Board board) {
        ArrayList<Move> moves = new ArrayList<Move>();
        Collection<String> gamepieceNames = player.getGamepieceSet().getPieces().keySet();

        for (String gamepieceName : gamepieceNames) {
            moves.addAll(
                    getMovesWithGivenGamepiece(
                            player.getGamepieceSet().getPieces().get(gamepieceName),
                            gamepieceName,
                            player,
                            board)
            );
        }
        int highscore=0;
        Move bestMove= null;
        for(Move move :moves){
            int score=0;
            Gamepiece clonedPiece=move.getGamepiece();
            score += clonedPiece.getLocations().length;
            if(score>highscore) {
                highscore = score;
                bestMove = move;
            }
        }
        moves.add(0,bestMove);
        return moves;
    }
    @Override
    public ArrayList<Move> getMovesWithGivenGamepiece(Gamepiece gamepiece, String gamepieceName, Player player, Board board){
        ArrayList<Move> moves = new ArrayList<Move>();
        Gamepiece clonedPiece = new Gamepiece(gamepiece);
        for (int i = 0; i < 4 ; i++) {
            moves.addAll(getMovesWithGivenOrientation(clonedPiece,gamepieceName,player,board));
            clonedPiece.rotateRight();
        }
        clonedPiece.flipAlongY();
        for (int i = 0; i < 4 ; i++) {
            moves.addAll(getMovesWithGivenOrientation(clonedPiece,gamepieceName,player,board));
            clonedPiece.rotateRight();
        }
        return moves;
    }
    @Override
    public ArrayList<Move> getMovesWithGivenOrientation(Gamepiece piece, String gamepieceName, Player player, Board board) {
        ArrayList<Move> moves = new ArrayList<Move>();
        Move move = new Move(player,piece, gamepieceName,new Location(0,0));
        for (int x = 0; x < board.WIDTH; x++) {
            for (int y = 0; y < board.HEIGHT; y++) {
                move.getLocation().setX(x);
                move.getLocation().setY(y);
                if (board.isValidSubsequentMove(move)) {
                    moves.add(new Move(move));
                }
            }
        }
        return moves;
    }
}
 */