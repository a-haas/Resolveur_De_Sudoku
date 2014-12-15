JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
 
CLASSES = \
	Node.java \
	Grid.java \
	Generation.java \
	Resolution.java \
	Sudoku.java
 
default: classes
 
classes: $(CLASSES:.java=.class)
 
clean:
	$(RM) *.class