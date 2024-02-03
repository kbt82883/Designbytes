package com.yzall.designbytes.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ai_response")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AiResponse {

    @Id
    @Column(name = "ai_id")
    private String aiId;

    @Column(name = "user_no")
    private Integer userNo;

    @Column(name = "ai_message")
    private String aiMessage;

    @Column(name = "ai_prompt")
    private String aiPrompt;

    @Column(name = "ai_model")
    private String aiModel;

    @Column(name = "prompt_tokens")
    private Integer promptTokens;

    @Column(name = "completion_tokens")
    private Integer completionTokens;

    @Column(name = "total_tokens")
    private Integer totalTokens;

    @Column(name = "insert_dt")
    private LocalDateTime insertDt;

    @Column(name = "insert_id")
    private String insertId;
}
