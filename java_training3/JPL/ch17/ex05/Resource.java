package ch17.ex05;

public interface Resource {
	void use(Object key, Object... args);
	void release();
}

