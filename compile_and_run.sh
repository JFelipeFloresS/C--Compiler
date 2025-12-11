#!/bin/zsh

# Compile Java source
javac -cp "lib/antlr-4.13.2-complete.jar:lib/introspector-1.3.1.jar" \
  -d out/production/C--Compiler \
  $(find src -name "*.java")

# Check if compiled
if [ $? -eq 0 ]; then
    echo "Java compiled"

    java -cp "lib/antlr-4.13.2-complete.jar:lib/introspector-1.3.1.jar:out/production/C--Compiler" Main input.txt output.txt

    if [ $? -eq 0 ]; then
        echo "Code output:"
        mono --arch=64 TextVM.exe output.txt
    else
        echo "Error compiling input"
    fi
else
    echo "Compilation failure"
fi
