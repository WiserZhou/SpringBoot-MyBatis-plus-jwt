package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "work_song")
public class Song {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "songName")
  private String name;

  @Column(name = "singer")
  private String singer;

  @Column(name = "platform")
  private String platform;

  @Column(name = "memo")
  private String memo;

  @Column(name = "selectNumber")
  private Integer selectNumber;

  @Column(name = "isAccept")
  private Integer isAccept;
}
