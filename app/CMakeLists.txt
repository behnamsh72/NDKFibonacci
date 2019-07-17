cmake_minimum_required(VERSION 3.4.1)


add_library(
            NativeFibLib
            SHARED
            src/main/cpp/NativeFibLib.cpp)
find_library(
            log-lib
            log
)

target_link_libraries(
                       NativeFibLib
                        ${log-lib})

