##############################################################
#               CMake Project Wrapper Makefile               #
############################################################## 

#RHEL_VER := $(shell uname -r | grep -o -E '(el5|el6)')
#ifeq ($(RHEL_VER), el5)
  #PATH     := /s/gcc-4.6.1/bin:$(PATH)
#endif
#ifeq ($(RHEL_VER), el6)
  #PATH     := /s/gcc-4.6.2/bin:$(PATH)
#endif
#export PATH

CXX = g++

VARNAME = value

CXXFLAGS = -Wall -g


myhw0.exe : myhw0.o
	g++ -Wall myhw0.o -o myhw0.exe 

myhw0.o : myhw0.cpp
	#cd src;\
	#g++ -std=c++0x *.cpp exceptions/*.cpp -I. -Wall -o badgerdb_main
	g++ -Wall -c myhw0.cpp


  clean: 
	  rm *.o myhw0.exe


