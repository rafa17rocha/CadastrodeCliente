package br.usjt.arqsis.cadastrodecliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void inserir(View view)
	{
		Intent intent = new Intent(this, InserirActivity.class);
		startActivity(intent);
	}

	public void consultar(View view)
	{
		Intent intent = new Intent(this, ConsultarActivity.class);
		startActivity(intent);
	}

	public void alterar(View view)
	{
		Intent intent = new Intent(this, AlterarActivity.class);
		startActivity(intent);
	}

	public void deletar(View view)
	{
		Intent intent = new Intent(this, DeletarActivity.class);
		startActivity(intent);
	}

}
