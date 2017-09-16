package com.example.android_user01.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Context context;
    public final static String LOG = "CursoAndroid";

    public final static String USUARIO_VALIDO = "root";
    public final static String PASSWORD_VALIDO = "123456";


    private LinearLayout lyPadre;
    private TextView lblUsuario;
    private EditText txtUsuario;
    private TextView lblPassword;
    private EditText txtPassword;

    private LinearLayout lyBotones;
    private Button btnEnviar;
    private Button btnLimpiar;

    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        lyPadre = new LinearLayout(context);
        lyPadre.setOrientation(LinearLayout.VERTICAL);
        lyPadre.setPadding(dpToPx(24),dpToPx(24),dpToPx(24),dpToPx(24));

        lblUsuario = new TextView(context);
        lblUsuario.setText(getString(R.string.usuario));
        lyPadre.addView(lblUsuario);

        txtUsuario = new EditText(context);
        lyPadre.addView(txtUsuario);

        lblPassword = new TextView(context);
        lblPassword.setText(getString(R.string.password));

        LinearLayout.LayoutParams lyParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lyParams.setMargins(0,dpToPx(20),0,0);
        lblPassword.setLayoutParams(lyParams);
        lyPadre.addView(lblPassword);

        txtPassword = new EditText(context);
        txtPassword.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);
        lyPadre.addView(txtPassword);

        lyBotones = new LinearLayout(context);
        lyBotones.setOrientation(LinearLayout.HORIZONTAL);

        btnEnviar = new Button(context);
        btnEnviar.setText(getString(R.string.enviar));
        lyBotones.addView(btnEnviar);

        btnLimpiar = new Button(context);
        btnLimpiar.setText(getString(R.string.limpiar));
        btnLimpiar.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        lyBotones.addView(btnLimpiar);

        //Ojo agregar los hijos antes
        lyPadre.addView(lyBotones);

        lblResultado = new TextView(context);
        lblResultado.setText(getString(R.string.resultado));
        lyPadre.addView(lblResultado);

        setContentView(lyPadre);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtUsuario.setText("");
                txtPassword.setText("");
                txtUsuario.requestFocus();
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = txtUsuario.getText().toString();
                String password = txtPassword.getText().toString();

                if(usuario.equals(USUARIO_VALIDO) &&password.equals(PASSWORD_VALIDO)){
                    lblResultado.setText(getString(R.string.login_ok,usuario));
                } else {
                    lblResultado.setText(getString(R.string.login_error));
                }
            }
        });
    }

    public static int dpToPx(int dp)
    {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
