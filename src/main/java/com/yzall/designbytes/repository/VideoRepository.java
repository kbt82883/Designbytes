package com.yzall.designbytes.repository;

import com.yzall.designbytes.repository.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    Video findByVideoNo(Integer videoNo);

    List<Video> findByVideoTitleLike(String videoTitle);

    @Modifying
    @Query(nativeQuery = true,
            value = "INSERT INTO video (video_title, video_url, video_running_time, video_maker_id, video_maker_name, video_file_size, video_paid_yn, video_price, video_thumbnail_id)" +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)")
    Integer insertVideo(String videoTitle, String videoUrl, Integer videoRunningTime, String videoMakerId, String videoMakerName, Integer videoFileSize, char videoPaidYn, Integer videoPrice, Integer videoThumbnailId);

}
