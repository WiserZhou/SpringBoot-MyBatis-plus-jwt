package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("work_song")
public class Song {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @TableField(
      value = "song_name",
      insertStrategy = FieldStrategy.NOT_NULL,
      updateStrategy = FieldStrategy.NOT_EMPTY)
  private String songName;

  @TableField(
      value = "singer",
      insertStrategy = FieldStrategy.NOT_NULL,
      updateStrategy = FieldStrategy.NOT_EMPTY)
  private String singer;

  @TableField(value = "platform")
  private String platform;

  @TableField(value = "memo")
  private String memo;

  @TableField(value = "select_number")
  private Integer selectNumber;

  @TableField(value = "is_accept")
  private Integer isAccept;
}
