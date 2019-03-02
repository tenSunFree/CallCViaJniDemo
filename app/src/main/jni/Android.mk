LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := ShowLuckyNumberJniLibrary
LOCAL_SRC_FILES =: ShowLuckyNumberJni.c
include $(BUILD_SHARED_LIBRARY)
