package br.usjt.arqsis.cadastrodecliente;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InserirActivity extends AppCompatActivity
{
	private EditText etNome;
	private EditText etIdade;
	private EditText etCpf;
	private EditText etTelefone;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inserir);

		etNome = (EditText) findViewById(R.id.etNome);
		etIdade = (EditText) findViewById(R.id.etIdade);
		etCpf = (EditText) findViewById(R.id.etCpf);
		etTelefone = (EditText) findViewById(R.id.etTelefone);
	}

	public void inserirCliente(View view)
	{
		String nome = etNome.getText().toString();
		int idade = Integer.valueOf(etIdade.getText().toString());
		String cpf = etCpf.getText().toString();
		String telefone = etTelefone.getText().toString();

		Cliente cliente = new Cliente(nome, idade, cpf, telefone);

		cliente.save();

		Toast.makeText(this, "Cliente " + cliente.getId() + " inserido.", Toast.LENGTH_LONG).show();

		finish();
	}
}
