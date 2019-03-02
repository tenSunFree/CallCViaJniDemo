#include <com_home_callcviajnidemo_jni_ShowLuckyNumberJni.h>

JNIEXPORT jstring JNICALL Java_com_home_callcviajnidemo_jni_ShowLuckyNumberJni_getTitle
  (JNIEnv * env, jobject jobject) {

  return  (*env)->NewStringUTF(env, "今天的幸運數字是︰");
  }

JNIEXPORT jint JNICALL Java_com_home_callcviajnidemo_jni_ShowLuckyNumberJni_getLuckyNumber
  (JNIEnv *env, jobject obj, jint luckyNumber) {

  return luckyNumber * luckyNumber;
  }