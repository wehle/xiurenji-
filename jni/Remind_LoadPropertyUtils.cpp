#include <jni.h>
#include "jni_md.h"
#include "Remind_LoadPropertyUtils.h"


JNIEXPORT jstring JNICALL Java_Remind_LoadPropertyUtils_WordArt
  (JNIEnv *env, jclass j)
  {




      jstring jstr;

    char cstr[]="    ▄▄▄▄                          ██\n"
                "  ██▀▀▀▀█                         ▀▀\n"
                " ██▀        ██▄████  ▀██  ███   ████     ██▄████▄   ▄███▄██\n"
                " ██         ██▀       ██▄ ██      ██     ██▀   ██  ██▀  ▀██\n"
                " ██▄        ██         ████▀      ██     ██    ██  ██    ██\n"
                "  ██▄▄▄▄█   ██          ███    ▄▄▄██▄▄▄  ██    ██  ▀██▄▄███\n"
                "    ▀▀▀▀    ▀▀          ██     ▀▀▀▀▀▀▀▀  ▀▀    ▀▀   ▄▀▀▀ ██\n"
                "                      ███                           ▀████▀▀";
      jstr=env->NewStringUTF(cstr);
      return jstr;




  }
