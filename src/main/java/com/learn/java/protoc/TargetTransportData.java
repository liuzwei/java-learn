// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: targetdata.proto

package com.learn.java.protoc;

public final class TargetTransportData {
  private TargetTransportData() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TargetAlarmData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TargetAlarmData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TargetData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TargetData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TargetWrapperData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TargetWrapperData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020targetdata.proto\"P\n\017TargetAlarmData\022\024\n" +
      "\014alarm_status\030\001 \001(\010\022\022\n\nalarm_type\030\002 \001(\t\022" +
      "\023\n\013alarm_value\030\003 \001(\t\"r\n\nTargetData\022\023\n\013ta" +
      "rget_code\030\001 \001(\t\022\023\n\013target_type\030\002 \001(\t\022\024\n\014" +
      "target_value\030\003 \001(\t\022$\n\nalarm_data\030\004 \001(\0132\020" +
      ".TargetAlarmData\"5\n\021TargetWrapperData\022 \n" +
      "\013targetDatas\030\001 \003(\0132\013.TargetDataB.\n\025com.l" +
      "earn.java.protocB\023TargetTransportDataP\001b" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_TargetAlarmData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_TargetAlarmData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TargetAlarmData_descriptor,
        new java.lang.String[] { "AlarmStatus", "AlarmType", "AlarmValue", });
    internal_static_TargetData_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_TargetData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TargetData_descriptor,
        new java.lang.String[] { "TargetCode", "TargetType", "TargetValue", "AlarmData", });
    internal_static_TargetWrapperData_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_TargetWrapperData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TargetWrapperData_descriptor,
        new java.lang.String[] { "TargetDatas", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
