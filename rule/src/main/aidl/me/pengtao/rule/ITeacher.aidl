// ITeacher.aidl
package me.pengtao.rule;

import me.pengtao.rule.StudentInfo;

interface ITeacher {
    // 向老师注册该学生信息
    void registerInfo(in StudentInfo info);

    // 向老师注册自己的Id
    void registerId(String id);

    // 学生获得自己的昵称
    String getAlias();
}