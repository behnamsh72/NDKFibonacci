//
// Created by behnam on 7/17/19.
//
#include <jni.h>
#include <android/log.h>

static jlong fib(jlong n){

    if(n<=0)
        return 0;
    else if(n==1)
        return 1;
    else
        return fib(n-1)+fib(n-2);
}

extern "C" JNIEXPORT jlong JNICALL
Java_com_example_behnam_ndkfibonacci_FibLib_fibNR(JNIEnv *env , jclass clazz,jlong number){
    __android_log_print(ANDROID_LOG_DEBUG,"FibLib.c","fibNR(%ld)",number);

    return fib(number);

}

extern "C" JNIEXPORT jlong  JNICALL
Java_com_example_behnam_ndkfibonacci_FibLib_fibNI(JNIEnv *env,jclass clazz,jlong number){
    __android_log_print(ANDROID_LOG_DEBUG,"FibLib.c","fibNI(%ld)",number);

    jlong previous=-1;
    jlong result=1;
    for(jlong i=0;i<=number;i++){
        jlong sum=result+previous;
        previous=result;
        result=sum;
    }
    return result;
}
