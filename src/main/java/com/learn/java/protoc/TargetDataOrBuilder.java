// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: targetdata.proto

package com.learn.java.protoc;

public interface TargetDataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:TargetData)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string target_code = 1;</code>
   * @return The targetCode.
   */
  java.lang.String getTargetCode();
  /**
   * <code>string target_code = 1;</code>
   * @return The bytes for targetCode.
   */
  com.google.protobuf.ByteString
      getTargetCodeBytes();

  /**
   * <code>string target_type = 2;</code>
   * @return The targetType.
   */
  java.lang.String getTargetType();
  /**
   * <code>string target_type = 2;</code>
   * @return The bytes for targetType.
   */
  com.google.protobuf.ByteString
      getTargetTypeBytes();

  /**
   * <code>string target_value = 3;</code>
   * @return The targetValue.
   */
  java.lang.String getTargetValue();
  /**
   * <code>string target_value = 3;</code>
   * @return The bytes for targetValue.
   */
  com.google.protobuf.ByteString
      getTargetValueBytes();

  /**
   * <code>.TargetAlarmData alarm_data = 4;</code>
   * @return Whether the alarmData field is set.
   */
  boolean hasAlarmData();
  /**
   * <code>.TargetAlarmData alarm_data = 4;</code>
   * @return The alarmData.
   */
  com.learn.java.protoc.TargetAlarmData getAlarmData();
  /**
   * <code>.TargetAlarmData alarm_data = 4;</code>
   */
  com.learn.java.protoc.TargetAlarmDataOrBuilder getAlarmDataOrBuilder();
}
