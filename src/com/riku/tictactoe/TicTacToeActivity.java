package com.riku.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
	AlertDialog.Builder builder;
	AlertDialog alert;
	private int jugador = 1;

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
			boton1.setEnabled(false);
			break;
		case R.id.button2:
			marcarCasilla(boton2);
			boton2.setEnabled(false);
			break;
		case R.id.button3:
			marcarCasilla(boton3);
			boton3.setEnabled(false);

			break;
		case R.id.button4:
			marcarCasilla(boton4);
			boton4.setEnabled(false);
			break;
		case R.id.button5:
			marcarCasilla(boton5);
			boton5.setEnabled(false);
			break;
		case R.id.button6:
			marcarCasilla(boton6);
			boton6.setEnabled(false);
			break;
		case R.id.button7:
			marcarCasilla(boton7);
			boton7.setEnabled(false);
			break;
		case R.id.button8:
			marcarCasilla(boton8);
			boton8.setEnabled(false);
			break;
		case R.id.button9:
			marcarCasilla(boton9);
			boton9.setEnabled(false);
			break;

		}
		if (comprobarTablero()) {
			partidaGanada();
		} else {
			cambiarTurno();

		}

	}

	// MARCA LA CASILLA CON LA IMAGEN DEL JUGADOR
	public void marcarCasilla(Button b) {
		if (jugador == JUGADOR1) {
			b.setBackgroundResource(R.drawable.xiconb);
			b.setTag("1");

		} else {
			b.setBackgroundResource(R.drawable.oiconb);
			b.setTag("2");
		}

	}

	public Boolean comprobarTablero() {
		boolean result = false;
		// Boton1
		if (boton1.getTag().toString().equals(boton2.getTag().toString())
				&& boton1.getTag().toString()
						.equals(boton3.getTag().toString())
				&& !boton1.getTag().toString().equals("0"))
			result = true;
		else if (boton1.getTag().toString().equals(boton5.getTag().toString())
				&& boton1.getTag().toString()
						.equals(boton9.getTag().toString())
				&& !boton1.getTag().toString().equals("0"))
			result = true;
		else if (boton1.getTag().toString().equals(boton4.getTag().toString())
				&& boton1.getTag().toString()
						.equals(boton7.getTag().toString())
				&& !boton1.getTag().toString().equals("0"))
			result = true;
		// Boton2
		else if (boton2.getTag().toString().equals(boton5.getTag().toString())
				&& boton2.getTag().toString()
						.equals(boton9.getTag().toString())
				&& !boton2.getTag().toString().equals("0"))
			result = true;
		// Boton3
		else if (boton3.getTag().toString().equals(boton6.getTag().toString())
				&& boton3.getTag().toString()
						.equals(boton9.getTag().toString())
				&& !boton3.getTag().toString().equals("0"))
			result = true;
		// Boton4
		else if (boton4.getTag().toString().equals(boton5.getTag().toString())
				&& boton4.getTag().toString()
						.equals(boton6.getTag().toString())
				&& !boton4.getTag().toString().equals("0"))
			result = true;
		// boton5-- Diagonal 7,5,3
		else if (boton5.getTag().toString().equals(boton7.getTag().toString())
				&& boton5.getTag().toString()
						.equals(boton3.getTag().toString())
				&& !boton5.getTag().toString().equals("0"))
			result = true;
		// boton7
		else if (boton7.getTag().toString().equals(boton8.getTag().toString())
				&& boton7.getTag().toString()
						.equals(boton9.getTag().toString())
				&& !boton7.getTag().toString().equals("0"))
			result = true;
		// si ninguno se cumple retorna False
		return result;

	}

	public void partidaGanada() {
		boton1.setEnabled(false);
		boton2.setEnabled(false);
		boton3.setEnabled(false);
		boton4.setEnabled(false);
		boton5.setEnabled(false);
		boton6.setEnabled(false);
		boton7.setEnabled(false);
		boton8.setEnabled(false);
		boton9.setEnabled(false);

		builder = new AlertDialog.Builder(this);
		builder.setMessage(text.getText().toString() + " ha ganado")
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		alert = builder.create();
		alert.show();
	}

	// CAMBIA EL TURNO DE LOS JUGADORES Y EL TEXTO DEL TEXTVIEW
	public void cambiarTurno() {
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
			builder = new AlertDialog.Builder(this);
			builder.setMessage("¿Quieres salir del juego?")
					.setPositiveButton("Si",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									System.exit(0);
								}
							})
					.setNegativeButton("No",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});

			alert = builder.create();
			alert.show();
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	// Accion del juego nuevo
	// limpia todo el tablero.
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

	// Resetea la casilla.
	public void vaciarCasilla(Button b) {
		b.setBackgroundResource(R.drawable.backgroud);
		b.setEnabled(true);
		b.setTag("0");
	}

}