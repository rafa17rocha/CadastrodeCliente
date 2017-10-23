package br.usjt.arqsis.cadastrodecliente;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlterarActivity extends AppCompatActivity
{
	private EditText etId;
	private EditText etNome;
	private EditText etIdade;
	private EditText etCpf;
	private EditText etTelefone;
	private Button btConsultar;
	private Button btAlterar;
	private Button btCancelar;

	private Cliente cliente;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alterar);

		etId = (EditText) findViewById(R.id.etId);
		etNome = (EditText) findViewById(R.id.etNome);
		etIdade = (EditText) findViewById(R.id.etIdade);
		etCpf = (EditText) findViewById(R.id.etCpf);
		etTelefone = (EditText) findViewById(R.id.etTelefone);
		btConsultar = (Button) findViewById(R.id.btConsultar);
		btAlterar = (Button) findViewById(R.id.btAlterar);
		btCancelar = (Button) findViewById(R.id.btCancelar);
	}

	public void consultarCliente(View view)
	{
		int id = 0;

		try
		{
			id = Integer.valueOf(etId.getText().toString());
		}
		catch (Exception e)
		{
			Log.e("Exception:", e.getMessage());
		}

		if (id == 0)
		{
			return;
		}

		cliente = Cliente.findById(Cliente.class, (long) id);

		if (cliente == null)
		{
			return;
		}

		etId.setEnabled(false);
		btConsultar.setEnabled(false);

		etNome.setText(cliente.getNome());
		etIdade.setText(String.valueOf(cliente.getIdade()));
		etCpf.setText(cliente.getCpf());
		etTelefone.setText(cliente.getTelefone());

		etNome.setEnabled(true);
		etIdade.setEnabled(true);
		etCpf.setEnabled(true);
		etTelefone.setEnabled(true);

		btAlterar.setEnabled(true);
		btCancelar.setEnabled(true);
	}

	public void alterarCliente(View view)
	{
		String nome = etNome.getText().toString();
		int idade = cliente.getIdade();

		try
		{
			idade = Integer.valueOf(etIdade.getText().toString());
		}
		catch (Exception e)
		{
			Log.e("Exception:", e.getMessage());
		}

		String cpf = etCpf.getText().toString();
		String telefone = etTelefone.getText().toString();

		cliente.setNome(nome);
		cliente.setIdade(idade);
		cliente.setCpf(cpf);
		cliente.setTelefone(telefone);

		cliente.save();

		Toast.makeText(this, "Cliente " + cliente.getId() + " alterado com sucesso!", Toast.LENGTH_LONG).show();
		cancelarAlteracao(getCurrentFocus());
	}

	public void cancelarAlteracao(View view)
	{
		etId.setEnabled(true);
		btConsultar.setEnabled(true);
		btAlterar.setEnabled(false);
		btCancelar.setEnabled(false);

		etId.setText("");
		etNome.setText("");
		etIdade.setText("");
		etCpf.setText("");
		etTelefone.setText("");

		cliente = null;
	}
}
