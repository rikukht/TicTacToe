package com.riku.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	Button boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8,
			boton9;
	TextView text;
	int jugador = 1;

	public static final int JUGADOR1 = 1;
	public static final int JUGADOR2 = 2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		boton1 = (Button) findViewById(R.id.button1);
		boton2 = (Button) findViewById(R.id.button2);
		boton3 = (Button) findViewById(R.id.button3);
		boton4 = (Button) findViewById(R.id.button4);
		boton5 = (Button) findViewById(R.id.button5);
		boton6 = (Button) findViewById(R.id.button6);
		boton7 = (Button) findViewById(R.id.button7);
		boton8 = (Button) findViewById(R.id.button8);
		boton9 = (Button) findViewById(R.id.button9);
		text = (TextView) findViewById(R.id.textView1);
		boton1.setOnClickListener(this);
		boton2.setOnClickListener(this);
		boton3.setOnClickListener(this);
		boton4.setOnClickListener(this);
		boton5.setOnClickListener(this);
		boton6.setOnClickListener(this);
		boton7.setOnClickListener(this);
		boton8.setOnClickListener(this);
		boton9.setOnClickListener(this);

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.button1:
			marcarCasilla(boton1);
			CambiarTurno();
			boton1.setEnabled(false);
			break;
		case R.id.button2:
			marcarCasilla(boton2);
			CambiarTurno();
			boton2.setEnabled(false);
			break;
		case R.id.button3:
			marcarCasilla(boton3);
			CambiarTurno();
			boton3.setEnabled(false);
			break;
		case R.id.button4:
			marcarCasilla(boton4);
			CambiarTurno();
			boton4.setEnabled(false);
			break;
		case R.id.button5:
			marcarCasilla(boton5);
			CambiarTurno();
			boton5.setEnabled(false);
			break;
		case R.id.button6:
			marcarCasilla(boton6);
			CambiarTurno();
			boton6.setEnabled(false);
			break;
		case R.id.button7:
			marcarCasilla(boton7);
			CambiarTurno();
			boton7.setEnabled(false);
			break;
		case R.id.button8:
			marcarCasilla(boton8);
			CambiarTurno();
			boton8.setEnabled(false);
			break;
		case R.id.button9:
			marcarCasilla(boton9);
			CambiarTurno();
			boton9.setEnabled(false);
			break;

		}

	}

	// MARCA LA CASILLA CON LA IMAGEN DEL JUGADOR
	public void marcarCasilla(Button b) {
		if (jugador == JUGADOR1) {
			b.setBackgroundResource(R.drawable.xiconb);
			b.setTag("1");

		} else {
			b.setBackgroundResource(R.drawable.oiconb);
			b.setTag("0");
		}

	}

	public Boolean ComprobarTablero() {
		//if (boton1)
		return true;

	}

	// CAMBIA EL TURNO DE LOS JUGADORES Y EL TEXTO DEL TEXTVIEW
	public void CambiarTurno() {
		if (jugador == JUGADOR1) {
			jugador = JUGADOR2;
			text.setText(R.string.turno2);
		} else {
			jugador = JUGADOR1;
			text.setText(R.string.turno1);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stu
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_layout, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.new_game:
			newGame();
			return true;
		case R.id.exit:
			System.exit(0);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
	
	//Accion del juego nuevo
	//limpia todo el tablero.
	public void newGame() {
		vaciarCasilla(boton1);
		vaciarCasilla(boton2);
		vaciarCasilla(boton3);
		vaciarCasilla(boton4);
		vaciarCasilla(boton5);
		vaciarCasilla(boton6);
		vaciarCasilla(boton7);
		vaciarCasilla(boton8);
		vaciarCasilla(boton9);
	}

	//Resetea la casilla.
	public void vaciarCasilla(Button b) {
		b.setBackgroundResource(R.drawable.backgroud);
		b.setEnabled(true);
	}

}