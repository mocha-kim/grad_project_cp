package com.grad_proj.assembletickets.front.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.grad_proj.assembletickets.front.Activity.HomeActivity;
import com.grad_proj.assembletickets.front.R;

public class AddEventFragment extends Fragment {

    public View view;

    private static final String DATE="";
    private String date;

    Button submitBtn;
    TimePicker eventTimePicker;
    EditText eventTitleEditText, eventContentEditText;

    private String eventTitle="";

    public static AddEventFragment newInstance(String date) {
        //이전 fragment로부터 데이터 넘겨받기
        AddEventFragment addEventFragment = new AddEventFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DATE, date);
        addEventFragment.setArguments(bundle);

        return addEventFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_addevent,container, false);

        if(getArguments() != null){
            date = getArguments().getString(DATE);
        }

        submitBtn = (Button)view.findViewById(R.id.submitBtn);
        eventTimePicker = (TimePicker)view.findViewById(R.id.eventTimePicker);
        eventTimePicker.setIs24HourView(true);
        eventTitleEditText = (EditText)view.findViewById(R.id.eventTitleEditText);
        eventContentEditText = (EditText)view.findViewById(R.id.eventContentEditText);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if("".equals(eventTitle)){
                    Toast toast=Toast.makeText(view.getContext(),"이벤트 제목을 입력해주세요",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
                else{
                    int eventHour =  eventTimePicker.getHour();
                    int eventMin = eventTimePicker.getMinute();
                    String eventContent = eventContentEditText.getText().toString();

                    //db에 새로 추가된 정보 넣기
                    if(eventContent.isEmpty()){
                        ((HomeActivity)getActivity()).insertEvent(date,eventTitle,eventHour,eventMin);
                    }
                    else{
                        ((HomeActivity)getActivity()).insertEvent(date,eventContent,eventHour,eventMin);
                    }
                    ((HomeActivity)getActivity()).submitBtnAction();
                }
            }
        });

        eventTitleEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence!=null){
                    eventTitle=charSequence.toString();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }
}
