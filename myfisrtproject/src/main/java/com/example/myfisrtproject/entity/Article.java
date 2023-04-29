package com.example.myfisrtproject.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@ToString
@Entity // DB가 해당 객체를 인식 가능
public class Article {

    @Id // 대표값을 지정 ! 주민등록번호처럼
    @GeneratedValue // 해당 주민등록 먼호를 자동생성
    private Long id;

    @Column
    private String title;

    @Column
    private String content;
}
