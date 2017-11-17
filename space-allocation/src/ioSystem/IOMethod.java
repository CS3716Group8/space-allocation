package ioSystem;

import java.util.List;

public abstract class IOMethod<T> {

	public abstract List<T> load();
	public abstract void save(List<T> data);
}
