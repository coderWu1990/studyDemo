//
// Created by di23.wu on 2023-08-16.
//

// native-lib.cpp

#include <jni.h>
#include <android/log.h>
#include <string>

extern "C" JNIEXPORT jint JNICALL Java_com_wd_jni_Math_nativeSum
        (JNIEnv *, jclass, jint a, jint b) {
    return a + b;
}
extern "C" JNIEXPORT jstring JNICALL Java_com_wd_jni_Math_nativeStr
        (JNIEnv *env, jclass clazz) {
    std::string hello = "hello JNI from C++";
    return env->NewStringUTF(hello.c_str());
}