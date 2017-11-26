package comaaronwalker96budgettracker.httpsgithub.budgettracker;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddExpense extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
    }

    public void submitExpenses(View view) {
        //Screen Elements
        EditText rentEdit = (EditText)findViewById(R.id.txtRent);
        EditText utilitiesEdit = (EditText)findViewById(R.id.txtUtilities);
        EditText foodEdit = (EditText)findViewById(R.id.txtFood);
        EditText leisureEdit = (EditText)findViewById(R.id.txtLeisure);

        //Get text from text boxes
        String rentExpenseIn = isEntered(rentEdit.getText().toString());
        String utilitiesExpenseIn = isEntered(utilitiesEdit.getText().toString());
        String foodExpenseIn = isEntered(foodEdit.getText().toString());
        String leisureExpenseIn = isEntered(leisureEdit.getText().toString());

        //Send variables
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Rent_Expense", rentExpenseIn);
        intent.putExtra("Utilities_Expense", utilitiesExpenseIn);
        intent.putExtra("Food_Expense", foodExpenseIn);
        intent.putExtra("Leisure_Expense", leisureExpenseIn);
        startActivity(intent);
    }

    //This method will replace any null values entered with "0", this is needed for calculations used further in the process
    public String isEntered(String expense) {
        if (expense.matches("")) {
            expense = "0";
        }
        return expense;
    }

}
