package com.project.grad.assembleticket.service;

import com.project.grad.assembleticket.domain.entity.ShowPerformer;
import com.project.grad.assembleticket.domain.entity.Shows;
import com.project.grad.assembleticket.domain.repository.ShowPerformerRepository;
import com.project.grad.assembleticket.domain.repository.ShowRepository;
import com.project.grad.assembleticket.dto.ShowDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ShowService {

    private final ShowRepository showRepository;
    private final ShowPerformerRepository showPerformerRepository;

    @Transactional
    public ShowDetailResponseDto getShowDetail(Long id){
        Shows show = showRepository.findById(id).orElse(null);
        List<ShowPerformer> showPerformer = showPerformerRepository.findAllByShowsId(id);
        List<String> performers = new ArrayList<>();
        for (ShowPerformer performer : showPerformer) {
            performers.add(performer.getPerformer().getName());
        }
        return new ShowDetailResponseDto(show, performers);
    }

    // 공연 목록 페이지 - 전체
    public List<Shows> getAllShows(int page) {
        PageRequest pageRequest = PageRequest.of(page, 20, Sort.by("title"));
        return showRepository.findAll(pageRequest).getContent();
    }

    // 공연 목록 페이지 - 타입별
    public List<Shows> getTypeShows(int page, int type) {
        PageRequest pageRequest = PageRequest.of(page, 20, Sort.by("title"));
        return showRepository.findAllByType(pageRequest, type);
    }

}
