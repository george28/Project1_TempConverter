package hargis.project1_tempconverter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


public class TempConverterActivity extends ActionBarActivity implements TextView.OnEditorActionListener {

    private EditText editText;

    private TextView output_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_converter);

        editText = (EditText) findViewById(R.id.editText);
        output_ID = (TextView) findViewById(R.id.output_ID);

        editText.setOnEditorActionListener(this);
        output_ID.setOnEditorActionListener(this);

    }


    public void calculateAndDisplay() {
        String editTextString = editText.getText().toString();
        float userEnter;
        if (editTextString.equals("")) {
            userEnter = 0;
        } else {
            userEnter = Float.parseFloat(editTextString);
        }

        float total = (userEnter - 32) * 5 / 9;

        NumberFormat temp = NumberFormat.getNumberInstance();
        output_ID.setText(temp.format(total));
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
           calculateAndDisplay();
        }

            return false;

    }
}