package br.usjt.arqsis.cadastrodecliente;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ConsultarActivity extends AppCompatActivity
{
	private EditText etId;
	private EditText etNome;
	private EditText etIdade;
	private EditText etCpf;
	private EditText etTelefone;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consultar);


		etId = (EditText) findViewById(R.id.etId);
		etNome = (EditText) findViewById(R.id.etNome);
		etIdade = (EditText) findViewById(R.id.etIdade);
		etCpf = (EditText) findViewById(R.id.etCpf);
		etTelefone = (EditText) findViewById(R.id.etTelefone);
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

		Cliente cliente = Cliente.findById(Cliente.class, (long) id);

		if (cliente == null)
		{
			return;
		}

		etNome.setText(cliente.getNome());
		etIdade.setText(String.valueOf(cliente.getIdade()));
		etCpf.setText(cliente.getCpf());
		etTelefone.setText(cliente.getTelefone());
	}
}
