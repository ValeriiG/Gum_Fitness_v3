package com.valgar.gum_fitness_v3.ui.profils;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.valgar.gum_fitness_v3.R;
import com.valgar.gum_fitness_v3.databinding.FragmentProfilsBinding;

import java.util.Calendar;
import java.util.TimeZone;

public class Fragment_Profils  extends Fragment {
    EditText editTextField ;

    Button bth_name_profil;      // имя
    Button bth_gender_profil;    // пол
    Button bth_birthday_profil;  // день рождения
    Button bth_city_profil;      // город
    Button save_profil;          // кнопка сохранить
    long date_DR ;
    private Fragment_Profils_ViewModel fragment_Profils_ViewModel;
    private FragmentProfilsBinding binding;

    private DatePickerDialog datePickerDialog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fragment_Profils_ViewModel =
                new ViewModelProvider(this).get(Fragment_Profils_ViewModel.class);

        binding = FragmentProfilsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        editTextField = new EditText(this.getContext());

        bth_name_profil =  root.findViewById(R.id.bth_name_profil);
        bth_name_profil.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                //AlertDialog alert= null;
                AlertDialog.Builder build= new AlertDialog.Builder(getActivity());
                build.setTitle("Введите имя");
                build.setView(editTextField)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String editTextInput = editTextField.getText().toString();
                                Log.d("333","editext value is: "+ editTextInput);
                                bth_name_profil.setText(editTextInput);

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                build.show();
            }
        });


        bth_gender_profil =  root.findViewById(R.id.bth_gender_profil);
        bth_gender_profil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext());
                alertBuilder.setMessage("Выберите пол")
                        .setCancelable(true)
                        .setPositiveButton("Мужчина",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        bth_gender_profil.setText("Мужчина");

                                        dialog.cancel();
                                    }
                                })
                        .setNeutralButton("я что-то среднее...",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        bth_gender_profil.setText("что-то среднее...");
                                        dialog.cancel();
                                    }
                                })
                        .setNegativeButton("Женщина",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        bth_gender_profil.setText("Женщина");
                                        dialog.cancel();
                                    }
                                });

                alertBuilder.show();
            }
        });

        bth_birthday_profil =  root.findViewById(R.id.bth_birthday_profil);
        Calendar cal = Calendar.getInstance(TimeZone.getDefault()); // Get current date
        bth_birthday_profil.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month +1;
                        String date = makeDateString(day, month,  year);
                        bth_birthday_profil.setText(date);
                    }
                };
                Calendar calendar = Calendar.getInstance();
                //int style = AlertDialog.THEME_HOLO_LIGHT;

                int  year = calendar.get(Calendar.YEAR);
                int  month = calendar.get(Calendar.MONTH);
                int  day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(getContext(), dateSetListener, year,month,day);
                datePickerDialog.show();

            }
        });

        return root;
    }

    private String makeDateString(int day, int month, int year) {
        return day+"-" + getMonthFormat(month) + "-" + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "Января";
        if (month == 2)
            return "Февраля";
        if (month == 3)
            return "Марта";
        if (month == 4)
            return "Апреля";
        if (month == 5)
            return "Мая";
        if (month == 6)
            return "Июня";
        if (month == 7)
            return "Июля";
        if (month == 8)
            return "Августа";
        if (month == 9)
            return "Сентября";
        if (month == 10)
            return "Октября";
        if (month == 11)
            return "Ноября";
        if (month == 12)
            return "Декабря";

        return "Январь";
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

