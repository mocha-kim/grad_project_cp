package com.grad_proj.assembletickets.front.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grad_proj.assembletickets.front.R;
import com.grad_proj.assembletickets.front.ShowAdapter;

public class TicketPlayFragment extends Fragment {

    public View view;
    private ShowAdapter playShowAdapter;
    RecyclerView playTicketList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ticket_play,container, false);

        playTicketList = (RecyclerView)view.findViewById(R.id.playTicketList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        playTicketList.setLayoutManager(linearLayoutManager);

        playShowAdapter = new ShowAdapter();
        playTicketList.setAdapter(playShowAdapter);

        return view;
    }
}