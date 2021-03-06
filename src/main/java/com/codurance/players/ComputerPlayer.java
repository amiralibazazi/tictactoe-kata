package com.codurance.players;

import com.codurance.gameEngine.strategy.ComputerStrategies;
import com.codurance.io.Console;
import com.codurance.gameEngine.*;
import com.codurance.gameEngine.markers.Cross;
import com.codurance.gameEngine.markers.Marker;
import com.codurance.gameEngine.markers.Naught;

public class ComputerPlayer implements Player {
	private final Marker O = new Naught();
	private final Marker X = new Cross();
	private Marker marker;
	private Marker opposingMarker;
	private Console console;

	public ComputerPlayer(Console console) {
		this.console = console;
	}

	@Override
	public void play(Board board) {
		getMarkersFrom(board);

		Position position = new ComputerStrategies(board, marker,  opposingMarker).execute();
		board.play(position);
	}

	private void getMarkersFrom(Board board) {
		marker = (board.remainingSpaces().size()%2==0) ? O : X;
		opposingMarker = (marker.equals(X)) ? O : X;
	}
}
