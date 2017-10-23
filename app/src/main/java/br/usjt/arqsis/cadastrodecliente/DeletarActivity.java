package br.usjt.arqsis.cadastrodecliente;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeletarActivity extends AppCompatActivity
{
	private EditText etId;
	private EditText etNome;
	private EditText etIdade;
	private EditText etCpf;
	private EditText etTelefone;
	private Button btConsultar;
	private Button btDeletar;
	private Button btCancelar;

	private Cliente cliente;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deletar);

		etId = (EditText) findViewById(R.id.etId);
		etNome = (EditText) findViewById(R.id.etNome);
		etIdade = (EditText) findViewById(R.id.etIdade);
		etCpf = (EditText) findViewById(R.id.etCpf);
		etTelefone = (EditText) findViewById(R.id.etTelefone);
		btConsultar = (Button) findViewById(R.id.btConsultar);
		btDeletar = (Button) findViewById(R.id.btDeletar);
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

		etNome.setText(cliente.getNome());
		etIdade.setText(String.valueOf(cliente.getIdade()));
		etCpf.setText(cliente.getCpf());
		etTelefone.setText(cliente.getTelefone());

		etId.setEnabled(false);
		btConsultar.setEnabled(false);
		btDeletar.setEnabled(true);
		btCancelar.setEnabled(true);
	}

	public void deletarCliente(View view)
	{
		String id = String.valueOf(cliente.getId());
		cliente.delete();
		Toast.makeText(this, "Cliente " + id + " deletado com sucesso!", Toast.LENGTH_LONG).show();
		cancelarExclusao(getCurrentFocus());
	}

	public void cancelarExclusao(View view)
	{
		etId.setEnabled(true);
		btConsultar.setEnabled(true);
		btDeletar.setEnabled(false);
		btCancelar.setEnabled(false);

		etId.setText("");
		etNome.setText("");
		etIdade.setText("");
		etCpf.setText("");
		etTelefone.setText("");

		cliente = null;
	}

}
