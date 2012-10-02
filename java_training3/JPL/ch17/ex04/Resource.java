package ch17.ex04;

interface Resource {
	  void use(Object key, Object...args);
	  void release();
	}
