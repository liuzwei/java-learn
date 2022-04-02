package com.learn.java.protoc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liuzhaowei
 * @date 2022/3/22 16:20
 */
public class TargetMain {
    private static String WRITE_FILE_PATH = "C:\\develop\\code\\java-learn\\src\\main\\protoc\\targetdata";
    public static void main(String[] args) {
        // 创建指标数据
        TargetData targetData = TargetData.newBuilder()
                .setTargetCode("320811001GO01WD002")
                .setTargetType("DEVICE_G0_WD")
                .setTargetValue("23.45")
                .setAlarmData(
                        TargetAlarmData.newBuilder()
                                .setAlarmStatus(true)
                                .setAlarmType("alarm::hi")
                                .setAlarmValue("34.55")
                                .build()
                )
                .build();

        TargetWrapperData wrapperData = TargetWrapperData.newBuilder().addTargetDatas(targetData).build();

        // 写
//        try {
//            wrapperData.writeTo(new FileOutputStream(WRITE_FILE_PATH));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 读
        try {
            TargetWrapperData readFromFile = TargetWrapperData.parseFrom(new FileInputStream(WRITE_FILE_PATH));
            System.out.println(readFromFile.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
