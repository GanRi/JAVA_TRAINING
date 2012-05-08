package ch06.ex03;

public interface Verbose {
	void setVerbosity(Verbosity verbosity);
	Verbosity getVerbosity();
}


enum Verbosity{
	SILENT, TERSE, NORMAL, VERBOSE
}