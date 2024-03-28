package com.yzall.designbytes.service;

import com.yzall.designbytes.dto.UserDTO;
import com.yzall.designbytes.dto.VideoDTO;
import com.yzall.designbytes.repository.UserRepository;
import com.yzall.designbytes.repository.VideoRepository;
import com.yzall.designbytes.repository.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VideoService {
    VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Transactional
    public VideoDTO insertVideoUrl(VideoDTO videoDTO) throws Exception {
        try {

            // TODO

//            Integer result = videoRepository.insertVideo(videoDTO.getVideoTitle(), videoDTO.getVideoUrl(), videoDTO.getVideoRunningTime(), videoDTO.getVideoMakerId(), videoDTO.getVideoMakerName(), videoDTO.getVideoFileSize(), videoDTO.getVideoPaidYn(), videoDTO.getVideoPrice(), videoDTO.getVideoThumbnailId());
//            if (result != 1) {
//                throw new Exception("사용자 생성에 실패하였습니다.");
//            }
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("해당 ID는 이미 존재합니다.");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return null;
    }

    @Transactional
    public VideoDTO insertVideoFile(VideoDTO videoDTO) throws Exception {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }
}
