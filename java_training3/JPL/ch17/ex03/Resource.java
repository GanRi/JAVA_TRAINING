package ch17.ex03;

interface Resource {
	  void use(Object key, Object...args);
	  void release();
	}
